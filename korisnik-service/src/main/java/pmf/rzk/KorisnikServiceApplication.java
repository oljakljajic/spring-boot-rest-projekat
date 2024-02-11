package pmf.rzk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan("pmf.rzk.model")
@SpringBootApplication
public class KorisnikServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(KorisnikServiceApplication.class, args);
	}

}
