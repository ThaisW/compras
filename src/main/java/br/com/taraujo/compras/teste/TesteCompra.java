package br.com.taraujo.compras.teste;

import br.com.taraujo.compras.servicos.CompraServico;

public class TesteCompra {
	public static void main(String[] args) {
		
		CompraServico compraServico = new CompraServico ();

//		@Compra Servico - Listar Compras - TesteOk
		compraServico.listarCompras();

//		@Compra Servico - Criar Compra - TesteOk
//		Compra compra = new Compra();
//		compra.setDataCompra(Date.valueOf(LocalDate.now()));
//		compra.setPreco(new PrecoServico().buscarPreco(1));
//		compra.setQuantidadeProduto(1);
//		compraServico.criarCompra(compra);
		
//		@Compra Servico - Excluir compra - TesteOk
//		Compra compra = new Compra ();
//		compra.setIdCompra(4);
//		compraServico.removerProdutodaCompra(compra);
		
		

	}

}
