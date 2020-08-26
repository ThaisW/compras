package br.com.taraujo.compras.teste;

import br.com.taraujo.compras.servicos.ProdutoServico;

public class TesteProduto {

	public static void main(String[] args) {

		ProdutoServico produtoServico = new ProdutoServico();

//		@Produto Servico - Listar Produtos - Teste ok;
		produtoServico.listarProdutos();

//		@Produto Servico - buscar produto por nome - Teste ok;
//		produtoServico.buscarProdutoPorNome("Achocolatado");

//		@Produto Servico - buscar produto por id - Teste ok;
//		produtoServico.buscarProdutoPorId(1);

//		@Produto Servico - criar produto - Teste ok;
//		ProdutoModel produtoModel = new ProdutoModel();
//		produtoModel.setNome("Farinha de trigo");
//		produtoModel.setMarca("Dona Benta");
//		produtoModel.setDescricao("1 kilo");
//		produtoServico.criarProduto(produtoModel);

//		@Produto Servico - excluir produto - Teste ok;
//		ProdutoModel produtoModel = new ProdutoModel();
//		produtoModel.setNome("Farinha de trigo");
//		produtoServico.excluirProduto(produtoModel);
	}

}
