package Biblioteca;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UltimoID {
	public static List<Publicacao> getUltimo() throws SQLException {
	    Connection con = new ConnectionFactory().getConnection();
	
	    // cria um preparedStatement
	    String sql = "select titulo, publi_id from publicacao order by publi_id desc limit 1";
	    PreparedStatement getUltimo = con.prepareStatement(sql);
	    ResultSet rs = getUltimo.executeQuery();
	    
	    List<Publicacao> titulos = new ArrayList<Publicacao>();
	
	    while (rs.next()) {
	    	Publicacao titulo = new Publicacao();
	    	titulo.setTitulo(rs.getString("titulo"));
	
	    	titulos.add(titulo);
	    }
	    rs.close();
	    getUltimo.close();
        return titulos;
	}
	
	  public static String getUltimoTitulo() throws SQLException {
	        List<Publicacao> titulos = UltimoID.getUltimo();
	        String ultimotitulo = " ";
	        for (Publicacao titulo : titulos) {
	        	ultimotitulo = titulo.getTitulo();
	        }
		    return ultimotitulo;
	    }
	  

}
