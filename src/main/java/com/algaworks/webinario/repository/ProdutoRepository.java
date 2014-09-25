package com.algaworks.webinario.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.apache.commons.lang3.StringUtils;

import com.algaworks.webinario.model.Produto;

public class ProdutoRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public Produto guardar(Produto produto) {
		// controlar transação aqui pode não ser o melhor lugar
		// mas fiz isso apenas para esse exemplo ficar mais simples
		manager.getTransaction().begin();
		produto = manager.merge(produto);
		manager.getTransaction().commit();
		
		return produto;
	}
	
	public List<Produto> porDescricao(String descricao) {
		String query = "from Produto where descricao like :descricao "
				+ "order by nivelDiversao desc";
		
		return manager.createQuery(query, Produto.class)
				.setParameter("descricao", "%" + StringUtils.defaultIfBlank(descricao, "") + "%")
				.getResultList();
	}

	public Produto porId(Long id) {
		return manager.find(Produto.class, id);
	}
	
}