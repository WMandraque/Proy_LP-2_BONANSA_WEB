package com.bonansa.beans;

public class EmpleadoDTO {
	
	//Datos del empleado Administrador, recepcionista y estibador
	private String idEmpleado;
	private int    idTipoEmpleado;  
	private String numDocumento;
	private String nomEmpleado; 
	private String apepaEmpleado;
	private String apemaEmpleado;
	private String sexoEmpleado;
	private String fecnacEmpleado;
	private String domicilioEmpleado;
	private String ubigeoEmpleado; 
	private String fonoEmpleado; 
	private String celularEmpleado; 
	private String emailEmpleado; 
	private byte[] fotoEmpleado;
	private String idEstadoTrabajo;
	private String idEstado; 
	
	//Datos extras para crear al empleado conductor
	private int idClaselic; 
	private int idCategorialic; 
	private String licenCondEmpleado;
	
	
	//Datos extras para el listado
	private String nomCargo;
	private String descEstadoT;
	private String descEstado;
	
	
	
	
	
	
	//CONSTRUCTOR PARA ACTUALIZAR EMPLEADO
	public EmpleadoDTO(String idEmpleado,
			String numDocumento, String nomEmpleado, String apepaEmpleado,
			String apemaEmpleado, String sexoEmpleado, String fecnacEmpleado,
			String domicilioEmpleado, String ubigeoEmpleado,
			String fonoEmpleado, String celularEmpleado, String emailEmpleado,
			byte[] fotoEmpleado, String idEstadoTrabajo, String idEstado) {
		super();
		this.idEmpleado = idEmpleado;
		this.numDocumento = numDocumento;
		this.nomEmpleado = nomEmpleado;
		this.apepaEmpleado = apepaEmpleado;
		this.apemaEmpleado = apemaEmpleado;
		this.sexoEmpleado = sexoEmpleado;
		this.fecnacEmpleado = fecnacEmpleado;
		this.domicilioEmpleado = domicilioEmpleado;
		this.ubigeoEmpleado = ubigeoEmpleado;
		this.fonoEmpleado = fonoEmpleado;
		this.celularEmpleado = celularEmpleado;
		this.emailEmpleado = emailEmpleado;
		this.fotoEmpleado = fotoEmpleado;
		this.idEstadoTrabajo = idEstadoTrabajo;
		this.idEstado = idEstado;
	}


	//Constructor para listar las busquedas para actualizar o eliminar del empleado
	public EmpleadoDTO(String idEmpleado, int idTipoEmpleado,
			String numDocumento, String nomEmpleado, String apepaEmpleado,
			String apemaEmpleado, String sexoEmpleado, String fecnacEmpleado,
			String domicilioEmpleado, String ubigeoEmpleado,
			String fonoEmpleado, String celularEmpleado, String emailEmpleado,
			String idEstado, String idEstadoTrabajo) {
		super();
		this.idEmpleado = idEmpleado;
		this.idTipoEmpleado = idTipoEmpleado;
		this.numDocumento = numDocumento;
		this.nomEmpleado = nomEmpleado;
		this.apepaEmpleado = apepaEmpleado;
		this.apemaEmpleado = apemaEmpleado;
		this.sexoEmpleado = sexoEmpleado;
		this.fecnacEmpleado = fecnacEmpleado;
		this.domicilioEmpleado = domicilioEmpleado;
		this.ubigeoEmpleado = ubigeoEmpleado;
		this.fonoEmpleado = fonoEmpleado;
		this.celularEmpleado = celularEmpleado;
		this.emailEmpleado = emailEmpleado;
		this.idEstado = idEstado;
		this.idEstadoTrabajo = idEstadoTrabajo;
	}
	

