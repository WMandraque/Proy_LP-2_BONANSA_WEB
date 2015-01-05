package com.bonansa.services;

import java.util.ArrayList;

import com.bonansa.beans.UsuarioDTO;
import com.bonansa.dao.DAOFactory;
import com.bonansa.interfaces.UsuarioDAO;

public class UsuarioService {
	
	
	DAOFactory factory=DAOFactory.obtenerDAOFactory(DAOFactory.MYSQL);
	
	UsuarioDAO dao=factory.getUsuarioDAO();
	
	
	public UsuarioDTO validarUsuario(String idEmpleado, String clave) {
		return dao.validarUsuario(idEmpleado, clave);
	}
	
	public int registrarUsurio(UsuarioDTO usuarioX, String idEmpleadoR) {
		return dao.registrarUsuario(usuarioX, idEmpleadoR);
	}
	
	public int actualizarUsuario(UsuarioDTO usuarioX, String idEmpleadoR) 
	{
		return dao.actualizarUsuario(usuarioX, idEmpleadoR);
	}
	
	public int eliminarUsuario(String idUsuario, String idEmpleadoR) 
	{
		return dao.eliminarUsuario(idUsuario, idEmpleadoR);
	}
	
	public ArrayList<UsuarioDTO> listarUsuarios() {
		return dao.listarUsuarios();
	}
	
	public UsuarioDTO buscarUsuario(String idUsuario) 
	{
		return dao.buscarUsuario(idUsuario);
	}

}
