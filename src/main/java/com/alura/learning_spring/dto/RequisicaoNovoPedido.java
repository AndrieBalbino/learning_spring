package com.alura.learning_spring.dto;

import com.alura.learning_spring.model.Pedido;

public class RequisicaoNovoPedido {
	
	private String nomeProduto;
	private String urlProduto;
	private String urlImagem;
	private String descricao;
	
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public String getUrlProduto() {
		return urlProduto;
	}
	public void setUrlProduto(String urlProduto) {
		this.urlProduto = urlProduto;
	}
	public String getUrlImagem() {
		return urlImagem;
	}
	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Pedido toPedido() {
		Pedido pedido = new Pedido();
		pedido.setDescricao(this.descricao);
		pedido.setUrlImagem(this.urlImagem);
		pedido.setUrlProduto(this.urlProduto);
		pedido.setNomeProduto(this.nomeProduto);
		
		return pedido;
	}
	
	
}
