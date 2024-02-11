package pmf.rzk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pmf.rzk.model.Kategorija;
import pmf.rzk.model.Proizvod;

public interface ProizvodRepository extends JpaRepository<Proizvod, Integer>{
	
	List<Proizvod> findByKategorija(Kategorija k);

}
