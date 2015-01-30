package com.bonansa.dao;

import java.io.Serializable;

import com.bonansa.beans.SolicitudOrdenRecojoDTO;
import com.bonansa.interfaces.ClienteDAO;
import com.bonansa.interfaces.EmpleadoDAO;
import com.bonansa.interfaces.GuiaRemisionTransportistaDAO;
import com.bonansa.interfaces.IncidenciaDAO;
import com.bonansa.interfaces.LogDAO;
import com.bonansa.interfaces.OrdenRecojoDAO;
import com.bonansa.interfaces.UsuarioDAO;
import com.bonansa.interfaces.VehiculoDAO;


public abstract class DAOFactory implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	//Identificadores costantes de cada fabrica de BD sirve para multiples fuentes de base de datos
	
	public static final int MYSQL=1;
	public static final int SQLSERVER=2;
	public static final int ORACLE=3;
	
	
	// Metodos para sobreEscribir en la clase hija, va a retornar una interfaz
	// Metodos Abstractos para el manejo de las tablas
	// si hay mas interfaces se debe crear mas metodos de acuerdo al numero de interfaces (lista los metodos abstractos) x cada interface
	
	public abstract UsuarioDAO getUsuarioDAO();
	public abstract VehiculoDAO getVehiculoDAO();
	public abstract LogDAO  getLogDAO();
	public abstract ClienteDAO getClienteDAO();
	public abstract EmpleadoDAO getEmpleadoDAO();
	public abstract OrdenRecojoDAO getOrdenRecojoDAO();
	public abstract GuiaRemisionTransportistaDAO getGuiaRemisionTransportistaDAO();
	public abstract IncidenciaDAO getIncidenciaDAO();
	
	//Metodo estatico que va a retornar la herencia hacia una clase hija
	public static DAOFactory obtenerDAOFactory(int bd){
		
		/** Segun el indetificador...*/
		/*Va a retornar hacia la clase hija adecuada*/
		switch (bd) {
		
		case MYSQL:/*Si es MySQL*/
			return new MySqlDAOFactory(); 
			
		case SQLSERVER:
            return new SqlServerDAOFactory();
            
		case ORACLE:
			return new OracleDAOFactory();
		default:
			return null;
		}
	}
	
	

}
