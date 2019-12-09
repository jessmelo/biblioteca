package Biblioteca;

public class LivroAnais {
    private String titulo;
    private String editora;
    private String cidade;
    private String estado;
    private String pais;
    private int volume;

    public String getTitulo() {
        return this.titulo;
    }
    public void setTitulo(String novo) {
        this.titulo = novo;
    }
    public String getEditora() {
        return this.editora;
    }
    public void setEditora(String novo) {
        this.editora = novo;
    }
    public String getCidade() {
        return this.cidade;
    }
    public void setCidade(String novo) {
        this.cidade = novo;
    }
    public String getEstado() {
        return this.estado;
    }
    public void setEstado(String novo) {
        this.estado = novo;
    }
    public String getPais() {
        return this.pais;
    }
    public void setPais(String novo) {
        this.pais = novo;
    }
    public int getVolume() {
        return this.volume;
    }
    public void setVolume(int novo) {
        this.volume = novo;
    }

}


