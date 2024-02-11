package pmf.rzk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pmf.rzk.model.Kategorija;

public interface KategorijaRepository extends JpaRepository<Kategorija, Integer>{
	
	Kategorija findByNazivKat(String nazivKat);

}
