package com.bonansa.beans;

public class VehiculoDTO {
	
	
	private String idVeh;
	private String placaVeh; 
	private int idCategoriaVeh; 
	private String marcaVeh; 
	private String modeloVeh; 
	private int numAsientosVeh; 
	private int anhoFabricVeh; 
	private String numSerieMotorVeh; 
	private double largoVeh; 
	private double anchoVeh; 
	private double alturaVeh; 
	private double cargaBrutaVeh; 
	private double cargaUtilVeh; 
	private double cargaNetaVeh; 
	private byte[] fotoVehiculo;
	private String idEstado; 
	private String idEstadoTrabajo;
	
	
	//Atributos extras....
	private String descCategoriaVeh;
	private String descEstadoE;
	private String descEstadoT;
	
	//Constructor para la busqueda de vehiculo
	public VehiculoDTO(String idVeh, String placaVeh, int idCategoriaVeh,
			String marcaVeh, String modeloVeh, int numAsientosVeh,
			int anhoFabricVeh, String numSerieMotorVeh, double largoVeh,
			double anchoVeh, double alturaVeh, double cargaBrutaVeh,
			double cargaUtilVeh, double cargaNetaVeh,
			String idEstado, String idEstadoTrabajo) {
		super();
		this.idVeh = idVeh;
		this.placaVeh = placaVeh;
		this.idCategoriaVeh = idCategoriaVeh;
		this.marcaVeh = marcaVeh;
		this.modeloVeh = modeloVeh;
		this.numAsientosVeh = numAsientosVeh;
		this.anhoFabricVeh = anhoFabricVeh;
		this.numSerieMotorVeh = numSerieMotorVeh;
		this.largoVeh = largoVeh;
		this.anchoVeh = anchoVeh;
		this.alturaVeh = alturaVeh;
		this.cargaBrutaVeh = cargaBrutaVeh;
		this.cargaUtilVeh = cargaUtilVeh;
		this.cargaNetaVeh = cargaNetaVeh;
		this.idEstado = idEstado;
		this.idEstadoTrabajo = idEstadoTrabajo;
	}



	
	//Constructor para listado de las vistas
	public VehiculoDTO(String idVeh, String placaVeh, String descCategoriaVeh, String marcaVeh,
			String modeloVeh, int numAsientosVeh, int anhoFabricVeh,
			 String descEstadoE, String descEstadoT) {
		super();
		this.idVeh = idVeh;
		this.placaVeh = placaVeh;
		this.marcaVeh = marcaVeh;
		this.modeloVeh = modeloVeh;
		this.numAsientosVeh = numAsientosVeh;
		this.anhoFabricVeh = anhoFabricVeh;
		this.descCategoriaVeh = descCategoriaVeh;
		this.descEstadoE = descEstadoE;
		this.descEstadoT = descEstadoT;
	}

	


    //Constructor para registrar en DAO
	public VehiculoDTO(String placaVeh, int idCategoriaVeh, String marcaVeh,
			String modeloVeh, int numAsientosVeh,
			int anhoFabricVeh, String numSerieMotorVeh, double largoVeh,
			double anchoVeh, double alturaVeh, double cargaBrutaVeh,
			double cargaUtilVeh, double cargaNetaVeh, byte[] fotoVehiculo) {
		super();
		this.placaVeh = placaVeh;
		this.idCategoriaVeh = idCategoriaVeh;
		this.marcaVeh = marcaVeh;
		this.modeloVeh = modeloVeh;
		this.numAsientosVeh = numAsientosVeh;
		this.anhoFabricVeh = anhoFabricVeh;
		this.numSerieMotorVeh = numSerieMotorVeh;
		this.largoVeh = largoVeh;
		this.anchoVeh = anchoVeh;
		this.alturaVeh = alturaVeh;
		this.cargaBrutaVeh = cargaBrutaVeh;
		this.cargaUtilVeh = cargaUtilVeh;
		this.cargaNetaVeh = cargaNetaVeh;
		this.fotoVehiculo = fotoVehiculo;
	}
	
	
	//Constructor para actualizarDAO
	
