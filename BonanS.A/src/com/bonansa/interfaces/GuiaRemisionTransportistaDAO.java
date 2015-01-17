package com.bonansa.interfaces;

import java.util.ArrayList;

import com.bonansa.beans.GuiaRemisionTransportistaDTO;
import com.bonansa.beans.SolicitudOrdenRecojoDTO;

public interface GuiaRemisionTransportistaDAO {
	
	
	
	int registrarGRT(GuiaRemisionTransportistaDTO gRT, String idEmpleadoR, String idSOR, ArrayList<GuiaRemisionTransportistaDTO> listadoDGRT, ArrayList<SolicitudOrdenRecojoDTO> listadoEquipoPersonalTraslado);
	ArrayList<GuiaRemisionTransportistaDTO> listarGRT(String idEmpleado);

}
