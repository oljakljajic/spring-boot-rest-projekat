package pmf.rzk.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pmf.rzk.excaption.KorisnikNotFound;
import pmf.rzk.model.Korisnik;
import pmf.rzk.model.Racun;
import pmf.rzk.repository.KorisnikRepository;
import pmf.rzk.repository.RacunRepository;

@Service
public class RacunService {
		
	@Autowired
	RacunRepository racunRepisotory;
	
	@Autowired
	KorisnikRepository korisnikRepo;

	public boolean kreirajRacun(Integer idKorisnika) {
		Optional<Korisnik> trazeniKorisnik = korisnikRepo.findById(idKorisnika);
		if(!trazeniKorisnik.isEmpty()) {
			Racun novRacun = new Racun();
			novRacun.setKorisnik(trazeniKorisnik.get());
			novRacun.setStanje(0);
			racunRepisotory.save(novRacun);
			return true;
		}else {
			throw new KorisnikNotFound("Ne postoji korisnik sa id-jem: ", idKorisnika);
		}
	}
	
	public Racun dodajNovac(Integer idRacuna, int kolicina) {
		Optional<Racun> trazeniRacun = racunRepisotory.findById(idRacuna);
		if(!trazeniRacun.isEmpty()) {
			trazeniRacun.get().setStanje(trazeniRacun.get().getStanje()+kolicina);
			Racun azuriranRacun = racunRepisotory.save(trazeniRacun.get());
			return azuriranRacun;
			
		}
		return null;
	}
	
	public List<Racun> vratiStanje(Integer idKorisnika) {
		Optional<Korisnik> trazeniKorisnik = korisnikRepo.findById(idKorisnika);
		if(!trazeniKorisnik.isEmpty()) {
			return trazeniKorisnik.get().getRacuns();
		}
		throw new KorisnikNotFound("Ne postoji korisnik sa id-jem: ", idKorisnika);
	}

	public int vratiStanjePoRacunu(Integer idRacuna) {
		Optional<Racun> trazeniRacun = racunRepisotory.findById(idRacuna);
		if(!trazeniRacun.isEmpty()) {
			return trazeniRacun.get().getStanje();
		}
		throw new RuntimeException();
	}
}
