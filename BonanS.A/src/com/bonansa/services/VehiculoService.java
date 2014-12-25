package com.bonansa.services;

import java.util.ArrayList;

import com.bonansa.beans.VehiculoDTO;
import com.bonansa.dao.DAOFactory;
import com.bonansa.interfaces.VehiculoDAO;

public class VehiculoService {
	
	
	DAOFactory factory=DAOFactory.obtenerDAOFactory(DAOFactory.MYSQL);
	VehiculoDAO dao=factory.getVehiculoDAO();
	
	
	public int registrarVehiculo(VehiculoDTO vehiculoX, String idEmpleadoR) {
		return dao.registrarVehiculo(vehiculoX, idEmpleadoR);
	}
	
	
	public int actualizarVehiculo(VehiculoDTO vehiculoX, String idEmpleadoR) {
		return dao.actualizarVehiculo(vehiculoX, idEmpleadoR);
	}
	
	
	public ArrayList<VehiculoDTO> listarVehiculos() {
		return dao.listarVehiculos();
	}
	
	public VehiculoDTO buscarVehiculo(String idVehiculo) {
		return dao.buscarVehiculo(idVehiculo);
	}
	
	public int eliminarVehiculo(String idVehiculo, String idEmpleadoR) {
		return dao.eliminarVehiculo(idVehiculo, idEmpleadoR);
	}
	
	

}
