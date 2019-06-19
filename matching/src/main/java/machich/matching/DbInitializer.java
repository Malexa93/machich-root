package machich.matching;

import org.springframework.boot.CommandLineRunner;

import org.springframework.stereotype.Component;

import machich.matching.domain.Macher;
import machich.matching.repository.MacherRepository;
import machich.matching.domain.Kategorie;


@Component
public class DbInitializer implements CommandLineRunner {
    private MacherRepository macherRepo;
    public DbInitializer(MacherRepository macherRepo){
        this.macherRepo = macherRepo;
    }
    @Override
    public void run(String... strings) throws Exception {
    	Macher m = new Macher();
		m.nameAendernZu("Peter");
		
		macherRepo.save(m);
		Kategorie haus = new Kategorie();
		haus.setName("Haus und Wohnung");
		haus.setHatUnterkategorien(true);
		
		Kategorie reparatur = new Kategorie();
		reparatur.setName("Reparaturen");
		reparatur.setHatUnterkategorien(true);
		reparatur.setOberKategorie(haus);
		
		Kategorie strom = new Kategorie();
		strom.setName("Strom und Elektronik");
		strom.setHatUnterkategorien(false);
		strom.setOberKategorie(reparatur);
		
		Kategorie tuer = new Kategorie();
		tuer.setName("Türen und Schlösser");
		tuer.setHatUnterkategorien(false);
		tuer.setOberKategorie(reparatur);
		
		Kategorie reinigung = new Kategorie();
		reinigung.setName("Reinigungen");
		reinigung.setHatUnterkategorien(true);
		reinigung.setOberKategorie(haus);
		
		Kategorie fenster = new Kategorie();
		fenster.setName("Fenster");
		fenster.setHatUnterkategorien(false);
		fenster.setOberKategorie(reinigung);
		
		Kategorie dachrinne = new Kategorie();
		dachrinne.setName("Dachrinnen");
		dachrinne.setHatUnterkategorien(false);
		dachrinne.setOberKategorie(reinigung);
		
		Kategorie garten = new Kategorie();
		garten.setName("Garten");
		garten.setHatUnterkategorien(true);
		
		Kategorie fahrzeuge = new Kategorie();
		fahrzeuge.setName("Fahrzeuge");
		fahrzeuge.setHatUnterkategorien(true);
		
		Kategorie betreuung = new Kategorie();
		betreuung.setName("Betreuung und Hilfe");
		betreuung.setHatUnterkategorien(true);
		
		Kategorie kuenstler = new Kategorie();
		kuenstler.setName("Künstler");
		kuenstler.setHatUnterkategorien(true);
		
		Kategorie events = new Kategorie();
		events.setName("Events und Veranstaltungen");
		events.setHatUnterkategorien(true);
		
    }
}