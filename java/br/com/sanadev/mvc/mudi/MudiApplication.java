package br.com.sanadev.mvc.mudi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("br.com.sanadev.mvc.mudi.model")
public class MudiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MudiApplication.class, args);
	}

}
