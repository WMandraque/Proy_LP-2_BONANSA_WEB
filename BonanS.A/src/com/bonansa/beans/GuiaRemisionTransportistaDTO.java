package com.bonansa.beans;

import java.util.ArrayList;

public class GuiaRemisionTransportistaDTO 
{
	
	private String idGRT;
	private String idEmpleado;
	private int    idTipoEmpleado;
	private String idVeh;
	private String fecInicioTraslado; 
	private String idCliRemitente;
	private String direcCliRemitente; 
	private String nomCliDestinatario; 
	private String apepaCliDestinatario; 
	private String apemaCliDestinatario; 
	private int    idTipoDocId;
	private String descTipoDocumentoCliDest; 
	private String numDocCliDestinatario;
	private String direcClienteDestinatario; 
	private String fecMinEntrega;
	private String fecMaxEntrega;
	private String idEstadoGRT;
	private String descEstadoGRT;
	
	private String numCodGR;
	private String numCodFT;
	private String descTraslado;
	private int cantidad;
	private int idTipoUnidadMedida;
	private String descTipoUnidadMedida;
	private double pesoKg;
	
	
	private String licenCondEmpleado;
	private String placaVeh;
    private String nomCliRemitente;	
    private String apePaCliRemitente;	
    private String apeMaCliRemitente;	
    private int    idTipoCliente;
    private String descTipoCliente;
    private String numDocumentoCliRemitente;
    private int    idTipoDocIdCliDestinatario;
    ArrayList<GuiaRemisionTransportistaDTO> listadoEquipoPersonalTraslado;
    ArrayList<GuiaRemisionTransportistaDTO> listadoDGRT;
    private String nomEmpleado;
    private String apePaEmpleado;
    private String apeMaEmpleado;
    private String descTipoEmpleado;


	public String getNomEmpleado() {
		return nomEmpleado;
	}

	public String getApePaEmpleado() {
		return apePaEmpleado;
	}

	public String getApeMaEmpleado() {
		return apeMaEmpleado;
	}

	public void setNomEmpleado(String nomEmpleado) {
		this.nomEmpleado = nomEmpleado;
	}

	public void setApePaEmpleado(String apePaEmpleado) {
		this.apePaEmpleado = apePaEmpleado;
	}

	public void setApeMaEmpleado(String apeMaEmpleado) {
		this.apeMaEmpleado = apeMaEmpleado;
	}

	public String getIdEmpleado() {
		return idEmpleado;
	}

	public String getIdVeh() {
		return idVeh;
	}

	public int getIdTipoDocId() {
		return idTipoDocId;
	}

	public String getIdEstadoGRT() {
		return idEstadoGRT;
	}

