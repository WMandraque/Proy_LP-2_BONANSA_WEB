package com.bonansa.interfaces;

import java.util.ArrayList;

import com.bonansa.beans.VehiculoDTO;

public interface VehiculoDAO {
	
	
	
	int registrarVehiculo(VehiculoDTO vehiculoX, String idEmpleadoR);
	int actualizarVehiculo(VehiculoDTO vehiculoX, String idEmpleadoR);
	int eliminarVehiculo(String idVehiculo, String idEmpleadoR);
	ArrayList<VehiculoDTO> listarVehiculos();
	VehiculoDTO buscarVehiculo(String idVehiculo);
	
	



}
