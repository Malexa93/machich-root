package machich.matching.web;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;



import machich.matching.repository.MacherRepository;
import machich.matching.domain.Kategorie;
import machich.matching.repository.KategorieRepository;

@Controller
@RequestMapping(path = "matching")
public class MatchingController {

	private final static Logger LOGGER = LoggerFactory.getLogger(MatchingController.class);
	private MacherRepository macherRepo;
	private KategorieRepository katRepo;

	@Value("${zeigeLoginURL}")
	private String zeigeLoginURL;



	public MatchingController(MacherRepository mR,KategorieRepository kR) {
		this.katRepo = kR;
		this.macherRepo = mR;

	}

	@GetMapping("/{gesuchnummer}")
	public String index(Model model, @PathVariable String gesuchnummer) {
		LOGGER.info("Matching-Applikation: " + gesuchnummer);
		model.addAttribute("macherListe", macherRepo.findAll());
		return "zeigeMatches";
	}

	@PostMapping("/{gesuchnummer}")
	public RedirectView zeigeLogin() {
		return new RedirectView(zeigeLoginURL);
	}

	@GetMapping("/{matchingnummer}")
	public String zeigeMatchDetails(Model model, @PathVariable String matchnummer) {
		return "";

	}
	
	@GetMapping("/{kundennummer}")
	public String zeigeMatch(Model model, @PathVariable String matchnummer) {
		return "";

	}
	@GetMapping("/{kundennummer}")
	public String zeigeKategorien(Model model, @PathVariable String matchnummer) {
		List<Kategorie>listeSubKategorien = getSubkategories(kategorie);
		if(listeSubKategorien.isEmpty() == true) {
			//
		}
		return "";
	}
	public List<Kategorie> getSubkategories(Kategorie kategorie){
		List<Kategorie> alleKategorien = new ArrayList<Kategorie>();
		List<Kategorie> subKategorien = new ArrayList<Kategorie>();
		alleKategorien = katRepo.findAll();
		for (Kategorie k : alleKategorien) {
			if(k.getOberKategorie().equals(kategorie)) {
				subKategorien.add(k);
			}
		}
		return subKategorien;
	}
	{

	}

}
