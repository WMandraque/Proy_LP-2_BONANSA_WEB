package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import extras.ServicioEntidades;

/**
 * Servlet implementation class SvGestionaServicios
 */
@WebServlet("/SvGestionaServicios")
public class SvGestionaServicios extends HttpServlet {
	private static final long serialVersionUID = 1L;


	ServicioEntidades servicioEntidad=new ServicioEntidades();
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String operacion=request.getParameter("");		
		if (operacion.equals("cantidadLogueos")) 
		{
			this.cantidadLogueos(request, response);
		}
	}


	private void cantidadLogueos(HttpServletRequest request,HttpServletResponse response)
	{
		
		try 
		{
			System.out.println("Llego a este metodo");
			int cantidadLogueos=servicioEntidad.countQuery("Select count(*)From tb_logGeneral where tipo='Loguin' and fecha=curdate()");
			PrintWriter print=response.getWriter();
			System.out.println("CantidadLogueos: "+cantidadLogueos);
			print.println("99");

			
			
		} catch (Exception e) {
			System.out.println("cantidadLogueos: "+e);
		}
		

	}



}
