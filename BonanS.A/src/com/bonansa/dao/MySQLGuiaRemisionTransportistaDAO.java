package com.bonansa.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLType;
import java.util.ArrayList;

import utils.MySQLConexion;

import com.bonansa.beans.GuiaRemisionTransportistaDTO;
import com.bonansa.beans.SolicitudOrdenRecojoDTO;
import com.bonansa.interfaces.GuiaRemisionTransportistaDAO;

import extras.ServicioFechas;

public class MySQLGuiaRemisionTransportistaDAO implements GuiaRemisionTransportistaDAO {

	
	Connection con=null;
	PreparedStatement pst=null;
	CallableStatement cst=null;
	ServicioFechas sF=new ServicioFechas();
	
	@Override
	public int registrarGRT(GuiaRemisionTransportistaDTO gRT, String idEmpleadoR, String idSOR, ArrayList<GuiaRemisionTransportistaDTO> listadoDGRT, ArrayList<SolicitudOrdenRecojoDTO> listadoEquipoPersonalTraslado) {
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
			
			cst.executeUpdate();
			
			String op_idGRT=cst.getString(16);
			
			for (int i = 0; i < listadoDGRT.size(); i++) 
			{
				
				String qSql2="{Call usp_registrarDGRT(?, ?, ?, ?, ?, ?, ?)}";
				cst=con.prepareCall(qSql2);
				cst.setString(1, op_idGRT);
				cst.setString(2, listadoDGRT.get(i).getNumCodGR());
				cst.setString(3, listadoDGRT.get(i).getNumCodFT());
				cst.setString(4, listadoDGRT.get(i).getDescTraslado());
				cst.setInt(5, listadoDGRT.get(i).getCantidad());
				cst.setInt(6, listadoDGRT.get(i).getIdTipoUnidadMedida());
				cst.setDouble(7, listadoDGRT.get(i).getPesoKg());
				
				cst.executeUpdate();

			}
			
			for (int i = 0; i < listadoEquipoPersonalTraslado.size(); i++) 
			{
				String qSql3="insert into tb_equipoTrasladoGRT values(?,?)";
				pst=con.prepareStatement(qSql3);
				pst.setString(1, op_idGRT);
				pst.setString(2, listadoEquipoPersonalTraslado.get(i).getIdEmpleado());
				pst.executeUpdate();
			}
			
			con.commit();
			r=1;
			
			
			System.out.println("GRT GENERADO: "+op_idGRT);
		} 
		catch (Exception e) 
		{
			System.out.println("Error en registrarGRTDAO: "+e);
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

	@Override
	public ArrayList<GuiaRemisionTransportistaDTO> listarGRT(String idEmpleado) {
		
		ArrayList<GuiaRemisionTransportistaDTO> listadoGRT=new ArrayList<GuiaRemisionTransportistaDTO>();
		try 
		{
			con=MySQLConexion.getConexion();
			String qSql;
			if(idEmpleado==null)
			{
				System.out.println("1");
				qSql="SELECT*FROM vistaListaGRT";
				pst=con.prepareStatement(qSql);
			}
			else
			{
				System.out.println("2");
				qSql="SELECT*FROM vistaListaGRT where idEmpleado=?";
				pst=con.prepareStatement(qSql);
				pst.setString(1, idEmpleado);
			}
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{			System.out.println("4");

				GuiaRemisionTransportistaDTO grt=new GuiaRemisionTransportistaDTO();
				grt.setIdGRT(rs.getString(1));
				grt.setIdEmpleado(rs.getString(2));
				grt.setLicenCondEmpleado(rs.getString(3));
				grt.setIdVeh(rs.getString(4));
				grt.setPlacaVeh(rs.getString(5));
				grt.setIdCliRemitente(rs.getString(6));
				grt.setDirecCliRemitente(rs.getString(7));
				grt.setNomCliRemitente(rs.getString(8));
				grt.setApePaCliRemitente(rs.getString(9));
				grt.setApeMaCliRemitente(rs.getString(10));
				grt.setIdTipoCliente(rs.getInt(11));
				grt.setDescTipoCliente(rs.getString(12));
				grt.setNumDocumentoCliRemitente(rs.getString(13));
				grt.setNomCliDestinatario(rs.getString(14));
				grt.setApepaCliDestinatario(rs.getString(15));
				grt.setApemaCliDestinatario(rs.getString(16));
				grt.setIdTipoDocIdCliDestinatario(rs.getInt(17));
				grt.setDescTipoDocumentoCliDest(rs.getString(18));
				grt.setNumDocCliDestinatario(rs.getString(19));
				grt.setDirecClienteDestinatario(rs.getString(20));
				grt.setFecMinEntrega(sF.op_formatearFechaMySQL(rs.getString(21)));
				grt.setFecMaxEntrega(sF.op_formatearFechaMySQL(rs.getString(22)));
				grt.setIdEstadoGRT(rs.getString(23));
				grt.setDescEstadoGRT(rs.getString(24));
				
				listadoGRT.add(grt);
			}

			
		} 
		catch (Exception e) 
		{
			System.out.println("Error al listarGRTDAO: "+e);
		}
		finally
		{
			try 
			{
				if(con!=null){con.close();}
				if(pst!=null){pst.close();}
			}
			catch (Exception e2)
			{
				System.out.println("Error al cerrar conexiones: "+e2);
			}
		}
		
		return listadoGRT;
	}

	@Override
	public GuiaRemisionTransportistaDTO buscarGRT(String idGRT) {
		
		GuiaRemisionTransportistaDTO regGrt=new GuiaRemisionTransportistaDTO();

		try 
		{
			con=MySQLConexion.getConexion();
			String qSql="select*from vistaBuscarGRT where idGRT=?";
			pst=con.prepareStatement(qSql);
			pst.setString(1, idGRT);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				regGrt.setIdGRT(rs.getString(1));
				regGrt.setFecInicioTraslado(sF.op_formatearFechaMySQL(rs.getString(2)));
				regGrt.setIdVeh(rs.getString(3));
				regGrt.setPlacaVeh(rs.getString(4));
				regGrt.setIdEmpleado(rs.getString(5));
				regGrt.setLicenCondEmpleado(rs.getString(6));
				regGrt.setIdTipoCliente(rs.getInt(7));
				regGrt.setNumDocumentoCliRemitente(rs.getString(8));
				regGrt.setIdCliRemitente(rs.getString(9));
				regGrt.setNomCliRemitente(rs.getString(10));
				regGrt.setApePaCliRemitente(rs.getString(11));
				regGrt.setApeMaCliRemitente(rs.getString(12));
				regGrt.setDirecCliRemitente(rs.getString(13));
				regGrt.setIdTipoDocIdCliDestinatario(rs.getInt(14));
				regGrt.setNumDocCliDestinatario(rs.getString(15));
				regGrt.setNomCliDestinatario(rs.getString(16));
				regGrt.setApepaCliDestinatario(rs.getString(17));
				regGrt.setApemaCliDestinatario(rs.getString(18));
				regGrt.setDirecClienteDestinatario(rs.getString(19));
				regGrt.setFecMinEntrega(sF.op_formatearFechaMySQL(rs.getString(20)));
				regGrt.setFecMaxEntrega(sF.op_formatearFechaMySQL(rs.getString(21)));
				regGrt.setIdEstadoGRT(rs.getString(22));
			}
			rs.close();
			
			String qSql2="select*From vistaBuscarListaEquipoTrasladoGRT where idGRT=?";
			pst=con.prepareStatement(qSql2);
			pst.setString(1, idGRT);
			ResultSet rs2=pst.executeQuery();
			ArrayList<GuiaRemisionTransportistaDTO> listadoEquipoPersonalTraslado=new ArrayList<GuiaRemisionTransportistaDTO>();
			while(rs2.next())
			{
			  GuiaRemisionTransportistaDTO personalTrasladoGRT=new GuiaRemisionTransportistaDTO();
			  personalTrasladoGRT.setIdEmpleado(rs2.getString(2));
			  personalTrasladoGRT.setNomEmpleado(rs2.getString(3));
			  personalTrasladoGRT.setApePaEmpleado(rs2.getString(4));
			  personalTrasladoGRT.setApeMaEmpleado(rs2.getString(5));
			  personalTrasladoGRT.setDescTipoEmpleado(rs2.getString(6));
			  listadoEquipoPersonalTraslado.add(personalTrasladoGRT);
			}
			rs2.close();
			regGrt.setListadoEquipoPersonalTraslado(listadoEquipoPersonalTraslado);

			String qSql3="select*From vistaBuscarListaDetalleGRT where idGRT=?";
			pst=con.prepareStatement(qSql3);
			pst.setString(1, idGRT);
			ResultSet rs3=pst.executeQuery();
			ArrayList<GuiaRemisionTransportistaDTO> listadoDGRT=new ArrayList<GuiaRemisionTransportistaDTO>();
			while(rs3.next())
			{
				GuiaRemisionTransportistaDTO dGRT=new GuiaRemisionTransportistaDTO();
				dGRT.setIdGRT(rs3.getString(1));
				dGRT.setDescTraslado(rs3.getString(2));
				dGRT.setCantidad(rs3.getInt(3));
				dGRT.setDescTipoUnidadMedida(rs3.getString(4));
				dGRT.setPesoKg(rs3.getDouble(5));
				dGRT.setNumCodGR(rs3.getString(6));
				dGRT.setNumCodFT(rs3.getString(7));
				listadoDGRT.add(dGRT);
			}
			rs3.close();
			regGrt.setListadoDGRT(listadoDGRT);
		
			
			
		} 
		catch (Exception e) 
		{
		System.out.println("Error en buscarGRTDAO: "+e);
		}
		finally
		{
			try 
			{
				if(con!=null){con.close();}
				if(pst!=null){pst.close();}
			}
			catch (Exception e2)
			{
				System.out.println("Error al cerrar conexiones: "+e2);
			}
		}
		return regGrt;
	}

	@Override
	public int registrarEntregaMercaderia(String idGrt, String idEmpleadoR) 
	{
		int r=0;
		try 
		{
			con=MySQLConexion.getConexion();
			con.setAutoCommit(false);
			
			String qSql="{Call usp_registrarEntregaGRT(?, ?)}";
			cst=con.prepareCall(qSql);
			cst.setString(1, idGrt);
			cst.setString(2, idEmpleadoR);
			r=cst.executeUpdate();
			
			con.commit();
		}
		catch (Exception e) 
		{
			System.out.println("Error en registrarEntregaGRTDAO: "+e);
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return r;
	}

}