	public VehiculoDTO(String idVeh, String placaVeh, int idCategoriaVeh,
			String marcaVeh, String modeloVeh, int numAsientosVeh,
			int anhoFabricVeh, String numSerieMotorVeh, double largoVeh,
			double anchoVeh, double alturaVeh, double cargaBrutaVeh,
			double cargaUtilVeh, double cargaNetaVeh, byte[] fotoVehiculo,
			String idEstado, String idEstadoTrabajo) {
		super();
		this.idVeh = idVeh;
		this.placaVeh = placaVeh;
		this.idCategoriaVeh = idCategoriaVeh;
		this.marcaVeh = marcaVeh;
		this.modeloVeh = modeloVeh;
		this.numAsientosVeh = numAsientosVeh;
		this.anhoFabricVeh = anhoFabricVeh;
		this.numSerieMotorVeh = numSerieMotorVeh;
		this.largoVeh = largoVeh;
		this.anchoVeh = anchoVeh;
		this.alturaVeh = alturaVeh;
		this.cargaBrutaVeh = cargaBrutaVeh;
		this.cargaUtilVeh = cargaUtilVeh;
		this.cargaNetaVeh = cargaNetaVeh;
		this.fotoVehiculo = fotoVehiculo;
		this.idEstado = idEstado;
		this.idEstadoTrabajo = idEstadoTrabajo;
	}




	public String getIdVeh() {
		return idVeh;
	}


	public String getPlacaVeh() {
		return placaVeh;
	}


	public int getIdCategoriaVeh() {
		return idCategoriaVeh;
	}


	public String getMarcaVeh() {
		return marcaVeh;
	}


	public String getModeloVeh() {
		return modeloVeh;
	}


	public int getNumAsientosVeh() {
		return numAsientosVeh;
	}



	public int getAnhoFabricVeh() {
		return anhoFabricVeh;
	}


	public String getNumSerieMotorVeh() {
		return numSerieMotorVeh;
	}


	public double getLargoVeh() {
		return largoVeh;
	}


	public double getAnchoVeh() {
		return anchoVeh;
	}


	public double getAlturaVeh() {
		return alturaVeh;
	}


	public double getCargaBrutaVeh() {
		return cargaBrutaVeh;
	}


	public double getCargaUtilVeh() {
		return cargaUtilVeh;
	}


	public double getCargaNetaVeh() {
		return cargaNetaVeh;
	}


	public byte[] getFotoVehiculo() {
		return fotoVehiculo;
	}


	public String getIdEstado() {
		return idEstado;
	}


	public String getIdEstadoTrabajo() {
		return idEstadoTrabajo;
	}


	public void setIdVeh(String idVeh) {
		this.idVeh = idVeh;
	}


	public void setPlacaVeh(String placaVeh) {
		this.placaVeh = placaVeh;
	}


	public void setIdCategoriaVeh(int idCategoriaVeh) {
		this.idCategoriaVeh = idCategoriaVeh;
	}


	public void setMarcaVeh(String marcaVeh) {
		this.marcaVeh = marcaVeh;
	}


	public void setModeloVeh(String modeloVeh) {
		this.modeloVeh = modeloVeh;
	}


	public void setNumAsientosVeh(int numAsientosVeh) {
		this.numAsientosVeh = numAsientosVeh;
	}




	public void setAnhoFabricVeh(int anhoFabricVeh) {
		this.anhoFabricVeh = anhoFabricVeh;
	}


	public void setNumSerieMotorVeh(String numSerieMotorVeh) {
		this.numSerieMotorVeh = numSerieMotorVeh;
	}


	public void setLargoVeh(double largoVeh) {
		this.largoVeh = largoVeh;
	}


	public void setAnchoVeh(double anchoVeh) {
		this.anchoVeh = anchoVeh;
	}


	public void setAlturaVeh(double alturaVeh) {
		this.alturaVeh = alturaVeh;
	}


	public void setCargaBrutaVeh(double cargaBrutaVeh) {
		this.cargaBrutaVeh = cargaBrutaVeh;
	}


	public void setCargaUtilVeh(double cargaUtilVeh) {
		this.cargaUtilVeh = cargaUtilVeh;
	}


	public void setCargaNetaVeh(double cargaNetaVeh) {
		this.cargaNetaVeh = cargaNetaVeh;
	}


	public void setFotoVehiculo(byte[] fotoVehiculo) {
		this.fotoVehiculo = fotoVehiculo;
	}


	public void setIdEstado(String idEstado) {
		this.idEstado = idEstado;
	}


	public void setIdEstadoTrabajo(String idEstadoTrabajo) {
		this.idEstadoTrabajo = idEstadoTrabajo;
	}
	
	

	//SET AND GETER DE LOS ATRIBUTS EXTRAS
	
	public String getDescCategoriaVeh() {
		return descCategoriaVeh;
	}


	public String getDescEstadoE() {
		return descEstadoE;
	}


	public String getDescEstadoT() {
		return descEstadoT;
	}


	public void setDescCategoriaVeh(String descCategoriaVeh) {
		this.descCategoriaVeh = descCategoriaVeh;
	}


	public void setDescEstadoE(String descEstadoE) {
		this.descEstadoE = descEstadoE;
	}


	public void setDescEstadoT(String descEstadoT) {
		this.descEstadoT = descEstadoT;
	}
	
	
	
	

}
