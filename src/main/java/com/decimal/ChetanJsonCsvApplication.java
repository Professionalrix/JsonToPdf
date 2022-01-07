package com.decimal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ChetanJsonCsvApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChetanJsonCsvApplication.class, args);
	}
	
	@Bean
	RestTemplate getTemplate() {
		return new RestTemplate();
	}

}
