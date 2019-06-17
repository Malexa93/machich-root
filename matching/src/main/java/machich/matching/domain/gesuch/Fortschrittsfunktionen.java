package machich.matching.domain.gesuch;

import java.util.HashSet;
import java.util.Set;



final class Fortschrittsfunktionen {
	public static boolean istAkzeptabel(final Fortschritt fortschritt) {
		return wurdeEingereicht(fortschritt) && wurdePreisvorschlagVerifiziert(fortschritt) && wurdeTerminVerifiziert(fortschritt);
	}

	public static boolean istNichtAkzeptabel(final Fortschritt fortschritt) {
		return wurdeEingereicht(fortschritt) && wurdePreisvorschlagAbgelehnt(fortschritt) || wurdeTerminAbgelehnt(fortschritt);
	}

	public static boolean wurdePreisvorschlagAbgelehnt(final Fortschritt fortschritt) {
		return fortschritt.specs.contains(Spec.PreisvorschlagAbgelehnt);
	}

	public static boolean wurdePreisvorschlagVerifiziert(final Fortschritt fortschritt) {
		return fortschritt.specs.contains(Spec.PreisvorschlagAngenommen);
	}

	public static boolean wurdeTerminAbgelehnt(final Fortschritt fortschritt) {
		return fortschritt.specs.contains(Spec.TerminAbgelehnt);
	}

	public static boolean wurdeTerminVerifiziert(final Fortschritt fortschritt) {
		return fortschritt.specs.contains(Spec.TerminAngenommen);
	}

	public static boolean wurdeEingereicht(final Fortschritt fortschritt) {
		return fortschritt.specs.contains(Spec.Eingereicht);
	}

	protected static Fortschritt abgelehntWegenVorgeschlagenemPreis(final Fortschritt fortschritt) {
		return mitZusaetzlicherSpec(fortschritt, Spec.PreisvorschlagAbgelehnt);
	}

	protected static Fortschritt abgelehntAufgrundVonTermin(final Fortschritt fortschritt) {
		return mitZusaetzlicherSpec(fortschritt, Spec.TerminAbgelehnt);
	}

	protected static Fortschritt vomKundenEingereicht(final Fortschritt fortschritt) {
		return nutMitDieserSpec(fortschritt, Spec.Eingereicht);
	}

	protected static Fortschritt verifiziertWegenVorgeschlagenemPreis(final Fortschritt fortschritt) {
		return mitZusaetzlicherSpec(fortschritt, Spec.PreisvorschlagAngenommen);
	}

	protected static Fortschritt verifiziertWegenTermin(final Fortschritt fortschritt) {
		return mitZusaetzlicherSpec(fortschritt, Spec.TerminAngenommen);
	}
	
	private static Fortschritt mitZusaetzlicherSpec(final Fortschritt fortschritt, final Spec spec) {
		final Set<Spec> neueSpecs = new HashSet<Spec>(fortschritt.specs);
		neueSpecs.add(spec);
		return new Fortschritt(neueSpecs);
	}

	private static Fortschritt nutMitDieserSpec(final Fortschritt fortschritt, final Spec spec) {
		final Set<Spec> neueSpecs = new HashSet<Spec>();
		neueSpecs.add(spec);
		return new Fortschritt(neueSpecs);
	}
}
