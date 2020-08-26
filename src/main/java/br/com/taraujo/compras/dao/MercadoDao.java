package br.com.taraujo.compras.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.taraujo.compras.config.ConnectionFactory;
import br.com.taraujo.compras.entidy.Mercado;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MercadoDao {

	Connection connection;

	public MercadoDao() {
		try {
			ConnectionFactory connectionFactory = new ConnectionFactory();
			connection = connectionFactory.recuperarConexao();
		} catch (SQLException e) {
			System.out.println("Ocorreu um erro ao realizar a conexao: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Ocorreu um erro não identificado: " + e.getMessage());

		}

	}

	public Mercado buscarMercadoPorId(int id) {
		try {
			PreparedStatement stm = connection.prepareStatement("select * from Mercados where id_mercado = ?");
			stm.setInt(1, id);
			stm.execute();
			ResultSet resultado = stm.getResultSet();
			Mercado mercado = new Mercado();

			while (resultado.next()) {

				mercado.setIdMercado(resultado.getInt(1));
				mercado.setNome(resultado.getString(2));

			}
			connection.close();
			return mercado;

		} catch (SQLException e) {

			throw new RuntimeException("Ocorreu um erro ao buscar o mercado: " + e.getMessage());

		} catch (Exception e) {

			throw new RuntimeException("Ocorreu um erro não identificado: " + e.getMessage());

		}

	}

	public Mercado buscarMercadoPorNome(String nome) {
		try {
			PreparedStatement stm = connection.prepareStatement("select * from Mercados where nome_mercado = ?");
			stm.setString(1, nome);
			stm.execute();
			ResultSet resultado = stm.getResultSet();
			Mercado mercado = new Mercado();

			while (resultado.next()) {

				mercado.setIdMercado(resultado.getInt(1));
				mercado.setNome(resultado.getString(2));

			}
			connection.close();
			return mercado;

		} catch (SQLException e) {

			throw new RuntimeException("Ocorreu um erro ao buscar o mercado: " + e.getMessage());

		} catch (Exception e) {

			throw new RuntimeException("Ocorreu um erro não identificado: " + e.getMessage());

		}

	}

	public List<Mercado> listarMercado() {
		try {
			Statement stm = connection.createStatement();
			stm.execute("Select * from Mercados");
			ResultSet resultado = stm.getResultSet();
			List<Mercado> Mercados = new ArrayList<>();

			while (resultado.next()) {
				Mercado mercado = new Mercado();
				mercado.setIdMercado(resultado.getInt(1));
				mercado.setNome(resultado.getString(2));
				Mercados.add(mercado);
			}

			connection.close();
			return Mercados;

		} catch (SQLException e) {
			throw new RuntimeException("Ocorreu um erro ao tentar buscar: " + e.getMessage());
		} catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro não identificado: " + e.getMessage());

		}

	}

	public void criarMercado(String nome) {

		try {
			PreparedStatement stm = connection.prepareStatement("insert into mercados (nome_mercado) values (?)",
					Statement.RETURN_GENERATED_KEYS);
			stm.setString(1, nome);
			stm.execute();
			connection.close();

		} catch (SQLException e) {
			throw new RuntimeException("Ocorreu um erro ao tentar criar um mercado: " + e.getMessage());

		} catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro não identificado: " + e.getMessage());

		}
	}

	public void excluirMercado(String nome) {

		try {
			PreparedStatement stm = connection.prepareStatement("Delete from mercados Where nome_mercado = ?");
			stm.setString(1, nome);
			stm.execute();
			connection.close();

		} catch (SQLException e) {

			throw new RuntimeException("Ocorreu um erro ao tentar excluir o mercado: " + e.getMessage());

		} catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro não identificado: " + e.getMessage());
		}

	}

}
