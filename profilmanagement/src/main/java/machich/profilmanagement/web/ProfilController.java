package machich.profilmanagement.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import machich.profilmanagement.domain.Kunde;

@Controller
@RequestMapping(path = "profil")
public class ProfilController {
	
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
	public String registrieren(@ModelAttribute Kunde kunde) {
		return "";
	}
	

}
