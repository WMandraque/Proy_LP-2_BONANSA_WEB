package extras;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import utils.MySQLConexion;

public class ServicioFoto {
	

	Connection con=null;
	PreparedStatement  pst=null;
	
	
	public InputStream getFotoVehiculo(String idVehiculo){
		
		InputStream is=null;
		
		try {
			
		
			con=MySQLConexion.getConexion();
			String sql="select fotoVehiculo from tb_vehiculo where idVeh=?";
			pst=con.prepareStatement(sql);
			pst.setString(1, idVehiculo.trim());
			ResultSet rs=pst.executeQuery();
			if(rs.next()){
				is=rs.getBinaryStream(1);
			}
			
			rs.close();
			
		} catch (Exception e) {
			System.out.println("Error al obtener la fotoVehiculoDAO: "+e);
		}finally{
			try {
				con.close();
				pst.close();
			} catch (Exception e2) {
				System.out.println("Error al cerrar conexiones: "+e2);
			}
		}
		
		return is;
	}
	
	
public InputStream getFotoEmpleado(String idEmpleado){
		
		InputStream is=null;
		
		try {
			
		
			con=MySQLConexion.getConexion();
			String sql="select fotoEmpleado from tb_empleado WHERE idEmpleado=?";
			pst=con.prepareStatement(sql);
			pst.setString(1, idEmpleado.trim());
			ResultSet rs=pst.executeQuery();
			if(rs.next()){
				is=rs.getBinaryStream(1);
			}
			
			
			
		} catch (Exception e) {
			System.out.println("Error al obtener EmpleadoDAO: "+e);
		}finally{
			try {
				con.close();
				pst.close();
			} catch (Exception e2) {
				System.out.println("Error al cerrar conexiones: "+e2);
			}
		}
		
		return is;
	}
	
	
	
	
	
	

}
