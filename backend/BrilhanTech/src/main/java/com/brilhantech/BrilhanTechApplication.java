package com.brilhantech;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.brilhantech.domain.Categoria;
import com.brilhantech.domain.Produto;
import com.brilhantech.repositories.CategoriaRepository;
import com.brilhantech.repositories.ProdutoRepository;

@SpringBootApplication
public class BrilhanTechApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(BrilhanTechApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {			
		
		Categoria cat1 = new Categoria(null, "Periférico");
		Categoria cat2 = new Categoria(null, "Monitor");
		Categoria cat3 = new Categoria(null, "Gabinete");
		
		Produto p1 = new Produto(null, "Mouse Gamer Havit", 80.00);
		Produto p2 = new Produto(null, "Teclado Gamer Enemy", 119.00);
		Produto p3 = new Produto(null, "Headset Gamer LED RGB", 93.00);
		Produto p4 = new Produto(null, "Monitor Philips", 789.00);
		Produto p5 = new Produto(null, "Monitor Acer", 1800.00);
		Produto p6 = new Produto(null, "Monitor LG UltraFine", 14999.00);
		Produto p7 = new Produto(null, "Gabinete Gamer Pichau", 499.90);
		Produto p8 = new Produto(null, "Gabinete Gamer Argb Vidro Revolt", 383.90);
		Produto p9 = new Produto(null, "Gabinete Gamer Cougar Conquer 2 RGB", 2934.57);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p4, p5, p6));
		cat3.getProdutos().addAll(Arrays.asList(p7, p8, p9));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		p4.getCategorias().addAll(Arrays.asList(cat2));
		p5.getCategorias().addAll(Arrays.asList(cat2));
		p6.getCategorias().addAll(Arrays.asList(cat2));
		
		p7.getCategorias().addAll(Arrays.asList(cat3));
		p8.getCategorias().addAll(Arrays.asList(cat3));
		p9.getCategorias().addAll(Arrays.asList(cat3));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		produtoRepository.saveAllAndFlush(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9));
	}

}
