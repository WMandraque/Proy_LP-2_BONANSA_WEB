package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bonansa.beans.UsuarioDTO;
import com.bonansa.services.UsuarioService;

/**
 * Servlet implementation class SvGestionaUsuario
 */
@WebServlet("/SvGestionaUsuario")
public class SvGestionaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;


	UsuarioService sUsuario=new UsuarioService();
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String operacion=request.getParameter("operacion");
		
		     if(operacion.equals("validar")) {this.validarUsuario(request, response);}
		else if(operacion.equals("salir")){	this.salir(request, response);}
		
	}

	private void salir(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			
			
			request.getRequestDispatcher("logueo.jsp").forward(request, response);
			
			
		} catch (Exception e) {
		
			System.out.println("Error al cerrar sesion: "+e);
		}
		
	}

	private void validarUsuario(HttpServletRequest request, HttpServletResponse response) {
		
		
		try {
			
			String idEmpleado=request.getParameter("txtIdEmpleado");
			String clave=request.getParameter("txtClave");
			
			UsuarioDTO usuarioX=sUsuario.validarUsuario(idEmpleado, clave);
			
			if (usuarioX!=null) {
				
				String nombreCompleto=usuarioX.getNomEmpleado()+" "+usuarioX.getApepaEmpleado()+" "+usuarioX.getApemaEmpleado();
				
				HttpSession sesionX=request.getSession();
				
				sesionX.setAttribute("idEmpleado", usuarioX.getIdEmpleado());
				sesionX.setAttribute("nombreCompleto", nombreCompleto);
				sesionX.setAttribute("tipoEmpleado", usuarioX.getNomCargo());
				if (usuarioX.getIdTipoEmpleado().equals("1")) {
					request.getRequestDispatcher("mpAdministrador.jsp").forward(request, response);
				}
				else if(usuarioX.getIdTipoEmpleado().equals("2")){
					
					request.getRequestDispatcher("mpRecepcionista.jsp").forward(request, response);
				}
				else if(usuarioX.getIdTipoEmpleado().equals("3")){
					request.getRequestDispatcher("mpConductor.jsp").forward(request, response);
				}
	
			}
			else {
				request.setAttribute("mensaje", "Datos ingresados incorrectos");
				request.getRequestDispatcher("logueo.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			System.out.println("Error Servlet al validar usuario: "+e);
		}
		
	}

}
