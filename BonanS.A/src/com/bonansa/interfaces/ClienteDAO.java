package com.bonansa.interfaces;

import java.util.ArrayList;
import java.util.List;

import com.bonansa.beans.ClienteDTO;
import com.bonansa.dao.DAOFactory;

public interface ClienteDAO {
	
	
	
	
	int registrarClienteNatural(ClienteDTO clienteX, String idEmpleadoR, List<ClienteDTO> listaDireccion);
	int registrarClienteJuridico(ClienteDTO clienteX, String idEmpleadoR, List<ClienteDTO> listaDireccion);
	int actualizarClienteNatural(ClienteDTO clienteX, String idEmpleadoR, List<ClienteDTO> listaDireccion);
	int actualizarClienteJuridico(ClienteDTO clienteX, String idEmpleadoR, List<ClienteDTO> listaDireccion);
	int eliminarCliente(String idCliente, String idEmpleadoR);
	ClienteDTO buscarClienteNatural(String idCliente);
	ClienteDTO buscarClienteJuridico(String idCliente);
	ArrayList<ClienteDTO> listarCliente();
	ArrayList<ClienteDTO> listarDirecciones(String idCliente);

}
