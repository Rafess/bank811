package com.santander.banco811;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Bank811Application {

	public static void main(String[] args) {
		SpringApplication.run(Bank811Application.class, args);
	}

}
