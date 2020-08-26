package br.com.taraujo.compras.teste;

import br.com.taraujo.compras.servicos.MercadoServico;

public class TesteMercado {

	public static void main(String[] args) {

		MercadoServico mercadoServico = new MercadoServico();

//		@Mercado Servico - Listar Mercados - ok		
		mercadoServico.listarmercados();

//		@Mercado Servico - buscar Mercado - ok
//		mercadoServico.bucarMercadoPorId(2);

//		@Mercado Servico - criar Mercado - ok
//		mercadoServico.criarMercado("Joanin");

//		@Mercado Servico - excluir Mercado - ok
//		mercadoServico.excluirMercado("Joanin");

	}

}
