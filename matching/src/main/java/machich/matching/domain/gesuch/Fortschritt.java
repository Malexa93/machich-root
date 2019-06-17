package machich.matching.domain.gesuch;

import java.util.HashSet;
import java.util.Set;


public final class Fortschritt {
	public static Fortschritt Keiner = new Fortschritt();
	public static Fortschritt Eingereicht = new Fortschritt(Spec.Eingereicht);
	public static Fortschritt ErneutEingereicht = new Fortschritt(Spec.ErneutEingereicht);

	protected final Set<Spec> specs;

	public boolean istAkzeptabel() {
		return wurdeEingereicht() && wurdePreisvorschlagAngenommen() && wurdeTerminBestaetigt();
	}

	public boolean istNichtAkzeptabel() {
		return wurdeEingereicht() && wurdePreisvorschlagAbgelehnt() || wurdeTerminAbgelehnt();
	}

	public boolean wurdePreisvorschlagAbgelehnt() {
		return specs.contains(Spec.PreisvorschlagAbgelehnt);
	}

	public boolean wurdePreisvorschlagAngenommen() {
		return specs.contains(Spec.PreisvorschlagAngenommen);
	}

	public boolean wurdeTerminAbgelehnt() {
		return specs.contains(Spec.TerminAbgelehnt);
	}

	public boolean wurdeTerminBestaetigt() {
		return specs.contains(Spec.TerminAngenommen);
	}

	public boolean wurdeEingereicht() {
		return specs.contains(Spec.Eingereicht);
	}

	public boolean wurdeGematched() {
		return specs.contains(Spec.Gematched);
	}

	@Override
	public int hashCode() {
		return specs.hashCode();
	}

	@Override
	public boolean equals(final Object other) {
		if (other == null || other.getClass() != Fortschritt.class) {
			return false;
		}

		final Fortschritt otherFortschritt = (Fortschritt) other;

		return this.specs.equals(otherFortschritt.specs);
	}

	@Override
	public String toString() {
		return "Fortschritt[specs=" + specs + "]";
	}

	protected Fortschritt abgelehntWegenVorgeschlagenemPreis() {
		return mitNeuerSpec(Spec.PreisvorschlagAbgelehnt);
	}

	protected Fortschritt abgelehntAufgrundVonTermin() {
		return mitNeuerSpec(Spec.TerminAbgelehnt);
	}

	protected Fortschritt angenommenWegenVorgeschlagenemPreis() {
		return mitNeuerSpec(Spec.PreisvorschlagAngenommen);
	}

	protected Fortschritt angenommenWegenTermin() {
		return mitNeuerSpec(Spec.TerminAngenommen);
	}

	protected Fortschritt gematched() {
		return mitNeuerSpec(Spec.Gematched);
	}

	Fortschritt() {
		this.specs = new HashSet<>();
	}

	Fortschritt(final Spec spec) {
		this.specs = new HashSet<>();
		this.specs.add(spec);
	}

	Fortschritt(final Set<Spec> specs) {
		this.specs = specs;
	}

	Fortschritt mitNeuerSpec(final Spec spec) {
		final Set<Spec> neueSpecs = new HashSet<>(this.specs);
		neueSpecs.add(spec);
		return new Fortschritt(neueSpecs);
	}

	Fortschritt withOnlySpec(final Spec spec) {
		return new Fortschritt(spec);
	}
}
