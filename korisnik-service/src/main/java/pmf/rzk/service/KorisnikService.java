package pmf.rzk.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pmf.rzk.model.Korisnik;
import pmf.rzk.model.Korisnikauloga;
import pmf.rzk.model.Uloga;
import pmf.rzk.repository.KorisnikRepository;
import pmf.rzk.repository.KorisnikUlogaRepository;
import pmf.rzk.repository.UlogaRepository;

@Service
public class KorisnikService {
	
	@Autowired
	KorisnikRepository korisnikRepo;
	
	@Autowired
	UlogaRepository ulogaRepository;
	
	@Autowired
	KorisnikUlogaRepository korisnikulogaRepository;

	public boolean ulogujSe(String username, String password) {
		Korisnik trazeniKorisnik = korisnikRepo.findByUsernameAndPassword(username, password);
		if(trazeniKorisnik == null) {
			return false;
		} else {
			return true;
		}
	}

	public Korisnik registracija(Korisnik k, Integer uloga) {
		Optional<Uloga> trazenaUloga = ulogaRepository.findById(uloga);
		if(!trazenaUloga.isEmpty()) {
			korisnikRepo.save(k);
			Korisnikauloga novKUloga = new Korisnikauloga();
			novKUloga.setKorisnik(k);
			novKUloga.setUloga(trazenaUloga.get());
			korisnikulogaRepository.save(novKUloga);
		}
		
		return k;
	}
	
	
}
