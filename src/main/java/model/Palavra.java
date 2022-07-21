package model;

import dao.PalavraDao;

public class Palavra {
	
	private int id_palavra;
	
	private String palavra;
	
		
	public int getId_palavra() {
		return id_palavra;
	}
	public void setId_palavra(int id_palavra) {
		this.id_palavra = id_palavra;
	}
	public String getPalavra() {
		return palavra;
	}
	public void setPalavra(String palavra) {
		this.palavra = palavra;
	}
	
	public void salvar() {
		new PalavraDao().inserirPalavra(this);
	}
	

}