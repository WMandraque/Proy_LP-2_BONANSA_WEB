package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class MySQLConexion {
			
	// Ojo el drive debe ir dentro del WEB-INF/lib... xq de lo contrario no reconocera

	public static Connection getConexion(){
		
		//Objeto de tipo conexion
		Connection con = null;
		
		try{
		Class.forName("com.mysql.jdbc.Driver");
		String url= "jdbc:mysql://localhost/bd_bonansa2014";
		String usr= "root";
		String psw= "mysql";
		con = DriverManager.getConnection(url,usr,psw);
		}catch(ClassNotFoundException ex) {
		System.out.println("No hay Driver!!"+ex);
		}catch(SQLException ex) {
		System.out.println("Error con la BD");
		}
		return con;
		
		
	}

}
