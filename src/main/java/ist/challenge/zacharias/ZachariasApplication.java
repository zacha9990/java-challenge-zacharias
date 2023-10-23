package ist.challenge.zacharias;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("ist.challenge.zacharias.model")
public class ZachariasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZachariasApplication.class, args);
	}

}
