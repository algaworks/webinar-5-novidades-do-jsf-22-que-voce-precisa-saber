package com.algaworks.webinario.controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.webinario.model.Produto;
import com.algaworks.webinario.repository.ProdutoRepository;

@Named
@RequestScoped
public class CatalogoProdutosBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ProdutoRepository produtos;

	private String descricao;

	private List<Produto> produtosFiltrados;

	public void consultar() {
		this.produtosFiltrados = produtos.porDescricao(descricao);
	}

	public List<Produto> getProdutosFiltrados() {
		return produtosFiltrados;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
