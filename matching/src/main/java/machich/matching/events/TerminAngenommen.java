package machich.matching.events;


import machich.matching.domain.Id;
import machich.matching.domain.Kunde;
import machich.matching.domain.gesuch.Erwartungen;

public class TerminAngenommen {
	public final String gesuchId;
	public final String kundeId;
	public final long ausfuehrungsdatum;

	public TerminAngenommen(//
			final Id gesuchId, //
			final Kunde kunde, //
			final Erwartungen erwartungen) {
		this.gesuchId = gesuchId.wert;
		this.kundeId = kunde.id.wert;
		this.ausfuehrungsdatum = erwartungen.ausfuehrungsdatum.getTime();
	}
}
