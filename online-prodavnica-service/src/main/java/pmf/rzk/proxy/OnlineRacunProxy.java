package pmf.rzk.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import pmf.rzk.beans.Racun;



@FeignClient(name = "racun-service")//, url = "localhost:8082")
public interface OnlineRacunProxy {
	
	@PostMapping("/kreirajRacun/{idKorisnika}")
	public boolean addRacun(@PathVariable Integer idKorisnika);
	
	@PutMapping("/dodajNovac/{idRacuna}/{kolicina}") 
	public Racun dodajNovac(@PathVariable Integer idRacuna,@PathVariable Integer kolicina);
	
	@GetMapping("/vratiStanje/{idKorisnika}")
	public List<Racun> vratiStanje(@PathVariable Integer idKorisnika);
	
	@GetMapping("/vratiStanjePoRacunu/{idRacuna}")
	public int vratiStanjePoRacunu(@PathVariable Integer idRacuna);

}
