package machich.suche.web;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import machich.suche.domain.Gesuch;
import machich.suche.events.SucheGestartet;

@Controller
public class SucheController {
	private final Logger LOGGER = LoggerFactory.getLogger(SucheController.class);
	
	@Value("${zeigeMacherURL}")
	private String zeigeMacherURL;
	
	
	@GetMapping("/")
	public String zeigeStartseite(Model model) {
		model.addAttribute("gesuch",new Gesuch());
		return "index";
	}
	
	@PostMapping("/")
	public RedirectView starteSuche(@ModelAttribute Gesuch gesuch) {
		Date startZeit = new Date();
		SucheGestartet sucheGestartetEvent = new SucheGestartet(startZeit);
		gesuch.setDatum(startZeit);
		LOGGER.info("Sent " + gesuch.toString());
		LOGGER.info("Sent " + sucheGestartetEvent.toString());
		
		return new RedirectView(zeigeMacherURL + gesuch.getId());
	}
}
