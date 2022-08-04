package com.vendasapi.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vendasapi.event.RecursoCriadoEvent;
import com.vendasapi.model.Venda;
import com.vendasapi.repository.VendaRepository;

@RestController
@RequestMapping("/vendas")
public class VendaResource {

	@Autowired
	private VendaRepository vendaRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	
	@GetMapping
	public ResponseEntity<?> listar() {
		List<Venda> venda = vendaRepository.findAll();
				
		return !venda.isEmpty() ? ResponseEntity.ok(venda): ResponseEntity.notFound().build();
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Venda> buscarPorCodigo(@PathVariable Long codigo) {
		return vendaRepository.findById(codigo).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
				
				
	}
	
	
	@PostMapping
	public ResponseEntity<Venda> criarVenda(@RequestBody Venda venda, HttpServletResponse response) {
		Venda vendaSalva = vendaRepository.save(venda);
			
		publisher.publishEvent(new RecursoCriadoEvent(this, response, vendaSalva.getCodigo()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(vendaSalva);
	}
	
	
}