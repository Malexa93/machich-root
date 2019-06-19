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
	
	private String nachname;
	private String vorname;
	private String email;
	private String telefonnummer;
	
	private Date mitgliedSeit;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date zuletztAktualisiert;
	
	public Kunde() {
		mitgliedSeit = new Date();
	}

	
	public Long zeigeId() {
		return id;
	}



	public String getNachname() {
		return nachname;
	}


	public void setNachname(String nachname) {
		this.nachname = nachname;
	}


	public String getVorname() {
		return vorname;
	}


	public void setVorname(String vorname) {
		this.vorname = vorname;
	}


	public Date istMitgliedSeit() {
		return mitgliedSeit;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTelefonnummer() {
		return telefonnummer;
	}


	public void setTelefonnummer(String telefonnummer) {
		this.telefonnummer = telefonnummer;
	}

	

}
