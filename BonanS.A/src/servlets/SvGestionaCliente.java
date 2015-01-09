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
	
	private static final long serialVersionUID = 1L;

	Gson obJson=new Gson();
	private List<ClienteDTO> listaDireccion=new ArrayList<ClienteDTO>();
	ClienteService sCliente=new ClienteService();
	int r=0;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			
			String operacion=request.getParameter("operacion");
			String tipoCliente=request.getParameter("cboTipoCliente");
			if (tipoCliente==null){tipoCliente="";}
		    operacion=operacion+tipoCliente;
		    
			switch (operacion) 
			{
				case "registrar1":
					this.registrarClienteJuridico(request, response);
					break;
				case "registrar2":
					this.registrarClienteNatural(request, response);
					break;
				case "actualizar1":
					this.ActualizarClienteJuridico(request, response);
					break;
				case "actualizar2":
					this.ActualizarClienteNatural(request, response);
					break;
				case "eliminar":
					this.eliminarCliente(request, response);
					break;
				case "buscar":
					this.buscar(request, response);
					break;
				case "listar":
					this.listarClientes(request, response);
					break;
				case "agregarDireccion":
					this.agregarDireccion(request, response);
					break;
				case "eliminarDireccion":
					this.eliminarDireccion(request, response);
					break;	
				case "limpiarDirecciones":
					this.limpiarDirecciones(request, response);
					break;
			}
			
			
		} catch (Exception e) {
			System.out.println("Error el el service SvGestionaCliente: "+e);
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
			
            
            int r=sCliente.registrarClienteJuridico(clienteJuridico, ip_idEmpleadoR, listaDireccion);
            if (r>0) 
			{
			request.setAttribute("mensaje", "Cliente juridico registrado correctamente");	
			}
			else
			{
				request.setAttribute("mensaje", "Error al registrar Cliente juridico");		
			}
			request.getRequestDispatcher("paRegistrarCliente.jsp").forward(request, response);
            
		} 
		catch (Exception e) 
		{
			System.out.println("Error en registrarClienteJuridico SvGestionaCliente: "+e);		
		}
		finally
		{
		listaDireccion.clear();	
		}
		
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
		
			
			
			
			int r=sCliente.registrarClienteNatural(clienteNatural, ip_idEmpleadoR, listaDireccion);
			
			if (r>0) 
			{
			request.setAttribute("mensaje", "Cliente Natural registrado correctamente");	
			}
			else
			{
				request.setAttribute("mensaje", "Error al registrar Cliente Natural");		
			}
			request.getRequestDispatcher("paRegistrarCliente.jsp").forward(request, response);

		} catch (Exception e) {
			System.out.println("Error en registrarClienteNatural SvGestionaCliente: "+e);
		}finally{
			listaDireccion.clear();
		}
		
		
		
	}
	
	



	private void ActualizarClienteJuridico(HttpServletRequest request, HttpServletResponse response) {
		
		try 
		  {
			    String idCliente=request.getParameter("txtIdCliente");
				String nomCliente=request.getParameter("txtNombre");
				String apePatCliente=request.getParameter("txtApePa"); 
				String apeMatCliente=request.getParameter("txtApeMa"); 
				String fecNacCliente=request.getParameter("txtFechaNac"); 
				String sexoCliente=request.getParameter("cboSexo"); 
				String telefonoCliente=request.getParameter("txtFono"); 
				String celularCliente=request.getParameter("txtCelular"); 
				String correoCliente=request.getParameter("txtCorreo");
				String numDocumento=request.getParameter("txtNumRUC");
				String idEstado=request.getParameter("cboEstado");
				
				String razSocCliente=request.getParameter("txtRazonSocial");
				String ciiuCliente=request.getParameter("txtCIUU");
				String cargoContacCliente=request.getParameter("txtCargo");

				HttpSession sesionX=request.getSession();
				String   ip_idEmpleadoR=(String)sesionX.getAttribute("idEmpleado");
				
				ClienteDTO clienteX=new ClienteDTO(idCliente, nomCliente, apePatCliente, apeMatCliente, fecNacCliente, sexoCliente, telefonoCliente, celularCliente, correoCliente, numDocumento, idEstado, razSocCliente, ciiuCliente, cargoContacCliente);
			
				r=sCliente.actualizarClienteJuridico(clienteX, ip_idEmpleadoR, listaDireccion);
						
				if (r>0) 
				{
				request.setAttribute("mensaje", "Cliente Juridico actualizado correctamente");	
				}
				else
				{
					request.setAttribute("mensaje", "Error al actualizar Cliente Juridico");		
				}
				listaDireccion.clear(); 
				request.getRequestDispatcher("paActualizarClienteJuridico.jsp").forward(request, response);
		  }
		  catch (Exception e) 
		  {
			  System.out.println("Error al actualizar cliente Juridico: "+e);
		  }
		  finally
		  {
		  listaDireccion.clear();  
		  }
		
	}



	
	
	private void ActualizarClienteNatural(HttpServletRequest request,HttpServletResponse response) 
	{
		  try 
		  {
			    String idCliente=request.getParameter("txtIdCliente");
				String nomCliente=request.getParameter("txtNombre");
				String apePatCliente=request.getParameter("txtApePa"); 
				String apeMatCliente=request.getParameter("txtApeMa"); 
				String fecNacCliente=request.getParameter("txtFechaNac"); 
				String sexoCliente=request.getParameter("cboSexo"); 
				String telefonoCliente=request.getParameter("txtFono"); 
				String celularCliente=request.getParameter("txtCelular"); 
				String correoCliente=request.getParameter("txtCorreo");
				String numDni=request.getParameter("txtNumDNI");
				String idEstado=request.getParameter("cboEstado");

				HttpSession sesionX=request.getSession();
				String   ip_idEmpleadoR=(String)sesionX.getAttribute("idEmpleado");
				
				ClienteDTO clienteX=new ClienteDTO(idCliente, nomCliente, apePatCliente, apeMatCliente, fecNacCliente, sexoCliente, telefonoCliente, celularCliente, correoCliente, numDni, idEstado);
			
				r=sCliente.actualizarClienteNatural(clienteX, ip_idEmpleadoR, listaDireccion);
						
				if (r>0) 
				{
				request.setAttribute("mensaje", "Cliente Natural actualizado correctamente");	
				}
				else
				{
					request.setAttribute("mensaje", "Error al actualizar Cliente Natural");		
				}
				listaDireccion.clear(); 
				request.getRequestDispatcher("paActualizarClienteNatural.jsp").forward(request, response);
		  }
		  catch (Exception e) 
		  {
			  System.out.println("Error al actualizar cliente natural: "+e);
		  }
		  finally
		  {
		  listaDireccion.clear();  
		  }
	}
	

	private void eliminarCliente(HttpServletRequest request, HttpServletResponse response) 
	{
		
		try 
		{
			 String idCliente=request.getParameter("txtIdCliente");
			 HttpSession sesionX=request.getSession();
			 String   ip_idEmpleadoR=(String)sesionX.getAttribute("idEmpleado");
			 
			 int r=sCliente.eliminarCliente(idCliente, ip_idEmpleadoR);
			 if(r>0)
			 {
			 request.setAttribute("mensaje", "Cliente eliminado correctamente: "+idCliente);	 
			 }
			 else
			 {
			 request.setAttribute("mensaje", "Error al eliminar cliente: "+idCliente);	 
			 }
			 request.getRequestDispatcher("paEliminarClienteNatural.jsp").forward(request, response);
		} 
		catch (Exception e) 
		{
			System.out.println("Error al eliminarCliente SvGestionaCliente: "+e);
		}
	}


	private void buscar(HttpServletRequest request, HttpServletResponse response) 
	{
		
		 try 
		  {
			 
			 String idCliente=request.getParameter("idCliente");
			 String tipo=request.getParameter("tipo");
			 String descTipoCliente=request.getParameter("descTipoCliente");
			
			 HttpSession sesionX=request.getSession();
			 ClienteDTO clienteX=null;
			 if (descTipoCliente.equals("NATURAL")) 
			 {
				 clienteX=sCliente.buscarClienteNatural(idCliente);	
			 }
			 else
			 {
				 clienteX=sCliente.buscarClienteJuridico(idCliente);
			 }
			
			 if(clienteX!=null)
			 {
				 listaDireccion.clear();
				 listaDireccion=sCliente.listarDirecciones(idCliente);
				 request.setAttribute("clienteX", clienteX);
				 
			 }
			 
			 if (tipo.equals("A")&&descTipoCliente.equals("NATURAL")) 
			 {
			 sesionX.setAttribute("listaDireccion", listaDireccion);
			 request.getRequestDispatcher("paActualizarClienteNatural.jsp").forward(request, response);	
		     }
			 else if(tipo.equals("A")&&descTipoCliente.equals("JURIDICO"))
			 {
			 sesionX.setAttribute("listaDireccion", listaDireccion);
			 request.getRequestDispatcher("paActualizarClienteJuridico.jsp").forward(request, response);	 
			 }
			 if (tipo.equals("E")&&descTipoCliente.equals("NATURAL")) 
			 {
			 request.setAttribute("listaDireccion", listaDireccion);
			 request.getRequestDispatcher("paEliminarClienteNatural.jsp").forward(request, response);	
		     }
			 else if(tipo.equals("E")&&descTipoCliente.equals("JURIDICO"))
			 {
			 request.setAttribute("listaDireccion", listaDireccion);
			 request.getRequestDispatcher("paEliminarClienteJuridico.jsp").forward(request, response);	 
			 }
			  
			 String json=obJson.toJson(listaDireccion);
			 PrintWriter out;
			 out = response.getWriter();
			 out.println(json);
			
		  }
		  catch (Exception e) 
		  {
			  System.out.println("Error al actualizar cliente natural: "+e);
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

	
	
	@SuppressWarnings("unchecked")
	private void agregarDireccion(HttpServletRequest request,HttpServletResponse response)
	{
	
	try {
		
		HttpSession misession=request.getSession();
		
		if(misession.getAttribute("listaDirecciones")==null)
		{
			misession.setAttribute("listaDireccion", listaDireccion);
		}
		else
		{
			listaDireccion=(List<ClienteDTO>)misession.getAttribute("listaDireccion");
		}
		System.out.println("Llego!!");
		//Capturamos que tipo de operacion engloba la operacion agregarDireccion
		String tipo=request.getParameter("tipo");
		
		if (tipo.equals("Update")) 
		{
			
			String descTipoEstablec=request.getParameter("descTipoEstablec");
			int idTipoEstablec=Integer.parseInt(request.getParameter("idTipoEstablec"));
			String codubigeoDirecCliente=request.getParameter("ubigeo");
			String direcDirecCliente=request.getParameter("direcCliente");
			
			
			ClienteDTO cliente=new ClienteDTO();
			cliente.setDescTipoEstablec(descTipoEstablec);
			cliente.setIdTipoEstablec(idTipoEstablec);
			cliente.setCodubigeoDirecCliente(codubigeoDirecCliente);
			cliente.setDirecDirecCliente(direcDirecCliente);
			System.out.println("En el object cli: "+cliente.getIdTipoEstablec());
			listaDireccion.add(cliente);
			
			misession.setAttribute("listaDireccion", listaDireccion);
			String json=obJson.toJson(listaDireccion);
			PrintWriter out;
			
				out = response.getWriter();
				out.println(json);
			
		}
		else if (tipo.equals("Insert")) 
		{
			String direcDirecCliente=request.getParameter("direcCliente");
			String codubigeoDirecCliente=request.getParameter("ubigeo");
			int idTipoEstablec=Integer.parseInt(request.getParameter("idTipoEstablec"));
			
			listaDireccion.add(new ClienteDTO(direcDirecCliente, codubigeoDirecCliente, idTipoEstablec));
			misession.setAttribute("listaDireccion", listaDireccion);
			String json=obJson.toJson(listaDireccion);
			PrintWriter out;
			
				out = response.getWriter();
				out.println(json);
					
		}
		
		} catch (Exception e) {
			System.out.println("Error al agregar direcciones: "+e);
		}

	}
	



	private void eliminarDireccion(HttpServletRequest request,HttpServletResponse response) 
	{
		
		try 
		{//
		    String direccion=request.getParameter("direccion");
			for (int i = 0; i < listaDireccion.size(); i++) {
				if (listaDireccion.get(i).getDirecDirecCliente().equals(direccion)) {
					
					listaDireccion.remove(i);
				}
			}
			
		}// 
		catch (Exception e) 
		{
		System.out.println("Error al eliminarDireccion: "+e);	
		}

	}

	
	

	private void limpiarDirecciones(HttpServletRequest request, HttpServletResponse response) 
	{
			try 
			{//
				
				listaDireccion.clear();
				
			}// 
			catch (Exception e) 
			{
			System.out.println("Error al limpiar direcciones: "+e);
			}
	}


}
