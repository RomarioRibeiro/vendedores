package com.vendasapi.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vendasapi.model.Venda;
import com.vendasapi.repository.VendaRepository;
import com.vendasapi.repository.VendedorRepository;
import com.vendasapi.repository.filter.VendaFilter;

@Service
public class VendaService {
	
	@Autowired
	private VendedorRepository vendedorRepository;
	
	@Autowired
	private VendaRepository vendaRepository;
	
	public Venda adicionarUmaVenda(VendaFilter obj) {
		Venda venda = new Venda();
		venda.setCodigo(null);
		venda.setDataVenda(new Date());
		//System.out.println(obj.getVendedorCodigo());
//		Vendedor vend = vendedorRepository.find(obj.getVendedorCodigo());
//		System.out.println(vend);
//		venda.setVendedor(vend);
//		vendaRepository.save(venda);
		
		
		return vendaRepository.save(venda);
	}
	
	
	
	
}
