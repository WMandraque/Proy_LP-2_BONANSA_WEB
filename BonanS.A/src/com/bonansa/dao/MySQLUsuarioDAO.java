package com.bonansa.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
			
			String sql="{call usp_validarUsuario(?, ?, ?)}";
			cst=con.prepareCall(sql);
			cst.setString(1, idEmpleado);
			cst.setString(2, clave);
			cst.registerOutParameter(3, java.sql.Types.CHAR);
			ResultSet rs=cst.executeQuery();
			if(rs.next()){
				usuarioX=new UsuarioDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
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

	@Override
	public int registrarUsuario(UsuarioDTO usuarioX, String idEmpleadoR) {
		int r=0;
		try {
			
			con=MySQLConexion.getConexion();
			con.setAutoCommit(false);
			String qSql="{Call usp_registrarUsuario(?, ?, ?, ?)}";
			cst=con.prepareCall(qSql);
			cst.setString(1, usuarioX.getIdEmpleado());
			cst.setString(2, usuarioX.getClave());
			cst.setString(3, usuarioX.getIdRol());
			
			cst.setString(4, idEmpleadoR);
			
			r=cst.executeUpdate();
			
			con.commit();
			
		} catch (Exception e) {
			System.out.println("Error al registrarUsuarioDAO: "+e);
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			try {
				if(con!=null){con.close();}
				if(cst!=null){cst.close();}
			} catch (Exception e2) {
				System.out.println("Error al cerrar conexiones: "+e2);
			}
		}
		return r;
	}

	@Override
	public ArrayList<UsuarioDTO> listarUsuarios() {
		ArrayList<UsuarioDTO> listadoUsuarios=new ArrayList<UsuarioDTO>();
		try {
			
			con=MySQLConexion.getConexion();
			String qSql="SELECT*FROM vistaListaUsuarios";
			pst=con.prepareStatement(qSql);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
			listadoUsuarios.add(new UsuarioDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));	
			}
			
			
			
		} catch (Exception e) 
		{
			System.out.println("Error al listarUsuariosDAO: "+e);
		}
		finally
		{
			try {
				if(con!=null){con.close();}
				if(pst!=null){pst.close();}
			} catch (Exception e2) {
				System.out.println("Error al cerrar conexiones: "+e2);
			}	
		}
		return listadoUsuarios;
	}

	@Override
	public UsuarioDTO buscarUsuario(String idUsuario) 
	{
		UsuarioDTO usuarioX=new UsuarioDTO();
		try {
			con=MySQLConexion.getConexion();
			
			String qSql="{CALL usp_buscarUsuario(?)}";
			cst=con.prepareCall(qSql);
			cst.setString(1, idUsuario);
			ResultSet rs=cst.executeQuery();
			if(rs.next())
			{
			usuarioX.setIdEmpleado(rs.getString(1));
			usuarioX.setClave(rs.getString(2));
			usuarioX.setIdRol(rs.getString(3));
			usuarioX.setIdEstado(rs.getString(4));
			}
			rs.close();
		} catch (Exception e) {
			System.out.println("Error al buscarEmpleado: "+e);
		}finally
		{
			try {
				if(con!=null){con.close();}
				if(pst!=null){pst.close();}
			} catch (Exception e2) {
				System.out.println("Error al cerrar conexiones: "+e2);
			}		
		}
		return usuarioX;
	}

	@Override
	public int actualizarUsuario(UsuarioDTO usuarioX, String idEmpleadoR) 
	{
		int r=0;
		try {
			con=MySQLConexion.getConexion();
			con.setAutoCommit(false);
			String qSql="{Call usp_actualizarUsuario(?, ?, ?, ?, ?)}";
			cst=con.prepareCall(qSql);
			cst.setString(1, usuarioX.getIdEmpleado());
			cst.setString(2, usuarioX.getClave());
			cst.setString(3, usuarioX.getIdRol());
			cst.setString(4, usuarioX.getIdEstado());
			
			cst.setString(5, idEmpleadoR);
			
			r=cst.executeUpdate();
			con.commit();
			
		} catch (Exception e) {
			System.out.println("Error al actualizarUsuarioDAO: "+e);
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			try {
				if(con!=null){con.close();}
				if(cst!=null){cst.close();}
			} catch (Exception e2) {
				System.out.println("Error al cerrar conexiones: "+e2);
			}		
		}
		
		return r;
	}

	@Override
	public int eliminarUsuario(String idUsuario, String idEmpleadoR) 
	{
		int r=0;
		try {
			con=MySQLConexion.getConexion();
			con.setAutoCommit(false);
			String qSql="{Call usp_eliminarUsuario(?, ?)}";
			cst=con.prepareCall(qSql);
			cst.setString(1, idUsuario);

			
			cst.setString(2, idEmpleadoR);
			
			r=cst.executeUpdate();
			con.commit();
			
		} catch (Exception e) {
			System.out.println("Error al actualizarUsuarioDAO: "+e);
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			try {
				if(con!=null){con.close();}
				if(cst!=null){cst.close();}
			} catch (Exception e2) {
				System.out.println("Error al cerrar conexiones: "+e2);
			}		
		}
		
		return r;
	}

}
