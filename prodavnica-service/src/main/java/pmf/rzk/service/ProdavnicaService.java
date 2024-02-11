package pmf.rzk.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pmf.rzk.excaption.KorisnikNotFound;
import pmf.rzk.excaption.ProizvodNotFound;
import pmf.rzk.model.Kategorija;
import pmf.rzk.model.Korisnik;
import pmf.rzk.model.Korisnikauloga;
import pmf.rzk.model.Korpa;
import pmf.rzk.model.Proizvod;
import pmf.rzk.model.Proizvodjac;
import pmf.rzk.model.Proizvodkorpa;
import pmf.rzk.repository.KategorijaRepository;
import pmf.rzk.repository.KorisnikRepository;
import pmf.rzk.repository.KorpaRepository;
import pmf.rzk.repository.ProizvodRepository;
import pmf.rzk.repository.ProizvodjacRepository;
import pmf.rzk.repository.ProizvodkorpaRepository;

@Service
public class ProdavnicaService {
	@Autowired
	ProizvodRepository proizvodRepo;
	
	@Autowired
	KategorijaRepository kategorijaRepo;
	
	@Autowired
	KorpaRepository korpaRepo;
	
	@Autowired
	KorisnikRepository korisnikRepo;
	
	@Autowired
	ProizvodkorpaRepository proizvodkorpaRepo;
	
	@Autowired
	ProizvodjacRepository proizvodjacRepo;
	
	
	public List<Proizvod> vratiSveProizvode() {
		List<Proizvod> listaSvihProizvoda = proizvodRepo.findAll();
		return listaSvihProizvoda;
	}


	public List<Proizvod> vratiFilterProizvode(String nazivKategorije) {
		Kategorija poslataKategorija = kategorijaRepo.findByNazivKat(nazivKategorije);
		List<Proizvod> listaFiltriranihProizvoda = proizvodRepo.findByKategorija(poslataKategorija);
		return listaFiltriranihProizvoda;
	}


	public Proizvodkorpa dodajUKorpu(Integer idKorpe, Integer idProizvod, Integer kolicina, Integer idKorisnik) {
		Optional<Korisnik> trazeniKorisnik = korisnikRepo.findById(idKorisnik);
		Optional<Proizvod> trazeniProizvod = proizvodRepo.findById(idProizvod);
		if (trazeniProizvod.isEmpty() || trazeniProizvod.get().getKolicinaP() < 0) {
			throw new ProizvodNotFound("Ne postoji proizvod sa id-jem: ", idProizvod);
		}
		if(trazeniKorisnik.isEmpty()) {
			throw new KorisnikNotFound("Ne postoji korisnik sa id-jem: ", idKorisnik);
		}
		Proizvodkorpa novProizvodKorpa = new Proizvodkorpa();
		Optional<Korpa> trazenaKorpa = korpaRepo.findById(idKorpe);
		if(trazenaKorpa.isEmpty()) {
			Korpa novaKorpa = new Korpa();
			novaKorpa.setKorisnik(trazeniKorisnik.get());
			novaKorpa.setDatumNarudzbine(new Date());
			
			korpaRepo.save(novaKorpa);
			novProizvodKorpa.setKorpa(novaKorpa);
		} else {
			if(trazenaKorpa.get().getKorisnik().getIdkorisnika()==idKorisnik) {			
				novProizvodKorpa.setKorpa(trazenaKorpa.get());
				
			} else {
				Korpa novaKorpa = new Korpa();
				novaKorpa.setKorisnik(trazeniKorisnik.get());
				novaKorpa.setDatumNarudzbine(new Date());
				korpaRepo.save(novaKorpa);
				novProizvodKorpa.setKorpa(novaKorpa);
			}
		}
		novProizvodKorpa.setProizvod(trazeniProizvod.get());
		novProizvodKorpa.setKolicina(kolicina);
		proizvodkorpaRepo.save(novProizvodKorpa);
		trazeniProizvod.get().setKolicinaP(trazeniProizvod.get().getKolicinaP()-kolicina);
		proizvodRepo.save(trazeniProizvod.get());
		
		return novProizvodKorpa;
	}
	
	public int naruci(Integer idKorpe) {
		Optional<Korpa> trazenaKorpa = korpaRepo.findById(idKorpe);
		int suma = 0;
		if(!trazenaKorpa.isEmpty()) {
			List<Proizvodkorpa> trazeniProKorpa = proizvodkorpaRepo.findByKorpa(trazenaKorpa.get());
			for(Proizvodkorpa k:trazeniProKorpa) {
				suma += k.getKolicina()*k.getProizvod().getCenaP();
			}
		}
		
		return suma;
	}



	public Proizvod dodajProizvod(Proizvod p, Integer idKorisnik, Integer idKategorija, Integer idProizvodjac) {
		Optional<Korisnik> trazeniKorisnik = korisnikRepo.findById(idKorisnik);
		Optional<Kategorija> trazenaKategorija = kategorijaRepo.findById(idKategorija);
		Optional<Proizvodjac> trazeniProizvodjac = proizvodjacRepo.findById(idProizvodjac);
		Proizvod novProizvod = null;
		if(!trazeniKorisnik.isEmpty()&&!trazenaKategorija.isEmpty()&&!trazeniProizvodjac.isEmpty()) {
			List<Korisnikauloga> lista = trazeniKorisnik.get().getKorisnikaulogas();
			for (Korisnikauloga k : lista) {
				if(k.getUloga().getNazivUloge().equals("admin")) {
					
					p.setKategorija(trazenaKategorija.get());
					p.setProizvodjac(trazeniProizvodjac.get());
					novProizvod = proizvodRepo.save(p);
				}
			}
		} else {
			throw new RuntimeException();
		}
		return novProizvod;
		
	}


	public Kategorija dodajKategoriju(Kategorija k, Integer idKorisnik) {
		Optional<Korisnik> trazeniKorisnik = korisnikRepo.findById(idKorisnik);
		List<Korisnikauloga> lista = trazeniKorisnik.get().getKorisnikaulogas();
		Kategorija novaKategorija = null;
		if(!trazeniKorisnik.isEmpty()) {
			for (Korisnikauloga kLista : lista) {
				if(kLista.getUloga().getNazivUloge().equals("admin")) {
					novaKategorija = kategorijaRepo.save(k);
				} 
			} 
		} else {
			throw new RuntimeException();
		}
		return novaKategorija;
	}


	public Proizvodjac dodajProizvodjaca(Proizvodjac p, Integer idKorisnik) {
		Optional<Korisnik> trazeniKorisnik = korisnikRepo.findById(idKorisnik);
		List<Korisnikauloga> lista = trazeniKorisnik.get().getKorisnikaulogas();
		Proizvodjac novProizvodjac = null;
		if(!trazeniKorisnik.isEmpty()) {
			for (Korisnikauloga kLista : lista) {
				if(kLista.getUloga().getNazivUloge().equals("admin")) {
					novProizvodjac = proizvodjacRepo.save(p);
				} 
			} 
		} else {
			throw new RuntimeException();
		}
		return novProizvodjac;
	}
}
