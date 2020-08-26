package br.com.taraujo.compras.model;

import java.sql.Date;

public class CompraModel {
	
	int quantidadeProduto;
    int idCompra;
	Date dataCompra;
	PrecoModel preco;
	
	@Override
	public String toString() {
		
		return
			  "Quantidade de Produto: "+ getQuantidadeProduto() + "\n"
			+ "Id da compra: "+ getIdCompra ()+ "\n"	
			+ "Data da compra: "+ getDataCompra ()+ "\n"
			+ "Preco da compra:"+ getPreco ().getValor()+"\n" 
			;
	}
	
	public int getQuantidadeProduto() {
		return quantidadeProduto;
	}
	public void setQuantidadeProduto(int quantidadeProduto) {
		this.quantidadeProduto = quantidadeProduto;
	}
	public int getIdCompra() {
		return idCompra;
	}
	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
	}
	public Date getDataCompra() {
		return dataCompra;
	}
	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}
	public PrecoModel getPreco() {
		return preco;
	}
	public void setPreco(PrecoModel preco) {
		this.preco = preco;
	}
	

}
