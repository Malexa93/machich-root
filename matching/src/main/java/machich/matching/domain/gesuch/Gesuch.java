package machich.matching.domain.gesuch;


import java.util.Date;

import java.util.Objects;

import javax.persistence.Entity;

import org.springframework.data.domain.AbstractAggregateRoot;

import machich.matching.domain.Gesuchsbeschreibung;
import machich.matching.domain.Id;
import machich.matching.domain.Kunde;
import machich.matching.domain.Zusammenfassung;
import machich.matching.events.GesuchEingereicht;
import machich.matching.events.GesuchErneutEingereicht;
import machich.matching.events.PreisvorschlagAbgelehnt;
import machich.matching.events.PreisvorschlagAngenommen;
import machich.matching.events.TerminAbgelehnt;
import machich.matching.events.TerminAngenommen;

@Entity
public class Gesuch extends AbstractAggregateRoot{

	private Id id;
	private Kunde kunde;
	private Erwartungen erwartungen;
	private Fortschritt fortschitt;

	// TODO fuer Matching mit Macher
	// private Macher macher;
	
	private Gesuch() {}

	public static Gesuch einreichenFuer(final Kunde kunde, final Erwartungen erwartungen) {
		return new Gesuch(kunde, erwartungen);
	}

	public Id id() {
		return id;
	}

	public void erneutEinreichenMit(final Erwartungen erwartungen) {
		registerEvent(new GesuchErneutEingereicht(id, kunde, erwartungen));
		
	}

	public void preisvorschlagBestaetigen() {
		if (!fortschitt.wurdePreisvorschlagAbgelehnt()) {
			registerEvent(new PreisvorschlagAngenommen(id, kunde, erwartungen));
		}
	}

	public void preisvorschlagAblehnen(final long vorgeschlagenerPreis) {
		if (!fortschitt.wurdePreisvorschlagAbgelehnt()) {
			registerEvent(new PreisvorschlagAbgelehnt(id, kunde, erwartungen, vorgeschlagenerPreis));
		}
	}

	public void terminBestaetigen() {
		if (!fortschitt.wurdeTerminBestaetigt()) {
			registerEvent(new TerminAngenommen(id, kunde, erwartungen));
		}
	}

	public void terminAblehnen(final Date vorgeschlagenesAusfuehrungsdatum) {
		if (!fortschitt.wurdeTerminAbgelehnt()) {
			registerEvent(new TerminAbgelehnt(id, kunde, erwartungen, vorgeschlagenesAusfuehrungsdatum));
		}
	}

	// TODO
//	public void gematchtMit(final Macher macher) {
//		if (!fortschitt.schonGematcht()) {
//			apply(new GesuchMatched(id, kunde, macher));
//		}
//	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(final Object other) {
		if (other == null || other.getClass() != Gesuch.class) {
			return false;
		}

		final Gesuch otherGesuch = (Gesuch) other;

		return Objects.equals(id, otherGesuch.id);
	}

	@Override
	public String toString() {
		return "Gesuch[id=" + id + " kunde=" + kunde + " erwartungen=" + erwartungen + " fortschritt=" + fortschitt
				+ "]";
	}

	protected void when(final GesuchEingereicht event) {
		this.id = Id.mitExistierenderId(event.gesuchId);
		this.kunde = Kunde.mit(event.kundeId);
		this.erwartungen = Erwartungen.fuer(//
				Zusammenfassung.hat(event.zusammenfassung), //
				Gesuchsbeschreibung.hat(event.beschreibung), //
				Erwartungen.umwandelnInSchluesselworte(event.schluesselworte), //
				new Date(event.ausfuehrungsdatum), //
				event.preis);
		this.fortschitt = Fortschritt.Eingereicht;
	}

	protected void when(final GesuchErneutEingereicht event) {
		this.erwartungen = Erwartungen.fuer(//
				Zusammenfassung.hat(event.zusammenfassung), //
				Gesuchsbeschreibung.hat(event.beschreibung), //
				Erwartungen.umwandelnInSchluesselworte(event.schluesselworte), //
				new Date(event.ausfuehrungsdatum), //
				event.preis);

		this.fortschitt = Fortschritt.ErneutEingereicht;
	}

	protected void when(final PreisvorschlagAbgelehnt event) {
		erwartungen = erwartungen.mitAngepasstem(event.vorgeschlagenerPreis);
		fortschitt = fortschitt.abgelehntWegenVorgeschlagenemPreis();
	}

	protected void when(final PreisvorschlagAngenommen event) {
		fortschitt = fortschitt.angenommenWegenVorgeschlagenemPreis();
	}

	protected void when(final TerminAbgelehnt event) {
		erwartungen = erwartungen.mitAngepasstem(event.vorgeschlagenesAusfuehrungsdatum);
		fortschitt = fortschitt.abgelehntAufgrundVonTermin();
	}

	protected void when(final TerminAngenommen event) {
		fortschitt = fortschitt.angenommenWegenTermin();
	}

	// TODO
//	protected void when(final GesuchMatcht event) {
//		this.macher = event.bevorzugterMacher ? Doer.bevorzugterMacherMit(event.macherId) : Doer.nichtBevorzugterMacher(event.macherId);
//		// ginge auch: this.macher = Macher.mit(event.macherId, event.bevorzugterMacher)
//
//		fortschitt = fortschitt.gematcht();
//	}

	private Gesuch(final Kunde kunde, final Erwartungen erwartungen) {
		this(Id.unique(), kunde, erwartungen, Fortschritt.Keiner);
	}

	private Gesuch(final Id id, final Kunde kunde, final Erwartungen erwartungen, final Fortschritt fortschritt) {
		registerEvent(new GesuchEingereicht(id, kunde, erwartungen));
	}

//	public Gesuch(final List<DomainEvents> stream, final long streamVersion) {
//		super(stream, (int) streamVersion);
//	}
}
