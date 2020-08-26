package br.com.taraujo.compras.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.taraujo.compras.config.ConnectionFactory;
import br.com.taraujo.compras.entidy.Preco;

public class PrecoDao {
	Connection connection;

	public PrecoDao() {

		try {
			ConnectionFactory connectionFactory = new ConnectionFactory();
			connection = connectionFactory.recuperarConexao();
		} catch (SQLException e) {
			throw new RuntimeException(
					"Ocorreu um erro ao realizar a conexão com o banco de dados, entre em contato com o administrador:"
							+ e.getMessage());
		} catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro não identificado: " + e.getMessage());
		}
	}

	public Preco buscarPreco(int id) {
		try {

			PreparedStatement stm = connection.prepareStatement("select * from precos where id_preco = ? ");
			stm.setDouble(1, id);
			stm.execute();
			ResultSet resultado = stm.getResultSet();
			Preco preco = new Preco();

			while (resultado.next()) {

				preco.setIdPreco(resultado.getInt(1));
				preco.setIdproduto(resultado.getInt(2));
				preco.setIdMercado(resultado.getInt(3));
				preco.setValor(resultado.getInt(4));

			}

			connection.close();
			return preco;

		} catch (SQLException e) {

			throw new RuntimeException("Ocorreu um erro ao buscar o produto: " + e.getMessage());
		} catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro não identificado: " + e.getMessage());

		}
	}

	public List<Preco> ListarPrecos() {

		try {
			Statement stm = connection.createStatement();
			stm.execute("Select * from Precos");

			ResultSet resultado = stm.getResultSet();
			List<Preco> Precos = new ArrayList<>();

			while (resultado.next()) {
				Preco preco = new Preco();
				preco.setIdPreco(resultado.getInt(1));
				preco.setIdproduto(resultado.getInt(2));
				preco.setIdMercado(resultado.getInt(3));
				preco.setValor(resultado.getInt(4));
				Precos.add(preco);

			}

			
			connection.close();
			return Precos;

		} catch (SQLException e) {
			throw new RuntimeException("Ocorreu um erro ao listar os precos: " + e.getMessage());
		} catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro não identificado: " + e.getMessage());
		}
	}

	public void criarPreco(Preco preco) {

		try {
			PreparedStatement stm = connection
					.prepareStatement("insert into Precos (id_mercado, id_produto,valor) values (?,?,?) ");
			
            stm.setInt(1, preco.getIdMercado());
			stm.setInt(2, preco.getIdproduto());
			stm.setDouble(3, preco.getValor());

			stm.execute();

			connection.close();
			
		} catch (SQLException e) {
			throw new RuntimeException("Ocorreu um erro ao criar o preco: " + e.getMessage());

		} catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro não identificado: " + e.getMessage());

		}
	}

	public void excluirPreco(Preco preco) {

		try {
			PreparedStatement stm = connection.prepareStatement("delete from Precos where id_preco = ?");
			stm.setInt(1, preco.getIdPreco());
			stm.execute();

			connection.close();
			

		} catch (SQLException e) {
			throw new RuntimeException("Ocorreu um erro ao excluir o produto" + e.getMessage());
		} catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro não identificado" + e.getMessage());

		}

	}
}
