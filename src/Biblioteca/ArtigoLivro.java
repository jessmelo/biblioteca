package Biblioteca;

public class ArtigoLivro {
    private String titulo_artigo;
    private String titulo_livro;
    private String titulo_original;
    private int edicao;
    private int numcapitulo;
    private int ano_publicacao;
    
    public String getTituloArtigo() {
        return this.titulo_artigo;
    }
    public void setTituloArtigo(String novo) {
        this.titulo_artigo = novo;
    }
    public String getTituloLivro() {
        return this.titulo_livro;
    }
    public void setTituloLivro(String novo) {
        this.titulo_livro = novo;
    }
    public String getTituloOriginal() {
        return this.titulo_original;
    }
    public void setTituloOriginal(String novo) {
        this.titulo_original = novo;
    }
    public int getEdicao() {
        return this.edicao;
    }
    public void setEdicao(int novo) {
        this.edicao = novo;
    }
    public int getNumCapitulo() {
        return this.numcapitulo;
    }
    public void setNumCapitulo(int novo) {
        this.numcapitulo = novo;
    }
    public int getAnoPublicacao() {
        return this.ano_publicacao;
    }
    public void setAnoPublicacao(int novo) {
        this.ano_publicacao = novo;
    }

}