	//Constructor para listar las busquedas para actualizar o eliminar del empleado conductor
	public EmpleadoDTO(String idEmpleado, int idTipoEmpleado,
			String numDocumento, String nomEmpleado, String apepaEmpleado,
			String apemaEmpleado, String sexoEmpleado, String fecnacEmpleado,
			String domicilioEmpleado, String ubigeoEmpleado,
			String fonoEmpleado, String celularEmpleado, String emailEmpleado,
			String idEstado, String idEstadoTrabajo, String licenCondEmpleado, int idClaselic,
			int idCategorialic) {
		super();
		this.idEmpleado = idEmpleado;
		this.idTipoEmpleado = idTipoEmpleado;
		this.numDocumento = numDocumento;
		this.nomEmpleado = nomEmpleado;
		this.apepaEmpleado = apepaEmpleado;
		this.apemaEmpleado = apemaEmpleado;
		this.sexoEmpleado = sexoEmpleado;
		this.fecnacEmpleado = fecnacEmpleado;
		this.domicilioEmpleado = domicilioEmpleado;
		this.ubigeoEmpleado = ubigeoEmpleado;
		this.fonoEmpleado = fonoEmpleado;
		this.celularEmpleado = celularEmpleado;
		this.emailEmpleado = emailEmpleado;
		this.idEstado = idEstado;
		this.idEstadoTrabajo = idEstadoTrabajo;
		this.licenCondEmpleado = licenCondEmpleado;
		this.idClaselic = idClaselic;
		this.idCategorialic = idCategorialic;

	}





	//Constructor para listar empleados mediante las vista
	public EmpleadoDTO(String idEmpleado, String nomCargo, String nomEmpleado,
			String apepaEmpleado, String apemaEmpleado, String fonoEmpleado, String celularEmpleado, String emailEmpleado, 
			String descEstadoT, String descEstado) {
		super();
		this.idEmpleado = idEmpleado;
		this.nomCargo = nomCargo;
		this.nomEmpleado = nomEmpleado;
		this.apepaEmpleado = apepaEmpleado;
		this.apemaEmpleado = apemaEmpleado;
		this.fonoEmpleado = fonoEmpleado;
		this.celularEmpleado=celularEmpleado;
		this.emailEmpleado = emailEmpleado;
		this.descEstadoT = descEstadoT;
		this.descEstado = descEstado;
	}
	
	

	//Contructor para crear Empleado ADMINISTRADOR, RECEPCIONISTA Y ESTIBADOR
	public EmpleadoDTO(int idTipoEmpleado, String numDocumento,
			String nomEmpleado, String apepaEmpleado, String apemaEmpleado,
			String sexoEmpleado, String fecnacEmpleado,
			String domicilioEmpleado, String ubigeoEmpleado,
			String fonoEmpleado, String celularEmpleado, String emailEmpleado,
			byte[] fotoEmpleado) {
		super();
		this.idTipoEmpleado = idTipoEmpleado;
		this.numDocumento = numDocumento;
		this.nomEmpleado = nomEmpleado;
		this.apepaEmpleado = apepaEmpleado;
		this.apemaEmpleado = apemaEmpleado;
		this.sexoEmpleado = sexoEmpleado;
		this.fecnacEmpleado = fecnacEmpleado;
		this.domicilioEmpleado = domicilioEmpleado;
		this.ubigeoEmpleado = ubigeoEmpleado;
		this.fonoEmpleado = fonoEmpleado;
		this.celularEmpleado = celularEmpleado;
		this.emailEmpleado = emailEmpleado;
		this.fotoEmpleado = fotoEmpleado;
	}

	//Contructor para crear Empleado CONDUCTOR
	public EmpleadoDTO(int idTipoEmpleado, String numDocumento,
			String nomEmpleado, String apepaEmpleado, String apemaEmpleado,
			String sexoEmpleado, String fecnacEmpleado,
			String domicilioEmpleado, String ubigeoEmpleado,
			String fonoEmpleado, String celularEmpleado, String emailEmpleado,
			byte[] fotoEmpleado, int idClaselic, int idCategorialic,
			String licenCondEmpleado) {
		super();
		this.idTipoEmpleado = idTipoEmpleado;
		this.numDocumento = numDocumento;
		this.nomEmpleado = nomEmpleado;
		this.apepaEmpleado = apepaEmpleado;
		this.apemaEmpleado = apemaEmpleado;
		this.sexoEmpleado = sexoEmpleado;
		this.fecnacEmpleado = fecnacEmpleado;
		this.domicilioEmpleado = domicilioEmpleado;
		this.ubigeoEmpleado = ubigeoEmpleado;
		this.fonoEmpleado = fonoEmpleado;
		this.celularEmpleado = celularEmpleado;
		this.emailEmpleado = emailEmpleado;
		this.fotoEmpleado = fotoEmpleado;
		this.idClaselic = idClaselic;
		this.idCategorialic = idCategorialic;
		this.licenCondEmpleado = licenCondEmpleado;
	}
	
	
	
