package com.bonansa.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import utils.MySQLConexion;

import com.bonansa.beans.VehiculoDTO;
import com.bonansa.interfaces.VehiculoDAO;

public class MySQLVehiculoDAO implements VehiculoDAO {
	
	
	
	Connection con=null;
	PreparedStatement pst=null;
	CallableStatement cst=null;

	@Override
	public int registrarVehiculo(VehiculoDTO vehiculoX, String idEmpleadoR) {
		
		int r=0;
		try {
	
			con=MySQLConexion.getConexion();
			
			con.setAutoCommit(false);
			
			String sql="{CALL usp_registrarVehiculo(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			cst=con.prepareCall(sql);
			cst.setString(1, vehiculoX.getPlacaVeh());
			cst.setInt(2, vehiculoX.getIdCategoriaVeh());
			cst.setString(3, vehiculoX.getMarcaVeh());
			cst.setString(4, vehiculoX.getModeloVeh());
			cst.setInt(5, vehiculoX.getNumAsientosVeh());
			cst.setInt(6, vehiculoX.getAnhoFabricVeh());
			cst.setString(7, vehiculoX.getNumSerieMotorVeh());
			cst.setDouble(8, vehiculoX.getLargoVeh());
			cst.setDouble(9, vehiculoX.getAnchoVeh());
			cst.setDouble(10, vehiculoX.getAlturaVeh());
			cst.setDouble(11, vehiculoX.getCargaBrutaVeh());
			cst.setDouble(12, vehiculoX.getCargaUtilVeh());
			cst.setDouble(13, vehiculoX.getCargaNetaVeh());
			cst.setBytes(14, vehiculoX.getFotoVehiculo());
			cst.setString(15, idEmpleadoR);
			
			r=cst.executeUpdate();
			
			con.commit();
			
		} catch (Exception e) {
			System.out.println("Error al registrarVehiculoDAO: "+e);
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
	public int actualizarVehiculo(VehiculoDTO vehiculoX, String idEmpleadoR) {
		
		
		int r=0;
		int tipoQuery=0;
		
		try {
			
			con=MySQLConexion.getConexion();
			
			con.setAutoCommit(false);
			
			if (vehiculoX.getFotoVehiculo().length>0) {
				
				tipoQuery=1;
			}
			
			String qSql="{Call usp_actualizarVehiculo(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
			cst=con.prepareCall(qSql);
			
			cst.setString(1, vehiculoX.getIdVeh());
			cst.setString(2, vehiculoX.getPlacaVeh());
			cst.setInt(3, vehiculoX.getIdCategoriaVeh());
			cst.setString(4, vehiculoX.getMarcaVeh());
			cst.setString(5, vehiculoX.getModeloVeh());
			cst.setInt(6, vehiculoX.getNumAsientosVeh());
			cst.setInt(7, vehiculoX.getAnhoFabricVeh());
			cst.setString(8, vehiculoX.getNumSerieMotorVeh());
			cst.setDouble(9, vehiculoX.getLargoVeh());
			cst.setDouble(10, vehiculoX.getAnchoVeh());
			cst.setDouble(11, vehiculoX.getAlturaVeh());
			cst.setDouble(12, vehiculoX.getCargaBrutaVeh());
			cst.setDouble(13, vehiculoX.getCargaUtilVeh());
			cst.setDouble(14, vehiculoX.getCargaNetaVeh());
			cst.setBytes(15, vehiculoX.getFotoVehiculo());
			cst.setString(16, vehiculoX.getIdEstado());
			cst.setString(17, vehiculoX.getIdEstadoTrabajo());
			
			cst.setString(18, idEmpleadoR);
			cst.setInt(19, tipoQuery);
			
			 r=cst.executeUpdate();
			con.commit();
			
			
			
		} catch (Exception e) {
			System.out.println("Error al actualizar vehiculoDAO: "+e);
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
				System.out.println("Error al cerrar conexiones vehiculoDAO: "+e2);
			}
		}
		
		return r;
	}
	
	@Override
	public int eliminarVehiculo(String idVehiculo, String idEmpleadoR) {
		
		int r=0;
		try {
			
			con=MySQLConexion.getConexion();
			con.setAutoCommit(false);
			
			String qSql="{Call usp_eliminarVehiculo(?, ?)}";
			cst=con.prepareCall(qSql);
			cst.setString(1, idVehiculo);
			cst.setString(2, idEmpleadoR);
			r=cst.executeUpdate();
			
			con.commit();
			
			
		} catch (Exception e) {
			System.out.println("Error al eliminarVehiculoDAO: "+e);
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
				System.out.println("Errror al cerrar conexiones: "+e2);
			}
		}
		return r;
	}

	@Override
	public ArrayList<VehiculoDTO> listarVehiculos() {
		
		ArrayList<VehiculoDTO> listadoVehiculos=new ArrayList<VehiculoDTO>();
		
		try {
			
			con=MySQLConexion.getConexion();
			String sql="select*from vistaListaVehiculos";
			pst=con.prepareStatement(sql);
			
			ResultSet rs=pst.executeQuery();
			
			while (rs.next()) {
				
				listadoVehiculos.add(new VehiculoDTO(
													rs.getString(1),
													rs.getString(2),
													rs.getString(3),
													rs.getString(4), 
													rs.getString(5), 
													rs.getInt(6), 
													rs.getInt(7), 
													rs.getString(8), 
													rs.getString(9)
													)
				                    );
				
			}
			
		
			
			
		} catch (Exception e) {
			System.out.println("Error al listar la vistaVehiculos: "+e);
		}
		return listadoVehiculos;
	}

	@Override
	public VehiculoDTO buscarVehiculo(String idVehiculo) {
		
		VehiculoDTO vehiculoX = null;
		try {
			
			con=MySQLConexion.getConexion();
			String qsql="Select*from tb_vehiculo where idVeh=?";
			pst=con.prepareStatement(qsql);
			pst.setString(1, idVehiculo);
			
			ResultSet rs=pst.executeQuery();
			
			while(rs.next()){	
				vehiculoX=new VehiculoDTO(
						rs.getString(1), 
						rs.getString(2), 
						rs.getInt(3), 
						rs.getString(4), 
						rs.getString(5), 
						rs.getInt(6), 
						rs.getInt(7), 
						rs.getString(8), 
						rs.getDouble(9), 
						rs.getDouble(10), 
						rs.getDouble(11), 
						rs.getDouble(12),
						rs.getDouble(13), 
						rs.getDouble(14),  
						rs.getString(16), 
						rs.getString(17)
						);
			}
			rs.close();
		} catch (Exception e) {
			System.out.println("Error al buscarVehiculoDAO: "+e);
		}finally{
			try {
				if(con!=null){con.close();}
				if(pst!=null){pst.close();}
			} catch (Exception e2) {
				System.out.println("Errror al cerrar conexiones: "+e2);
			}
		}
		return vehiculoX;
	}



	

}
