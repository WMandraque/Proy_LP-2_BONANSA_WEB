package com.bonansa.interfaces;

import java.util.ArrayList;

import com.bonansa.beans.IncidenciaDTO;

public interface IncidenciaDAO 
{
	
	int registrarIncidencia(IncidenciaDTO incidencia);
	int actualizarIncidencia(IncidenciaDTO incidencia, String idEmpleadoR);
	ArrayList<IncidenciaDTO> listarIncidencias();

}
