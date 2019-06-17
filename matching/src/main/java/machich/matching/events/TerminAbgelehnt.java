package machich.matching.events;

import java.util.Date;

import machich.matching.domain.Id;
import machich.matching.domain.Kunde;
import machich.matching.domain.gesuch.Erwartungen;



public class TerminAbgelehnt {
	public final String gesuchId;
	public final String kundeId;
	public final long ausfuehrungsdatum;
	public final long vorgeschlagenesAusfuehrungsdatum;

	public TerminAbgelehnt(//
			final Id gesuchId, //
			final Kunde kunde, //
			final Erwartungen erwartungen, //
			final Date vorgeschlagenesAusfuehrungsdatum) {
		this.gesuchId = gesuchId.wert;
		this.kundeId = kunde.id.wert;
		this.ausfuehrungsdatum = erwartungen.ausfuehrungsdatum.getTime();
		this.vorgeschlagenesAusfuehrungsdatum = vorgeschlagenesAusfuehrungsdatum.getTime();
	}
}
