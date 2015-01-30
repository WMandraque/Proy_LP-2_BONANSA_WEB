package com.bonansa.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import utils.MySQLConexion;

import com.bonansa.beans.IncidenciaDTO;
import com.bonansa.interfaces.IncidenciaDAO;

import extras.ServicioFechas;

public class MySQLIncidenciaDAO implements IncidenciaDAO {

	Connection con=null;
	PreparedStatement pst=null;
	CallableStatement cst=null;
	ServicioFechas sf=new ServicioFechas();
	@Override
	public int registrarIncidencia(IncidenciaDTO incidencia) 
	{
		int r=0;
		
		try 
		{
			con=MySQLConexion.getConexion();
			con.setAutoCommit(false);
			String qSql="{Call usp_registrarIncidencia(?,?, ?)}";
			cst=con.prepareCall(qSql);
			cst.setString(1, incidencia.getIdEmpleado());
			cst.setString(2, incidencia.getDireccion());
			cst.setString(3, incidencia.getDescripcion());
			r=cst.executeUpdate();
			con.commit();
		}
		catch (Exception e) 
		{
			System.out.println("Error en registrarIncidencia()DAO: "+e);
			try {
				con.rollback();
			} catch (SQLException e1)
			{
				e1.printStackTrace();
			}
		}
		finally
		{
			try 
			{
				con.close();
				cst.close();
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		return r;
	}

	@Override
	public ArrayList<IncidenciaDTO> listarIncidencias() 
	{
		ArrayList<IncidenciaDTO> listadoIncidencias=new ArrayList<IncidenciaDTO>();
		
		try 
		{
			con=MySQLConexion.getConexion();
			String qSql="SELECT*FROM vista_listadoIncidencias";
			pst=con.prepareStatement(qSql);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				IncidenciaDTO incidencia=new IncidenciaDTO();
				incidencia.setIdIncidencia(rs.getString(1));
				incidencia.setIdEmpleado(rs.getString(2));
				incidencia.setDireccion(rs.getString(3));
				incidencia.setDescripcion(rs.getString(4));
				incidencia.setFecha(sf.op_formatearFechaMySQL(rs.getString(5)));
				incidencia.setHora(rs.getString(6));
				incidencia.setIdEstadoIncidencia(rs.getString(7));
				incidencia.setDescEstadoIncidencia(rs.getString(8));
				
				listadoIncidencias.add(incidencia);
			}
			
			rs.close();
		}
		catch (Exception e) 
		{
         System.out.println();		
         }
		finally
		{
			
		}
		return listadoIncidencias;
	}

	@Override
	public int actualizarIncidencia(IncidenciaDTO incidencia, String idEmpleadoR)
	{
		
		int r=0;
		
		try 
		{
			con=MySQLConexion.getConexion();
			con.setAutoCommit(false);
			String qSql="{Call usp_actualizarIncidencia(?, ?, ?, ?, ?, ?, ?, ?)}";
			cst=con.prepareCall(qSql);
			cst.setString(1, incidencia.getIdIncidencia());
			cst.setString(2, incidencia.getIdEmpleado());
			cst.setString(3, incidencia.getDireccion());
			cst.setString(4, incidencia.getDescripcion());
			cst.setString(5, sf.ip_formatearFechaMySQL(incidencia.getFecha()));
			cst.setString(6, incidencia.getHora());
			cst.setString(7, incidencia.getIdEstadoIncidencia());
			cst.setString(8, idEmpleadoR);
			r=cst.executeUpdate();
			con.commit();
		}
		catch (Exception e) 
		{
			System.out.println("Error--> actualizarIncidencia()DAO: "+e);
			try {
				con.rollback();
			} catch (SQLException e1)
			{
				e1.printStackTrace();
			}
		}
		finally
		{
			try 
			{
				con.close();
				cst.close();
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		return r;
	}

}
