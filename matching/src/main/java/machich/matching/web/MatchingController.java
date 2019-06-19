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


@Controller
@RequestMapping(path = "matching")
public class MatchingController {
	
	
	@Value("${zeigeLoginURL}")
	private String zeigeLoginURL;
	
	private final static Logger LOGGER = LoggerFactory.getLogger(MatchingController.class);
	
	@GetMapping("/{gesuchnummer}")
	public String index(Model model, @PathVariable String gesuchnummer) {
		LOGGER.info("Matching-Applikation: " + gesuchnummer);
		return "zeigeMatches";
	}
	
	@PostMapping("/{gesuchnummer}")
	public RedirectView zeigeLogin(){
		return new RedirectView(zeigeLoginURL);
	}
	{
		
	}



}
