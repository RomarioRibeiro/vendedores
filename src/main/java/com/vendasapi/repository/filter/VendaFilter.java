package com.vendasapi.repository.filter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vendasapi.model.Vendas;

public class VendaFilter implements Serializable{

	private static final long serialVersionUID = 1L;


	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataVenda;

	private BigDecimal valor;

	public Date getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	
}
