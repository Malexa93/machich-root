package machich.profilmanagement.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import machich.profilmanagement.domain.Kunde;
import machich.profilmanagement.event.KundeErstellt;
import machich.profilmanagement.repository.KundeRepository;

@Controller
@RequestMapping(path = "profil")
public class ProfilController {

	private final static Logger LOGGER = LoggerFactory.getLogger(ProfilController.class);
	private KundeRepository kundeRepo;
	
	@Value("${zeigeMacherURL}")
	private String zeigeMacherURL;

	public ProfilController(KundeRepository kundeRepository) {
		this.kundeRepo = kundeRepository;
	}

	@GetMapping("/")
	public String zeigeLogin() {
		return "zeigeLoginWahl";
	}

	@GetMapping("/registrieren")
	public String zeigeRegistrieren(Model model) {
		model.addAttribute("kunde", new Kunde());
		
		return "registrieren";
	}

	@PostMapping("/registrieren")
	public RedirectView registrieren(@ModelAttribute Kunde kunde) {
		
		Kunde neuerKunde = kundeRepo.save(kunde);
		KundeErstellt event = new KundeErstellt(neuerKunde.zeigeId());
		LOGGER.info("Event: " + event.toString());
		return new RedirectView(zeigeMacherURL + neuerKunde.zeigeId());
	}

}
