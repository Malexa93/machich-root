package machich.suche.events;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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



	@Override
	public String toString() {
		return "SucheGestartet{" +
				"id=" + id +
				", erstellungsdatum=" + erstellungsdatum +
				'}';
	}

}
