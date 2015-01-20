package com.bonansa.services;

import java.util.ArrayList;

import com.bonansa.beans.GuiaRemisionTransportistaDTO;
import com.bonansa.beans.SolicitudOrdenRecojoDTO;
import com.bonansa.dao.DAOFactory;
import com.bonansa.interfaces.GuiaRemisionTransportistaDAO;

public class GuiaRemisionTransportistaService {
	
	
	DAOFactory factory=DAOFactory.obtenerDAOFactory(DAOFactory.MYSQL);
	GuiaRemisionTransportistaDAO dao=factory.getGuiaRemisionTransportistaDAO();
	
	public int registrarGRT(GuiaRemisionTransportistaDTO gRT, String idEmpleadoR, String idSOR, ArrayList<GuiaRemisionTransportistaDTO> listadoDGRT, ArrayList<SolicitudOrdenRecojoDTO> listadoEquipoPersonalTraslado)
	{
		return dao.registrarGRT(gRT, idEmpleadoR, idSOR, listadoDGRT, listadoEquipoPersonalTraslado);
	}
	
	public int registrarEntregaMercaderia(String idGrt, String idEmpleadoR) 
	{
		return dao.registrarEntregaMercaderia(idGrt, idEmpleadoR);
	}
	
	public ArrayList<GuiaRemisionTransportistaDTO> listarGRT(String idEmpleado) {
		return dao.listarGRT(idEmpleado);
	}
	
	
	public GuiaRemisionTransportistaDTO buscarGRT(String idGRT) {
		return dao.buscarGRT(idGRT);
	}
		
		

}
