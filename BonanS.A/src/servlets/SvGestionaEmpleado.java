package servlets;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.bonansa.beans.EmpleadoDTO;
import com.bonansa.services.EmpleadoService;

import extras.ServicioFoto;

@SuppressWarnings("serial")
@MultipartConfig(maxFileSize = 16177215)
@WebServlet("/SvGestionaEmpleado")
public class SvGestionaEmpleado extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	EmpleadoService sEmpleado=new EmpleadoService();
	ServicioFoto sFoto=new ServicioFoto();

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			String operacion=request.getParameter("operacion");
			String tipoEmpleado=request.getParameter("cboTipoEmpleado");
			String registrar=operacion+tipoEmpleado;
			
	        if(registrar.equals("registrar1")|| registrar.equals("registrar2")||registrar.equals("registrar4")){this.registrarEmpleado(request, response);}
	   else if(registrar.equals("registrar3")){this.registrarEmpleadoConductor(request, response);}
	        
	   else if(operacion.equals("actualizar")){this.actualizarEmpleado(request, response);}
	   else if(operacion.equals("actualizarEC")){this.actualizarEmpleadoConductor(request, response);}
	        
	   else if(operacion.equals("buscar")){this.buscar(request, response);}
	   else if(operacion.equals("mostrarFoto")){this.mostrarFoto(request, response);}
	   else if(operacion.equals("listar")){this.listar(request, response);}
				
			
		} catch (Exception e) {
			System.out.println("Error en el service de SvGestionaEmpleado: "+e);
		}
	}



	

	private void buscar(HttpServletRequest request, HttpServletResponse response) {
		try {
			
			String idEmpleado=request.getParameter("idEmpleado");
			String tipo=request.getParameter("tipo");
			String tipoEmpleado=request.getParameter("tipoEmpleado");
			
			EmpleadoDTO empleadoX=null;
			if (tipoEmpleado.equals("ADMINISTRADOR")||tipoEmpleado.equals("REPCECIONISTA")||tipoEmpleado.equals("ESTIBADOR")) 
			{
				empleadoX=sEmpleado.buscarEmpleado(idEmpleado);	
				
			}
			else
			{
				empleadoX=sEmpleado.buscarEmpleadoConductor(idEmpleado);
			}
		
			request.setAttribute("empleadoX", empleadoX);
			System.out.println(empleadoX.getIdEstado()+" "+empleadoX.getIdEstadoTrabajo());
			
			if (tipo.equals("A")&&tipoEmpleado.equals("ADMINISTRADOR")||tipoEmpleado.equals("REPCECIONISTA")||tipoEmpleado.equals("ESTIBADOR")) {
				request.getRequestDispatcher("paActualizarEmpleado.jsp").forward(request, response);
				
			}
			else if (tipo.equals("A")&&tipoEmpleado.equals("CONDUCTOR"))
			{
				request.getRequestDispatcher("paActualizarEmpleadoConductor.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			System.out.println("Error al buscar SvGestionaEmpleado: "+e);
		}
		
		
	}



	private void mostrarFoto(HttpServletRequest request, HttpServletResponse response) {
		
		InputStream is=null;
		try {
			    String idEmpleado=request.getParameter("idEmpleado");
			   
				is=sFoto.getFotoEmpleado(idEmpleado);
			     
				if(is!=null){
					
						byte[] bytearray = new byte[1048576];
		                int size=0;
		         
		                response.reset();
		                response.setContentType("image/jpeg");
		                while((size = is.read(bytearray)) != -1 ){
		                    response.getOutputStream().
		                    write(bytearray,0,size);
		                }
				
			    }
			
		} catch (Exception e) {
			System.out.println("Error al mostrar fotoEmpleado: "+e);
		}

		
		
	}


	private void registrarEmpleadoConductor(HttpServletRequest request, HttpServletResponse response) {
       try {
			HttpSession sesionX=request.getSession();
			
			int idTipoEmpleado=Integer.parseInt(request.getParameter("cboTipoEmpleado"));
			String numDocumento=request.getParameter("txtNumDocum");
			String nomEmpleado=request.getParameter("txtNombre");
			String apepaEmpleado=request.getParameter("txtApePa"); 
			String apemaEmpleado=request.getParameter("txtApeMa"); 
			String sexoEmpleado=request.getParameter("cboSexo");
			String fecnacEmpleado=request.getParameter("txtFechaNac"); 
			String domicilioEmpleado=request.getParameter("txtDireccion"); 
		    String ubigeoEmpleado=request.getParameter("cboDistrito");
			String fonoEmpleado=request.getParameter("txtFono");
			String celularEmpleado=request.getParameter("txtCelular"); 
			String emailEmpleado=request.getParameter("txtCorreo");
			int    idClaselic=Integer.parseInt(request.getParameter("cboClaseLicenciaConductor"));
			int    idCategorialic=Integer.parseInt(request.getParameter("cboCategoriaLicenciaConductor"));
			String licenCondEmpleado=request.getParameter("txtNumLicenciaConducir");
			byte[] fotoEmpleado=generarBytes(request, response, "txtFoto").toByteArray();
			String   ip_idEmpleadoR=(String)sesionX.getAttribute("idEmpleado");
			
			EmpleadoDTO empleado=new EmpleadoDTO(idTipoEmpleado, numDocumento, nomEmpleado, apepaEmpleado, apemaEmpleado, sexoEmpleado, fecnacEmpleado, domicilioEmpleado, ubigeoEmpleado, fonoEmpleado, celularEmpleado, emailEmpleado, fotoEmpleado, idClaselic, idCategorialic, licenCondEmpleado);
			
			int r=sEmpleado.registrarEmpleadoConductor(empleado, ip_idEmpleadoR);
			
			if (r>0) {
				
				request.getRequestDispatcher("mpAdRegistrarEmpleado.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			System.out.println("Error al registrar empleadoConductor en SvGestionarEmpleado: "+e);
		}
	}


	private void registrarEmpleado(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			
			HttpSession sesionX=request.getSession();
			
			int idTipoEmpleado=Integer.parseInt(request.getParameter("cboTipoEmpleado"));
			String numDocumento=request.getParameter("txtNumDocum");
			String nomEmpleado=request.getParameter("txtNombre");
			String apepaEmpleado=request.getParameter("txtApePa"); 
			String apemaEmpleado=request.getParameter("txtApeMa"); 
			String sexoEmpleado=request.getParameter("cboSexo");
			String fecnacEmpleado=request.getParameter("txtFechaNac"); 
			String domicilioEmpleado=request.getParameter("txtDireccion"); 
		    String ubigeoEmpleado=request.getParameter("cboDistrito");
			String fonoEmpleado=request.getParameter("txtFono");
			String celularEmpleado=request.getParameter("txtCelular"); 
			String emailEmpleado=request.getParameter("txtCorreo");
			byte[] fotoEmpleado=generarBytes(request, response, "txtFoto").toByteArray();
			String   ip_idEmpleadoR=(String)sesionX.getAttribute("idEmpleado");
			
			
			EmpleadoDTO empleado=new EmpleadoDTO(idTipoEmpleado, numDocumento, nomEmpleado, apepaEmpleado, apemaEmpleado, sexoEmpleado, fecnacEmpleado, domicilioEmpleado, ubigeoEmpleado, fonoEmpleado, celularEmpleado, emailEmpleado, fotoEmpleado);
			
			int r=sEmpleado.registrarEmpleado(empleado, ip_idEmpleadoR);
			
			if (r>0) {
				request.setAttribute("mensaje", "Empleado registrado correctamente");
				request.getRequestDispatcher("mpAdRegistrarEmpleado.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			System.out.println("Error al registrar empleado en SvGestionarEmpleado: "+e);
		}
	}
	
	
private void actualizarEmpleadoConductor(HttpServletRequest request,HttpServletResponse response) 
{
	
	try {
		
		//Capturamos parametros
		HttpSession sesionX=request.getSession();
		
		String idEmpleado=request.getParameter("txtIdEmpleado");
		String numDocumento=request.getParameter("txtNumDocumento");
		String nomEmpleado=request.getParameter("txtNombre");
		String apepaEmpleado=request.getParameter("txtApePa");
		String apemaEmpleado=request.getParameter("txtApeMa");
		String sexoEmpleado=request.getParameter("cboSexo");
		String fecnacEmpleado=request.getParameter("txtFecNac");
		String domicilioEmpleado=request.getParameter("txtDireccion");
		String ubigeoEmpleado=request.getParameter("txtUbigeo");
		String fonoEmpleado=request.getParameter("txtFono");
		String celularEmpleado=request.getParameter("txtCelular");
		String emailEmpleado=request.getParameter("txtEmail");
        byte[] fotoEmpleado=generarBytes(request, response, "txtFoto").toByteArray();
        String licenCondEmpleado=request.getParameter("txtLicenCond");
        int idClaselic=Integer.parseInt(request.getParameter("cboClaseLicenciaConductor"));
        int idCategorialic=Integer.parseInt(request.getParameter("cboCategoriaLicenciaConductor"));
		String idEstadoTrabajo=request.getParameter("cboEstadoTrabajo");
		String idEstado=request.getParameter("cboEstado");

		String   ip_idEmpleadoR=(String)sesionX.getAttribute("idEmpleado");


		EmpleadoDTO empleado=new EmpleadoDTO(
											idEmpleado, 
											numDocumento, 
											nomEmpleado, 
											apepaEmpleado, 
											apemaEmpleado, 
											sexoEmpleado, 
											fecnacEmpleado, 
											domicilioEmpleado, 
											ubigeoEmpleado, 
											fonoEmpleado, 
											celularEmpleado, 
											emailEmpleado,
											fotoEmpleado,
											licenCondEmpleado,
											idClaselic,
											idCategorialic,
											idEstadoTrabajo,
											idEstado
											); 
		
		
	int r=sEmpleado.actualizarEmpleadoConductor(empleado, ip_idEmpleadoR);
	
	
	if (r>0) 
	{
	    request.setAttribute("mensaje", "Empleado Conductor actualizado correctamente");	
	}
	else
	{
		request.setAttribute("mensaje", "Error al actualizar empleado conductor");	
	}	
	request.getRequestDispatcher("paActualizarEmpleadoConductor.jsp").forward(request, response);	
	
	} catch (Exception e) {
		System.out.println("Error al actualizarEmpleadoConductor SvGestionaEmpleado: "+e);
	}
		
		
	}



	private void actualizarEmpleado(HttpServletRequest request, HttpServletResponse response) {
		try {
			
			//Capturamos parametros
			HttpSession sesionX=request.getSession();
			
			String idEmpleado=request.getParameter("txtIdEmpleado");
			String numDocumento=request.getParameter("txtNumDocumento");
			String nomEmpleado=request.getParameter("txtNombre");
			String apepaEmpleado=request.getParameter("txtApePa");
			String apemaEmpleado=request.getParameter("txtApeMa");
			String sexoEmpleado=request.getParameter("cboSexo");
			String fecnacEmpleado=request.getParameter("txtFecNac");
			String domicilioEmpleado=request.getParameter("txtDireccion");
			String ubigeoEmpleado=request.getParameter("txtUbigeo");
			String fonoEmpleado=request.getParameter("txtFono");
			String celularEmpleado=request.getParameter("txtCelular");
			String emailEmpleado=request.getParameter("txtEmail");
            byte[] fotoEmpleado=generarBytes(request, response, "txtFoto").toByteArray();
			String idEstadoTrabajo=request.getParameter("cboEstadoTrabajo");
			String idEstado=request.getParameter("cboEstado");

			String   ip_idEmpleadoR=(String)sesionX.getAttribute("idEmpleado");
			

			EmpleadoDTO empleado=new EmpleadoDTO(
												idEmpleado, 
												numDocumento, 
												nomEmpleado, 
												apepaEmpleado, 
												apemaEmpleado, 
												sexoEmpleado, 
												fecnacEmpleado, 
												domicilioEmpleado, 
												ubigeoEmpleado, 
												fonoEmpleado, 
												celularEmpleado, 
												emailEmpleado,
												fotoEmpleado, 
												idEstadoTrabajo,
												idEstado
												); 
			
			
		int r=sEmpleado.actualizarEmpleado(empleado, ip_idEmpleadoR);
		
		
		if (r>0) 
		{
		    request.setAttribute("mensaje", "Empleado actualizado correctamente");	
		}
		else
		{
			request.setAttribute("mensaje", "Error al actualizar empleado");	
		}	
		request.getRequestDispatcher("paActualizarEmpleado.jsp").forward(request, response);	
		
		} catch (Exception e) {
			System.out.println("Error al actualizarEmpleado SvGestionaEmpleado: "+e);
		}
		
	}


	

	private void listar(HttpServletRequest request, HttpServletResponse response) {
		try {
			ArrayList<EmpleadoDTO> listadoEmpleados=sEmpleado.listarEmpleado();
			HttpSession sesionX=request.getSession();
			sesionX.setAttribute("listadoEmpleados", listadoEmpleados);
			request.getRequestDispatcher("paListarEmpleado.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println("Error al listarEmpleados SvGestionaEmpleado: "+e);
		}
	}

	
	
	
	private ByteArrayOutputStream generarBytes(HttpServletRequest request,HttpServletResponse response, String input){
		
		ByteArrayOutputStream bos=null;
		try {
			
			InputStream inputStream = null; 
	        Part filePart = request.getPart(input);
	        if (filePart != null) {
	            inputStream = filePart.getInputStream();
	            bos = new ByteArrayOutputStream();
	            byte[] tmp = new byte[4096];
	            int ret = 0;

	            while((ret = inputStream.read(tmp)) > 0)
	            {
	                bos.write(tmp, 0, ret);
	            }   
	        }
			
		} catch (Exception e) {
			System.out.println("Error al generarBytes de las fotos: "+e);
		}

		return bos;
	}


}
