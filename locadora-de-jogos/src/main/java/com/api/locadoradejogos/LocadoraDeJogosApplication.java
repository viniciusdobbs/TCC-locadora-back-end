package com.api.locadoradejogos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class LocadoraDeJogosApplication {

	public static void main(String[] args) {
		SpringApplication.run(LocadoraDeJogosApplication.class, args);
	}

	@GetMapping("/")
	public String index(){
		return "Ola mundo!";
	}
}
