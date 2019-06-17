package machich.matching.domain;

import java.util.UUID;

public class Id {
	public final String wert;

	public static Id mitExistierenderId(final String referenzierteId) {
		return new Id(referenzierteId);
	}

	public static Id unique() {
		return new Id();
	}

	@Override
	public int hashCode() {
		return wert.hashCode();
	}

	@Override
	public boolean equals(final Object other) {
		if (other == null || other.getClass() != Id.class) {
			return false;
		}

		final Id otherId = (Id) other;

		return this.wert.equals(otherId.wert);
	}

	@Override
	public String toString() {
		return "Id[wert=" + wert + "]";
	}

	private Id() {
		this.wert = UUID.randomUUID().toString();
	}

	private Id(final String referenzierteId) {
		this.wert = referenzierteId;
	}
}