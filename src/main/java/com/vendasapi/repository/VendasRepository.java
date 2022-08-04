package com.vendasapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vendasapi.model.Vendas;

@Repository
public interface VendasRepository extends JpaRepository<Vendas, Long>{

}
