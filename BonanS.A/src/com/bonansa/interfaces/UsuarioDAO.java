package com.bonansa.interfaces;

import java.util.ArrayList;

import com.bonansa.beans.UsuarioDTO;

public interface UsuarioDAO {
	
	
	
	UsuarioDTO validarUsuario(String idEmpleado, String clave);
	int registrarUsuario(UsuarioDTO usuarioX, String idEmpleadoR);
	int actualizarUsuario(UsuarioDTO usuarioX, String idEmpleadoR);
	int eliminarUsuario(String idUsuario, String idEmpleadoR);
	UsuarioDTO buscarUsuario(String idUsuario);
	ArrayList<UsuarioDTO> listarUsuarios();

}
