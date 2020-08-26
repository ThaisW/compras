package br.com.taraujo.compras.model;
import javax.persistence.Entity;

@Entity(name="Preco")

public class PrecoModel {

	private int idPreco;
	private double valor;
	private MercadoModel mercado;
	private ProdutoModel produto;
	
	@Override
	public String toString() {
		
		return "Id Preço: " + getIdPreco() + "\n"
			 + "Preco: R$ " + getValor () + "\n"
			 + "Mercado: " + getMercado ().getNome() + "\n"
			 + "Produto: " + getProduto ().getNome() + "\n"	
				;
	}
	
	
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
	public MercadoModel getMercado() {
		return mercado;
	}
	public void setMercado(MercadoModel mercado) {
		this.mercado = mercado;
	}
	public ProdutoModel getProduto() {
		return produto;
	}
	public void setProduto(ProdutoModel produto) {
		this.produto = produto;
	}
	
}
