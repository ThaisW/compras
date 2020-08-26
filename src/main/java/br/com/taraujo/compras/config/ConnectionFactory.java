package br.com.taraujo.compras.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	
		
		public Connection recuperarConexao () throws SQLException {
			
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/compras?useTimezone=true&serverTimezone=UTC","root","Willyanmeumundo");
				
		
		
		}
		
		

}
