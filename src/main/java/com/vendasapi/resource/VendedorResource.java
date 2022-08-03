package com.vendasapi.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vendasapi.model.Vendedor;
import com.vendasapi.repository.VendedorRepository;

@RestController
@RequestMapping("/vendedores")
public class VendedorResource {

	@Autowired
	private VendedorRepository vendedorRepository;
	
	@GetMapping
	public ResponseEntity<?> listar(){
	List<Vendedor> vendedor = vendedorRepository.findAll();
	
		return !vendedor.isEmpty() ? ResponseEntity.ok(vendedor): ResponseEntity.noContent().build();
	}
	
}
