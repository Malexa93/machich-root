package machich.matching;

import org.springframework.boot.CommandLineRunner;

import org.springframework.stereotype.Component;

import machich.matching.domain.Macher;
import machich.matching.repository.MacherRepository;


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
     
    }
}