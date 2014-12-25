package com.bonansa.interfaces;

import com.bonansa.beans.UsuarioDTO;

public interface UsuarioDAO {
	
	
	
	UsuarioDTO validarUsuario(String idEmpleado, String clave);

}
