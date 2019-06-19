package machich.matching.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Kategorie {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	private Kategorie oberKategorie;
	private boolean hatUnterkategorien;
	
	public Kategorie() {}

	public Long getId() {
		return id;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Kategorie getOberKategorie() {
		return oberKategorie;
	}

	public void setOberKategorie(Kategorie oberKategorie) {
		this.oberKategorie = oberKategorie;
	}

	public boolean isHatUnterkategorien() {
		return hatUnterkategorien;
	}

	public void setHatUnterkategorien(boolean hatUnterkategorien) {
		this.hatUnterkategorien = hatUnterkategorien;
	}
	
	

}
