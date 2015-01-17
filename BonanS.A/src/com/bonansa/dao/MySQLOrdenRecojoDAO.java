package com.bonansa.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import utils.MySQLConexion;

import com.bonansa.beans.SolicitudOrdenRecojoDTO;
import com.bonansa.interfaces.OrdenRecojoDAO;

import extras.ServicioFechas;

public class MySQLOrdenRecojoDAO implements OrdenRecojoDAO 
{
	

	Connection con=null;
	PreparedStatement pst=null;
	CallableStatement cst=null;
	ServicioFechas sFechas=new ServicioFechas();
	
	@Override
	public int registrarOrdenRecojo(
									SolicitudOrdenRecojoDTO ordenRecojo,
									ArrayList<SolicitudOrdenRecojoDTO> cp_listadoDOR,
									ArrayList<SolicitudOrdenRecojoDTO> cp_listadoOR_EquipoPersonal,
									ArrayList<SolicitudOrdenRecojoDTO> cp_listadoOR_EquipoVehicular,
									String idEmpleadoR
									) 
	{
		
		int r=0;
		
		try 
		{
			con=MySQLConexion.getConexion();
			con.setAutoCommit(false);
			String qSql="{Call usp_registrarOrdenRecojo(?, ?, ?, ?, ?, ?)}";
			cst=con.prepareCall(qSql);
			cst.setString(1, ordenRecojo.getIdCliente());
			cst.setString(2, ordenRecojo.getDireccionRecojo());
			cst.setString(3, sFechas.ip_formatearFechaMySQL(ordenRecojo.getFechaRecojo()));
			cst.setString(4, ordenRecojo.getHoraRecojo());
			cst.setString(5, idEmpleadoR);
			cst.registerOutParameter(6, java.sql.Types.CHAR);
			r=cst.executeUpdate();
			String op_idOR=cst.getString(6);
			if (cp_listadoDOR.size()>0) 
			{
			 String qSql2="{Call usp_detalleOrdenRecojo(?, ?, ?, ?, ?)}";
			 cst=con.prepareCall(qSql2);
			 
			 for (int i = 0; i < cp_listadoDOR.size(); i++) 
			 {
			  SolicitudOrdenRecojoDTO sORX=cp_listadoDOR.get(i);
			  cst.setString(1, op_idOR);
			  cst.setString(2, sORX.getDescripcionTraslado());
			  cst.setInt(3, sORX.getCantidad());
			  cst.setInt(4, sORX.getIdTipoUnidadMedida());
			  cst.setDouble(5, sORX.getPesoKg());
			  cst.executeUpdate();
			 }
			}
			
			if(cp_listadoOR_EquipoPersonal.size()>0)
			{
			 String qSql3="{Call usp_registrarEquipoPersonalOrdenRecojo(?, ?)}";
			 cst=con.prepareCall(qSql3);
				 for (int i = 0; i < cp_listadoOR_EquipoPersonal.size(); i++) 
				 {
					 cst.setString(1, op_idOR);
					 cst.setString(2, cp_listadoOR_EquipoPersonal.get(i).getIdEmpleado());
					 cst.executeUpdate();
				 }
			}
			
			if(cp_listadoOR_EquipoVehicular.size()>0)
			{
				 String qSql4="{Call usp_registrarEquipoVehicularOrdenRecojo(?, ?)}";
				 cst=con.prepareCall(qSql4);
				 for (int i = 0; i < cp_listadoOR_EquipoVehicular.size(); i++) 
				 {
					 cst.setString(1, op_idOR);
					 cst.setString(2, cp_listadoOR_EquipoVehicular.get(i).getIdVehiculo());
					 r=cst.executeUpdate();
				 }
			}
			
			
			con.commit();
			
			
			
		} 
		catch (Exception e) 
		{
				System.out.println("Erroe en  registrarOrdenRecojoDAO: "+e);
				try 
				{
					con.rollback();
				} 
				catch (SQLException e1) 
				{
					e1.printStackTrace();
				}
		}
		finally
		{
			try 
			{
				if(con!=null){con.close();}
				if(cst!=null){cst.close();}
			}
			catch (Exception e2)
			{
				System.out.println("Error al cerrar conexiones: "+e2);
			}
		}
		
		
		
		return r;
	}

	
	
