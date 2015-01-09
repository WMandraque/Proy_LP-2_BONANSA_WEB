package com.bonansa.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLType;
import java.util.ArrayList;
import java.util.List;

import utils.MySQLConexion;

import com.bonansa.beans.ClienteDTO;
import com.bonansa.beans.EmpleadoDTO;
import com.bonansa.interfaces.ClienteDAO;
import com.sun.xml.internal.ws.wsdl.writer.document.Types;

import extras.ServicioFechas;

public class MySQLClienteDAO implements ClienteDAO {
	
	
	Connection con=null;
	CallableStatement cst=null;
	PreparedStatement pst=null;
	int r=0;
	ServicioFechas sF=new ServicioFechas();
	String op_idEmpleado=null;
	
	
	
	@Override
	public int registrarClienteJuridico(ClienteDTO clienteX, String idEmpleadoR, List<ClienteDTO> listaDireccion)
	{
		
     try 
     {
			
			con=MySQLConexion.getConexion();
			con.setAutoCommit(false);
			
			String qSql="{call usp_registrarClienteJuridico(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
			cst=con.prepareCall(qSql);
			
			cst.setInt(1, clienteX.getIdTipoCliente());
			cst.setString(2, clienteX.getNomCliente());
			cst.setString(3, clienteX.getApePatCliente());
			cst.setString(4, clienteX.getApeMatCliente());
			cst.setString(5, sF.ip_formatearFechaMySQL(clienteX.getFecNacCliente()));
			cst.setString(6, clienteX.getSexoCliente());
			cst.setString(7, clienteX.getTelefonoCliente());
			cst.setString(8, clienteX.getCelularCliente());
			cst.setString(9, clienteX.getCorreoCliente());
			cst.setString(10, clienteX.getNumDocumento());
			cst.setString(11, clienteX.getRazSocCliente());
			cst.setString(12, clienteX.getCiiuCliente());
			cst.setString(13, clienteX.getCargoContacCliente());
			cst.setString(14, idEmpleadoR);
			cst.registerOutParameter(15, java.sql.Types.CHAR);


		    cst.executeUpdate();
		    
		    op_idEmpleado=cst.getString(15);
		    for (int i = 0; i < listaDireccion.size(); i++) 
		    {
			    String qSql2="{call usp_registrarDireccionesCliente(?, ?, ?, ?)}";
			    cst=con.prepareCall(qSql2);
			    cst.setString(1, op_idEmpleado);
			    cst.setString(2, listaDireccion.get(i).getDirecDirecCliente());
			    cst.setString(3, listaDireccion.get(i).getCodubigeoDirecCliente());
			    cst.setInt(4, listaDireccion.get(i).getIdTipoEstablec());
			    
			    cst.executeUpdate();
			}
			
			con.commit();
			r=1;
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
	
	
	
	
	@Override
	public int registrarClienteNatural(ClienteDTO clienteX, String idEmpleadoR, List<ClienteDTO> listaDireccion) {
		try {
			
			con=MySQLConexion.getConexion();
			con.setAutoCommit(false);
			
			String qSql="{call usp_registrarClienteNatural(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
			cst=con.prepareCall(qSql);
			
			cst.setInt(1, clienteX.getIdTipoCliente());
			cst.setString(2, clienteX.getNomCliente());
			cst.setString(3, clienteX.getApePatCliente());
			cst.setString(4, clienteX.getApeMatCliente());
			cst.setString(5, sF.ip_formatearFechaMySQL(clienteX.getFecNacCliente()));
			cst.setString(6, clienteX.getSexoCliente());
			cst.setString(7, clienteX.getTelefonoCliente());
			cst.setString(8, clienteX.getCelularCliente());
			cst.setString(9, clienteX.getCorreoCliente());
			cst.setString(10, clienteX.getNumDocumento());
			cst.setString(11, idEmpleadoR);
			cst.registerOutParameter(12, java.sql.Types.CHAR);
			
			
		    cst.executeUpdate();
		    
		    op_idEmpleado=cst.getString(12);
		    for (int i = 0; i < listaDireccion.size(); i++) {
			    String qSql2="{call usp_registrarDireccionesCliente(?, ?, ?, ?)}";
			    cst=con.prepareCall(qSql2);
			    cst.setString(1, op_idEmpleado);
			    cst.setString(2, listaDireccion.get(i).getDirecDirecCliente());
			    cst.setString(3, listaDireccion.get(i).getCodubigeoDirecCliente());
			    cst.setInt(4, listaDireccion.get(i).getIdTipoEstablec());
			    
			    r=cst.executeUpdate();
			}

		    
			
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
	public int actualizarClienteJuridico(ClienteDTO clienteX, String idEmpleadoR, List<ClienteDTO> listaDireccion) {
		
        int r=0;
    try 
       {
			con=MySQLConexion.getConexion();
			con.setAutoCommit(false);
			
			String qSql="{call usp_actualizarClienteJuridico(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
			cst=con.prepareCall(qSql);
			System.out.println("Probando numero de documento: "+clienteX.getNumDocumento());
			cst.setString(1, clienteX.getIdCliente());
			cst.setString(2, clienteX.getNomCliente());
			cst.setString(3, clienteX.getApePatCliente());
			cst.setString(4, clienteX.getApeMatCliente());
			cst.setString(5, sF.ip_formatearFechaMySQL(clienteX.getFecNacCliente()));
			cst.setString(6, clienteX.getSexoCliente());
			cst.setString(7, clienteX.getTelefonoCliente());
			cst.setString(8, clienteX.getCelularCliente());
			cst.setString(9, clienteX.getCorreoCliente());
			cst.setString(10, clienteX.getNumDocumento());
			cst.setString(11, clienteX.getIdEstado());
			cst.setString(12, clienteX.getRazSocCliente());
			cst.setString(13, clienteX.getCiiuCliente());
			cst.setString(14, clienteX.getCargoContacCliente());
			cst.setString(15, idEmpleadoR);
			
			
		    r=cst.executeUpdate();
		    
		    String qSql2="delete from tb_direccionescliente where idCliente=?";
		    pst=con.prepareStatement(qSql2);
		    pst.setString(1, clienteX.getIdCliente());
		    pst.executeUpdate();
		    
		    if(listaDireccion.size()>0)
		    {
			    for (int i = 0; i < listaDireccion.size(); i++) 
			    {
				    String qSql3="{Call usp_registrarDireccionesCliente(?, ?, ?, ?)}";
				    cst=con.prepareCall(qSql3);
				    cst.setString(1, clienteX.getIdCliente());
				    cst.setString(2, listaDireccion.get(i).getDirecDirecCliente());
				    cst.setString(3, listaDireccion.get(i).getCodubigeoDirecCliente());
				    cst.setInt(4, listaDireccion.get(i).getIdTipoEstablec());
				    System.out.println("Probamdo: "+listaDireccion.get(i).getIdTipoEstablec());
				    cst.executeUpdate();
				}
		    }
	
	
		    
	        
			con.commit();
		
	} 
    catch (Exception e)
    {
		
		System.out.println("Error al regitrarClienteJuridicoDAO: "+e);
		
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
		} catch (Exception e2) 
		{
			System.out.println("Error al cerrar conexiones: "+e2);
		}
	}
	return r;
	}
	
	
	@Override
	public int actualizarClienteNatural(ClienteDTO clienteX, String idEmpleadoR, List<ClienteDTO> listaDireccion) {
		
	        int r=0;
      try 
      {
			con=MySQLConexion.getConexion();
			con.setAutoCommit(false);
			
			String qSql="{call usp_actualizarClienteNatural(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
			cst=con.prepareCall(qSql);
			
			cst.setString(1, clienteX.getIdCliente());
			cst.setString(2, clienteX.getNomCliente());
			cst.setString(3, clienteX.getApePatCliente());
			cst.setString(4, clienteX.getApeMatCliente());
			cst.setString(5, sF.ip_formatearFechaMySQL(clienteX.getFecNacCliente()));
			cst.setString(6, clienteX.getSexoCliente());
			cst.setString(7, clienteX.getTelefonoCliente());
			cst.setString(8, clienteX.getCelularCliente());
			cst.setString(9, clienteX.getCorreoCliente());
			cst.setString(10, clienteX.getNumDocumento());
			cst.setString(11, clienteX.getIdEstado());
			cst.setString(12, idEmpleadoR);
			
			
		    cst.executeUpdate();
		    
		    String qSql2="delete from tb_direccionescliente where idCliente=?";
		    pst=con.prepareStatement(qSql2);
		    pst.setString(1, clienteX.getIdCliente());
		    pst.executeUpdate();
		    
		    if(listaDireccion.size()>0)
		    {
		    	for (int i = 0; i < listaDireccion.size(); i++) 
			    {
				    String qSql3="{Call usp_registrarDireccionesCliente(?, ?, ?, ?)}";
				    cst=con.prepareCall(qSql3);
				    cst.setString(1, clienteX.getIdCliente());
				    cst.setString(2, listaDireccion.get(i).getDirecDirecCliente());
				    cst.setString(3, listaDireccion.get(i).getCodubigeoDirecCliente());
				    cst.setInt(4, listaDireccion.get(i).getIdTipoEstablec());
				    cst.executeUpdate();
				}
		    }

		    
		    
			con.commit();
			r=1;
		} 
        catch (Exception e)
        {
			System.out.println("Error al regitrarClienteNaturalDAO: "+e);
			
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
			} catch (Exception e2) 
			{
				System.out.println("Error al cerrar conexiones: "+e2);
			}
		}
		return r;
	}
	
	
	
	
	
	

	
	@Override
	public ArrayList<ClienteDTO> listarCliente() {
		ArrayList<ClienteDTO> listadoClientes=new ArrayList<ClienteDTO>();
		try {
			con=MySQLConexion.getConexion();
			String qSql="select*From vistaListaClientes";
			pst=con.prepareStatement(qSql);
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
				listadoClientes.add(new ClienteDTO
						                         (
						                          rs.getString(1), 
						                          rs.getString(2), 
						                          rs.getString(3), 
						                          rs.getString(4), 
						                          rs.getString(5), 
						                          rs.getString(6), 
						                          rs.getString(7), 
						                          rs.getString(8), 
						                          rs.getString(9))
				                    );
			}
			
		
		} catch (Exception e) {
			System.out.println("Error al listarClientesDAO: "+e);
		}finally{
			try {
				if(con!=null){con.close();}
				if(pst!=null){pst.close();}
			} catch (Exception e2) {
				System.out.println("Error al cerrar conexiones: "+e2);
			}
		}

		return listadoClientes;
	}
	@Override
	public ClienteDTO buscarClienteNatural(String idCliente) {
		
		ClienteDTO clienteX=null;
		try 
		{
			con=MySQLConexion.getConexion();
			String qSql="select*From tb_cliente where idCliente=?";
			pst=con.prepareStatement(qSql);
			pst.setString(1, idCliente);
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
			clienteX=new ClienteDTO(
					               rs.getString(1), 
					               rs.getString(3),
					               rs.getString(4), 
					               rs.getString(5), 
					               sF.op_formatearFechaMySQL(rs.getString(6)), 
					               rs.getString(7), rs.getString(8), 
					               rs.getString(9), rs.getString(10), 
					               rs.getString(11), rs.getString(12));	
			}
			
		} 
		catch (Exception e) 
		{
		System.out.println("Error al buscarClienteNaturalDAO: "+e);	
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
		return clienteX;
	}
	@Override
	public ArrayList<ClienteDTO> listarDirecciones(String idCliente) {
		
		ArrayList<ClienteDTO> listadoDirecciones=new ArrayList<ClienteDTO>();
		
		try 
		{
			con=MySQLConexion.getConexion();
			String qSql="select dc.*, te.descTipoEstablec From tb_direccionescliente as dc inner join tb_tipoestablecimiento as te on dc.idTipoEstablec=te.idTipoEstablec WHERE idCliente=?";
			pst=con.prepareStatement(qSql);
			pst.setString(1, idCliente);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{	
				
				listadoDirecciones.add(
						               new ClienteDTO
						               (
						            		   rs.getInt(1), 
						            		   rs.getString(2), 
						            		   rs.getString(3), 
						            		   rs.getString(4), 
						            		   rs.getInt(5),
						            		   rs.getString(6)
						               )
				                      );
			}
			
		
		} 
		catch (Exception e) 
		{
			System.out.println("Error al listarDireccionesDAO: "+e);
		}
		finally
		{
			try 
			{
				if(con!=null){con.close();}
				if(pst!=null){pst.close();}
			} catch (Exception e2) 
			{
				System.out.println("Error al cerrar conexiones: "+e2);
			}
		}

		return listadoDirecciones;
	}
	
	
	@Override
	public int eliminarCliente(String idCliente, String idEmpleadoR) {
		int r=0;
		try
		{
		con=MySQLConexion.getConexion();
		con.setAutoCommit(false);
		String qSql="{Call usp_eliminarCliente(?, ?)}";
		cst=con.prepareCall(qSql);
		cst.setString(1, idCliente);
		cst.setString(2, idEmpleadoR);
		r=cst.executeUpdate();
		con.commit();
		}
		catch(Exception e)
		{
			System.out.println("Error al eliminarClienteDAO: "+e);	
			try
			{
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
				if(con!=null){con.close();}
				if(cst!=null){cst.close();}
			} catch (Exception e2) 
			{
				System.out.println("Error al cerrar conexiones: "+e2);
			}
		}
		return r;
	}
	@Override
	public ClienteDTO buscarClienteJuridico(String idCliente) {
		
		ClienteDTO clienteX=null;
		try 
		{
			con=MySQLConexion.getConexion();
			String qSql=""
					+ "select c.*, cj.razSocCliente, cj.ciiuCliente, cj.cargoContacCliente From "
					+ "tb_cliente as c "
					+ "inner join tb_cliente_juridico as cj "
					+ "on c.idCliente=cj.idCliente "
					+ "where c.idCliente=?";
			pst=con.prepareStatement(qSql);
			pst.setString(1, idCliente);
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
			clienteX=new ClienteDTO(
					               rs.getString(1), 
					               rs.getString(3),
					               rs.getString(4), 
					               rs.getString(5), 
					               sF.op_formatearFechaMySQL(rs.getString(6)), 
					               rs.getString(7), 
					               rs.getString(8), 
					               rs.getString(9),
					               rs.getString(10), 
					               rs.getString(11), 
					               rs.getString(12),
					               rs.getString(13),
					               rs.getString(14),
					               rs.getString(15)
					               );	
			}
			
		} 
		catch (Exception e) 
		{
		System.out.println("Error al buscarClienteJuridicoDAO: "+e);	
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
		return clienteX;
	}


}
