package com.vendasapi.repository.venda;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.vendasapi.model.Venda;
import com.vendasapi.model.Venda_;
import com.vendasapi.model.Vendedor_;
import com.vendasapi.repository.filter.VendaFilter;
import com.vendasapi.repository.projection.ResumoVenda;

public class VendaRepositoryImpl implements VendaRepositoryQuery {

	@Autowired
	private EntityManager entityManager;

	@Override
	public Page<Venda> filter(VendaFilter vendaFilter, Pageable pageable) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Venda> criteria = builder.createQuery(Venda.class);
		Root<Venda> root = criteria.from(Venda.class);

		// criar restrições
		Predicate[] predicate = criarRestricoes(vendaFilter, builder, root);
		criteria.where(predicate);

		TypedQuery<Venda> query = entityManager.createQuery(criteria);
		adicionarRegistracoesDePaginacao(query, pageable);

		return new PageImpl<>(query.getResultList(), pageable, total(vendaFilter));
	}

	private Predicate[] criarRestricoes(VendaFilter vendaFilter, CriteriaBuilder builder, Root<Venda> root) {
		List<Predicate> pridicates = new ArrayList<>();
 		
		
		if(vendaFilter.getDataVenda() != null) {
			pridicates.add(builder.greaterThanOrEqualTo(root.get(Venda_.dataVenda), vendaFilter.getDataVenda()));
		}
		
		
		
		return pridicates.toArray(new Predicate[pridicates.size()]);
	}

	

	@Override
	public Page<ResumoVenda> resumir(VendaFilter vendaFilter, Pageable pageable) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<ResumoVenda> criteria = builder.createQuery(ResumoVenda.class);
		Root<Venda> root = criteria.from(Venda.class);
		
		criteria.select(builder.construct(ResumoVenda.class
				, root.get(Venda_.codigo), root.get(Venda_.dataVenda)
				, root.get(Venda_.valor)
				, root.get(Venda_.vendedor).get(Vendedor_.nome)));
		
		Predicate[] predicates = criarRestricoes(vendaFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<ResumoVenda> query = entityManager.createQuery(criteria);
		adicionarRegistracoesDePaginacao(query, pageable);
		
		return new PageImpl<>(query.getResultList(), pageable, total(vendaFilter)) ;
	}

	private Long total(VendaFilter vendaFilter) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Venda> root = criteria.from(Venda.class);
		
		Predicate[] predicate = criarRestricoes(vendaFilter, builder, root);
		criteria.where(predicate);
		
		criteria.select(builder.count(root));
		return entityManager.createQuery(criteria).getSingleResult();
	}

	private void adicionarRegistracoesDePaginacao(TypedQuery<?> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalRegistrosPorPagina = pageable.getPageSize();
		int primeiroRegistroDaPagina= paginaAtual * totalRegistrosPorPagina;
		
		query.setFirstResult(primeiroRegistroDaPagina);
		query.setMaxResults(totalRegistrosPorPagina);
	}

}
