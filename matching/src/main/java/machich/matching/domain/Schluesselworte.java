package machich.matching.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Schluesselworte {

	public static Schluesselworte sind(final List<String> schluesselworte) {
		return new Schluesselworte(schluesselworte);
	}

	public static Schluesselworte sind(final String... Schluesselworte) {
		return new Schluesselworte(Schluesselworte);
	}

	public final List<String> geordneteKlassifikation;

	@Override
	public boolean equals(final Object other) {
		if (other == null || other.getClass() != Schluesselworte.class) {
			return false;
		}
		return Objects.equals(geordneteKlassifikation, ((Schluesselworte) other).geordneteKlassifikation);
	}

	private Schluesselworte(final String... schluesselworte) {
		this(Arrays.asList(schluesselworte));
	}

	private Schluesselworte(final List<String> schluesselworte) {
		this.geordneteKlassifikation = Collections.unmodifiableList(schluesselworte);
	}
}
