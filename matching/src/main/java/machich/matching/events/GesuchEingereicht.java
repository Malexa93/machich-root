package machich.matching.events;

import machich.matching.domain.Id;
import machich.matching.domain.Kunde;
import machich.matching.domain.gesuch.Erwartungen;

public final class GesuchEingereicht{
  public final String gesuchId;
  public final String kundeId;
  public final String beschreibung;
  public final String zusammenfassung;
  public final String[] schluesselworte;
  public final long ausfuehrungsdatum;
  public final long preis;
  
  public GesuchEingereicht(
      final Id gesuchId,
      final Kunde kunde,
      final Erwartungen erwartungen) {
    this.gesuchId = gesuchId.wert;
    this.kundeId = kunde.id.wert;
    this.zusammenfassung = erwartungen.zusammenfassung.text;
    this.beschreibung = erwartungen.beschreibung.text;
    this.schluesselworte = Erwartungen.umwandeln(erwartungen.schluesselworte);
    this.ausfuehrungsdatum = erwartungen.ausfuehrungsdatum.getTime();
    this.preis = erwartungen.preis;
  }
}
