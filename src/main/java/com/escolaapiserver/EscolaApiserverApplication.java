package com.escolaapiserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class EscolaApiserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(EscolaApiserverApplication.class, args);
	}

}
