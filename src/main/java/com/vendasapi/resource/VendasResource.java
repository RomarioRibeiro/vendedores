package com.vendasapi.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vendasapi.model.Vendas;
import com.vendasapi.repository.VendasRepository;

@RestController
@RequestMapping("/totalvendas")
public class VendasResource {
	
	@Autowired
	private VendasRepository vendasRepository;
	
	@GetMapping
	public ResponseEntity<?> listaVendas() {
		List<Vendas> vendas = vendasRepository.findAll();
		return !vendas.isEmpty() ? ResponseEntity.ok(vendas) : ResponseEntity.notFound().build();
	}
	
}
