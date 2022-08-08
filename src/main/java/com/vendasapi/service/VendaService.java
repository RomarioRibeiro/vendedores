package com.vendasapi.service;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vendasapi.model.Venda;
import com.vendasapi.model.Vendas;
import com.vendasapi.model.VendasPK;
import com.vendasapi.model.Vendedor;
import com.vendasapi.repository.VendaRepository;
import com.vendasapi.repository.VendasRepository;

@Service
public class VendaService {
	
	@Autowired
	private VendasRepository vendasRepository;
	
	@Autowired
	private VendedorService vendedorService;
	
	@Autowired
	private VendaRepository vendaRepository;
	
	public Venda adicionarUmaVenda(Venda obj ) {
		Venda venda = new Venda();
		venda.setCodigo(null);
		venda.setDataVenda(new Date());
		venda.setValor(obj.getValor());
		Vendedor vend = vendedorService.buscarPorCodigo(obj.getVendedor().getCodigo());
		venda.setVendedor(vend);
		System.out.println(obj.getVendedor());
		System.out.println(vend);
		vendaRepository.save(venda);
		BigDecimal somaDaVenda = new BigDecimal(0);
		for(Vendas vens :  obj.getVen()) {
			vens.setMediaVendas(vens.getMediaVendas().add(vens.getMediaVendas()));
		VendasPK vdPK = new VendasPK();
		vdPK.setVenda(venda);
		vens.setCodigo(vdPK);
		vendasRepository.save(vdPK);
		
		}
		return vendaRepository.save(venda);
	}
	
	

	
}
