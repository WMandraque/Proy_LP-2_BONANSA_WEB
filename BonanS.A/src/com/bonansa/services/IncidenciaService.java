package com.bonansa.services;

import java.util.ArrayList;

import com.bonansa.beans.IncidenciaDTO;
import com.bonansa.dao.DAOFactory;
import com.bonansa.interfaces.IncidenciaDAO;

public class IncidenciaService 
{

	DAOFactory factory=DAOFactory.obtenerDAOFactory(DAOFactory.MYSQL);
	IncidenciaDAO dao=factory.getIncidenciaDAO();
	
	public int registrarIncidencia(IncidenciaDTO incidencia) 
	{
		return dao.registrarIncidencia(incidencia);
	}
	
	public int actualizarIncidencia(IncidenciaDTO incidencia, String idEmpleadoR)
	{
		return dao.actualizarIncidencia(incidencia, idEmpleadoR);
	}
	
	public ArrayList<IncidenciaDTO> listarIncidencias() 
	{
		return dao.listarIncidencias();
	}
}
