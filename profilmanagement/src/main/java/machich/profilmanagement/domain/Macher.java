package machich.profilmanagement.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Macher {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	private Date mitgliedSeit;
	
	@OneToMany(mappedBy = "macher", cascade = CascadeType.ALL)
	private List<Dienstleistung> angeboteneDienste;

	
	@Temporal(TemporalType.TIMESTAMP)
	private Date zuletztAktualisiert;
	
	
	public Macher() {
		mitgliedSeit = new Date();
		angeboteneDienste = new ArrayList<Dienstleistung>();
	 
	}

	
	public void fuegeHinzu(Dienstleistung dl) {
		angeboteneDienste.add(dl);
		dl.setMacher(this);
	}
	
	public Long zeigeId() {
		return id;
	}

	public String zeigeName() {
		return name;
	}

	public void nameAendernZu(String name) {
		this.name = name;
		zuletztAktualisiert = new Date();
	}

	public Date istMitgliedSeit() {
		return mitgliedSeit;
	}

	

}
