package com.bonansa.services;

import java.util.ArrayList;

import com.bonansa.beans.ClienteDTO;
import com.bonansa.dao.DAOFactory;
import com.bonansa.interfaces.ClienteDAO;

public class ClienteService {
	
	
	DAOFactory factory=DAOFactory.obtenerDAOFactory(DAOFactory.MYSQL);
	ClienteDAO dao=factory.getClienteDAO();
	
	public int registrarClienteNatural(ClienteDTO clienteX, String idEmpleadoR) {
		return dao.registrarClienteNatural(clienteX, idEmpleadoR);
	}
	
	
	public int registrarClienteJuridico(ClienteDTO clienteX, String idEmpleadoR) {
		return dao.registrarClienteJuridico(clienteX, idEmpleadoR);
	}
	
	public ArrayList<ClienteDTO> listarCliente() {
		return dao.listarCliente();
	}
	
	

}