package machich.matching.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MatchingController {
	
	@GetMapping("/")
	public String index() {
		return "index";
	}

}
