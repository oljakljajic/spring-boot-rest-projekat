package pmf.rzk.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pmf.rzk.excaption.ProizvodNotFound;
import pmf.rzk.model.Ocena;
import pmf.rzk.model.Proizvod;
import pmf.rzk.repository.OcenaRepository;
import pmf.rzk.repository.ProizvodRepository;

@Service
public class OcenaService {
	
	@Autowired
	OcenaRepository ocenaRepo;
	
	@Autowired
	ProizvodRepository proizvodRepo;

	public Ocena dodajOcena(Ocena o, Integer idProizvod) {
		Optional<Proizvod> trazeniProizvod = proizvodRepo.findById(idProizvod);
		if(!trazeniProizvod.isEmpty()) {
			o.setProizvod(trazeniProizvod.get());
			ocenaRepo.save(o);
			return o;		
		}
		throw new ProizvodNotFound("Ne postoji proizvod sa id-jem: ", idProizvod);
	}

	public List<Ocena> vratiOcene(Integer idProizvod) {
		Optional<Proizvod> trazeniProizvod = proizvodRepo.findById(idProizvod);
		if(!trazeniProizvod.isEmpty()) {
			return trazeniProizvod.get().getOcenas();
		}
		throw new ProizvodNotFound("Ne postoji proizvod sa id-jem: ", idProizvod);
	}
	
	
	

}
