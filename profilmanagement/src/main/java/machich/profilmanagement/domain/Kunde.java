package machich.profilmanagement.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Kunde {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	private Date mitgliedSeit;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date zuletztAktualisiert;
	
	public Kunde() {
		mitgliedSeit = new Date();
	}

	
	public Long zeigeId() {
		return id;
	}

	public String zeigeName() {
		return name;
	}

	public void nameAendernZu(String name) {
		this.name = name;
	}

	public Date istMitgliedSeit() {
		return mitgliedSeit;
	}


}
