package com.vendasapi.resource;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
import com.vendasapi.repository.filter.VendaFilter;
import com.vendasapi.repository.projection.ResumoVenda;
import com.vendasapi.service.VendaService;

@RestController
@RequestMapping("/vendas")
public class VendaResource {

	@Autowired
	private VendaRepository vendaRepository;
	
	@Autowired
	private VendaService vendaService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	
	@GetMapping
	public Page<Venda> pesquisar(VendaFilter vendaFilter, Pageable pageable) {
		return vendaRepository.filter(vendaFilter, pageable);
		
	}
	
	//paginação com um resulmo do dados informados localhost:8080/vendas?resumo
	@GetMapping(params = "resumo")
	public Page<ResumoVenda> resumir(VendaFilter vendaFilter, Pageable pageable) {
				
		return vendaRepository.resumir(vendaFilter, pageable);
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Venda> buscarPorCodigo(@PathVariable Long codigo) {
		return vendaRepository.findById(codigo).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
				
				
	}
	
	
	@PostMapping
	public ResponseEntity<Venda> criarVenda(@Valid @RequestBody Venda venda, HttpServletResponse response) {
		Venda vendaSalva = vendaService.adicionarUmaVenda(venda);
			
		publisher.publishEvent(new RecursoCriadoEvent(this, response, vendaSalva.getCodigo()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(vendaSalva);
	}
	
	
}
