package pmf.rzk.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import pmf.rzk.beans.Korisnik;



@FeignClient(name = "korisnik-service")//, url = "localhost:8081")
public interface OnlineKorisnikProxy {
	
	@GetMapping("/login/{username}/{password}")
	public boolean login(@PathVariable String username,@PathVariable String password);
	
	@PostMapping("/registracija/{uloga}") 
	public Korisnik registracija(@RequestBody Korisnik k, @PathVariable Integer uloga);

}
