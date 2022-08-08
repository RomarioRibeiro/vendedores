package com.vendasapi.repository.venda;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.vendasapi.model.Venda;
import com.vendasapi.repository.filter.VendaFilter;
import com.vendasapi.repository.projection.ResumoVenda;

public interface VendaRepositoryQuery {

	
	public Page<Venda> filter(VendaFilter vendaFilter, Pageable pageable);
	public Page<ResumoVenda> resumir(VendaFilter vendaFilter, Pageable pageable);
	
}
