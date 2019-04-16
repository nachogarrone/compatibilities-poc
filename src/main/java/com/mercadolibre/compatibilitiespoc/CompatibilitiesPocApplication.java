package com.mercadolibre.compatibilitiespoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.mercadolibre.compatibilitiespoc.model")
public class CompatibilitiesPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompatibilitiesPocApplication.class, args);
	}

}
