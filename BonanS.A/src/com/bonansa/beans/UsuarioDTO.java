package com.bonansa.beans;

public class UsuarioDTO {
	
	private String idEmpleado;
	private String clave;
	private String idRol;
	private String idEstado;
	private String descRol; 
	private String descEstado;
	private String nomEmpleado;
	private String apepaEmpleado;
	private String apemaEmpleado;
	

	
    //Contructor para obtener al usuario
	public UsuarioDTO(String idEmpleado, String clave, String descRol,
			String descEstado, String nomEmpleado, String apepaEmpleado,
			String apemaEmpleado) {
		super();
		this.idEmpleado = idEmpleado;
		this.clave = clave;
		this.descRol = descRol;
		this.descEstado = descEstado;
		this.nomEmpleado = nomEmpleado;
		this.apepaEmpleado = apepaEmpleado;
		this.apemaEmpleado = apemaEmpleado;
	}
	
	
	//Constructor para registrarEmpleado
	public UsuarioDTO(String idEmpleado, String clave, String idRol) {
		super();
		this.idEmpleado = idEmpleado;
		this.clave = clave;
		this.idRol = idRol;
	}
	
	
    //Constructor para las vistasListarUsuario!!
	public UsuarioDTO(String idEmpleado, String clave, String descRol, String descEstado) 
	{
		
		this.idEmpleado = idEmpleado;
		this.clave = clave;
		this.descRol = descRol;
		this.descEstado = descEstado;
	}
	
	



	public UsuarioDTO(){
	}


	public String getIdRol() {
		return idRol;
	}

	public void setIdRol(String idRol) {
		this.idRol = idRol;
	}
	public String getIdEmpleado() {
		return idEmpleado;
	}


	public String getClave() {
		return clave;
	}


	public String getDescRol() {
		return descRol;
	}


	public String getDescEstado() {
		return descEstado;
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


	public void setIdEmpleado(String idEmpleado) {
		this.idEmpleado = idEmpleado;
	}


	public void setClave(String clave) {
		this.clave = clave;
	}


	public void setDescRol(String descRol) {
		this.descRol = descRol;
	}


	public void setDescEstado(String descEstado) {
		this.descEstado = descEstado;
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



	public String getIdEstado() {
		return idEstado;
	}



	public void setIdEstado(String idEstado) {
		this.idEstado = idEstado;
	}
	
	
	
	
	
	
	

	
	

}
