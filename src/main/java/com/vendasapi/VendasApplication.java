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
		
		Vendedor vendedor1 = new Vendedor();
		vendedor1.setCodigo(null);
		vendedor1.setNome("Romario Ribeiro");
		
		Vendedor vendedor2 = new Vendedor();
		vendedor2.setCodigo(null);
		vendedor2.setNome("João da Silva");
		
		Vendedor vendedor3 = new Vendedor();
		vendedor3.setCodigo(null);
		vendedor3.setNome("Maria das Rosas");
		
		Vendedor vendedor4 = new Vendedor();
		vendedor4.setCodigo(null);
		vendedor4.setNome("José Oliveira");
		
		Vendedor vendedor5 = new Vendedor();
		vendedor5.setCodigo(null);
		vendedor5.setNome("Luis das Couves");
		


		
		
		vendedorRepository.saveAll(Arrays.asList(vendedor1, vendedor2, vendedor3, vendedor4, vendedor5 ));
	}

}
