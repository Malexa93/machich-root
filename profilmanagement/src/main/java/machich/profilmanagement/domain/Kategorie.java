package machich.profilmanagement.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


public class Kategorie {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String kategorieName;
	
	public Kategorie() {}

	
	public String getKategorieName() {
		return kategorieName;
	}

	public void setKategorieName(String kategorieName) {
		this.kategorieName = kategorieName;
	}
	
	

}
