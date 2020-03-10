package Biblioteca;

public class ArtigoPeriodicos {
	private String titulo;
	private int publi_id;
	private int numvolume;
	private int ano;
	private String mes;
	private String tituloperiodico;
	
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
	public String getTituloperiodico() {
		return tituloperiodico;
	}
	public void setTituloperiodico(String tituloperiodico) {
		this.tituloperiodico = tituloperiodico;
	}
	public int getNumvolume() {
		return numvolume;
	}
	public void setNumvolume(int numvolume) {
		this.numvolume = numvolume;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getMes() {
		return mes;
	}
	public void setMes(String mes) {
		this.mes = mes;
	}

}
