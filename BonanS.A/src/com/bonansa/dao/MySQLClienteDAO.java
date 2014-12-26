package com.bonansa.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLType;

import utils.MySQLConexion;

import com.bonansa.beans.ClienteDTO;
import com.bonansa.interfaces.ClienteDAO;
import com.sun.xml.internal.ws.wsdl.writer.document.Types;

public class MySQLClienteDAO implements ClienteDAO {
	
	
	Connection con=null;
	CallableStatement cst=null;
	PreparedStatement pst=null;
	int r=0;
	
	@Override
	public int registrarClienteNatural(ClienteDTO clienteX, String idEmpleadoR) {
		try {
			
			con=MySQLConexion.getConexion();
			con.setAutoCommit(false);
			
			String qSql="{call usp_registrarClienteNatural(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
			cst=con.prepareCall(qSql);
			
			cst.setInt(1, clienteX.getIdTipoCliente());
			cst.setString(2, clienteX.getNomCliente());
			cst.setString(3, clienteX.getApePatCliente());
			cst.setString(4, clienteX.getApeMatCliente());
			cst.setString(5, clienteX.getFecNacCliente());
			cst.setString(6, clienteX.getSexoCliente());
			cst.setString(7, clienteX.getTelefonoCliente());
			cst.setString(8, clienteX.getCelularCliente());
			cst.setString(9, clienteX.getCorreoCliente());
			cst.setString(10, clienteX.getNumDocumento());
			cst.setString(11, idEmpleadoR);
			cst.registerOutParameter(12, java.sql.Types.VARCHAR);


		    r=cst.executeUpdate();
			
			con.commit();
			
		} catch (Exception e) {
			
			System.out.println("Error al regitrarClienteNaturalDAO: "+e);
			
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
	public int registrarClienteJuridico(ClienteDTO clienteX, String idEmpleadoR) {
try {
			
			con=MySQLConexion.getConexion();
			con.setAutoCommit(false);
			
			String qSql="{call usp_registrarClienteJuridico(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
			cst=con.prepareCall(qSql);
			
			cst.setInt(1, clienteX.getIdTipoCliente());
			cst.setString(2, clienteX.getNomCliente());
			cst.setString(3, clienteX.getApePatCliente());
			cst.setString(4, clienteX.getApeMatCliente());
			cst.setString(5, clienteX.getFecNacCliente());
			cst.setString(6, clienteX.getSexoCliente());
			cst.setString(7, clienteX.getTelefonoCliente());
			cst.setString(8, clienteX.getCelularCliente());
			cst.setString(9, clienteX.getCorreoCliente());
			cst.setString(10, clienteX.getNumDocumento());
			cst.setString(11, clienteX.getRazSocCliente());
			cst.setString(12, clienteX.getCiiuCliente());
			cst.setString(13, clienteX.getCargoContacCliente());
			cst.setString(14, idEmpleadoR);
			cst.registerOutParameter(15, java.sql.Types.VARCHAR);


		    r=cst.executeUpdate();
			
			con.commit();
			
		} catch (Exception e) {
			
			System.out.println("Error al regitrarClienteJuridicoDAO: "+e);
			
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
