package com.example.demo.model;

public class EnderecoDTO {
	
	private String cep;
	
	private String numCasa;
	
	private String complemento;

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNumCasa() {
		return numCasa;
	}

	public void setNumCasa(String numCasa) {
		this.numCasa = numCasa;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public EnderecoDTO(String cep, String numCasa, String complemento) {
		super();
		this.cep = cep;
		this.numCasa = numCasa;
		this.complemento = complemento;
	}

	public EnderecoDTO() {
		super();
	}
	
	

}
