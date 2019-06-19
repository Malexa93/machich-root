package machich.suche.events;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;


public class SucheGestartet implements Serializable{
	
	private UUID id;
	private Date erstellungsdatum;


	public SucheGestartet(Date creationTime) {
		this.id = UUID.randomUUID();
		this.erstellungsdatum = creationTime;

	}

	public SucheGestartet() {
		this.id = UUID.randomUUID();
	}



	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Date getErstellungsdatum() {
		return erstellungsdatum;
	}

	public void setErstellungsdatum(Date erstellungsdatum) {
		this.erstellungsdatum = erstellungsdatum;
	}

	@Override
	public String toString() {
		return "SucheGestartet{" +
				"id=" + id +
				", erstellungsdatum=" + erstellungsdatum +
				'}';
	}

}
