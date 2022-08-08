package com.vendasapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vendasapi.model.Vendedor;
import com.vendasapi.repository.VendedorRepository;

@Service
public class VendedorService {

	@Autowired
	private VendedorRepository vendedorRepository;
	
	public Vendedor buscarPorCodigo(Long codigo) throws IllegalAccessError {
		return vendedorRepository.findById(codigo).orElseThrow(() -> new IllegalAccessError()); 
	}


}
