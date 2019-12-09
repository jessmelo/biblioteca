package Biblioteca;

import java.sql.SQLException;

public class Main {
	public static void main(String[] args) throws SQLException {
		System.out.println("Lista de autores:");
		Pesquisas.listarAutores();
		System.out.println("\n");

		System.out.println("Lista de publicação por tema:");
		Pesquisas.listarPublicacoesTema();
		System.out.println("\n");

		System.out.println("Lista de publicações por título:");
		Pesquisas.listarPublicacoesTitulo();
		System.out.println("\n");

		System.out.println("Lista de artigos de anais:");
		Pesquisas.listarArtigosAnais();
		System.out.println("\n");
	}
}
