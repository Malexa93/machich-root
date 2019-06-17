package machich.matching.domain.gesuch;

import java.util.Date;
import java.util.Objects;

import machich.matching.domain.Gesuchsbeschreibung;
import machich.matching.domain.Schluesselworte;
import machich.matching.domain.Zusammenfassung;


// TODO: Aufgabe
// - Studenten sollen vorgeschlagenenenPreis und vorgeschlagenesAusfuehrungsdatum implementieren mit Szenarios
// - ist "vorgeschlagen" sinnvoll, oder besser "angebotenes"
//
// - was ist mit Dienstleistungen, die länger dauern und Kunde ein Fertigstellungsdatum angeben möchte?

public final class Erwartungen {
	public static Erwartungen fuer( //
			Zusammenfassung zusammenfassung, //
			Gesuchsbeschreibung beschreibung, //
			Schluesselworte schluesselworte, //
			Date ausfuehrungsdatum, //
			long preis) {
		return new Erwartungen(zusammenfassung, beschreibung, schluesselworte, ausfuehrungsdatum, preis);
	}

	public final Zusammenfassung zusammenfassung;
	public final Gesuchsbeschreibung beschreibung;
	public final Schluesselworte schluesselworte;
	public final Date ausfuehrungsdatum;
	public final Date vorgeschlagenesAusfuehrungsdatum;
	public final long preis;
	public final long vorgeschlagenerPreis;

	public Erwartungen mitAngepasstem(final Date vorgeschlagenesAusfuehrungsdatum) {
		return new Erwartungen(zusammenfassung, beschreibung, schluesselworte, ausfuehrungsdatum,
				vorgeschlagenesAusfuehrungsdatum, preis, preis);
	}

	public Erwartungen mitAngepasstem(final long vorgeschlagenerPreis) {
		return new Erwartungen(zusammenfassung, beschreibung, schluesselworte, ausfuehrungsdatum,
				vorgeschlagenesAusfuehrungsdatum, preis, vorgeschlagenerPreis);
	}

	public Erwartungen mitNeuer(final Zusammenfassung zusammenfassung) {
		return new Erwartungen(zusammenfassung, beschreibung, schluesselworte, ausfuehrungsdatum,
				vorgeschlagenesAusfuehrungsdatum, preis, vorgeschlagenerPreis);
	}

	public Erwartungen mitNeuer(final Gesuchsbeschreibung beschreibung) {
		return new Erwartungen(zusammenfassung, beschreibung, schluesselworte, ausfuehrungsdatum,
				vorgeschlagenesAusfuehrungsdatum, preis, vorgeschlagenerPreis);
	}

	public Erwartungen mitVerfeinerten(final Schluesselworte schluesselworten) {
		return new Erwartungen(zusammenfassung, beschreibung, schluesselworten, ausfuehrungsdatum,
				vorgeschlagenesAusfuehrungsdatum, preis, vorgeschlagenerPreis);
	}

	@Override
	public int hashCode() {
		return Objects.hash(zusammenfassung, beschreibung, schluesselworte, ausfuehrungsdatum,
				vorgeschlagenesAusfuehrungsdatum, preis, vorgeschlagenerPreis);
	}

	@Override
	public boolean equals(final Object other) {
		if (other == null || other.getClass() != Erwartungen.class) {
			return false;
		}

		final Erwartungen otherErwartungen = (Erwartungen) other;

		return Objects.equals(zusammenfassung, otherErwartungen.zusammenfassung) //
				&& Objects.equals(beschreibung, otherErwartungen.beschreibung) //
				&& Objects.equals(schluesselworte, otherErwartungen.schluesselworte) //
				&& Objects.equals(ausfuehrungsdatum, otherErwartungen.ausfuehrungsdatum) //
				&& Objects.equals(vorgeschlagenesAusfuehrungsdatum, otherErwartungen.vorgeschlagenesAusfuehrungsdatum) //
				&& Objects.equals(preis, otherErwartungen.preis) //
				&& Objects.equals(vorgeschlagenerPreis, otherErwartungen.vorgeschlagenerPreis);
	}

	@Override
	public String toString() {
		return "Erwartungen[zusammenfassung=" + zusammenfassung + " beschreibung=" + beschreibung
				+ " ausfuehrungsdatum=" + ausfuehrungsdatum + "]";
	}

	public static String[] umwandeln(final Schluesselworte schluesselworte) {
		return schluesselworte.geordneteKlassifikation
				.toArray(new String[schluesselworte.geordneteKlassifikation.size()]);
	}

	protected static Schluesselworte umwandelnInSchluesselworte(final String[] keywords) {
		return Schluesselworte.sind(keywords);
	}

	private Erwartungen(final Zusammenfassung zusammenfassung, final Gesuchsbeschreibung beschreibung,
			final Schluesselworte schluesselworte, final Date ausfuehrungsdatum, final long preis) {
		this.zusammenfassung = zusammenfassung;
		this.beschreibung = beschreibung;
		this.schluesselworte = schluesselworte;
		this.ausfuehrungsdatum = ausfuehrungsdatum;
		this.vorgeschlagenesAusfuehrungsdatum = ausfuehrungsdatum;
		this.preis = preis;
		this.vorgeschlagenerPreis = preis;
	}

	private Erwartungen(final Zusammenfassung zusammenfassung, final Gesuchsbeschreibung beschreibung,
			final Schluesselworte schluesselworte, final Date ausfuehrungsdatum,
			final Date vorgeschlagenesAusfuehrungsdatum, final long preis, final long vorgeschlagenerPreis) {
		this.zusammenfassung = zusammenfassung;
		this.beschreibung = beschreibung;
		this.schluesselworte = schluesselworte;
		this.ausfuehrungsdatum = ausfuehrungsdatum;
		this.vorgeschlagenesAusfuehrungsdatum = vorgeschlagenesAusfuehrungsdatum;
		this.preis = preis;
		this.vorgeschlagenerPreis = vorgeschlagenerPreis;
	}

}
