package pmf.rzk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import pmf.rzk.beans.Kategorija;
import pmf.rzk.beans.Korisnik;
import pmf.rzk.beans.Ocena;
import pmf.rzk.beans.Proizvod;
import pmf.rzk.beans.Proizvodjac;
import pmf.rzk.beans.Proizvodkorpa;
import pmf.rzk.beans.Racun;
import pmf.rzk.proxy.OnlineKorisnikProxy;
import pmf.rzk.proxy.OnlineOcenaProxy;
import pmf.rzk.proxy.OnlineProdavnicaProxy;
import pmf.rzk.proxy.OnlineRacunProxy;

@RestController
public class OnlineProdavnicaRestController {
	
	@Autowired
	OnlineProdavnicaProxy proxy;
	
	@Autowired
	OnlineKorisnikProxy korisnikProxy;
	
	@Autowired
	OnlineRacunProxy racunProxy;
	
	@Autowired
	OnlineOcenaProxy ocenaProxy;
	
	//prodavnica service
	
	@GetMapping("/vratiSveProizvode")
	public List<Proizvod> getAllItems() {
		return proxy.getAllProizvodi();
	}
	
	@GetMapping("/filtrirajProizvode/{nazivKategorije}")
	public List<Proizvod> getFilteredItems(@PathVariable String nazivKategorije) {
		return proxy.getAllFilteredProizvodi(nazivKategorije);
	}
	
	
	@PostMapping("/naruci/{idKorpe}/{idKorisnik}/{idProizvod}/{kolicina}") 
	public Proizvodkorpa addToCart(@PathVariable Integer idKorpe, @PathVariable Integer idKorisnik, @PathVariable Integer idProizvod, @PathVariable Integer kolicina) {
		 return proxy.addToCart(idKorpe, idKorisnik, idProizvod, kolicina);
	}
	
	@GetMapping("/plati/{idKorpa}/{idRacuna}")
	public String plati(@PathVariable Integer idKorpa, @PathVariable Integer idRacuna) {
		int sumaCene = proxy.sumirajCene(idKorpa);
		if(racunProxy.vratiStanjePoRacunu(idRacuna) >= sumaCene) { 
		
		Racun krajnjiRacun = racunProxy.dodajNovac(3, sumaCene);
		Racun mojRacun = racunProxy.dodajNovac(idRacuna, -sumaCene);
		return "Stanje krajnjeg racuna " + krajnjiRacun.getStanje() + " stanje mog racuna " + mojRacun.getStanje();
		}
		return "Ne moze da se izvrsi kupovina. Nemate dovoljno novca na racunu!";
	}
	
	//korisnik service - vrv treba izbaciti odavde 
	
	@GetMapping("/login/{username}/{password}")
	public boolean login(@PathVariable String username,@PathVariable String password) {
		return korisnikProxy.login(username, password);
	}
	
	@PostMapping("/registracija/{uloga}") 
	public Korisnik registracija(@RequestBody Korisnik k, @PathVariable Integer uloga) {
		return korisnikProxy.registracija(k, uloga);
	}
	
	//racun service
	
	@PostMapping("/kreirajRacun/{idKorisnika}")
	public boolean addRacun(@PathVariable Integer idKorisnika) {
		return racunProxy.addRacun(idKorisnika);
	}
	
	@PutMapping("/dodajNovac/{idRacuna}/{kolicina}") 
	public Racun dodajNovac(@PathVariable Integer idRacuna,@PathVariable Integer kolicina) {
		return racunProxy.dodajNovac(idRacuna, kolicina);
	}
	
	@GetMapping("/vratiStanje/{idKorisnika}")
	public List<Racun> vratiStanje(@PathVariable Integer idKorisnika) {
		return racunProxy.vratiStanje(idKorisnika);
	}
	
	@GetMapping("/vratiStanjePoRacunu/{idRacuna}")
	public int vratiStanjePoRacunu(@PathVariable Integer idRacuna) {
		return racunProxy.vratiStanjePoRacunu(idRacuna);
	}
	
	//ocena service
	
	@PostMapping("/dodajOcenu/{idProizvod}")
	public Ocena addOcena(@RequestBody Ocena o, @PathVariable Integer idProizvod) {
		return ocenaProxy.addOcena(o, idProizvod);
	}
	
	@GetMapping("/vratiProsecneOcene/{idProizvod}") 
	public String getAvgOcene(@PathVariable Integer idProizvod) {
		List<Ocena> sveOcene = ocenaProxy.getOcene(idProizvod);
		double avg = 0.0;
		for (Ocena o:sveOcene) {
			avg+=o.getOcena();
		}
		
		return "Prosek za proizvod (" + idProizvod + ") je: "  + avg/sveOcene.size();
	}
	
	@GetMapping("/vratiOcene/{idProizvod}") 
	public List<Ocena> getOcene(@PathVariable Integer idProizvod) {
		return ocenaProxy.getOcene(idProizvod);
	}
	
	@PostMapping("/dodaj/proizvod/{idKorisnik}/{idKategorija}/{idProizvodjac}")
	public Proizvod addProizvod(@RequestBody Proizvod p, @PathVariable Integer idKorisnik, @PathVariable Integer idKategorija, @PathVariable Integer idProizvodjac) {
		return proxy.addProizvod(p, idKorisnik, idKategorija, idProizvodjac);
	}
	
	@PostMapping("/dodaj/kategorija/{idKorisnik}")
	public Kategorija addKategorija(@RequestBody Kategorija k, @PathVariable Integer idKorisnik) {
		return proxy.addKategorija(k, idKorisnik);
	}
	
	@PostMapping("/dodaj/proizvodjaca/{idKorisnik}")
	public Proizvodjac addProizvodjac(@RequestBody Proizvodjac p, @PathVariable Integer idKorisnik) {
		return proxy.addProizvodjac(p, idKorisnik);
	}
	
	
}
