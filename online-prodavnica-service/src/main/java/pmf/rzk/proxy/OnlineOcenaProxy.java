package pmf.rzk.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import pmf.rzk.beans.Ocena;


@FeignClient(name = "ocena-service")//, url = "localhost:8083")
public interface OnlineOcenaProxy {
	

	@PostMapping("/dodajOcenu/{idProizvod}")
	public Ocena addOcena(@RequestBody Ocena o, @PathVariable Integer idProizvod);
	
	@GetMapping("/vratiOcene/{idProizvod}") 
	public List<Ocena> getOcene(@PathVariable Integer idProizvod);

}
