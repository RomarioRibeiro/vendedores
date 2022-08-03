package com.vendasapi;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.vendasapi.model.Venda;
import com.vendasapi.model.Vendedor;
import com.vendasapi.repository.VendaRepository;
import com.vendasapi.repository.VendedorRepository;

@SpringBootApplication
public class VendasApplication implements CommandLineRunner{

	@Autowired
	private VendedorRepository vendedorRepository;
	
	@Autowired
	private VendaRepository vendaRepository;
	
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

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
		Venda venda1 = new Venda();
		venda1.setCodigo(null);
		venda1.setDataVenda(sdf.parse("03/08/2022"));
		venda1.setMediaVendas(BigDecimal.valueOf(20));
		venda1.setTotalVendas(BigDecimal.valueOf(50));
		venda1.setValor(BigDecimal.valueOf(30));
		venda1.setVendedor(vendedor1);
		
		Venda venda2 = new Venda();
		venda2.setCodigo(null);
		venda2.setDataVenda(sdf.parse("02/08/2022"));
		venda2.setMediaVendas(BigDecimal.valueOf(25));
		venda2.setTotalVendas(BigDecimal.valueOf(55));
		venda2.setValor(BigDecimal.valueOf(35));
		venda2.setVendedor(vendedor2);
		
		
		Venda venda3 = new Venda();
		venda3.setCodigo(null);
		venda3.setDataVenda(sdf.parse("01/08/2022"));
		venda3.setMediaVendas(BigDecimal.valueOf(10));
		venda3.setTotalVendas(BigDecimal.valueOf(40));
		venda3.setValor(BigDecimal.valueOf(20));
		venda3.setVendedor(vendedor3);
		
		
		Venda venda4 = new Venda();
		venda4.setCodigo(null);
		venda4.setDataVenda(sdf.parse("31/07/2022"));
		venda4.setMediaVendas(BigDecimal.valueOf(21));
		venda4.setTotalVendas(BigDecimal.valueOf(51));
		venda4.setValor(BigDecimal.valueOf(31));
		venda4.setVendedor(vendedor4);
		
		
		Venda venda5 = new Venda();
		venda5.setCodigo(null);
		venda5.setDataVenda(sdf.parse("30/07/2022"));
		venda5.setMediaVendas(BigDecimal.valueOf(15));
		venda5.setTotalVendas(BigDecimal.valueOf(45));
		venda5.setValor(BigDecimal.valueOf(25));
		venda5.setVendedor(vendedor5);
		
		
			
		vendaRepository.saveAll(Arrays.asList(venda1, venda2, venda3, venda4, venda5));
		
	}

}
