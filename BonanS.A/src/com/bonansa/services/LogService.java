package com.bonansa.services;

import java.util.ArrayList;

import com.bonansa.beans.LogDTO;
import com.bonansa.dao.DAOFactory;
import com.bonansa.interfaces.LogDAO;

public class LogService {
	
	
	
	DAOFactory factory=DAOFactory.obtenerDAOFactory(DAOFactory.MYSQL);
	
	LogDAO dao=factory.getLogDAO();
	
	public ArrayList<LogDTO> listaLog() {
		return dao.listaLog();
	}

}
