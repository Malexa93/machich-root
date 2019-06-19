package machich.profilmanagement.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "profil")
public class ProfilController {
	
	@GetMapping("/")
		public String zeigeLogin() {
			return "zeigeLoginWahl";
		}
	

}
