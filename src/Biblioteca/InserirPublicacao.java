package Biblioteca;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InserirPublicacao {

	public static boolean novaPublicacao(String titulo,String tipo_publicacao,int numfolder, boolean digital, String armario, String local) throws SQLException {
        // conectando
        Connection con = new ConnectionFactory().getConnection();

        // cria um preparedStatement
        String sql = "insert into publicacao" +
                "(titulo, tipo_publicacao, numfolder, digital, armario, local)" +
                " values (?,?,?,?,?,?)";
        PreparedStatement novaPublicacao = con.prepareStatement(sql);

        // preenche os valores
        novaPublicacao.setString(1, titulo);
        novaPublicacao.setString(2, tipo_publicacao);
        novaPublicacao.setInt(3, numfolder);
        novaPublicacao.setBoolean(4, digital);
        novaPublicacao.setString(5, armario);
        novaPublicacao.setString(6, local);
        // executa
        novaPublicacao.execute();
        novaPublicacao.close();

        con.close();
        return true;
    }
	
	public static boolean novoAutor(String nome_autor) throws SQLException {
        // conectando
        Connection con = new ConnectionFactory().getConnection();

        // cria um preparedStatement
        String sql = "insert into autor" +
                "(nome_autor)" +
                " values (?)";
        PreparedStatement novoAutor = con.prepareStatement(sql);

        // preenche os valores
        novoAutor.setString(1, nome_autor);
        
        // executa
        novoAutor.execute();
        novoAutor.close();

        con.close();
        return true;
	}
	
	public static boolean novoLivroCap(String titulo,String autor,int numpaginas, int numedicao, String editora, int ano_publicacao) throws SQLException {
        // conectando
        Connection con = new ConnectionFactory().getConnection();

        // cria um preparedStatement
        String sql = "insert into livro" +
                "(titulo, tipo_livro, autor, numpaginas, numedicao, editora, ano_publicacao)" +
                " values (?,'LIVROCAP', ?,?,?,?,?)";
        PreparedStatement novoLivroCap = con.prepareStatement(sql);

        // preenche os valores
        novoLivroCap.setString(1, titulo);
        novoLivroCap.setString(2, autor);
        novoLivroCap.setInt(3, numpaginas);
        novoLivroCap.setInt(4, numedicao);
        novoLivroCap.setString(5, editora);
        novoLivroCap.setInt(6, ano_publicacao);
        
        // executa
        novoLivroCap.execute();
        novoLivroCap.close();

        con.close();
        return true;
    }
	
	public static boolean novoAutorLivros(String nome_autor,String titulo_livro) throws SQLException {
        // conectando
        Connection con = new ConnectionFactory().getConnection();

        // cria um preparedStatement
        String sql = "insert into autor_livros" +
                "(nome_autor, titulo_livro)" +
                " values (?,?)";
        PreparedStatement novoAutorLivros = con.prepareStatement(sql);

        // preenche os valores
        novoAutorLivros.setString(1, nome_autor);
        novoAutorLivros.setString(2, titulo_livro);
        
        // executa
        novoAutorLivros.execute();
        novoAutorLivros.close();

        con.close();
        return true;
    }
	
	public static boolean novoLivroArt(String titulo,String autor,int numpaginas, int numedicao, String editora, int ano_publicacao) throws SQLException {
        // conectando
        Connection con = new ConnectionFactory().getConnection();

        // cria um preparedStatement
        String sql = "insert into livro" +
                "(titulo, tipo_livro, autor, numpaginas, numedicao, editora, ano_publicacao)" +
                " values (?,'LIVROART', ?,?,?,?,?)";
        PreparedStatement novoLivroArt = con.prepareStatement(sql);

        // preenche os valores
        novoLivroArt.setString(1, titulo);
        novoLivroArt.setString(2, autor);
        novoLivroArt.setInt(3, numpaginas);
        novoLivroArt.setInt(4, numedicao);
        novoLivroArt.setString(5, editora);
        novoLivroArt.setInt(6, ano_publicacao);
        
        // executa
        novoLivroArt.execute();
        novoLivroArt.close();

        con.close();
        return true;
    }

	public static boolean novoLivroAnais(String titulo, String editora,String cidade,String estado, String pais, int volume) throws SQLException {
        // conectando
        Connection con = new ConnectionFactory().getConnection();

        // cria um preparedStatement
        String sql = "insert into livro_de_anais" +
                "(titulo, editora, cidade, estado, pais, volume)" +
                " values (?,?,?,?,?,?)";
        PreparedStatement novoLivroAnais = con.prepareStatement(sql);

        // preenche os valores
        novoLivroAnais.setString(1, titulo);
        novoLivroAnais.setString(2, editora);
        novoLivroAnais.setString(3, cidade);
        novoLivroAnais.setString(4, estado);
        novoLivroAnais.setString(5, pais);
        novoLivroAnais.setInt(6, volume);
        
        // executa
        novoLivroAnais.execute();
        novoLivroAnais.close();

        con.close();
        return true;
    }
	
	public static boolean novoPeriodico(String titulo, String primeirovolume, String ultimovolume, String editora) throws SQLException {
        // conectando
        Connection con = new ConnectionFactory().getConnection();

        // cria um preparedStatement
        String sql = "insert into PERIODICO" +
                "(titulo, PrimeiroVolume, UltimoVolume, editora)" +
                " values (?,?,?,?)";
        PreparedStatement novoPeriodico = con.prepareStatement(sql);

        // preenche os valores
        novoPeriodico.setString(1, titulo);
        novoPeriodico.setString(2, primeirovolume);
        novoPeriodico.setString(3, ultimovolume);
        novoPeriodico.setString(4, editora);
        
        // executa
        novoPeriodico.execute();
        novoPeriodico.close();

        con.close();
        return true;
    }
	
	public static boolean novaMonografia(String titulo, String ano, String mes, String local, String autor, String instituicao) throws SQLException {
        // conectando
        Connection con = new ConnectionFactory().getConnection();

        // cria um preparedStatement
        String sql = "insert into MONOGRAFIA" +
                "(titulo, ano, mes, local, autor, instituicao)" +
                " values (?,?,?,?,?,?)";
        PreparedStatement novaMonografia = con.prepareStatement(sql);

        // preenche os valores
        novaMonografia.setString(1, titulo);
        novaMonografia.setString(2, ano);
        novaMonografia.setString(3, mes);
        novaMonografia.setString(4, local);
        novaMonografia.setString(5, autor);
        novaMonografia.setString(6, instituicao);
        
        // executa
        novaMonografia.execute();
        novaMonografia.close();

        con.close();
        return true;
    }

}
