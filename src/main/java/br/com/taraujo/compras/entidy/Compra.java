package br.com.taraujo.compras.entidy;

import java.sql.Date;

public class Compra {

	int quantidadeProduto;
	int idCompra;
    Date dataCompra;
	int idPreco;

	public int getQuantidadeProduto() {
		return quantidadeProduto;
	}

	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
	}

	public void setQuantidadeProduto(int quantidadeProduto) {
		this.quantidadeProduto = quantidadeProduto;
	}

	public int getIdCompra() {
		return idCompra;
	}



	public Date getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}

	public int getIdPreco() {
		return idPreco;
	}

	public void setIdPreco(int idPreco) {
		this.idPreco = idPreco;
	}

	
}
