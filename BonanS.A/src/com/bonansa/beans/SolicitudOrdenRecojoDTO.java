package com.bonansa.beans;

import java.sql.Time;
import java.util.Date;

public class SolicitudOrdenRecojoDTO {
	
	
	
	//Atributos para la tabla tb_OrdenRecojo
	private String idOR;
	private String idCliente;
	private String direccionRecojo;
	private Date fechaRecojo;
	private Time horaRecojo; 
	
	
	//Atributos para la tabla tb_DetalleOrdenRecojo
	private String descripcionTraslado;
	private int cantidad;
	private int idTipoUnidadMedida;
	private double PesokG;
	
	
	//Atributos para la tabla tb_OrdenRecojo_EquipoPersonal
	private String idEmpleado;
	private String nomCompleto;
	private String descTipoEmpleado;
	
	
	//Atributos para la tabla tb_OrdenRecojo_EquipoVehicular
	private String idVehiculo;
	private String placaVehiculo;
	private String descCatVehiculo;
	
	
	
	private String descTipoUnidadMedida;
	



	public SolicitudOrdenRecojoDTO() {
		super();
	}


	
	
	public String getIdOR() {
		return idOR;
	}


	public String getIdCliente() {
		return idCliente;
	}


	public String getDireccionRecojo() {
		return direccionRecojo;
	}


	public Date getFechaRecojo() {
		return fechaRecojo;
	}


	public Time getHoraRecojo() {
		return horaRecojo;
	}


	public String getDescripcionTraslado() {
		return descripcionTraslado;
	}


	public double getPesokG() {
		return PesokG;
	}


	public void setIdOR(String idOR) {
		this.idOR = idOR;
	}


	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}


	public void setDireccionRecojo(String direccionRecojo) {
		this.direccionRecojo = direccionRecojo;
	}


	public void setFechaRecojo(Date fechaRecojo) {
		this.fechaRecojo = fechaRecojo;
	}


	public void setHoraRecojo(Time horaRecojo) {
		this.horaRecojo = horaRecojo;
	}


	public void setDescripcionTraslado(String descripcionTraslado) {
		this.descripcionTraslado = descripcionTraslado;
	}





	public void setPesokG(double pesokG) {
		PesokG = pesokG;
	}
	
	
	public int getIdTipoUnidadMedida() {
		return idTipoUnidadMedida;
	}




	public String getDescTipoUnidadMedida() {
		return descTipoUnidadMedida;
	}




	public void setIdTipoUnidadMedida(int idTipoUnidadMedida) {
		this.idTipoUnidadMedida = idTipoUnidadMedida;
	}




	public void setDescTipoUnidadMedida(String descTipoUnidadMedida) {
		this.descTipoUnidadMedida = descTipoUnidadMedida;
	}

	public int getCantidad() {
		return cantidad;
	}




	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}




	public String getIdEmpleado() {
		return idEmpleado;
	}




	public void setIdEmpleado(String idEmpleado) {
		this.idEmpleado = idEmpleado;
	}




	public String getNomCompleto() {
		return nomCompleto;
	}




	public String getDescTipoEmpleado() {
		return descTipoEmpleado;
	}




	public void setNomCompleto(String nomCompleto) {
		this.nomCompleto = nomCompleto;
	}




	public void setDescTipoEmpleado(String descTipoEmpleado) {
		this.descTipoEmpleado = descTipoEmpleado;
	}




	public String getIdVehiculo() {
		return idVehiculo;
	}




	public String getPlacaVehiculo() {
		return placaVehiculo;
	}




	public String getDescCatVehiculo() {
		return descCatVehiculo;
	}




	public void setIdVehiculo(String idVehiculo) {
		this.idVehiculo = idVehiculo;
	}




	public void setPlacaVehiculo(String placaVehiculo) {
		this.placaVehiculo = placaVehiculo;
	}




	public void setDescCatVehiculo(String descCatVehiculo) {
		this.descCatVehiculo = descCatVehiculo;
	}




	
	
	

}
