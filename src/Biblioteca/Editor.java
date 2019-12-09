package Biblioteca;

public class Editor {
    private String nome_editor;
    private String titulo_livro;
    
    public String getNome() {
        return this.nome_editor;
    }
    public void setNome(String novo) {
        this.nome_editor = novo;
    }
    public String getTituloLivro() {
        return this.titulo_livro;
    }
    public void setTituloLivro(String novo) {
        this.titulo_livro = novo;
    }

}
