package com.bonansa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import utils.MySQLConexion;

import com.bonansa.beans.LogDTO;
import com.bonansa.interfaces.LogDAO;

public class MySQLLogDAO implements LogDAO {
	
	
	PreparedStatement pst=null;
	Connection con=null;

	@Override
	public ArrayList<LogDTO> listaLog() {
		
		ArrayList<LogDTO> listadoLog=new ArrayList<LogDTO>();
		
		try {
			
			con=MySQLConexion.getConexion();
			String sql="SELECT * FROM tb_logGeneral WHERE fecha > TO_DAYS(CURRENT_DATE()) order by codigo desc";
			pst=con.prepareStatement(sql);
			
			ResultSet rs=pst.executeQuery();
			
			while (rs.next()) {
				
				listadoLog.add(new LogDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getTime(6)));
			}
			
		} catch (Exception e) {
			System.out.println("Erro al listar logDAO: "+e);
		}
		return listadoLog;
	}

}