	public void setIdEmpleado(String idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public void setIdVeh(String idVeh) {
		this.idVeh = idVeh;
	}

	public void setIdTipoDocId(int idTipoDocId) {
		this.idTipoDocId = idTipoDocId;
	}

	public void setIdEstadoGRT(String idEstadoGRT) {
		this.idEstadoGRT = idEstadoGRT;
	}
	
	public GuiaRemisionTransportistaDTO() {
		super();
	}
	
	public String getIdGRT() {
		return idGRT;
	}
	public String getFecInicioTraslado() {
		return fecInicioTraslado;
	}
	public String getIdCliRemitente() {
		return idCliRemitente;
	}
	public String getDirecCliRemitente() {
		return direcCliRemitente;
	}
	public String getNomCliDestinatario() {
		return nomCliDestinatario;
	}
	public String getApepaCliDestinatario() {
		return apepaCliDestinatario;
	}
	public String getApemaCliDestinatario() {
		return apemaCliDestinatario;
	}
	public String getDescTipoDocumentoCliDest() {
		return descTipoDocumentoCliDest;
	}
	public String getNumDocCliDestinatario() {
		return numDocCliDestinatario;
	}
	public String getDirecClienteDestinatario() {
		return direcClienteDestinatario;
	}
	public String getNumCodGR() {
		return numCodGR;
	}
	public String getNumCodFT() {
		return numCodFT;
	}
	public String getDescTraslado() {
		return descTraslado;
	}
	public int getCantidad() {
		return cantidad;
	}
	
	public double getPesoKg() {
		return pesoKg;
	}
	public String getFecMinEntrega() {
		return fecMinEntrega;
	}
	public String getFecMaxEntrega() {
		return fecMaxEntrega;
	}
	public void setIdGRT(String idGRT) {
		this.idGRT = idGRT;
	}
	public void setFecInicioTraslado(String fecInicioTraslado) {
		this.fecInicioTraslado = fecInicioTraslado;
	}
	public void setIdCliRemitente(String idCliRemitente) {
		this.idCliRemitente = idCliRemitente;
	}
	public void setDirecCliRemitente(String direcCliRemitente) {
		this.direcCliRemitente = direcCliRemitente;
	}
	public void setNomCliDestinatario(String nomCliDestinatario) {
		this.nomCliDestinatario = nomCliDestinatario;
	}
	public void setApepaCliDestinatario(String apepaCliDestinatario) {
		this.apepaCliDestinatario = apepaCliDestinatario;
	}
	public void setApemaCliDestinatario(String apemaCliDestinatario) {
		this.apemaCliDestinatario = apemaCliDestinatario;
	}
	public void setDescTipoDocumentoCliDest(String descTipoDocumentoCliDest) {
		this.descTipoDocumentoCliDest = descTipoDocumentoCliDest;
	}
	public void setNumDocCliDestinatario(String numDocCliDestinatario) {
		this.numDocCliDestinatario = numDocCliDestinatario;
	}
	public void setDirecClienteDestinatario(String direcClienteDestinatario) {
		this.direcClienteDestinatario = direcClienteDestinatario;
	}
	public void setNumCodGR(String numCodGR) {
		this.numCodGR = numCodGR;
	}
	public void setNumCodFT(String numCodFT) {
		this.numCodFT = numCodFT;
	}
	public void setDescTraslado(String descTraslado) {
		this.descTraslado = descTraslado;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public void setPesoKg(double pesoKg) {
		this.pesoKg = pesoKg;
	}
	public void setFecMinEntrega(String fecMinEntrega) {
		this.fecMinEntrega = fecMinEntrega;
	}
	public void setFecMaxEntrega(String fecMaxEntrega) {
		this.fecMaxEntrega = fecMaxEntrega;
	}

	public int getIdTipoUnidadMedida() {
		return idTipoUnidadMedida;
	}

	public void setIdTipoUnidadMedida(int idTipoUnidadMedida) {
		this.idTipoUnidadMedida = idTipoUnidadMedida;
	}

	public String getDescTipoUnidadMedida() {
		return descTipoUnidadMedida;
	}

	public void setDescTipoUnidadMedida(String descTipoUnidadMedida) {
		this.descTipoUnidadMedida = descTipoUnidadMedida;
	}

	public String getLicenCondEmpleado() {
		return licenCondEmpleado;
	}

	public void setLicenCondEmpleado(String licenCondEmpleado) {
		this.licenCondEmpleado = licenCondEmpleado;
	}

	public String getPlacaVeh() {
		return placaVeh;
	}

	public void setPlacaVeh(String placaVeh) {
		this.placaVeh = placaVeh;
	}

	public String getNomCliRemitente() {
		return nomCliRemitente;
	}

	public String getApePaCliRemitente() {
		return apePaCliRemitente;
	}

	public String getApeMaCliRemitente() {
		return apeMaCliRemitente;
	}

	public void setNomCliRemitente(String nomCliRemitente) {
		this.nomCliRemitente = nomCliRemitente;
	}

	public void setApePaCliRemitente(String apePaCliRemitente) {
		this.apePaCliRemitente = apePaCliRemitente;
	}

	public void setApeMaCliRemitente(String apeMaCliRemitente) {
		this.apeMaCliRemitente = apeMaCliRemitente;
	}

	public int getIdTipoCliente() {
		return idTipoCliente;
	}

	public void setIdTipoCliente(int idTipoCliente) {
		this.idTipoCliente = idTipoCliente;
	}

	public String getDescTipoCliente() {
		return descTipoCliente;
	}

	public void setDescTipoCliente(String descTipoCliente) {
		this.descTipoCliente = descTipoCliente;
	}

	public String getNumDocumentoCliRemitente() {
		return numDocumentoCliRemitente;
	}

	public void setNumDocumentoCliRemitente(String numDocumentoCliRemitente) {
		this.numDocumentoCliRemitente = numDocumentoCliRemitente;
	}

	public int getIdTipoDocIdCliDestinatario() {
		return idTipoDocIdCliDestinatario;
	}

	public void setIdTipoDocIdCliDestinatario(int idTipoDocIdCliDestinatario) {
		this.idTipoDocIdCliDestinatario = idTipoDocIdCliDestinatario;
	}

	public String getDescEstadoGRT() {
		return descEstadoGRT;
	}

	public void setDescEstadoGRT(String descEstadoGRT) {
		this.descEstadoGRT = descEstadoGRT;
	}

	public int getIdTipoEmpleado() {
		return idTipoEmpleado;
	}

	public void setIdTipoEmpleado(int idTipoEmpleado) {
		this.idTipoEmpleado = idTipoEmpleado;
	}

	public ArrayList<GuiaRemisionTransportistaDTO> getListadoEquipoPersonalTraslado() {
		return listadoEquipoPersonalTraslado;
	}

	public ArrayList<GuiaRemisionTransportistaDTO> getListadoDGRT() {
		return listadoDGRT;
	}

	public void setListadoEquipoPersonalTraslado(
			ArrayList<GuiaRemisionTransportistaDTO> listadoEquipoPersonalTraslado) {
		this.listadoEquipoPersonalTraslado = listadoEquipoPersonalTraslado;
	}

	public void setListadoDGRT(ArrayList<GuiaRemisionTransportistaDTO> listadoDGRT) {
		this.listadoDGRT = listadoDGRT;
	}

	public String getDescTipoEmpleado() {
		return descTipoEmpleado;
	}

	public void setDescTipoEmpleado(String descTipoEmpleado) {
		this.descTipoEmpleado = descTipoEmpleado;
	}

}
