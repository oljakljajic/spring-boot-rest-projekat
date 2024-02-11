package pmf.rzk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("pmf.rzk.model")
public class ProdavnicaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProdavnicaServiceApplication.class, args);
	}

}
