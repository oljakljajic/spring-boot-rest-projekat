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
import pmf.rzk.model.Kategorija;
import pmf.rzk.model.Proizvod;
import pmf.rzk.model.Proizvodjac;
import pmf.rzk.model.Proizvodkorpa;
import pmf.rzk.service.ProdavnicaService;

@Validated
@RestController
public class ProdavnicaRestController {
	
	@Autowired
	ProdavnicaService prodavnicaService;
	

	
	@GetMapping("/vratiSveProizvode")
	public List<Proizvod> getAllProizvodi() {
		return prodavnicaService.vratiSveProizvode();
	}
	@GetMapping("/filtrirajProizvode/{nazivKategorije}")
	public List<Proizvod> getAllFilteredProizvodi(@PathVariable String nazivKategorije) {
		return prodavnicaService.vratiFilterProizvode(nazivKategorije);
	}
	
	@PostMapping("/naruci/{idKorpe}/{idKorisnik}/{idProizvod}/{kolicina}") 
	public Proizvodkorpa addToCart(@PathVariable Integer idKorpe, @PathVariable Integer idKorisnik, @PathVariable Integer idProizvod, @PathVariable Integer kolicina) {
		return prodavnicaService.dodajUKorpu(idKorpe, idProizvod, kolicina, idKorisnik);
	}
	
	@GetMapping("/napravi-racun/{idKorpa}")
	public int sumirajCene(@PathVariable Integer idKorpa) {
		return prodavnicaService.naruci(idKorpa);
	}
	
	@PostMapping("/dodaj/proizvod/{idKorisnik}/{idKategorija}/{idProizvodjac}")
	public Proizvod addProizvod(@RequestBody @Valid Proizvod p, @PathVariable Integer idKorisnik, @PathVariable Integer idKategorija, @PathVariable Integer idProizvodjac) {
		return prodavnicaService.dodajProizvod(p, idKorisnik, idKategorija, idProizvodjac);
	}
	
	@PostMapping("/dodaj/kategorija/{idKorisnik}")
	public Kategorija addKategorija(@RequestBody @Valid Kategorija k, @PathVariable Integer idKorisnik) {
		return prodavnicaService.dodajKategoriju(k, idKorisnik);
	}
	
	@PostMapping("/dodaj/proizvodjaca/{idKorisnik}")
	public Proizvodjac addProizvodjac(@RequestBody @Valid Proizvodjac p, @PathVariable Integer idKorisnik) {
		return prodavnicaService.dodajProizvodjaca(p, idKorisnik);
	}
	
	 
}
