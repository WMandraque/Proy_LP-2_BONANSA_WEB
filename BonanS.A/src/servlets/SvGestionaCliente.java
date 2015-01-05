package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bonansa.beans.ClienteDTO;
import com.bonansa.services.ClienteService;
import com.google.gson.Gson;

/**
 * Servlet implementation class SvGestionaCliente
 */
@WebServlet("/SvGestionaCliente")
public class SvGestionaCliente extends HttpServlet {
	Gson obJson=new Gson();
	private static final long serialVersionUID = 1L;

	private List<String> listaDireccion=new ArrayList<String>();
	
	ClienteService sCliente=new ClienteService();
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			
			String operacion=request.getParameter("operacion");
			//int tipoCliente=Integer.parseInt(request.getParameter("cboTipoCliente"));
			
			//String registrar=operacion+tipoCliente;
			String registrar=operacion;
			switch (registrar) {
			
			case "registrar1":
				this.registrarClienteJuridico(request, response);
				break;
			case "registrar2":
				this.registrarClienteNatural(request, response);
				break;
			case "registrar3":
				this.agregarDireccion(request, response);
				break;
			case "listar":
				this.listarClientes(request, response);
			}
			
			
		} catch (Exception e) {
			System.out.println("Error el el service SvGestionaCliente: "+e);
		}
		
	}


	private void listarClientes(HttpServletRequest request, HttpServletResponse response) 
	{
				try {
					ArrayList<ClienteDTO> listadoClientes=sCliente.listarCliente();
					HttpSession sesionX=request.getSession();
					sesionX.setAttribute("listadoClientes", listadoClientes);
					request.getRequestDispatcher("paListarClientes.jsp").forward(request, response);
				} catch (Exception e) {
					System.out.println("Error al listar Clientes SvGestionaCliente: "+e);
				}
		
	}


	private void registrarClienteJuridico(HttpServletRequest request, HttpServletResponse response) {
		try {
			

			int    idTipoCliente=Integer.parseInt(request.getParameter("cboTipoCliente"));
			String nomCliente=request.getParameter("txtNombre");
			String apePatCliente=request.getParameter("txtApePa"); 
			String apeMatCliente=request.getParameter("txtApeMa"); 
			String fecNacCliente=request.getParameter("txtFechaNac"); 
			String sexoCliente=request.getParameter("cboSexo"); 
			String telefonoCliente=request.getParameter("txtFono"); 
			String celularCliente=request.getParameter("txtCelular"); 
			String correoCliente=request.getParameter("txtCorreo");
			String numDocumento=request.getParameter("txtNumRUC");
			String razSocCliente=request.getParameter("txtRazonSocial");
			String ciiuCliente=request.getParameter("txtCIUU");
			String cargoContacCliente=request.getParameter("txtCargo");
			
			HttpSession sesionX=request.getSession();
			String   ip_idEmpleadoR=(String)sesionX.getAttribute("idEmpleado");

		
            ClienteDTO clienteJuridico=new ClienteDTO(idTipoCliente, nomCliente, apePatCliente, apeMatCliente, fecNacCliente, sexoCliente, telefonoCliente, celularCliente, correoCliente, numDocumento, razSocCliente, ciiuCliente, cargoContacCliente);			
			
            
            int r=sCliente.registrarClienteJuridico(clienteJuridico, ip_idEmpleadoR);
            
            if (r>0) {
				
            	request.getRequestDispatcher("paRegistrarCliente.jsp").forward(request, response);
			}
            
		} catch (Exception e) {
			System.out.println("Error en registrarClienteJuridico SvGestionaCliente: "+e);		}
		
	}


	private void registrarClienteNatural(HttpServletRequest request,HttpServletResponse response) {
		
		try {
			
			
			int    idTipoCliente=Integer.parseInt(request.getParameter("cboTipoCliente"));
			String nomCliente=request.getParameter("txtNombre");
			String apePatCliente=request.getParameter("txtApePa"); 
			String apeMatCliente=request.getParameter("txtApeMa"); 
			String fecNacCliente=request.getParameter("txtFechaNac"); 
			String sexoCliente=request.getParameter("cboSexo"); 
			String telefonoCliente=request.getParameter("txtFono"); 
			String celularCliente=request.getParameter("txtCelular"); 
			String correoCliente=request.getParameter("txtCorreo");
			String numDni=request.getParameter("txtNumDNI");

			HttpSession sesionX=request.getSession();
			String   ip_idEmpleadoR=(String)sesionX.getAttribute("idEmpleado");
			
			ClienteDTO clienteNatural=new ClienteDTO(idTipoCliente, nomCliente, apePatCliente, apeMatCliente, fecNacCliente, sexoCliente, telefonoCliente, celularCliente, correoCliente, numDni);
		
			
			int r=sCliente.registrarClienteNatural(clienteNatural, ip_idEmpleadoR);
			
			if (r>0) {
				
				request.getRequestDispatcher("paRegistrarCliente.jsp").forward(request, response);
			}
			

			
			
			
			
			
			
		} catch (Exception e) {
			System.out.println("Error en registrarClienteNatural SvGestionaCliente: "+e);
		}
		
		
	}
	
	@SuppressWarnings("unchecked")
	private void agregarDireccion(HttpServletRequest request,HttpServletResponse response)
	{
		HttpSession misession=request.getSession();
		if(misession.getAttribute("listaDirecciones")==null)
		{
			misession.setAttribute("listaDirecciones", listaDireccion);
		}
		else
		{
			listaDireccion=(List<String>)misession.getAttribute("listaDirecciones");
		}
		String direccionEnviada=request.getParameter("txtDireccion");
		listaDireccion.add(direccionEnviada); //<ADD
		misession.setAttribute("listaDirecciones", listaDireccion);
		String json=obJson.toJson(listaDireccion);
		PrintWriter out;
		try {
			out = response.getWriter();
			out.println(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
