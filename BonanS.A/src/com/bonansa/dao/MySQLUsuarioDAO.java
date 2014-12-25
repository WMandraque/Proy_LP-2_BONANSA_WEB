package com.bonansa.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utils.MySQLConexion;

import com.bonansa.beans.UsuarioDTO;
import com.bonansa.interfaces.UsuarioDAO;

public class MySQLUsuarioDAO implements UsuarioDAO {
	
	
	Connection con=null;
	CallableStatement cst=null;
	PreparedStatement pst=null;

	@Override
	public UsuarioDTO validarUsuario(String idEmpleado, String clave) {
		
		UsuarioDTO usuarioX=null;

		try {
			con=MySQLConexion.getConexion();
			
			String sql="{call validarEmpleado(?, ?, ?)}";
			cst=con.prepareCall(sql);
			cst.setString(1, idEmpleado);
			cst.setString(2, clave);
			cst.registerOutParameter(3, java.sql.Types.CHAR);
			ResultSet rs=cst.executeQuery();
			if(rs.next()){
				usuarioX=new UsuarioDTO(
						rs.getString(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getString(4), 
						rs.getString(5), 
						rs.getString(6),
						rs.getString(7),
						rs.getString(8)
						);
			}
			
			String op_idEmpleado=cst.getString(3);
			String sql2="{CALL registrarLog(?, ?, ?)}";
			cst=con.prepareCall(sql2);
			cst.setString(1, op_idEmpleado);
			cst.setString(2, "Empleado logueado: "+idEmpleado);
			cst.setString(3, "LOGUIN");
			cst.executeUpdate();


		} catch (Exception e) {
			System.out.println("Error DAO al validar usuario: "+e);
		}finally{
			try {
				if(con!=null){con.close();}
				if(cst!=null){cst.close();}
			} catch (Exception e2) {
				System.out.println("Error al cerrar conexiones: "+e2);
			}
		}
		return usuarioX;
	}

}
