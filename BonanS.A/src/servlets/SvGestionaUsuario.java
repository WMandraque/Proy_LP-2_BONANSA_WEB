package servlets;

import java.io.IOException;
import java.util.ArrayList;

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
		else if(operacion.equals("registrar")){this.registrar(request, response);}
		else if(operacion.equals("actualizar")){this.actualizar(request, response);}
		else if(operacion.equals("eliminar")){this.eliminar(request, response);}     
		else if(operacion.equals("listar")){this.listar(request, response);}
		else if(operacion.equals("buscar")){this.buscar(request, response);}
		else if(operacion.equals("salir")){	this.salir(request, response);}
		
	}
	


	private void registrar(HttpServletRequest request, HttpServletResponse response)
	{
		try {
			
			

			String idEmpleado=request.getParameter("txtIdUsuario");
			String clave=request.getParameter("txtClave");
			String idRol=request.getParameter("cboRolUsuario");
			
			HttpSession sesionX=request.getSession();
			String   ip_idEmpleadoR=(String)sesionX.getAttribute("idEmpleado");
		    UsuarioDTO usuarioX=new UsuarioDTO(idEmpleado, clave, idRol);
			int r=sUsuario.registrarUsurio(usuarioX, ip_idEmpleadoR);
			
			if(r>0)
			{
			request.setAttribute("mensaje", "Usuario registrado correctamente: "+idEmpleado);
			}
			else
			{
				request.setAttribute("mensaje", "Error al registrar usuario: "+idEmpleado);	
			}
			request.getRequestDispatcher("paRegistrarUsuario.jsp").forward(request, response);	
			
		} catch (Exception e) {
			System.out.println("Error al registrar usuario svGestionaUsuario: "+e);
		}
	}

	
	private void actualizar(HttpServletRequest request, HttpServletResponse response) 
	{
		try {
			
			String idUsuario=request.getParameter("txtIdUsuario");
			String clave=request.getParameter("txtClave");
			String idRol=request.getParameter("cboRolUsuario");
			String idEstado=request.getParameter("cboEstado");
			
			HttpSession sesionX=request.getSession();
			String   ip_idEmpleadoR=(String)sesionX.getAttribute("idEmpleado");
			
			
			UsuarioDTO usuarioX=new UsuarioDTO();
			usuarioX.setIdEmpleado(idUsuario);
			usuarioX.setClave(clave);
			usuarioX.setIdRol(idRol);
			usuarioX.setIdEstado(idEstado);
			
			int r=sUsuario.actualizarUsuario(usuarioX, ip_idEmpleadoR);
			
			if(r>0)
			{
			request.setAttribute("mensaje", "Usuario actualizado correctamente: "+idUsuario);	
			}
			else{
				request.setAttribute("mensaje", "Error al actualizar usuario: "+idUsuario);	
			}
			request.getRequestDispatcher("paActualizarUsuario.jsp").forward(request, response);
			
		} catch (Exception e) {
			System.out.println("Error al actualizarUsuario SvGestionaUsuario: "+e);
		}
	
		
	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response) 
	{
			try {
				
				String idUsuario=request.getParameter("txtIdUsuario");
				
				HttpSession sesionX=request.getSession();
				String   ip_idEmpleadoR=(String)sesionX.getAttribute("idEmpleado");
				
				int r=sUsuario.eliminarUsuario(idUsuario, ip_idEmpleadoR);
				
				if(r>0)
				{
				request.setAttribute("mensaje", "Usuario eliminado correctamente: "+idUsuario);	
				}
				else{
					request.setAttribute("mensaje", "Error al eliminar usuario: "+idUsuario);	
				}
				request.getRequestDispatcher("paEliminarUsuario.jsp").forward(request, response);
				
			} catch (Exception e) {
				System.out.println("Error al eliminarUsuario SvGestionaUsuario: "+e);
			}
			
		
	}



	private void listar(HttpServletRequest request, HttpServletResponse response) 
	{
		try {
			ArrayList<UsuarioDTO> listadoUsuarios=sUsuario.listarUsuarios();
			HttpSession sesionX=request.getSession();
			sesionX.setAttribute("listadoUsuarios", listadoUsuarios);
			request.getRequestDispatcher("paListarUsuarios.jsp").forward(request, response);
			
		} catch (Exception e) {
			System.out.println("Error al listarUsuario SvGestionaUsuario: "+e);
		}	
	}

	
	private void buscar(HttpServletRequest request, HttpServletResponse response) 
	{
	
		try {
			
			String idUsuario=request.getParameter("idEmpleado");
			String tipo=request.getParameter("tipo");
			UsuarioDTO usuarioX=sUsuario.buscarUsuario(idUsuario);
			request.setAttribute("usuarioX", usuarioX);
			if (tipo.equals("A"))
			{
				request.getRequestDispatcher("paActualizarUsuario.jsp").forward(request, response);	
			}
	        else if(tipo.equals("E"))
	        {
	        	request.getRequestDispatcher("paEliminarUsuario.jsp").forward(request, response);	
	        }
			
			
		} catch (Exception e) {
			System.out.println("Error al buscarUsuario SvGestionaUsuario: "+e);
		}
		
	}
	
	

	private void validarUsuario(HttpServletRequest request, HttpServletResponse response) 
	{
		
		
			try {
				
					String idEmpleado=request.getParameter("txtIdEmpleado");
					String clave=request.getParameter("txtClave");
					
					UsuarioDTO usuarioX=sUsuario.validarUsuario(idEmpleado, clave);
					
					if (usuarioX!=null) {
						
						String nombreCompleto=usuarioX.getNomEmpleado()+" "+usuarioX.getApepaEmpleado()+" "+usuarioX.getApemaEmpleado();
						
						HttpSession sesionX=request.getSession();
						
						sesionX.setAttribute("idEmpleado", usuarioX.getIdEmpleado());
						sesionX.setAttribute("nombreCompleto", nombreCompleto);
						sesionX.setAttribute("tipoEmpleado", usuarioX.getDescRol());
						
						if (usuarioX.getDescRol().equals("ADMINISTRADOR") && usuarioX.getDescEstado().equals("ACTIVO")) {
							request.getRequestDispatcher("mpAdministrador.jsp").forward(request, response);
						}
						else if(usuarioX.getDescRol().equals("RECEPCIONISTA") && usuarioX.getDescEstado().equals("ACTIVO")){
							
							request.getRequestDispatcher("mpRecepcionista.jsp").forward(request, response);
						}
						else if(usuarioX.getDescRol().equals("CONDUCTOR") && usuarioX.getDescEstado().equals("ACTIVO")){
							request.getRequestDispatcher("mpConductor.jsp").forward(request, response);
						}
						
						else
						{
							request.setAttribute("mensaje", "Cuenta desactivada, consultar con el administrador");
							request.getRequestDispatcher("logueo.jsp").forward(request, response);
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
	
	private void salir(HttpServletRequest request, HttpServletResponse response) 
	{
			
			try {
				
				
				HttpSession miSesion=request.getSession();
				miSesion.invalidate();
				request.getRequestDispatcher("logueo.jsp").forward(request, response);
				
				
			} catch (Exception e) {
			
				System.out.println("Error al cerrar sesion: "+e);
			}
			
	}


}
