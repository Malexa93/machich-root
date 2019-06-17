package machich.suche.web;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import machich.suche.domain.Gesuch;
import machich.suche.events.SucheGestartet;

@Controller
public class SucheController {
	private final Logger LOGGER = LoggerFactory.getLogger(SucheController.class);
	
	
	@GetMapping("/")
	public String zeigeStartseite(Model model) {
		model.addAttribute("gesuch",new Gesuch());
		return "index";
	}
	
	@PostMapping("/")
	public String starteSuche(@ModelAttribute Gesuch gesuch) {
		Date startZeit = new Date();
		SucheGestartet sucheGestartetEvent = new SucheGestartet(startZeit);
		gesuch.setDatum(startZeit);
		LOGGER.info("Sent " + gesuch.toString());
		LOGGER.info("Sent " + sucheGestartetEvent.toString());
		
		return "index";
	}
}
