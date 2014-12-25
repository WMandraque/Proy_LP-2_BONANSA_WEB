package com.bonansa.beans;

public class ProvinciaDTO {
	
	
	private int codprov;
	private String provincia;
	
	
	
	
	
	
	public ProvinciaDTO(int codprov, String provincia) {
		super();
		this.codprov = codprov;
		this.provincia = provincia;
	}
	
	
	public int getCodprov() {
		return codprov;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setCodprov(int codprov) {
		this.codprov = codprov;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	
	
	


}
