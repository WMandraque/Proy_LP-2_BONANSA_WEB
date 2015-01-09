package com.bonansa.services;

import java.util.ArrayList;
import java.util.List;

import com.bonansa.beans.ClienteDTO;
import com.bonansa.dao.DAOFactory;
import com.bonansa.interfaces.ClienteDAO;

public class ClienteService {
	
	
	DAOFactory factory=DAOFactory.obtenerDAOFactory(DAOFactory.MYSQL);
	ClienteDAO dao=factory.getClienteDAO();
	
	public int registrarClienteNatural(ClienteDTO clienteX, String idEmpleadoR, List<ClienteDTO> listaDireccion) {
		return dao.registrarClienteNatural(clienteX, idEmpleadoR, listaDireccion);
	}
	
	
	public int registrarClienteJuridico(ClienteDTO clienteX, String idEmpleadoR, List<ClienteDTO> listaDireccion) {
		return dao.registrarClienteJuridico(clienteX, idEmpleadoR, listaDireccion);
	}
	
	public int actualizarClienteNatural(ClienteDTO clienteX, String idEmpleadoR, List<ClienteDTO> listaDireccion) {
		return dao.actualizarClienteNatural(clienteX, idEmpleadoR, listaDireccion);
	}
	
	public int actualizarClienteJuridico(ClienteDTO clienteX, String idEmpleadoR, List<ClienteDTO> listaDireccion) {
		return dao.actualizarClienteJuridico(clienteX, idEmpleadoR, listaDireccion);
	}
	
	public int eliminarCliente(String idCliente, String idEmpleadoR) {
		return dao.eliminarCliente(idCliente, idEmpleadoR);
	}
	
	public ArrayList<ClienteDTO> listarCliente() {
		return dao.listarCliente();
	}
	public ClienteDTO buscarClienteNatural(String idCliente) {
		return dao.buscarClienteNatural(idCliente);
	}
	
	public ClienteDTO buscarClienteJuridico(String idCliente) {
		return dao.buscarClienteJuridico(idCliente);
	}
	
	public ArrayList<ClienteDTO> listarDirecciones(String idCliente) {
		return dao.listarDirecciones(idCliente);
	}
	

}