	public String getIdEmpleado() {
		return idEmpleado;
	}

	public int getIdTipoEmpleado() {
		return idTipoEmpleado;
	}

	public String getNumDocumento() {
		return numDocumento;
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

	public String getSexoEmpleado() {
		return sexoEmpleado;
	}

	public String getFecnacEmpleado() {
		return fecnacEmpleado;
	}

	public String getDomicilioEmpleado() {
		return domicilioEmpleado;
	}

	public String getUbigeoEmpleado() {
		return ubigeoEmpleado;
	}

	public String getFonoEmpleado() {
		return fonoEmpleado;
	}

	public String getCelularEmpleado() {
		return celularEmpleado;
	}

	public String getEmailEmpleado() {
		return emailEmpleado;
	}

	public byte[] getFotoEmpleado() {
		return fotoEmpleado;
	}

	public String getIdEstado() {
		return idEstado;
	}

	public String getIdEstadoTrabajo() {
		return idEstadoTrabajo;
	}



	public String getLicenCondEmpleado() {
		return licenCondEmpleado;
	}

	public void setIdEmpleado(String idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public void setIdTipoEmpleado(int idTipoEmpleado) {
		this.idTipoEmpleado = idTipoEmpleado;
	}

	public void setNumDocumento(String numDocumento) {
		this.numDocumento = numDocumento;
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

	public void setSexoEmpleado(String sexoEmpleado) {
		this.sexoEmpleado = sexoEmpleado;
	}

	public void setFecnacEmpleado(String fecnacEmpleado) {
		this.fecnacEmpleado = fecnacEmpleado;
	}

	public void setDomicilioEmpleado(String domicilioEmpleado) {
		this.domicilioEmpleado = domicilioEmpleado;
	}

	public void setUbigeoEmpleado(String ubigeoEmpleado) {
		this.ubigeoEmpleado = ubigeoEmpleado;
	}

	public void setFonoEmpleado(String fonoEmpleado) {
		this.fonoEmpleado = fonoEmpleado;
	}

	public void setCelularEmpleado(String celularEmpleado) {
		this.celularEmpleado = celularEmpleado;
	}

	public void setEmailEmpleado(String emailEmpleado) {
		this.emailEmpleado = emailEmpleado;
	}

	public void setFotoEmpleado(byte[] fotoEmpleado) {
		this.fotoEmpleado = fotoEmpleado;
	}

	public void setIdEstado(String idEstado) {
		this.idEstado = idEstado;
	}

	public void setIdEstadoTrabajo(String idEstadoTrabajo) {
		this.idEstadoTrabajo = idEstadoTrabajo;
	}
	
	public int getIdClaselic() {
		return idClaselic;
	}

	public int getIdCategorialic() {
		return idCategorialic;
	}

	public void setIdClaselic(int idClaselic) {
		this.idClaselic = idClaselic;
	}

	public void setIdCategorialic(int idCategorialic) {
		this.idCategorialic = idCategorialic;
	}


	public void setLicenCondEmpleado(String licenCondEmpleado) {
		this.licenCondEmpleado = licenCondEmpleado;
	}
	
	
	

	public String getNomCargo() {
		return nomCargo;
	}

	public String getDescEstadoT() {
		return descEstadoT;
	}

	public String getDescEstado() {
		return descEstado;
	}

	public void setNomCargo(String nomCargo) {
		this.nomCargo = nomCargo;
	}

	public void setDescEstadoT(String descEstadoT) {
		this.descEstadoT = descEstadoT;
	}

	public void setDescEstado(String descEstado) {
		this.descEstado = descEstado;
	}

	


}
