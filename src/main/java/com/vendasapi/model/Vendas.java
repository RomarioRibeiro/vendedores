package com.vendasapi.model;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "vendas")
public class Vendas {

	@JsonIgnore
	@EmbeddedId
	private VendasPK codigo = new VendasPK();
	
	private BigDecimal totalVendas;
	
	private BigDecimal mediaVendas;

	public Vendas(Venda venda, Vendedor vendedor, BigDecimal totalVendas, BigDecimal mediaVendas) {
		super();
		this.totalVendas = totalVendas;
		this.mediaVendas = mediaVendas;
		codigo.setVenda(venda);
		codigo.setVendedor(vendedor);
	}

	public VendasPK getCodigo() {
		return codigo;
	}

	public void setCodigo(VendasPK codigo) {
		this.codigo = codigo;
	}

	public BigDecimal getTotalVendas() {
		return totalVendas;
	}

	public void setTotalVendas(BigDecimal totalVendas) {
		this.totalVendas = totalVendas;
	}

	public BigDecimal getMediaVendas() {
		return mediaVendas;
	}

	public void setMediaVendas(BigDecimal mediaVendas) {
		this.mediaVendas = mediaVendas;
	}

	public Venda getVenda() {
		return codigo.getVenda();
	}

	public void setVenda(Venda venda) {
		this.codigo.setVenda(venda);
	}
	
	
	public Vendedor getVendedor() {
		return codigo.getVendedor();
	}

	public void setVendedor(Vendedor vendedor) {
		this.codigo.setVendedor(vendedor);
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vendas other = (Vendas) obj;
		return Objects.equals(codigo, other.codigo);
	}
	
	
	
}
