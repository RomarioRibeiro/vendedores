package com.vendasapi.model;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Vendas.class)
public abstract class Vendas_ {

	public static volatile SingularAttribute<Vendas, VendasPK> codigo;
	public static volatile SingularAttribute<Vendas, BigDecimal> totalVendas;
	public static volatile SingularAttribute<Vendas, BigDecimal> mediaVendas;

	public static final String CODIGO = "codigo";
	public static final String TOTAL_VENDAS = "totalVendas";
	public static final String MEDIA_VENDAS = "mediaVendas";

}

