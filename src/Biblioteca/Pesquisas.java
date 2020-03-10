package Biblioteca;

import java.sql.*;
import java.util.*;

public class Pesquisas {
	
    public static List<Autor> getLista() {
    	// obtem uma listagem em ordem alfabetica dos autores de todas as publicacoes
    	
        try {
    		Connection con = new ConnectionFactory().getConnection();
            List<Autor> autores = new ArrayList<Autor>();
            PreparedStatement stmt = con.prepareStatement("select * from autor order by nome_autor");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Autor autor = new Autor();
                autor.setNome_autor(rs.getString("nome_autor"));

                autores.add(autor);
            }
            rs.close();
            stmt.close();
            return autores;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<AutorLivros> getListaAutorLivros() {
    	// obtem uma listagem em ordem alfabetica dos autores de todas as publicacoes
    	
        try {
    		Connection con = new ConnectionFactory().getConnection();
            List<AutorLivros> autores = new ArrayList<AutorLivros>();
            PreparedStatement stmt = con.prepareStatement("select nome_autor, titulo_livro from autor_livros order by nome_autor");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
            	AutorLivros autor = new AutorLivros();
                autor.setNome_autor(rs.getString("nome_autor"));
                autor.setTitulo_livro(rs.getString("titulo_livro"));

                autores.add(autor);
            }
            rs.close();
            stmt.close();
            return autores;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    static void listarAutores() {
        List<AutorLivros> autores = Pesquisas.getListaAutorLivros();
        int i = 1;
        for (AutorLivros autor : autores) {
	        System.out.println(i + " - Título do Livro: " + autor.getTitulo_livro());
	        System.out.println("Autor: " + autor.getNome_autor());
	        i++;
        }
    }
    
    public static List<Publicacao> getListaPublicacoesTema() {
    	// obtem uma listagem em ordem alfabetica pelo tema de todas as publicacoes
    	
        try {
    		Connection con = new ConnectionFactory().getConnection();
            List<Publicacao> publis = new ArrayList<Publicacao>();
            PreparedStatement stmt = con.prepareStatement("select distinct titulo, tipo_publicacao from publicacao order by tipo_publicacao, titulo");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Publicacao publi = new Publicacao();
                publi.setTitulo(rs.getString("titulo"));
                publi.setTipoPublicacao(rs.getString("tipo_publicacao"));
                publis.add(publi);
            }
            rs.close();
            stmt.close();
            return publis;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    static void listarPublicacoesTema() {
        List<Publicacao> publis = Pesquisas.getListaPublicacoesTema();
        int i = 1;
        for (Publicacao publi : publis) {
	        System.out.println(i + " - " + publi.getTitulo() + " - " + publi.getTipoPublicacao());
	        i++;
        }
    }
    
    public static List<Publicacao> getListaPublicacoes() {
    	// obtem uma listagem em ordem alfabetica pelo titulo de todas as publicacoes
    	
        try {
    		Connection con = new ConnectionFactory().getConnection();
            List<Publicacao> publis = new ArrayList<Publicacao>();
            PreparedStatement stmt = con.prepareStatement("select distinct titulo, tipo_publicacao from publicacao order by titulo");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Publicacao publi = new Publicacao();
                publi.setTitulo(rs.getString("titulo"));
                publi.setTipoPublicacao(rs.getString("tipo_publicacao"));

                publis.add(publi);
            }
            rs.close();
            stmt.close();
            return publis;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    static void listarPublicacoesTitulo() {
        List<Publicacao> publis = Pesquisas.getListaPublicacoes();
        int i = 1;
        for (Publicacao publi : publis) {
	        System.out.println(i + " - " + publi.getTitulo());
	        i++;
        }
    }
    
    public static List<ArtigoAnais> getArtigosAnais() {
    	// obtem uma listagem dos artigos que constituem os anais de conferencia
    	
        try {
    		Connection con = new ConnectionFactory().getConnection();
            List<ArtigoAnais> artigos = new ArrayList<ArtigoAnais>();
            PreparedStatement stmt = con.prepareStatement("select distinct titulo from artigo_de_anais order by titulo");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
            	ArtigoAnais art = new ArtigoAnais();
                art.setTitulo(rs.getString("titulo"));

                artigos.add(art);
            }
            rs.close();
            stmt.close();
            return artigos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    static void listarArtigosAnais() {
        List<ArtigoAnais> artigos = Pesquisas.getArtigosAnais();
        int i = 1;
        for (ArtigoAnais art : artigos) {
	        System.out.println(i + " - " + art.getTitulo());
	        i++;
        }
    }
    
    public static List<ArtigoPeriodicos> getArtigosPeriodicos() {
        // obtem listagem cronológica de todos os ARTIGOS que constituem os numeros de um PERIoDICO, dados um ano de inicio e um ano de fim.	
            try {
        		Connection con = new ConnectionFactory().getConnection();
                List<ArtigoPeriodicos> artigosP = new ArrayList<ArtigoPeriodicos>();
                String q = "select distinct titulo from artigo_de_periodicos order by ano";
                Statement s = con.createStatement();
                //PreparedStatement stmt = con.prepareStatement("xgsgfjdy");
                ResultSet rs = s.executeQuery(q);
    	
                while (rs.next()) {
                	ArtigoPeriodicos art = new ArtigoPeriodicos();
                    art.setTitulo(rs.getString("titulo"));

                    artigosP.add(art);
                }
                rs.close();
                s.close();
                return artigosP;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        static void listarArtigosPeriodicos() {
            List<ArtigoPeriodicos> artigosP = Pesquisas.getArtigosPeriodicos();
            int i = 1;
            for (ArtigoPeriodicos art : artigosP) {
    	        System.out.println(i + " - " + art.getTitulo());
    	        i++;
            }
        }
    
}
