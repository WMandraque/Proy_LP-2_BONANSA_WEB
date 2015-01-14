package com.bonansa.interfaces;

import java.util.ArrayList;

import com.bonansa.beans.SolicitudOrdenRecojoDTO;

public interface OrdenRecojoDAO {
	
	
	int registrarOrdenRecojo(SolicitudOrdenRecojoDTO ordenRecojo, ArrayList<SolicitudOrdenRecojoDTO> cp_listadoDOR, ArrayList<SolicitudOrdenRecojoDTO> cp_listadoOR_EquipoPersonal,ArrayList<SolicitudOrdenRecojoDTO> cp_listadoOR_EquipoVehicular, String idEmpleadoR);
	SolicitudOrdenRecojoDTO buscarSOR(String idOR);
	ArrayList<SolicitudOrdenRecojoDTO> listarOrdenRecojos(String idEmpleado);
	ArrayList<SolicitudOrdenRecojoDTO> listarDescripcionTraslado(String idEmpleado);

	
}
