package pmf.rzk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan("pmf.rzk.model")
@SpringBootApplication
public class RacunServisApplication {

	public static void main(String[] args) {
		SpringApplication.run(RacunServisApplication.class, args);
	}

}
