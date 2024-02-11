package pmf.rzk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pmf.rzk.model.Korpa;
import pmf.rzk.model.Proizvodkorpa;

public interface ProizvodkorpaRepository extends JpaRepository<Proizvodkorpa, Integer>{
	
	List<Proizvodkorpa> findByKorpa(Korpa k);

}
