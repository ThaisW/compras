package br.com.taraujo.compras.servicos;

import java.util.ArrayList;
import java.util.List;

import br.com.taraujo.compras.dao.MercadoDao;
import br.com.taraujo.compras.model.MercadoModel;

public class MercadoServico {

	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(MercadoServico.class);

	public MercadoModel bucarMercadoPorId(int id) {
		br.com.taraujo.compras.entidy.Mercado m = new br.com.taraujo.compras.entidy.Mercado();
		MercadoDao mercadoDao = new MercadoDao();
		m = mercadoDao.buscarMercadoPorId(id);
		MercadoModel mercado = new MercadoModel();
		mercado.setIdMercado(m.getIdMercado());
		mercado.setNome(m.getNome());
		System.out.println(mercado.toString());
		return mercado;

	}

	public List<MercadoModel> listarmercados() {
		MercadoDao mercadoDao = new MercadoDao();
		List<MercadoModel> mercados = new ArrayList<>();

		mercadoDao.listarMercado().forEach(m -> {
			MercadoModel mercado = new MercadoModel();
			mercado.setIdMercado(m.getIdMercado());
			mercado.setNome(m.getNome());
			mercados.add(mercado);
		});

		mercados.forEach(m -> System.out.println(m.toString()));
		return mercados;
	}

	public void criarMercado(String nome) {
		MercadoDao mercadoDao = new MercadoDao();
		mercadoDao.criarMercado(nome);
		log.info("Mercado criado com sucesso!");
	}

	public void excluirMercado(String nome) {
		MercadoDao mercadoDao = new MercadoDao();
		mercadoDao.excluirMercado(nome);
		log.info("Mercado excluido com sucesso!");
	}
}