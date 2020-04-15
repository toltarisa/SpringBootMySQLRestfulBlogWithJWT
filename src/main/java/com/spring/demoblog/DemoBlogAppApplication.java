package com.spring.demoblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class DemoBlogAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoBlogAppApplication.class, args);
	}

}
