package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bonansa.beans.Persona;

/**
 * Servlet implementation class SvAccionServlet
 */
@WebServlet("/SvAccionServlet")
public class SvAccionServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ArrayList<Persona> personas = new ArrayList<>();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		response.setContentType( "text/html; charset=iso-8859-1" );
		PrintWriter out = response.getWriter();
		
		// Obtengo los datos de la peticion
				String nombre = request.getParameter("nombre");
				String apellido = request.getParameter("apellido");
				int edad = Integer.parseInt(request.getParameter("edad"));
						
		
				// Compruebo que los campos del formulario tienen datos para añadir a la tabla
				
					// Creo el objeto persona y lo añado al arrayList
					Persona persona = new Persona(nombre, apellido, edad);
					personas.add(persona);
		
				
				
				out.println("<table>");
				out.println("<tr>");
				out.println("<td> NOMBRE </td>");			
				out.println("<td>APELLIDO</td>");
				out.println("<td>EDAD</td>");
				out.println("</tr>");
				for(int i=0; i<personas.size(); i++){
					Persona persona1 = personas.get(i);
					out.println("<tr>");
					out.println("<td>"+persona1.getNombre()+"</td>");			
					out.println("<td>"+persona1.getApellido()+"</td>");
					out.println("<td>"+persona1.getEdad()+"</td>");
					out.println("</tr>");
				}
				out.println("</table>");
		
	}

}
