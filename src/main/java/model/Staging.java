package model;

import org.jsoup.nodes.Document;

import dao.PalavraDao;
import dao.StagingDao;

public class Staging {
	
	private int id_staging;
	
	private String palavra;
	
	private Document doc;
	
		
	public int getId_staging() {
		return id_staging;
	}

	public void setId_staging(int id_staging) {
		this.id_staging = id_staging;
	}

	public String getPalavra() {
		return palavra;
	}

	public void setPalavra(String palavra) {
		this.palavra = palavra;
	}


	public Document getDoc() {
		return doc;
	}


	public void setDoc(Document doc) {
		this.doc = doc;
	}

	public void salvar() {
		new StagingDao().inserirStaging(this);
	}
	

}