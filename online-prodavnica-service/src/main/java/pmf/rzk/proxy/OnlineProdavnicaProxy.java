package pmf.rzk.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import pmf.rzk.beans.Kategorija;
import pmf.rzk.beans.Proizvod;
import pmf.rzk.beans.Proizvodjac;
import pmf.rzk.beans.Proizvodkorpa;

@FeignClient(name = "shop-service")//, url = "localhost:8080")
public interface OnlineProdavnicaProxy {
	
	@GetMapping("/vratiSveProizvode")
	public List<Proizvod> getAllProizvodi();
	
	@GetMapping("/filtrirajProizvode/{nazivKategorije}")
	public List<Proizvod> getAllFilteredProizvodi(@PathVariable String nazivKategorije);
	
	@PostMapping("/naruci/{idKorpe}/{idKorisnik}/{idProizvod}/{kolicina}") 
	public Proizvodkorpa addToCart(@PathVariable Integer idKorpe, @PathVariable Integer idKorisnik, @PathVariable Integer idProizvod, @PathVariable Integer kolicina);
	
	@GetMapping("/napravi-racun/{idKorpa}")
	public int sumirajCene(@PathVariable Integer idKorpa);
	
	@PostMapping("/dodaj/proizvod/{idKorisnik}/{idKategorija}/{idProizvodjac}")
	public Proizvod addProizvod(@RequestBody Proizvod p, @PathVariable Integer idKorisnik, @PathVariable Integer idKategorija, @PathVariable Integer idProizvodjac);
	
	@PostMapping("/dodaj/kategorija/{idKorisnik}")
	public Kategorija addKategorija(@RequestBody Kategorija k, @PathVariable Integer idKorisnik);
	
	@PostMapping("/dodaj/proizvodjaca/{idKorisnik}")
	public Proizvodjac addProizvodjac(@RequestBody Proizvodjac p, @PathVariable Integer idKorisnik);

}
