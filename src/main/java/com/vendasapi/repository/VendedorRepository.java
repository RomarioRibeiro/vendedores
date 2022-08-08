package com.vendasapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vendasapi.model.Vendedor;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, Long>{

	@Query(value="select * from vendedor where codigo = ?",nativeQuery = true )
    Vendedor find(Vendedor codigo);
	

	
}
