package Biblioteca;

public class Livro {
    private String titulo;
	private int publi_id;
	private String tipo_livro;
	private String autor;
	private int numpaginas;
	private int numedicao;
	private String Editora;
	private int ano_publicacao;
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getPubli_id() {
		return publi_id;
	}
	public void setPubli_id(int publi_id) {
		this.publi_id = publi_id;
	}
	public String getTipo_livro() {
		return tipo_livro;
	}
	public void setTipo_livro(String tipo_livro) {
		this.tipo_livro = tipo_livro;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public int getNumpaginas() {
		return numpaginas;
	}
	public void setNumpaginas(int numpaginas) {
		this.numpaginas = numpaginas;
	}
	public int getNumedicao() {
		return numedicao;
	}
	public void setNumedicao(int numedicao) {
		this.numedicao = numedicao;
	}
	public String getEditora() {
		return Editora;
	}
	public void setEditora(String editora) {
		Editora = editora;
	}
	public int getAno_publicacao() {
		return ano_publicacao;
	}
	public void setAno_publicacao(int ano_publicacao) {
		this.ano_publicacao = ano_publicacao;
	}
}
