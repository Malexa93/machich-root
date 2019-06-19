package machich.profilmanagement;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;

import org.springframework.stereotype.Component;

import machich.profilmanagement.domain.Dienstleistung;
import machich.profilmanagement.domain.Kategorie;
import machich.profilmanagement.domain.Macher;
import machich.profilmanagement.repository.KategorieRepository;
import machich.profilmanagement.repository.MacherRepository;




@Component
public class DbInitializer implements CommandLineRunner {
    private MacherRepository macherRepo;
    private KategorieRepository kategorieRepo;
    
    public DbInitializer(MacherRepository macherRepo, KategorieRepository kategorieRepository){
        this.macherRepo = macherRepo;
        this.kategorieRepo = kategorieRepository;
    }
    
    
    @Override
    public void run(String... strings) throws Exception {
    	
    	Dienstleistung d = new Dienstleistung();
    	d.setName("Gartenarbeit");
    	d.setSchluesselworte(Arrays.asList("garten arbeit draussen"));
    	Macher m = new Macher();
 
    	m.fuegeHinzu(d);
		m.nameAendernZu("Peter");
	
		
		macherRepo.save(m);
     
    }
}