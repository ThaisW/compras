package br.com.taraujo.compras.model;

public class ProdutoModel {

	int idProduto;
	String nome;
	String descricao;
	String marca;

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	@Override
	public String toString() {

		return "ID do produto: " + getIdProduto() + "\n" + "Nome do produto: " + getNome() + "\n"
				+ "Descrição do produto: " + getDescricao() + "\n" + "Marca do produto: " + getMarca();
	}

}
