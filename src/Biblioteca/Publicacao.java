package Biblioteca;

public class Publicacao {
    private String titulo;
    private String tipo_publicacao;
    private int numfolder;
    private boolean digital;
    private String armario;
    
    public String getTitulo() {
        return this.titulo;
    }
    public void setTitulo(String novo) {
        this.titulo = novo;
    }
    public String getTipoPublicacao() {
        return this.tipo_publicacao;
    }
    public void setTipoPublicacao(String novo) {
        this.tipo_publicacao = novo;
    }
    public int getNumFolder() {
        return this.numfolder;
    }
    public void setNumFolder(int novo) {
        this.numfolder = novo;
    }
    public boolean getDigital() {
    	return this.digital;
    }
    public void setDigital(Boolean novo) {
    	this.digital = novo;
    }
    public String setArmario() {
    	return this.armario;
    }
    public void setArmario(String novo) {
    	this.armario = novo;
    }
}
