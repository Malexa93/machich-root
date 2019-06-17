package machich.matching.events;

import machich.matching.domain.Id;
import machich.matching.domain.Kunde;
import machich.matching.domain.gesuch.Erwartungen;

public class PreisvorschlagAbgelehnt  {
	public final String gesuchId;
	public final String kundeId;
	public final long preis;
	public final long vorgeschlagenerPreis;

	public PreisvorschlagAbgelehnt(//
			final Id gesuchId, //
			final Kunde kunde, //
			final Erwartungen erwartungen, //
			final long vorgeschlagenerPreis) {
		this.gesuchId = gesuchId.wert;
		this.kundeId = kunde.id.wert;
		this.preis = erwartungen.preis;
		this.vorgeschlagenerPreis = erwartungen.preis;
	}
}
