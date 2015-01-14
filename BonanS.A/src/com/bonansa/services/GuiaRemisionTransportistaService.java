package com.bonansa.services;

import com.bonansa.beans.GuiaRemisionTransportistaDTO;
import com.bonansa.dao.DAOFactory;
import com.bonansa.interfaces.GuiaRemisionTransportistaDAO;

public class GuiaRemisionTransportistaService {
	
	
	DAOFactory factory=DAOFactory.obtenerDAOFactory(DAOFactory.MYSQL);
	GuiaRemisionTransportistaDAO dao=factory.getGuiaRemisionTransportistaDAO();
	
	public int registrarGRT(GuiaRemisionTransportistaDTO gRT, String idEmpleadoR, String idSOR) 
	{
		return dao.registrarGRT(gRT, idEmpleadoR, idSOR);
	}
		
		

}
