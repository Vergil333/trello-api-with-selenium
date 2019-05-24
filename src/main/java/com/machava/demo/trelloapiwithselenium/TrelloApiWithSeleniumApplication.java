package com.machava.demo.trelloapiwithselenium;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TrelloApiWithSeleniumApplication {
	@Value("${spring.application.name}")
	public static void main(String[] args) {
		SpringApplication.run(TrelloApiWithSeleniumApplication.class, args);
	}

}
