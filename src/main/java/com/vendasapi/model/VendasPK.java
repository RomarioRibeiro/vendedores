package com.vendasapi.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class VendasPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name ="codigo_venda")
	private Venda venda ;
	
	@ManyToOne
	@JoinColumn(name = "codigo_vendedor")
	private Vendedor vendedor;

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(venda, vendedor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VendasPK other = (VendasPK) obj;
		return Objects.equals(venda, other.venda) && Objects.equals(vendedor, other.vendedor);
	}
	
	
	
	
}
