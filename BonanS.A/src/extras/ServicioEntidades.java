package extras;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.rowset.CachedRowSet;

import com.sun.rowset.CachedRowSetImpl;

import utils.MySQLConexion;

public class ServicioEntidades {
	
	
	Connection con=null;
	PreparedStatement pst=null;
	
	
	
	public CachedRowSet listadoEntidades(String query){
		
		CachedRowSet crs =null;
		
		try {
			con=MySQLConexion.getConexion();
			
			pst=con.prepareStatement(query);
			
			ResultSet rs=pst.executeQuery();
			
			//Creamos el crs
			crs = new CachedRowSetImpl();
			//Poblamos el crs con el resultset
			crs.populate(rs);
			
		} catch (Exception e) {
			System.out.println("Error al listar Entidades: "+e);
		}finally{
			try {
				if(con!=null){con.close();}
				if(pst!=null){pst.close();}
			} catch (Exception e2) {
				System.out.println("Error al cerrar conexones: "+e2);
			}
		}
		
		
		return crs;
	}
	
	
	
	public int countQuery(String query)
	{
		int cantidad=0;
		try 
		{
			con=MySQLConexion.getConexion();
			pst=con.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			if(rs.next()) 
			{
				cantidad=rs.getInt(1);
				
			}
			rs.close();
		} 
		catch (Exception e) 
		{
			System.out.println("error en CounterQuery(): "+e);
		}
		finally{
			try {
				if(con!=null){con.close();}
				if(pst!=null){pst.close();}
			} catch (Exception e2) {
				System.out.println("Error al cerrar conexones: "+e2);
			}
		}
		return cantidad;
	}
	
	
	
	
	
	




}
