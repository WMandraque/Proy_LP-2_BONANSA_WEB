package com.bonansa.beans;

public class GuiaRemisionTransportistaDTO 
{
	
	private String idGRT;
	private String idEmpleado;
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
	
	private String numCodGR;
	private String numCodFT;
	private String descTraslado;
	private int cantidad;
	private int idTipoUnidadMedida;
	private String descTipoUnidadMedida;
	private double pesoKg;

	
	

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

}
