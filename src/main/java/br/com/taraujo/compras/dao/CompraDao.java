package br.com.taraujo.compras.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.taraujo.compras.config.ConnectionFactory;
import br.com.taraujo.compras.entidy.Compra;

public class CompraDao {
	Connection connection;

	public CompraDao() {
		try {
			ConnectionFactory connectionFactory = new ConnectionFactory();
			connection = connectionFactory.recuperarConexao();
		} catch (SQLException e) {
			throw new RuntimeException("Ocorreu um erro ao tentar conectar o banco de dados: " + e.getMessage());

		} catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro não identificado: " + e.getMessage());
		}

	}

	public List<Compra> listarCompras() {
		try {
			Statement stm = connection.createStatement();
			stm.execute("Select * from Compras");

			ResultSet resultado = stm.getResultSet();
			List<Compra> compras = new ArrayList<>();

			while (resultado.next()) {
				Compra compra = new Compra();
				compra.setIdCompra(resultado.getInt(1));
				compra.setQuantidadeProduto(resultado.getInt(2));
				compra.setIdPreco(resultado.getInt(4));
				compra.setDataCompra(resultado.getDate(3));
				compras.add(compra);

			}

			connection.close();
			return compras;

		} catch (SQLException e) {
			throw new RuntimeException("Ocorreu um erro ao tentar listar as compras: " + e.getMessage());

		} catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro não identificado: " + e.getMessage());
		}

	}

	public void criarCompra(Compra compra) {
		try {
			PreparedStatement stm = connection
					.prepareStatement("insert into compras (Quantidade,Data_Compra, ID_Preco) values (?,?,?)");
			stm.setInt(1, compra.getQuantidadeProduto());
			stm.setDate(2, compra.getDataCompra());
			stm.setInt(3, compra.getIdPreco());
			stm.execute();
			connection.close();

		} catch (SQLException e) {
			throw new RuntimeException("Ocorreu um erro ao criar a compra: " + e.getMessage());

		} catch (Exception e) {
			throw new RuntimeException("ocorreu um erro não identificado: " + e.getMessage());

		}

	}

	public void excluirProdutodaCompra(Compra compra) {
		try {
			PreparedStatement stm = connection.prepareStatement("delete from compras where id_compra = ? ");
			stm.setInt(1, compra.getIdCompra());
			stm.execute();
		} catch (SQLException e) {
			throw new RuntimeException("Ocorreu um erro ao deletar a compra");
		}
	}

}
