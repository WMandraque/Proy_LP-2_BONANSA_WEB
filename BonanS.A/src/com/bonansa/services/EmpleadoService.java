package com.bonansa.services;

import java.util.ArrayList;

import com.bonansa.beans.EmpleadoDTO;
import com.bonansa.dao.DAOFactory;
import com.bonansa.interfaces.EmpleadoDAO;

public class EmpleadoService {
	
	DAOFactory factory=DAOFactory.obtenerDAOFactory(DAOFactory.MYSQL);
	EmpleadoDAO dao=factory.getEmpleadoDAO();
	
	public int registrarEmpleado(EmpleadoDTO empleado, String idEmpleadoR) {
		return dao.registrarEmpleado(empleado, idEmpleadoR);
	}
	
	
	public int registrarEmpleadoConductor(EmpleadoDTO empleado, String idEmpleadoR) {
		return dao.registrarEmpleadoConductor(empleado, idEmpleadoR);
	}
	
	public int actualizarEmpleado(EmpleadoDTO empleado, String idEmpleadoR) {
		return dao.actualizarEmpleado(empleado, idEmpleadoR);
	}
	
	public ArrayList<EmpleadoDTO> listarEmpleado() {
		return dao.listarEmpleado();
	}
	
	public EmpleadoDTO buscarEmpleado(String idEmpleado) {
		return dao.buscarEmpleado(idEmpleado);
	}
	
	public EmpleadoDTO buscarEmpleadoConductor(String idEmpleado) {
		return dao.buscarEmpleadoConductor(idEmpleado);
	}
	
	public int actualizarEmpleadoConductor(EmpleadoDTO empleado,String idEmpleadoR){ 
	return dao.actualizarEmpleadoConductor(empleado, idEmpleadoR);
	}

}
