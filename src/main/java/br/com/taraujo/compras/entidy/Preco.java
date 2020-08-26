package br.com.taraujo.compras.entidy;

import javax.persistence.Entity;

@Entity(name = "Preco")

public class Preco {

	private int idPreco;
	private double valor;
	private int idMercado;
	private int idProduto;

	

	public int getIdPreco() {
		return idPreco;
	}

	public void setIdPreco(int idPreco) {
		this.idPreco = idPreco;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getIdMercado() {
		return idMercado;
	}

	public void setIdMercado(int idMercado) {
		this.idMercado = idMercado;
	}

	public int getIdproduto() {
		return idProduto;
	}

	public void setIdproduto(int idproduto) {
		this.idProduto = idproduto;
	}

	

	

}
