package machich.matching.domain;

import java.util.Objects;

// TODO bei Zusammenfassung haben wir keine "Gesuch" vorangestellt; brauchen wir das hier?
public class Gesuchsbeschreibung {
	public static Gesuchsbeschreibung hat(final String text) {
		return new Gesuchsbeschreibung(text);
	}

	public final String text;

	@Override
	public int hashCode() {
		return text.hashCode();
	}

	@Override
	public boolean equals(final Object other) {
		if (other == null || other.getClass() != Gesuchsbeschreibung.class) {
			return false;
		}

		return Objects.equals(text, ((Gesuchsbeschreibung) other).text);
	}

	@Override
	public String toString() {
		return "Gesuchtsbeschreibung[text=" + text + "]";
	}

	private Gesuchsbeschreibung(final String text) {
		this.text = text;
	}
}
