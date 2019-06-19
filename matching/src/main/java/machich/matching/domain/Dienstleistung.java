package machich.matching.domain;


import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Dienstleistung {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	
	@ElementCollection
	private List<String> schluesselworte;
	
	@ManyToOne()
	private Macher macher;
	
	public Dienstleistung() {
		
	}
	


	public Macher getMacher() {
		return macher;
	}



	public void setMacher(Macher macher) {
		this.macher = macher;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public List<String> getSchluesselworte() {
		return schluesselworte;
	}



	public void setSchluesselworte(List<String> schluesselworte) {
		this.schluesselworte = schluesselworte;
	}







	

	
	
	

}
