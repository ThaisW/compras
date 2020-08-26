package br.com.taraujo.compras.teste;

import br.com.taraujo.compras.servicos.PrecoServico;

public class TestePreco {

	public static void main(String[] args) {
		
		PrecoServico precoServico = new PrecoServico ();

//		@Preco Servico - Buscar preco - Teste Ok;
		precoServico.buscarPreco(1);

//		@Preco Servico - Listar precos - Teste ok;
//		precoServico.listarPrecos();

		
//		@Preco Servico - criar preco - Teste ok;
//		PrecoModel preco = new PrecoModel();
//
//		MercadoModel mercadoModel = new MercadoModel();
//		mercadoModel.setIdMercado(1);
//		preco.setMercado(mercadoModel);
//
//		ProdutoModel produtoModel = new ProdutoModel();
//		produtoModel.setIdProduto(1);
//		preco.setProduto(produtoModel);
//
//		preco.setValor(10.00);
//
//		precoServico.criarPreco(preco);
		
		

//		@Preco Servicos - Excluir preco - Teste
//		PrecoModel precoModel = new PrecoModel ();
//		precoModel.setIdPreco(2);
//		precoServico.excluirPreco(precoModel);

	}

}
