package com.vendasapi.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Vendedor.class)
public abstract class Vendedor_ {

	public static volatile SingularAttribute<Vendedor, Long> codigo;
	public static volatile SingularAttribute<Vendedor, String> nome;
	public static volatile SetAttribute<Vendedor, Vendas> ven;

	public static final String CODIGO = "codigo";
	public static final String NOME = "nome";
	public static final String VEN = "ven";

}

