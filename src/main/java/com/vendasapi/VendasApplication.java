package com.vendasapi;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.vendasapi.model.Vendedor;
import com.vendasapi.repository.VendedorRepository;

@SpringBootApplication
public class VendasApplication implements CommandLineRunner{

	@Autowired
	private VendedorRepository vendedorRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}
	
	
	@Override
	public void run(String... args) throws Exception {
		
		Vendedor vendedor1 = new Vendedor(null, "Romario Ribeiro");
		Vendedor vendedor2 = new Vendedor(null, "João da Silva");
		Vendedor vendedor3 = new Vendedor(null, "Maria das Rosas");
		Vendedor vendedor4 = new Vendedor(null, "José Oliveira");
		Vendedor vendedor5 = new Vendedor(null, "Luis das Couves");

		
		
		vendedorRepository.saveAll(Arrays.asList(vendedor1, vendedor2, vendedor3, vendedor4, vendedor5));
	}

}
