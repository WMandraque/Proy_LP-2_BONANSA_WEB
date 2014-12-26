package com.bonansa.dao;

import com.bonansa.interfaces.ClienteDAO;
import com.bonansa.interfaces.EmpleadoDAO;
import com.bonansa.interfaces.LogDAO;
import com.bonansa.interfaces.UsuarioDAO;
import com.bonansa.interfaces.VehiculoDAO;

public class MySqlDAOFactory extends DAOFactory {

	@Override
	public UsuarioDAO getUsuarioDAO() {
		// TODO Auto-generated method stub
		return new MySQLUsuarioDAO();
	}

	@Override
	public VehiculoDAO getVehiculoDAO() {
		// TODO Auto-generated method stub
		return new MySQLVehiculoDAO();
	}

	@Override
	public LogDAO getLogDAO() {
		// TODO Auto-generated method stub
		return new MySQLLogDAO();
	}

	@Override
	public ClienteDAO getClienteDAO() {
		// TODO Auto-generated method stub
		return new MySQLClienteDAO();
	}

	@Override
	public EmpleadoDAO getEmpleadoDAO() {
		// TODO Auto-generated method stub
		return new MySQLEmpleadoDAO();
	}

}
