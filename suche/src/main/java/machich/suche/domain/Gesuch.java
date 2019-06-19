package machich.suche.domain;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;


@Embeddable

@Entity
public class Gesuch {
	
	@Id
	@GeneratedValue
	private Long id;
	private String ortsname;
	private Date datum;
	private String dienstleistung;
	private String gesuchsnummer;
	
	public Gesuch () {
		//id = UUID.randomUUID();
	}
	


	public String getGesuchsNummer() {
		return gesuchsnummer;
	}



	public void setGesuchsNummer(String gesuchsNummer) {
		this.gesuchsnummer = gesuchsNummer;
	}



	public String getOrtsname() {
		return ortsname;
	}

	public void setOrtsname(String ortsname) {
		this.ortsname = ortsname;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public String getDienstleistung() {
		return dienstleistung;
	}

	public void setDienstleistung(String dienstleistung) {
		this.dienstleistung = dienstleistung;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Gesuch{" +
				"ortsname=" + ortsname +
				", datum=" + datum +
				", dienstleistung='" + dienstleistung + '\'' +
				'}';
	}

	
	
	
	
	
	

}
