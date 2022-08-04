package com.vendasapi.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vendasapi.model.Venda;
import com.vendasapi.model.Vendedor;
import com.vendasapi.repository.VendaRepository;
import com.vendasapi.repository.VendasRepository;
import com.vendasapi.repository.VendedorRepository;

@Service
public class VendaService {
	
	@Autowired
	private VendedorRepository vendedorRepository;
	
	@Autowired
	private VendaRepository vendaRepository;
	
	public Venda adicionarUmaVenda(Venda obj) {
		Venda venda = new Venda();
		venda.setDataVenda(new Date());
		System.out.println(obj.getVendedor());
		Optional<Vendedor> vend = vendedorRepository.findById(obj.getCodigo());
		System.out.println(vend);
	
		
		
		
		return vendaRepository.save(venda);
	}
	
	
	
}
