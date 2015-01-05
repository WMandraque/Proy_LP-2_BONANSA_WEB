package com.bonansa.interfaces;

import java.util.ArrayList;

import com.bonansa.beans.ClienteDTO;
import com.bonansa.dao.DAOFactory;

public interface ClienteDAO {
	
	
	
	
	int registrarClienteNatural(ClienteDTO clienteX, String idEmpleadoR);
	int registrarClienteJuridico(ClienteDTO clienteX, String idEmpleadoR);
	ArrayList<ClienteDTO> listarCliente();

}
