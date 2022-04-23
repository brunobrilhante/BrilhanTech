package com.brilhantech;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.brilhantech.domain.Categoria;
import com.brilhantech.repositories.CategoriaRepository;

@SpringBootApplication
public class BrilhanTechApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(BrilhanTechApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {			
		
		Categoria cat1 = new Categoria(null, "Gabinete");
		Categoria cat2 = new Categoria(null, "Monitor");
		Categoria cat3 = new Categoria(null, "Mouse");
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		
	}

}
