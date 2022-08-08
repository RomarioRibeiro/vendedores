package com.vendasapi.repository.projection;

import java.math.BigDecimal;
import java.util.Date;

public class ResumoVenda {

	private Long codigo;
	private Date dataVenda;
	private BigDecimal valor;
	private String vendedor;

	

	public ResumoVenda(Long codigo, Date dataVenda, BigDecimal valor, String vendedor) {
		this.codigo = codigo;
		this.dataVenda = dataVenda;
		this.valor = valor;
		this.vendedor = vendedor;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

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

	public String getVendedor() {
		return vendedor;
	}

	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}


}
