package com.bonansa.services;

import com.bonansa.beans.UsuarioDTO;
import com.bonansa.dao.DAOFactory;
import com.bonansa.interfaces.UsuarioDAO;

public class UsuarioService {
	
	
	DAOFactory factory=DAOFactory.obtenerDAOFactory(DAOFactory.MYSQL);
	
	UsuarioDAO dao=factory.getUsuarioDAO();
	
	
	public UsuarioDTO validarUsuario(String idEmpleado, String clave) {
		return dao.validarUsuario(idEmpleado, clave);
	}

}
