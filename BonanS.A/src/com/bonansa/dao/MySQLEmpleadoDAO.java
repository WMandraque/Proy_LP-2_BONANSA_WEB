package com.bonansa.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import utils.MySQLConexion;

import com.bonansa.beans.EmpleadoDTO;
import com.bonansa.interfaces.EmpleadoDAO;

import extras.ServicioFechas;

public class MySQLEmpleadoDAO implements EmpleadoDAO {
	
	Connection con=null;
	CallableStatement cst=null;
	PreparedStatement pst=null;
	ServicioFechas sF=new ServicioFechas();

	@Override
	public int registrarEmpleado(EmpleadoDTO empleado, String idEmpleadoR) {
		int r=0;
		try {
			con=MySQLConexion.getConexion();
			con.setAutoCommit(false);
			String qSql="{Call usp_registrarEmpleado(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
			cst=con.prepareCall(qSql);
			
			cst.setInt(1, empleado.getIdTipoEmpleado());
			cst.setString(2, empleado.getNumDocumento());
			cst.setString(3, empleado.getNomEmpleado());
			cst.setString(4, empleado.getApepaEmpleado());
			cst.setString(5, empleado.getApemaEmpleado());
			cst.setString(6, empleado.getSexoEmpleado());
			cst.setString(7, sF.ip_formatearFechaMySQL(empleado.getFecnacEmpleado()));
			cst.setString(8, empleado.getDomicilioEmpleado());
			cst.setString(9, empleado.getUbigeoEmpleado());
			cst.setString(10, empleado.getFonoEmpleado());
			cst.setString(11, empleado.getCelularEmpleado());
			cst.setString(12, empleado.getEmailEmpleado());
			cst.setBytes(13, empleado.getFotoEmpleado());
			
			cst.setString(14, idEmpleadoR);
			
			r=cst.executeUpdate();
			
			
			con.commit();
			
		} catch (Exception e) {
			System.out.println("Error al registrarEmpleadoDAO: "+e);
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
		}finally{
			try {
				if(cst!=null){cst.close();}
				if(con!=null){con.close();}
			} catch (Exception e2) {
				System.out.println("Error al cerrar conexiones: "+e2);
			}
		}
		return r;
	}

	@Override
	public int registrarEmpleadoConductor(EmpleadoDTO empleado, String idEmpleadoR) {
		int r=0;
		try {
			con=MySQLConexion.getConexion();
			con.setAutoCommit(false);
			String qSql="{Call usp_registrarEmpleadoConductor(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
			cst=con.prepareCall(qSql);
			
			cst.setInt(1, empleado.getIdTipoEmpleado());
			cst.setString(2, empleado.getNumDocumento());
			cst.setString(3, empleado.getNomEmpleado());
			cst.setString(4, empleado.getApepaEmpleado());
			cst.setString(5, empleado.getApemaEmpleado());
			cst.setString(6, empleado.getSexoEmpleado());
			cst.setString(7, sF.ip_formatearFechaMySQL(empleado.getFecnacEmpleado()));
			cst.setString(8, empleado.getDomicilioEmpleado());
			cst.setString(9, empleado.getUbigeoEmpleado());
			cst.setString(10, empleado.getFonoEmpleado());
			cst.setString(11, empleado.getCelularEmpleado());
			cst.setString(12, empleado.getEmailEmpleado());
			cst.setBytes(13, empleado.getFotoEmpleado());
			cst.setString(14, empleado.getLicenCondEmpleado());
			cst.setInt(15, empleado.getIdClaselic());
			cst.setInt(16, empleado.getIdCategorialic());

			
			cst.setString(17, idEmpleadoR);
			
			r=cst.executeUpdate();
			
			
			con.commit();
			
		} catch (Exception e) {
			System.out.println("Error al registrarEmpleadoDAO: "+e);
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
		}finally{
			try {
				if(cst!=null){cst.close();}
				if(con!=null){con.close();}
			} catch (Exception e2) {
				System.out.println("Error al cerrar conexiones: "+e2);
			}
		}
		return r;
	}

	@Override
	public ArrayList<EmpleadoDTO> listarEmpleado() {
		ArrayList<EmpleadoDTO> listadoEmpleados=new ArrayList<EmpleadoDTO>();
		try {
			con=MySQLConexion.getConexion();
			String qSql="select*From vistaListaEmpleados";
			pst=con.prepareStatement(qSql);
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
				listadoEmpleados.add(new EmpleadoDTO(
														rs.getString(1), 
														rs.getString(2), 
														rs.getString(3), 
														rs.getString(4), 
														rs.getString(5),
														rs.getString(6), 
														rs.getString(7),
														rs.getString(8), 
														rs.getString(9), 
														rs.getString(10)
													)
				                    );
			}
			
		
		} catch (Exception e) {
			System.out.println("Error al listarEmpleadoDAO: "+e);
		}finally{
			try {
				if(con!=null){con.close();}
				if(pst!=null){pst.close();}
			} catch (Exception e2) {
				System.out.println("Error al cerrar conexiones: "+e2);
			}
		}

