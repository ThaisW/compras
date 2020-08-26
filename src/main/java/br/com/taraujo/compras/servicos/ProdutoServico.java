package br.com.taraujo.compras.servicos;

import java.util.ArrayList;
import java.util.List;

import br.com.taraujo.compras.dao.ProdutoDao;
import br.com.taraujo.compras.model.ProdutoModel;

public class ProdutoServico {

	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ProdutoServico.class);

	public List<ProdutoModel> listarProdutos() {
		ProdutoDao produtoDao = new ProdutoDao();
		List<ProdutoModel> produtos = new ArrayList<>();

		produtoDao.listarProdutos().forEach(p -> {
			ProdutoModel produto = new ProdutoModel();
			produto.setDescricao(p.getDescricao());
			produto.setIdProduto(p.getIdProduto());
			produto.setMarca(p.getMarca());
			produto.setNome(p.getNome());
			produtos.add(produto);
		});

		produtos.forEach(p -> System.out.println(p.toString().concat("\n")));
		return produtos;
	}

	public void criarProduto(ProdutoModel produt) {
		ProdutoDao produtoDao = new ProdutoDao();
		br.com.taraujo.compras.entidy.Produto p = new br.com.taraujo.compras.entidy.Produto();
		p.setDescricao(produt.getDescricao());
		p.setIdProduto(produt.getIdProduto());
		p.setMarca(produt.getMarca());
		p.setNome(produt.getNome());
		produtoDao.criarProduto(p);
		log.info("Produto criado com sucesso!");

	}

	public void excluirProduto(ProdutoModel produto) {
		ProdutoDao produtoDao = new ProdutoDao();
		br.com.taraujo.compras.entidy.Produto p = new br.com.taraujo.compras.entidy.Produto();
		produtoDao.excluirProduto(p);
		log.info("Produto excluido com sucesso!");

	}

	public ProdutoModel buscarProdutoPorNome(String nome) {
		ProdutoDao produtoDao = new ProdutoDao();
		br.com.taraujo.compras.entidy.Produto p = new br.com.taraujo.compras.entidy.Produto();
		p.setNome(nome);
		p = produtoDao.buscarProdutoPorNome(p);
		ProdutoModel produto = new ProdutoModel();
		produto.setDescricao(p.getDescricao());
		produto.setMarca(p.getMarca());
		produto.setNome(p.getNome());
		produto.setIdProduto(p.getIdProduto());
		System.out.println(produto.toString());
		return produto;

	}

	public ProdutoModel buscarProdutoPorId(int id) {

		ProdutoDao produtoDao = new ProdutoDao();
		br.com.taraujo.compras.entidy.Produto p = new br.com.taraujo.compras.entidy.Produto();
		p.setIdProduto(id);
		p = produtoDao.buscarProdutoPorId(p);
		ProdutoModel produto = new ProdutoModel();
		produto.setDescricao(p.getDescricao());
		produto.setIdProduto(p.getIdProduto());
		produto.setMarca(p.getMarca());
		produto.setNome(p.getNome());
		System.out.println(produto.toString());
		return produto;

	}

}
