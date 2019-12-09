package Biblioteca;

public class Periodico {
    private String titulo;
    private String primeirovolume;
    private String ultimovolume;
    private String editora;
    
    public String getTitulo() {
        return this.titulo;
    }
    public void setTitulo(String novo) {
        this.titulo = novo;
    }
    public String getPrimeiroVolume() {
        return this.primeirovolume;
    }
    public void setPrimeiroVolume(String novo) {
        this.primeirovolume = novo;
    }
    public String getUltimoVolume() {
        return this.ultimovolume;
    }
    public void setUltimoVolume(String novo) {
        this.ultimovolume = novo;
    }
    public String getEditora() {
        return this.editora;
    }
    public void setEditora(String novo) {
        this.editora = novo;
    }
}