		return listadoEmpleados;
	}

	@Override
	public EmpleadoDTO buscarEmpleado(String idEmpleado) {
		EmpleadoDTO empleadoX=null;
		try {
			con=MySQLConexion.getConexion();
			String qSql="select*from tb_empleado where idEmpleado=?";
			pst=con.prepareStatement(qSql);
			pst.setString(1, idEmpleado);
			
			ResultSet rs=pst.executeQuery();
			
			if(rs.next())
			{
			empleadoX=new EmpleadoDTO(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), sF.op_formatearFechaMySQL(rs.getString(8)), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(15), rs.getString(16));	
			}
			rs.close();
		} catch (Exception e) {
			System.out.println("Error al buscarEmpleadoDAO: "+e);
		}finally{
		try {
			if(con!=null){con.close();}
			if(pst!=null){pst.close();}
		} catch (Exception e2) {
			System.out.println("Error al cerrar conexiones: "+e2);
		}
	}
		return empleadoX;
	}

	@Override
	public EmpleadoDTO buscarEmpleadoConductor(String idEmpleado) {
		EmpleadoDTO empleadoX=null;
		try {
			con=MySQLConexion.getConexion();
			String qSql="select*from tb_empleado as e inner join tb_empleado_conductor as ec on e.idEmpleado=ec.idEmpleado where e.idEmpleado=?";
			pst=con.prepareStatement(qSql);
			pst.setString(1, idEmpleado);
			
			ResultSet rs=pst.executeQuery();
			
			if(rs.next())
			{
			empleadoX=new EmpleadoDTO(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), sF.op_formatearFechaMySQL(rs.getString(8)), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(15), rs.getString(16), rs.getString(18), rs.getInt(19), rs.getInt(20));	
			}
			rs.close();
		} catch (Exception e) {
			System.out.println("Error al buscarEmpleadoDAO: "+e);
		}finally{
		try {
			if(con!=null){con.close();}
			if(pst!=null){pst.close();}
		} catch (Exception e2) {
			System.out.println("Error al cerrar conexiones: "+e2);
		}
	}
		return empleadoX;
	}

	@Override
	public int actualizarEmpleado(EmpleadoDTO empleado, String idEmpleadoR) {
		int r=0;
		int tipoQuery=0;
		try {
			con=MySQLConexion.getConexion();
			con.setAutoCommit(false);
			

			if (empleado.getFotoEmpleado().length>0) {
				
				tipoQuery=1;
			}
			
			String qSql="{Call usp_actualizarEmpleado(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
			cst=con.prepareCall(qSql);
			cst.setString(1, empleado.getIdEmpleado());
			cst.setString(2, empleado.getNumDocumento());
			cst.setString(3, empleado.getNomEmpleado());
			cst.setString(4, empleado.getApepaEmpleado());
			cst.setString(5, empleado.getApemaEmpleado());
			cst.setString(6, empleado.getSexoEmpleado());
			cst.setString(7, sF.ip_formatearFechaMySQL(empleado.getFecnacEmpleado()));
			cst.setString(8, empleado.getDomicilioEmpleado());
			cst.setString(9, empleado.getUbigeoEmpleado());
			cst.setString(10, empleado.getFonoEmpleado());
			cst.setString(11, empleado.getCelularEmpleado());
			cst.setString(12, empleado.getEmailEmpleado());
			cst.setBytes(13, empleado.getFotoEmpleado());
			cst.setString(14, empleado.getIdEstadoTrabajo());
			cst.setString(15, empleado.getIdEstado());
			
			cst.setString(16, idEmpleadoR);
			cst.setInt(17, tipoQuery);
			
			r=cst.executeUpdate();
			
			con.commit();
			
		} catch (Exception e) {
			System.out.println("Error al actualizarEmpleadoDAO: "+e);
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			try {
				if(cst!=null){cst.close();}
				if(con!=null){con.close();}
			} catch (Exception e2) {
				System.out.println("Error al cerrar conexiones: "+e2);
			}
		}
		return r;
	}

	@Override
	public int actualizarEmpleadoConductor(EmpleadoDTO empleado,String idEmpleadoR)
	{ 
	int r=0;
	int tipoQuery=0;
	try {
		con=MySQLConexion.getConexion();
		con.setAutoCommit(false);
		if (empleado.getFotoEmpleado().length>0) {
			tipoQuery=1;
		}
		
		String qSql="{Call usp_actualizarEmpleadoConductor(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
		cst=con.prepareCall(qSql);
		cst.setString(1, empleado.getIdEmpleado());
		cst.setString(2, empleado.getNumDocumento());
		cst.setString(3, empleado.getNomEmpleado());
		cst.setString(4, empleado.getApepaEmpleado());
		cst.setString(5, empleado.getApemaEmpleado());
		cst.setString(6, empleado.getSexoEmpleado());
		cst.setString(7, sF.ip_formatearFechaMySQL(empleado.getFecnacEmpleado()));
		cst.setString(8, empleado.getDomicilioEmpleado());
		cst.setString(9, empleado.getUbigeoEmpleado());
		cst.setString(10, empleado.getFonoEmpleado());
		cst.setString(11, empleado.getCelularEmpleado());
		cst.setString(12, empleado.getEmailEmpleado());
		cst.setBytes(13, empleado.getFotoEmpleado());
		cst.setString(14, empleado.getLicenCondEmpleado());
		cst.setInt(15, empleado.getIdClaselic());
		cst.setInt(16, empleado.getIdCategorialic());
		cst.setString(17, empleado.getIdEstadoTrabajo());
		cst.setString(18, empleado.getIdEstado());
		
		cst.setString(19, idEmpleadoR);
		cst.setInt(20, tipoQuery);
        System.out.println("Antes del exucte");
		r=cst.executeUpdate();
		
		con.commit();
		
	} catch (Exception e) {
		System.out.println("Error al actualizarEmpleadoConductorDAO: "+e);
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
