package Biblioteca;

public class Autor {
    private String nome_autor;
    private String titulo_livro;
    
    public String getNome() {
        return this.nome_autor;
    }
    public void setNome(String novo) {
        this.nome_autor = novo;
    }

    public String getTituloLivro() {
        return this.titulo_livro;
    }
    public void setTituloLivro(String novo) {
        this.titulo_livro = novo;
    }
}
