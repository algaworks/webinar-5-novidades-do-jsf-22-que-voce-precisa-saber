package com.algaworks.webinario.controller;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

import com.algaworks.webinario.model.Produto;
import com.algaworks.webinario.repository.ProdutoRepository;
import com.algaworks.webinario.util.JsfUtil;

@Named
@ViewScoped
public class CadastroProdutoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ProdutoRepository produtos;
	
	private Produto produto = new Produto();
	private Part foto;
	
	public void adicionar() throws IOException {
		this.produto.setFoto(IOUtils.toByteArray(this.foto.getInputStream()));
		
		this.produtos.guardar(this.produto);
		
		this.produto = new Produto();
		
		JsfUtil.adicionarMensagem("Produto adicionado com sucesso!");
	}

	public Produto getProduto() {
		return produto;
	}

	public Part getFoto() {
		return foto;
	}

	public void setFoto(Part foto) {
		this.foto = foto;
	}
	
}
