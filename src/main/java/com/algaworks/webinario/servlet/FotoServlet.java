package com.algaworks.webinario.servlet;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import com.algaworks.webinario.model.Produto;
import com.algaworks.webinario.repository.ProdutoRepository;

@WebServlet(urlPatterns = "/foto")
public class FotoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	@Inject
	private ProdutoRepository produtos;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		Long idProduto = Long.valueOf(request.getParameter("produto"));
		
		Produto produto = produtos.porId(idProduto);
		
		response.setContentType("image/jpeg");
		IOUtils.write(produto.getFoto(), response.getOutputStream());
	}

}