	public ArrayList<SolicitudOrdenRecojoDTO> listarOrdenRecojos(String idEmpleado)
	{
		ArrayList<SolicitudOrdenRecojoDTO> listadoOrdenRecojos=new ArrayList<SolicitudOrdenRecojoDTO>();
		try 
		{
			con=MySQLConexion.getConexion();
			String qSql;
			if (idEmpleado==null) 
			{
				qSql="select*from vistaListaOrdenRecojos";
				pst=con.prepareStatement(qSql);
			}
			else
			{
				qSql="select*from vistaListaOrdenRecojos where idEmpleado=?";
				pst=con.prepareStatement(qSql);
				pst.setString(1, idEmpleado);	
			}
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
			
				SolicitudOrdenRecojoDTO sORX=new SolicitudOrdenRecojoDTO();
				sORX.setIdOR(rs.getString(1));
				sORX.setIdCliente(rs.getString(2));
				sORX.setDireccionRecojo(rs.getString(3));
				sORX.setFechaRecojo(sFechas.op_formatearFechaMySQL(rs.getString(4)));
				sORX.setHoraRecojo(rs.getString(5));
				sORX.setDescEstadoOR(rs.getString(6));
			    sORX.setIdEmpleado(rs.getString(7));
				
				listadoOrdenRecojos.add(sORX);
				
			}
			
			
		} 
		catch (Exception e) 
		{
	     System.out.println("Error en listadoOrdenRecojosDAO: "+e);
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
		
		return listadoOrdenRecojos;
	}



	@Override
	public SolicitudOrdenRecojoDTO buscarSOR(String idOR) {
		
		SolicitudOrdenRecojoDTO sORX=new SolicitudOrdenRecojoDTO();
		ArrayList<SolicitudOrdenRecojoDTO> listadoDescripcionTraslado=new ArrayList<SolicitudOrdenRecojoDTO>();
		ArrayList<SolicitudOrdenRecojoDTO> listadoEquipoPersonaRecojo=new ArrayList<SolicitudOrdenRecojoDTO>();
		try 
		{
			con=MySQLConexion.getConexion();
			String qSql="SELECT*FROM vistaBuscarSOR where idOR=? and idEstadoOR='0'";
			pst=con.prepareStatement(qSql);
			pst.setString(1, idOR);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
			 sORX.setIdOR(rs.getString(1));
			 sORX.setIdCliente(rs.getString(2));
			 sORX.setDireccionRecojo(rs.getString(3));
			 sORX.setNomCompleto(rs.getString(4));
			 sORX.setIdTipoCliente(rs.getInt(5));
			 sORX.setNumDocumento(rs.getString(6));
			 sORX.setIdEmpleado(rs.getString(7));
			 sORX.setLicenCondu(rs.getString(8));
			 sORX.setIdVehiculo(rs.getString(9));
			 sORX.setPlacaVehiculo(rs.getString(10));
			}
			rs.close();
			
			String qSql2="SELECT dor.*, tum.descTipoUnidadMedida FROM tb_detalle_ordenRecojo as dor inner join tb_tipoUnidadMedida as tum on dor.idTipoUnidadMedida=tum.idTipoUnidadMedida where dor.idOR=?";
			pst=con.prepareStatement(qSql2);
			pst.setString(1, idOR);
			ResultSet rs2=pst.executeQuery();
			while(rs2.next())
			{
			 SolicitudOrdenRecojoDTO descripcionTraslado=new SolicitudOrdenRecojoDTO();
			 descripcionTraslado .setDescripcionTraslado(rs2.getString(2));
			 descripcionTraslado.setCantidad(rs2.getInt(3));
			 descripcionTraslado.setIdTipoUnidadMedida(rs2.getInt(4));
			 descripcionTraslado.setPesoKg(rs2.getDouble(5));
			 descripcionTraslado.setDescTipoUnidadMedida(rs2.getString(6));
			 listadoDescripcionTraslado.add(descripcionTraslado);
			}
			sORX.setListadoDescripcionTraslado(listadoDescripcionTraslado);
			rs2.close();
			
			String qSql3=   "SELECT*FROM vistaBuscarEquipoPersonal WHERE idOR=?";
			pst=con.prepareStatement(qSql3);
			pst.setString(1, idOR);
			ResultSet rs3=pst.executeQuery();
			while(rs3.next())
			{
				SolicitudOrdenRecojoDTO equipoPersonalRecojo=new SolicitudOrdenRecojoDTO();
				equipoPersonalRecojo.setIdEmpleado(rs3.getString(2));
				equipoPersonalRecojo.setDescTipoEmpleado(rs3.getString(4));
				equipoPersonalRecojo.setNomCompleto(rs3.getString(5)+" "+rs3.getString(6)+" "+rs3.getString(7));
				listadoEquipoPersonaRecojo.add(equipoPersonalRecojo);
			}
				
			sORX.setListadoEquipoPersonaRecojos(listadoEquipoPersonaRecojo);
			rs3.close();


			
		} 
		catch (Exception e) 
		{
			System.out.println("Error en buscarSORDAO: "+e);
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
		return sORX;
	}



	@Override
	public ArrayList<SolicitudOrdenRecojoDTO> listarDescripcionTraslado(
			String idEmpleado) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	

	
	
	
}
