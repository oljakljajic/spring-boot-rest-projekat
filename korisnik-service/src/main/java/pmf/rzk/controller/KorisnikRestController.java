package pmf.rzk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pmf.rzk.model.Korisnik;
import pmf.rzk.service.KorisnikService;

@RestController
public class KorisnikRestController {
	
	@Autowired
	KorisnikService korisnikService;
	
	@GetMapping("/login/{username}/{password}")
	public boolean login(@PathVariable String username,@PathVariable String password) {
		return korisnikService.ulogujSe(username, password);
	}
	
	@PostMapping("/registracija/{uloga}") 
	public Korisnik registracija(@RequestBody Korisnik k, @PathVariable Integer uloga) {
		return korisnikService.registracija(k, uloga);
	}

}
