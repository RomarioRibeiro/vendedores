package com.vendasapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vendasapi.model.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {

}
