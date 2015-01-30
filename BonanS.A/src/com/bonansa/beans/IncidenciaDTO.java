package com.bonansa.beans;

public class IncidenciaDTO 
{

	  private String idIncidencia;
	  private String idEmpleado;
	  private String  direccion;
	  private String  descripcion;
	  private String  fecha;
	  private String  hora;
	  private String  idEstadoIncidencia;
	  private String  descEstadoIncidencia;
	  
	  
	  
	  
	public IncidenciaDTO(String idIncidencia, String idEmpleado, String direccion,
			String descripcion, String fecha, String hora,
			String idEstadoIncidencia) {
		super();
		this.idIncidencia = idIncidencia;
		this.idEmpleado = idEmpleado;
		this.direccion = direccion;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.hora = hora;
		this.idEstadoIncidencia = idEstadoIncidencia;
	}
	
	
	public IncidenciaDTO() {
		super();
	}

	public String getIdIncidencia() {
		return idIncidencia;
	}
	public String getIdEmpleado() {
		return idEmpleado;
	}
	public String getDireccion() {
		return direccion;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public String getFecha() {
		return fecha;
	}
	public String getHora() {
		return hora;
	}
	public String getIdEstadoIncidencia() {
		return idEstadoIncidencia;
	}
	public void setIdIncidencia(String idIncidencia) {
		this.idIncidencia = idIncidencia;
	}
	public void setIdEmpleado(String idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public void setIdEstadoIncidencia(String idEstadoIncidencia) {
		this.idEstadoIncidencia = idEstadoIncidencia;
	}


	public String getDescEstadoIncidencia() {
		return descEstadoIncidencia;
	}


	public void setDescEstadoIncidencia(String descEstadoIncidencia) {
		this.descEstadoIncidencia = descEstadoIncidencia;
	}
	
	
	
}
