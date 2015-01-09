package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.CachedRowSet;

import com.bonansa.beans.DistritoDTO;
import com.bonansa.beans.ProvinciaDTO;
import com.google.gson.Gson;

import extras.ServicioEntidades;

/**
 * Servlet implementation class SvGestionaUbigeo
 */
@WebServlet("/SvGestionaUbigeo")
public class SvGestionaUbigeo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	
	CachedRowSet crs=null;
	ServicioEntidades sEntidades=new ServicioEntidades();
	Gson obJson=new Gson();
  
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String operacion=request.getParameter("operacion");
			
			switch (operacion) {
			case "Provincia":
				this.Provincia(request, response);
				break;

			case "Distrito":
				this.Distrito(request, response);
				break;
			}
			
		} catch (Exception e) {
			System.out.println("Error al listar ubigeos: "+e);
		}
	}



	private void Provincia(HttpServletRequest request,HttpServletResponse response) {
		
		
		try {
			
			
			
			String coddepto=request.getParameter("coddepto");
			
			ArrayList<ProvinciaDTO> listadoProvincia=new ArrayList<ProvinciaDTO>();
			
			crs=sEntidades.listadoEntidades("SELECT * FROM tb_ubigeo WHERE coddpto ="+coddepto+" AND coddist = 0 AND codprov <> 0");
			while(crs.next()){
				
				listadoProvincia.add(new ProvinciaDTO(crs.getInt(3), crs.getString(5)));
			}

			
			
			String json=obJson.toJson(listadoProvincia);
			PrintWriter out=response.getWriter();
			out.println(json);
			
		} catch (Exception e) {
			System.out.println("Error: "+e);
		}
		
		
	}
	
	

	private void Distrito(HttpServletRequest request,HttpServletResponse response) {
		
		
try {
			
			String coddepto=request.getParameter("coddepto");
			String codprov=request.getParameter("codprov");
			
			ArrayList<DistritoDTO> listadoProvincia=new ArrayList<DistritoDTO>();
			
			crs=sEntidades.listadoEntidades("SELECT * FROM tb_ubigeo WHERE coddpto ="+coddepto+" AND codprov ="+codprov+" AND coddist<> 0");
			while(crs.next()){
				
				listadoProvincia.add(new DistritoDTO(crs.getString(1), crs.getString(5)));
			}
	
			
			
			String json=obJson.toJson(listadoProvincia);
			PrintWriter out=response.getWriter();
			out.println(json);
			
		} catch (Exception e) {
			System.out.println("Error: "+e);
		}
		
	}




}
