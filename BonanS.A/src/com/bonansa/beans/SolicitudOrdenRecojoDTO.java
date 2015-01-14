package com.bonansa.beans;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public class SolicitudOrdenRecojoDTO {
	
	
	
	//Atributos para la tabla tb_OrdenRecojo
	private String idOR;
	private String idCliente;
	private String direccionRecojo;
	private String fechaRecojo;
	private String horaRecojo; 
	private String descEstadoOR;
	private ArrayList<SolicitudOrdenRecojoDTO> listadoDescripcionTraslado;
	


	//Atributos para la tabla tb_DetalleOrdenRecojo
	private String descripcionTraslado;
	private int cantidad;
	private int idTipoUnidadMedida;
	private double pesoKg;
	
	
	//Atributos para la tabla tb_OrdenRecojo_EquipoPersonal
	private String idEmpleado;
	private String nomCompleto;
	private String descTipoEmpleado;
	
	
	//Atributos para la tabla tb_OrdenRecojo_EquipoVehicular
	private String idVehiculo;
	private String placaVehiculo;
	private String descCatVehiculo;
	
	
	
	private String descTipoUnidadMedida;
	
	//Atributos para listador de ordenes de recojo con joins
	private String licenCondu;
	private int idTipoCliente;
	private String descTipoDocumento;
	private String numDocumento;
	private String nomCompletoCliente;
	
	

	

	public ArrayList<SolicitudOrdenRecojoDTO> getListadoDescripcionTraslado() {
		return listadoDescripcionTraslado;
	}




	public void setListadoDescripcionTraslado(
			ArrayList<SolicitudOrdenRecojoDTO> listadoDescripcionTraslado) {
		this.listadoDescripcionTraslado = listadoDescripcionTraslado;
	}




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


	public String getFechaRecojo() {
		return fechaRecojo;
	}


	public String getHoraRecojo() {
		return horaRecojo;
	}


	public String getDescripcionTraslado() {
		return descripcionTraslado;
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


	public void setFechaRecojo(String fechaRecojo) {
		this.fechaRecojo = fechaRecojo;
	}


	public void setHoraRecojo(String horaRecojo) {
		this.horaRecojo = horaRecojo;
	}


	public void setDescripcionTraslado(String descripcionTraslado) {
		this.descripcionTraslado = descripcionTraslado;
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




	public double getPesoKg() {
		return pesoKg;
	}




	public void setPesoKg(double pesoKg) {
		this.pesoKg = pesoKg;
	}


	public String getDescEstadoOR() {
		return descEstadoOR;
	}




	public void setDescEstadoOR(String descEstadoOR) {
		this.descEstadoOR = descEstadoOR;
	}




	public String getDescTipoDocumento() {
		return descTipoDocumento;
	}




	public String getNumDocumento() {
		return numDocumento;
	}




	public String getNomCompletoCliente() {
		return nomCompletoCliente;
	}




	public void setDescTipoDocumento(String descTipoDocumento) {
		this.descTipoDocumento = descTipoDocumento;
	}




	public void setNumDocumento(String numDocumento) {
		this.numDocumento = numDocumento;
	}




	public void setNomCompletoCliente(String nomCompletoCliente) {
		this.nomCompletoCliente = nomCompletoCliente;
	}





	public String getLicenCondu() {
		return licenCondu;
	}




	public int getIdTipoCliente() {
		return idTipoCliente;
	}






	public void setLicenCondu(String licenCondu) {
		this.licenCondu = licenCondu;
	}




	public void setIdTipoCliente(int idTipoCliente) {
		this.idTipoCliente = idTipoCliente;
	}




	
	
	

}
