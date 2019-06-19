package machich.profilmanagement.event;

import java.io.Serializable;

public class KundeErstellt implements Serializable{
	private Long kundenNummer;
	
	public KundeErstellt(Long kundenNummer) {
		this.kundenNummer = kundenNummer;
	}
	
	public Long getKundenNummer() {
		return kundenNummer;
	}
	
	

}
