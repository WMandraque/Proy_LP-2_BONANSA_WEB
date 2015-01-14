package com.bonansa.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLType;

import utils.MySQLConexion;

import com.bonansa.beans.GuiaRemisionTransportistaDTO;
import com.bonansa.interfaces.GuiaRemisionTransportistaDAO;

import extras.ServicioFechas;

public class MySQLGuiaRemisionTransportistaDAO implements GuiaRemisionTransportistaDAO {

	
	Connection con=null;
	PreparedStatement pst=null;
	CallableStatement cst=null;
	ServicioFechas sF=new ServicioFechas();
	
	@Override
	public int registrarGRT(GuiaRemisionTransportistaDTO gRT, String idEmpleadoR, String idSOR) {
		int r=0;
		try 
		{
			con=MySQLConexion.getConexion();
			con.setAutoCommit(false);
			String qSql="{Call usp_registrarGRT(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
			cst=con.prepareCall(qSql);
			cst.setString(1, gRT.getIdEmpleado());
			cst.setString(2, gRT.getIdVeh());
			cst.setString(3, sF.ip_formatearFechaMySQL(gRT.getFecInicioTraslado()));
			cst.setString(4, gRT.getIdCliRemitente());
			cst.setString(5, gRT.getIdCliRemitente());
			cst.setString(6, gRT.getNomCliDestinatario());
			cst.setString(7, gRT.getApepaCliDestinatario());
			cst.setString(8, gRT.getApemaCliDestinatario());
			cst.setInt(9, gRT.getIdTipoDocId());
			cst.setString(10, gRT.getNumDocCliDestinatario());
			cst.setString(11, gRT.getDirecClienteDestinatario());
			cst.setString(12, sF.ip_formatearFechaMySQL(gRT.getFecMinEntrega()));
			cst.setString(13, sF.ip_formatearFechaMySQL(gRT.getFecMaxEntrega()));
			cst.setString(14, idEmpleadoR);
			cst.setString(15, idSOR);
			cst.registerOutParameter(16, java.sql.Types.VARCHAR);
			
			r=cst.executeUpdate();
			
			con.commit();
			
			String op_idGRT=cst.getString(16);
			
			System.out.println("GRT GENERADO: "+op_idGRT);
		} 
		catch (Exception e) 
		{
			System.out.println("Error en registrarGRTDAO: "+e);
		}
		finally
		{
			
		}
		
		return r;
	}

}
