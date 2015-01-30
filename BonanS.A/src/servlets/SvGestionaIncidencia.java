package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bonansa.beans.IncidenciaDTO;
import com.bonansa.services.IncidenciaService;

/**
 * Servlet implementation class SvGestionaIncidencia
 */
@WebServlet("/SvGestionaIncidencia")
public class SvGestionaIncidencia extends HttpServlet {
	private static final long serialVersionUID = 1L;


	IncidenciaService servicioIncidencia=new IncidenciaService();
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
       String operacion=request.getParameter("operacion");
       
       if (operacion.equals("registrar")) 
       {
		this.registrar(request, response);
       }
       if (operacion.equals("actualizar")) 
       {
		this.actualizar(request, response);
       }
       else if(operacion.equals("listar"))
       {
    	this.listar(request, response);   
       }
    
    
	}


	private void actualizar(HttpServletRequest request,HttpServletResponse response) 
	{
		try 
		{
			   String  idIncidencia=request.getParameter("txtIdIncidencia");
			   String  idEmpleado=request.getParameter("txtIdEmpleado");
			   String  direccion=request.getParameter("txtDireccion");
			   String  descripcion=request.getParameter("txtDescripcion");
			   String  fecha=request.getParameter("txtFecha");
			   String  hora=request.getParameter("txtHora");
			   String  idEstadoIncidencia=request.getParameter("cboEstadoIncidencia");
			
			   
			   HttpSession sesionX=request.getSession();
			   String   idEmpleadoR=(String)sesionX.getAttribute("idEmpleado");

			   
			IncidenciaDTO incidencia=new IncidenciaDTO();
			incidencia.setIdIncidencia(idIncidencia);
			incidencia.setIdEmpleado(idEmpleado);
			incidencia.setDireccion(direccion);
			incidencia.setDescripcion(descripcion);
			incidencia.setFecha(fecha);
			incidencia.setHora(hora);
			incidencia.setIdEstadoIncidencia(idEstadoIncidencia);
			
			int r=servicioIncidencia.actualizarIncidencia(incidencia, idEmpleadoR);
			
			if(r>0)
			{
				request.setAttribute("mensaje", "Incidencia actualizada correctamente");
			}
			else
			{
				request.setAttribute("mensaje", "Error al actualizar Incidencia");

			}
			
			String  nivel=request.getParameter("nivel");
			if (nivel.equals("RECEPCIONISTA")) 
			{
				request.getRequestDispatcher("prActualizarIncidencias.jsp").forward(request, response);

			}
			else if(nivel.equals("ADMINISTRADOR"))
			{
				request.getRequestDispatcher("paActualizarIncidencias.jsp").forward(request, response);

			}
			
			
		}
		catch (Exception e) 
		{
			System.out.println("Error -->actualizar() SvGestionaIncidencia: "+e);
		}
	}


	private void listar(HttpServletRequest request, HttpServletResponse response) 
	{
		
		try 
		{			
			String nivel=request.getParameter("nivel");
			
			ArrayList<IncidenciaDTO> listadoIncidencias=servicioIncidencia.listarIncidencias();
			request.getSession().setAttribute("s_listadoIncidencias", listadoIncidencias);
			if (nivel.equals("ADMINISTRADOR")) 
			{
			request.getRequestDispatcher("paListarIncidencias.jsp").forward(request, response);
			}
			else if(nivel.equals("RECEPCIONISTA"))
			{
			request.getRequestDispatcher("prListarIncidencias.jsp").forward(request, response);
			}
			
		}
		catch (Exception e) 
		{
			
		}
		
	}


	private void registrar(HttpServletRequest request,	HttpServletResponse response)
	{
	
		try 
		{
			
			String idEmpleado=request.getParameter("txtIdEmpleado");
			String direccion=request.getParameter("txtDireccion");
			String descripcion=request.getParameter("txtDescripcion");
			
			IncidenciaDTO incidencia=new IncidenciaDTO();
			incidencia.setIdEmpleado(idEmpleado);
			incidencia.setDireccion(direccion);
			incidencia.setDescripcion(descripcion);
			
			int r=servicioIncidencia.registrarIncidencia(incidencia);
			
			if(r>0)
			{
				request.setAttribute("mensaje", "Incidencia registrada correctamente");
			}
			else
			{
				request.setAttribute("mensaje", "Error al registrar Incidencia");

			}
			
			request.getRequestDispatcher("pcRegistrarIncidencias.jsp").forward(request, response);
			
			
		}
		catch (Exception e) 
		{
			System.out.println("Error en registrar(): "+e);
		}
	}

}
