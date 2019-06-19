package machich.matching.web;

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

@Controller
@RequestMapping(path = "matching")
public class MatchingController {

	private final static Logger LOGGER = LoggerFactory.getLogger(MatchingController.class);
	private MacherRepository macherRepo;

	@Value("${zeigeLoginURL}")
	private String zeigeLoginURL;



	public MatchingController(MacherRepository mR) {
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

	{

	}

}
