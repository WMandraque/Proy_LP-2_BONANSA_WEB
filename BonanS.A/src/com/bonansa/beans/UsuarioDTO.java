package com.bonansa.beans;

public class UsuarioDTO {
	
	private String idEmpleado;
	private String clave; 
	private String idTipoEmpleado; 
	private String idEstado;
	private String nomEmpleado;
	private String apepaEmpleado;
	private String apemaEmpleado;
	private String nomCargo;
	
	public UsuarioDTO(String idEmpleado, String clave, String idTipoEmpleado,
			String idEstado, String nomEmpleado, String apepaEmpleado,
			String apemaEmpleado, String nomCargo) {
		super();
		this.idEmpleado = idEmpleado;
		this.clave = clave;
		this.idTipoEmpleado = idTipoEmpleado;
		this.idEstado = idEstado;
		this.nomEmpleado = nomEmpleado;
		this.apepaEmpleado = apepaEmpleado;
		this.apemaEmpleado = apemaEmpleado;
		this.nomCargo = nomCargo;
	}

	public String getIdEmpleado() {
		return idEmpleado;
	}

	public String getClave() {
		return clave;
	}

	public String getIdTipoEmpleado() {
		return idTipoEmpleado;
	}

	public String getIdEstado() {
		return idEstado;
	}

	public String getNomEmpleado() {
		return nomEmpleado;
	}

	public String getApepaEmpleado() {
		return apepaEmpleado;
	}

	public String getApemaEmpleado() {
		return apemaEmpleado;
	}

	public String getNomCargo() {
		return nomCargo;
	}

	public void setIdEmpleado(String idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public void setIdTipoEmpleado(String idTipoEmpleado) {
		this.idTipoEmpleado = idTipoEmpleado;
	}

	public void setIdEstado(String idEstado) {
		this.idEstado = idEstado;
	}

	public void setNomEmpleado(String nomEmpleado) {
		this.nomEmpleado = nomEmpleado;
	}

	public void setApepaEmpleado(String apepaEmpleado) {
		this.apepaEmpleado = apepaEmpleado;
	}

	public void setApemaEmpleado(String apemaEmpleado) {
		this.apemaEmpleado = apemaEmpleado;
	}

	public void setNomCargo(String nomCargo) {
		this.nomCargo = nomCargo;
	}
	
	
	
	
	

}
