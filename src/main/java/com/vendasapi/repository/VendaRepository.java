package com.vendasapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vendasapi.model.Venda;
import com.vendasapi.repository.venda.VendaRepositoryQuery;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long>, VendaRepositoryQuery  {

}
