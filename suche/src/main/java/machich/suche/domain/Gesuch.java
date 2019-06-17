package machich.suche.domain;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;


@Embeddable

@AllArgsConstructor
public class Gesuch {
	
	private String ortsname;
	private Date datum;
	private String dienstleistung;
	private UUID id;
	
	public Gesuch () {
		id = UUID.randomUUID();
	}
	
	@Override
	public String toString() {
		return "Gesuch{" +
				"ortsname=" + ortsname +
				", datum=" + datum +
				", dienstleistung='" + dienstleistung + '\'' +
				'}';
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

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
	
	
	
	
	
	

}
