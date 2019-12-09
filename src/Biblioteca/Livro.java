package Biblioteca;

public class Livro {
    private String titulo;
    private String titulo_original;
    private String tipo_livro;
    private int numpaginas;
    private int numedicao;
    private String editora;
    private int ano_publicacao;
    
    public String getTitulo() {
        return this.titulo;
    }
    public void setTitulo(String novo) {
        this.titulo = novo;
    }
    public String getTituloOriginal() {
        return this.titulo_original;
    }
    public void setTituloOriginal(String novo) {
        this.titulo_original = novo;
    }
    public String getTipoLivro() {
        return this.tipo_livro;
    }
    public void setTipoLivro(String novo) {
        this.tipo_livro = novo;
    }
    public int getNumPaginas() {
        return this.numpaginas;
    }
    public void setNumPaginas(int novo) {
        this.numpaginas = novo;
    }
    public int getNumEdicao() {
        return this.numedicao;
    }
    public void setNumEdicao(int novo) {
        this.numedicao = novo;
    }
    public String getEditora() {
        return this.editora;
    }
    public void setEditora(String novo) {
        this.editora = novo;
    }
    public int getAnoPublicacao() {
        return this.ano_publicacao;
    }
    public void setAnoPublicacao(int novo) {
        this.ano_publicacao = novo;
    }
}	


