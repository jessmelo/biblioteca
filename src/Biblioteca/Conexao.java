package Biblioteca;

import java.sql.*;

public class Conexao {
	
	static void PostgresDriver() {
		try {
			Class.forName("org.postgresql.Driver");	
		} 
		catch(ClassNotFoundException e) {
			System.out.print("Driver do Postgres não foi encontrado.");
		}
	}
		
	static void Query(Connection banco) {
		try {
			Statement st = banco.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM aluno");
			while (rs.next()) {
			    System.out.print("Column 1 returned ");
			    System.out.println(rs.getString(1));
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar consulta.");
		}

	}
}