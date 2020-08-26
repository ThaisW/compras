package br.com.taraujo.compras.servicos;

import java.util.ArrayList;
import java.util.List;
import br.com.taraujo.compras.dao.PrecoDao;
import br.com.taraujo.compras.model.PrecoModel;


public class PrecoServico {
	
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(PrecoServico.class);


	public List<PrecoModel> listarPrecos() {
		PrecoDao precoDao = new PrecoDao();

		List<PrecoModel> precos = new ArrayList<>();
		precoDao.ListarPrecos().forEach(p -> {
			PrecoModel preco = new PrecoModel();
			preco.setIdPreco(p.getIdPreco());
			preco.setValor(p.getValor());			
			preco.setMercado(new MercadoServico().bucarMercadoPorId(p.getIdMercado()));
			preco.setProduto(new ProdutoServico().buscarProdutoPorId(p.getIdproduto()));
			precos.add(preco);
			
		});

		precos.forEach(p -> System.out.println(p.toString()));
		return precos;

	}

	public PrecoModel buscarPreco(int id) {
		PrecoModel preco = new PrecoModel();
		PrecoDao precoDao = new PrecoDao();
		br.com.taraujo.compras.entidy.Preco p = precoDao.buscarPreco(id);
		preco.setIdPreco(p.getIdPreco());
		preco.setMercado(new MercadoServico().bucarMercadoPorId(p.getIdMercado()));
		preco.setProduto(new ProdutoServico().buscarProdutoPorId(p.getIdproduto()));
		preco.setValor(p.getValor());
		return preco;

	}

	public void criarPreco(PrecoModel preco) {
		PrecoDao precoDao = new PrecoDao();
		br.com.taraujo.compras.entidy.Preco p = new br.com.taraujo.compras.entidy.Preco();
		p.setValor(preco.getValor());
		p.setIdPreco(preco.getIdPreco());
		p.setIdproduto(preco.getProduto().getIdProduto());
		p.setIdMercado(preco.getMercado().getIdMercado());
		precoDao.criarPreco(p);
		log.info("Preço criado!");
	}

	public void excluirPreco(PrecoModel preco) {

		PrecoDao precoDao = new PrecoDao();
		br.com.taraujo.compras.entidy.Preco p = new br.com.taraujo.compras.entidy.Preco();
		p.setIdPreco(preco.getIdPreco());
		precoDao.excluirPreco(p);
		log.info("Preco excluido com sucesso!");
	}

}
