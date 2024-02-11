package pmf.rzk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import pmf.rzk.model.Racun;
import pmf.rzk.service.RacunService;

@Validated
@RestController
public class RacunRestController {
	
	@Autowired
	RacunService racunService;
	
	@PostMapping("/kreirajRacun/{idKorisnika}")
	public boolean addRacun(@PathVariable Integer idKorisnika) {
		return racunService.kreirajRacun(idKorisnika);
	}
	
	@PutMapping("/dodajNovac/{idRacuna}/{kolicina}") 
	public Racun dodajNovac(@PathVariable Integer idRacuna,@PathVariable Integer kolicina) {
		return racunService.dodajNovac(idRacuna, kolicina);
	}
	
	@GetMapping("/vratiStanje/{idKorisnika}")
	public List<Racun> vratiStanje(@PathVariable Integer idKorisnika) {
		return racunService.vratiStanje(idKorisnika);
	}
	
	@GetMapping("/vratiStanjePoRacunu/{idRacuna}")
	public int vratiStanjePoRacunu(@PathVariable Integer idRacuna) {
		return racunService.vratiStanjePoRacunu(idRacuna);
	}
	

}
