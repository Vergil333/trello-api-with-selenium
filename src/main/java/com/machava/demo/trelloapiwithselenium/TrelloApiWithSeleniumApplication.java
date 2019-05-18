package com.machava.demo.trelloapiwithselenium;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TrelloApiWithSeleniumApplication {
	@Value("${spring.application.name}")
	public static void main(String[] args) {
		SpringApplication.run(TrelloApiWithSeleniumApplication.class, args);
	}

}
