package com.vendasapi.resource;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Vendedor> buscarPorCodigo(@PathVariable Long codigo){
		
		return vendedorRepository.findById(codigo).map(ResponseEntity::ok).orElse(ResponseEntity.noContent().build());
	}
	
	@PostMapping
	public ResponseEntity<Vendedor> criarVendedor(@Valid @RequestBody Vendedor vendedor, HttpServletResponse response) {
		Vendedor vendedorSalva = vendedorRepository.save(vendedor);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{codigo}")
		.buildAndExpand(vendedorSalva.getCodigo()).toUri();
		
		return ResponseEntity.created(uri).body(vendedorSalva);
	}
	
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removerVendedor(@PathVariable Long codigo) {
		this.vendedorRepository.deleteById(codigo);
	}
}
