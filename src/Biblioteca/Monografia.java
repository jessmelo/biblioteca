package Biblioteca;

public class Monografia {
	private String titulo;
	private int ano;
	private String mes;
	private String local;
	private String autor;
	private String instituicao;
	private String codigo;
	
    public String getTitulo() {
        return this.titulo;
    }
    public void setTitulo(String novo) {
        this.titulo = novo;
    }
    public int getAno() {
        return this.ano;
    }
    public void setAno(int novo) {
        this.ano = novo;
    }
    public String getMes() {
        return this.mes;
    }
    public void setMes(String novo) {
        this.mes = novo;
    }
    public String getLocal() {
        return this.local;
    }
    public void setLocal(String novo) {
        this.local = novo;
    }
    public String getAutor() {
        return this.autor;
    }
    public void setAutor(String novo) {
        this.autor = novo;
    }
    public String getInstituicao() {
        return this.instituicao;
    }
    public void setInstituicao(String novo) {
        this.instituicao = novo;
    }
    public String getCodigo() {
        return this.codigo;
    }
    public void setCodigo(String novo) {
        this.codigo = novo;
    }
    
}