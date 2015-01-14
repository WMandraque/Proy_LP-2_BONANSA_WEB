package com.bonansa.services;

import java.util.ArrayList;

import com.bonansa.beans.SolicitudOrdenRecojoDTO;
import com.bonansa.dao.DAOFactory;
import com.bonansa.interfaces.OrdenRecojoDAO;

public class OrdenRecojoService {
	
	
	DAOFactory factory=DAOFactory.obtenerDAOFactory(DAOFactory.MYSQL);
	OrdenRecojoDAO dao=factory.getOrdenRecojoDAO();
	
	public int registrarOrdenRecojo(
									SolicitudOrdenRecojoDTO ordenRecojo,
									ArrayList<SolicitudOrdenRecojoDTO> cp_listadoDOR,
									ArrayList<SolicitudOrdenRecojoDTO> cp_listadoOR_EquipoPersonal,
									ArrayList<SolicitudOrdenRecojoDTO> cp_listadoOR_EquipoVehicular,
									String idEmpleadoR
									) 
	{
		
	return dao.registrarOrdenRecojo(ordenRecojo, cp_listadoDOR, cp_listadoOR_EquipoPersonal, cp_listadoOR_EquipoVehicular, idEmpleadoR);	
	}
	
	
	public ArrayList<SolicitudOrdenRecojoDTO> listarOrdenRecojos(String idEmpleado)
	{
		return dao.listarOrdenRecojos(idEmpleado);
	}
	
	public SolicitudOrdenRecojoDTO buscarSOR(String idOR) {
		return dao.buscarSOR(idOR);
	}

}
