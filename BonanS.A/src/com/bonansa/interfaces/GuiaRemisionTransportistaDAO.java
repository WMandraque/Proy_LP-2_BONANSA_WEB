package com.bonansa.interfaces;

import com.bonansa.beans.GuiaRemisionTransportistaDTO;

public interface GuiaRemisionTransportistaDAO {
	
	
	
	int registrarGRT(GuiaRemisionTransportistaDTO gRT, String idEmpleadoR, String idSOR);

}
