package com.vendasapi.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Venda.class)
public abstract class Venda_ {

	public static volatile SingularAttribute<Venda, Long> codigo;
	public static volatile SingularAttribute<Venda, Vendedor> vendedor;
	public static volatile SingularAttribute<Venda, Date> dataVenda;
	public static volatile SingularAttribute<Venda, BigDecimal> valor;
	public static volatile SetAttribute<Venda, Vendas> ven;

	public static final String CODIGO = "codigo";
	public static final String VENDEDOR = "vendedor";
	public static final String DATA_VENDA = "dataVenda";
	public static final String VALOR = "valor";
	public static final String VEN = "ven";

}

