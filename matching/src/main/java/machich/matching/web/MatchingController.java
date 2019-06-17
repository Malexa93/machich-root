package machich.matching.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(path = "matching")
public class MatchingController {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(MatchingController.class);
	
	@GetMapping("/{gesuchnummer}")
	public String index(Model model, @PathVariable String gesuchnummer) {
		LOGGER.info("Matching-Applikation: " + gesuchnummer);
		return "zeigeMatches";
	}



}
