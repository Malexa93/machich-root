package machich.matching.domain;

import java.util.Objects;

public class Kunde {
	public static Kunde mit(String referenzierteId) {
		return new Kunde(Id.mitExistierenderId(referenzierteId));
	}

	public final Id id;

	@Override
	public int hashCode() {
		return id.hashCode();
	}

	@Override
	public boolean equals(final Object other) {
		if (other == null || other.getClass() != Kunde.class) {
			return false;
		}

		return Objects.equals(this.id, ((Kunde) other).id);
	}

	@Override
	public String toString() {
		return "Kunde[id=" + id + "]";
	}

	private Kunde(final Id id) {
		this.id = id;
	}
}
