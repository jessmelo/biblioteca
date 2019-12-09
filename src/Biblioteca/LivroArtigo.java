package Biblioteca;

public class LivroArtigo {
    private String titulo;
    private String tipo_livro;
    private String editor;

    public String getTitulo() {
        return this.titulo;
    }
    public void setTitulo(String novo) {
        this.titulo = novo;
    }
    public String getTipoLivro() {
        return this.tipo_livro;
    }
    public void setTipoLivro(String novo) {
        this.tipo_livro = novo;
    }
    public String getEditor() {
        return this.editor;
    }
    public void setEditor(String novo) {
        this.editor = novo;
    }

}
