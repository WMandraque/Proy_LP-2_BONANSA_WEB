package com.bonansa.beans;

import java.sql.Time;
import java.util.Date;

public class LogDTO {
	
	

	  private int codigo;
	  private String usuario;
	  private String descripcion;
	  private String tipo;
	  private Date   fecha;
	  private Time hora;
	  
	  
	public LogDTO(int codigo, String usuario, String descripcion, String tipo,
			Date fecha, Time hora) {
		super();
		this.codigo = codigo;
		this.usuario = usuario;
		this.descripcion = descripcion;
		this.tipo = tipo;
		this.fecha = fecha;
		this.hora = hora;
	}


	public int getCodigo() {
		return codigo;
	}


	public String getUsuario() {
		return usuario;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public String getTipo() {
		return tipo;
	}


	public Date getFecha() {
		return fecha;
	}


	public Time getHora() {
		return hora;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public void setHora(Time hora) {
		this.hora = hora;
	}
	
	  


}
