package pmf.rzk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import pmf.rzk.model.Ocena;
import pmf.rzk.service.OcenaService;

@Validated
@RestController
public class OcenaRestController {
	
	@Autowired
	OcenaService ocenaService;
	
	@PostMapping("/dodajOcenu/{idProizvod}")
	public Ocena addOcena(@RequestBody @Valid Ocena o, @PathVariable Integer idProizvod) {
		return ocenaService.dodajOcena(o, idProizvod);
	}
	@GetMapping("/vratiOcene/{idProizvod}") 
	public List<Ocena> getOcene(@PathVariable Integer idProizvod) {
		return ocenaService.vratiOcene(idProizvod);
	}
}
