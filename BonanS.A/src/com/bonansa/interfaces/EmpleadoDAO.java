package com.bonansa.interfaces;

import java.util.ArrayList;

import com.bonansa.beans.EmpleadoDTO;

public interface EmpleadoDAO {
	
	
	int registrarEmpleado(EmpleadoDTO empleado, String idEmpleadoR);
	int registrarEmpleadoConductor(EmpleadoDTO empleado, String idEmpleadoR);
	int actualizarEmpleado(EmpleadoDTO empleado, String idEmpleadoR);
	int actualizarEmpleadoConductor(EmpleadoDTO empleado, String idEmpleadoR);
	ArrayList<EmpleadoDTO> listarEmpleado();
	EmpleadoDTO buscarEmpleado(String idEmpleado);
	EmpleadoDTO buscarEmpleadoConductor(String idEmpleado);

}
