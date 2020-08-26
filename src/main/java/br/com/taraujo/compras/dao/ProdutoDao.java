package br.com.taraujo.compras.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.taraujo.compras.config.ConnectionFactory;
import br.com.taraujo.compras.entidy.Produto;

public class ProdutoDao {

	private Connection connection;

	public ProdutoDao() {

		try {
			this.connection = new ConnectionFactory().recuperarConexao();
		} catch (SQLException e) {
			System.out.println(
					"Não foi possivel estabelecer a conexão com o banco de dados entre em contato com o administrador: "
							+ e.getMessage());
		} catch (Exception e) {
			System.out.println("Ocorreu um erro não identificado: " + e.getMessage());
		}

	}

	public Produto buscarProdutoPorNome(Produto prod) {
		try {
			PreparedStatement stm = connection.prepareStatement("select * from produtos where nome_produto = ?");
			stm.setString(1, prod.getNome());
			stm.execute();
			ResultSet resultado = stm.getResultSet();
			Produto produto = new Produto();

			while (resultado.next()) {

				produto.setIdProduto(resultado.getInt(1));
				produto.setNome(resultado.getString(2));
				produto.setDescricao(resultado.getString(3));
				produto.setMarca(resultado.getString(4));

			}

			connection.close();
			return produto;

		} catch (SQLException e) {

			throw new RuntimeException("Ocorreu um erro ao buscar o produto: " + e.getMessage());
		} catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro não identificado: " + e.getMessage());

		}
	}

	public Produto buscarProdutoPorId(Produto prod) {
		try {
			PreparedStatement stm = connection.prepareStatement("select * from produtos where id_produto = ?");
			stm.setInt(1, prod.getIdProduto());
			stm.execute();
			ResultSet resultado = stm.getResultSet();
			Produto produto = new Produto();

			while (resultado.next()) {

				produto.setIdProduto(resultado.getInt(1));
				produto.setNome(resultado.getString(2));
				produto.setDescricao(resultado.getString(3));
				produto.setMarca(resultado.getString(4));

			}

			connection.close();
			return produto;

		} catch (SQLException e) {

			throw new RuntimeException("Ocorreu um erro ao buscar o produto: " + e.getMessage());
		} catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro não identificado: " + e.getMessage());

		}
	}

	public List<Produto> listarProdutos() {

		try {
			Statement stm = connection.createStatement();
			stm.execute("Select * from produtos");
			ResultSet resultado = stm.getResultSet();

			List<Produto> Produtos = new ArrayList<>();

			while (resultado.next()) {

				Produto produto = new Produto();
				produto.setIdProduto(resultado.getInt(1));
				produto.setNome(resultado.getString(2));
				produto.setDescricao(resultado.getString(3));
				produto.setMarca(resultado.getString(4));
				Produtos.add(produto);
			}

			connection.close();
			return Produtos;

		} catch (SQLException e) {
			throw new RuntimeException("Ocorreu um erro na busca do produto: " + e.getMessage());

		} catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro não identificado: " + e.getMessage());

		}
	}

	public void criarProduto(Produto produto) {

		try {
			PreparedStatement stm = connection.prepareStatement(
					"insert into produtos (nome_produto, descricao_produto, marca_produto) values (?,?,?)");
			stm.setString(1, produto.getNome());
			stm.setString(2, produto.getDescricao());
			stm.setString(3, produto.getMarca());
			stm.execute();
			connection.close();

		} catch (SQLException e) {
			throw new RuntimeException("Ocorreu um erro ao inserir o produto: " + e.getMessage());

		} catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro não identificado: " + e.getMessage());
		}

	}

	public void excluirProduto(Produto produto) {

		try {

			PreparedStatement stm = connection.prepareStatement("Delete from produtos where nome_produto = ?");
			stm.setString(1, produto.getNome());
			stm.execute();
			connection.close();

		} catch (SQLException e) {
			throw new RuntimeException("Aconteceu um erro ao tentar excluir o produto: " + e.getMessage());
		} catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro não identificado: " + e.getMessage());
		}

	}
}