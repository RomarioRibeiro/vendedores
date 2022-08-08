package com.vendasapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vendasapi.model.Vendas;
import com.vendasapi.model.VendasPK;

@Repository
public interface VendasRepository extends JpaRepository<Vendas, Long>{

	void save(VendasPK vdPK);

}
