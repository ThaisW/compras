package br.com.taraujo.compras.servicos;

import java.util.ArrayList;
import java.util.List;

import br.com.taraujo.compras.dao.CompraDao;
import br.com.taraujo.compras.model.CompraModel;

public class CompraServico {
	
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(CompraServico.class);

	public List<CompraModel> listarCompras() {

		CompraDao compraDao = new CompraDao();

		List<CompraModel> compras = new ArrayList<>();
		compraDao.listarCompras().forEach(c -> {
			CompraModel compra = new CompraModel();
			compra.setDataCompra(c.getDataCompra());
			compra.setIdCompra(c.getIdCompra());
			compra.setQuantidadeProduto(c.getQuantidadeProduto());
			compra.setPreco(new PrecoServico().buscarPreco(c.getIdPreco()));
			compras.add(compra);

		});

		compras.forEach(c -> System.out.println(c.toString()));
		return compras;
	}

	public void criarCompra(CompraModel compra) {
		CompraDao compraDao = new CompraDao();
		br.com.taraujo.compras.entidy.Compra c = new br.com.taraujo.compras.entidy.Compra();
		c.setDataCompra(compra.getDataCompra());
		c.setIdPreco(compra.getPreco().getIdPreco());
		c.setQuantidadeProduto(compra.getQuantidadeProduto());
		compraDao.criarCompra(c);
		log.info("Compra criada com sucesso!");
	}

	public void removerProdutodaCompra(CompraModel compra) {
		CompraDao compraDao = new CompraDao();
		br.com.taraujo.compras.entidy.Compra c = new br.com.taraujo.compras.entidy.Compra();
		c.setIdCompra(compra.getIdCompra());
		compraDao.excluirProdutodaCompra(c);
		log.info("Compra excluida com sucesso!");

	}

}
