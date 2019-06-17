package machich.matching.domain;

import java.util.Objects;

public final class Zusammenfassung {
	public static Zusammenfassung hat(final String text) {
		return new Zusammenfassung(text);
	}

	public final String text;

	@Override
	public int hashCode() {
		return text.hashCode();
	}

	@Override
	public boolean equals(final Object other) {
		if (other == null || other.getClass() != Zusammenfassung.class) {
			return false;
		}

		return Objects.equals(text, ((Zusammenfassung) other).text);
	}

	@Override
	public String toString() {
		return "Zusammenfassung[text=" + text + "]";
	}

	private Zusammenfassung(final String text) {
		this.text = text;
	}

}
