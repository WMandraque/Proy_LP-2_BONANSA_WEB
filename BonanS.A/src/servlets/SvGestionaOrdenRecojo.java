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
import javax.sql.rowset.CachedRowSet;

import com.bonansa.beans.ClienteDTO;
import com.bonansa.beans.EmpleadoDTO;
import com.bonansa.beans.GuiaRemisionTransportistaDTO;
import com.bonansa.beans.SolicitudOrdenRecojoDTO;
import com.bonansa.beans.VehiculoDTO;
import com.bonansa.services.ClienteService;
import com.bonansa.services.EmpleadoService;
import com.bonansa.services.OrdenRecojoService;
import com.google.gson.Gson;

import extras.ServicioEntidades;

/**
 * Servlet implementation class SvGestionaOrdenRecojo
 */
@WebServlet("/SvGestionaOrdenRecojo")
public class SvGestionaOrdenRecojo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	OrdenRecojoService sOrdenRecojo=new OrdenRecojoService();
	ClienteService sCliente=new ClienteService();
	EmpleadoService sEmpleado=new EmpleadoService();
	ServicioEntidades sEntidades=new ServicioEntidades();
	ArrayList<SolicitudOrdenRecojoDTO> listadoDOR=new ArrayList<SolicitudOrdenRecojoDTO>();
	ArrayList<SolicitudOrdenRecojoDTO> listadoOR_EquipoPersonal=new ArrayList<SolicitudOrdenRecojoDTO>();
	ArrayList<SolicitudOrdenRecojoDTO> listadoOR_EquipoVehicular=new ArrayList<SolicitudOrdenRecojoDTO>();
	ArrayList<GuiaRemisionTransportistaDTO> listadoGRT=new ArrayList<GuiaRemisionTransportistaDTO>();
	Gson obJson=new Gson();
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		
		
			try 
			{
				
				String operacion=request.getParameter("operacion");
				
				if (operacion.equals("registrar")) 
				{
				this.registrar(request, response);	
				}
				else if(operacion.equals("listar"))
				{
				this.listar(request, response);	
				}
				else if(operacion.equals("listarClientes"))
				{
				this.listarCliente(request, response);	
				}
				else if (operacion.equals("prelistarEmpleados"))
				{
				this.prelistarEmpleados(request, response);	
				}
				else if(operacion.equals("listarEmpleados"))
				{
				this.listarEmpleados(request, response);	
				}
				else if (operacion.equals("prelistarVehiculos"))
				{
				this.prelistarVehiculos(request, response);	
				}
				else if(operacion.equals("listarVehiculos"))
				{
				this.listarVehiculos(request, response);	
				}
/*				else if(operacion.equals("buscarEmpleado"))
				{
				this.buscarEmpleado(request, response);	
				}*/
				else if(operacion.equals("buscarCliente"))
				{
				this.buscarCliente(request, response);	
				}
				else if(operacion.equals("buscarSOR"))
				{
				this.buscarSOR(request, response);	
				}
/*				else if(operacion.equals("buscarVehiculo"))
				{
				this.buscarVehiculo(request, response);	
				}*/
				else if(operacion.equals("agregarDOR"))
				{
				this.agregarDOR(request, response);	
				}
				else if(operacion.equals("eliminarDOR"))
				{
				this.eliminarDOR(request, response);	
				}
				else if(operacion.equals("limpiarDOR"))
				{
				this.limpiarDOR(request, response);	
				}
				else if(operacion.equals("agregarOR_EquipoPersponal"))
				{
				this.agregarOR_EquipoPersponal(request, response);	
				}
				else if(operacion.equals("limpiarOR_EquipoPersonal"))
				{
				this.limpiarOR_EquipoPersonal(request, response);	
				}
				else if(operacion.equals("eliminarOR_EquipoPersonal"))
				{
				this.eliminarOR_EquipoPersonal(request, response);	
				}
				else if(operacion.equals("agregarOR_EquipoVehicular"))
				{
				this.agregarOR_EquipoVehicular(request, response);	
				}
				else if(operacion.equals("limpiarOR_EquipoVehicular"))
				{
				this.limpiarOR_EquipoVehicular(request, response);	
				}
				else if(operacion.equals("eliminarOR_EquipoVehicular"))
				{
				this.eliminarOR_EquipoVehicular(request, response);	
				}
				
				
				
				
			} 
			catch (Exception e) 
			{
				System.out.println("Error en el service SvGestionaOrdenRecojo: "+e);
			}	
		
	}



	



	private void buscarSOR(HttpServletRequest request, HttpServletResponse response) 
	{
		try {
			
			HttpSession miSesion=request.getSession();
			
			String idOR=request.getParameter("idOR");
			String nivel=request.getParameter("nivel");
			SolicitudOrdenRecojoDTO sORX=sOrdenRecojo.buscarSOR(idOR);
			listadoGRT.clear();
			
			if(sORX.getIdOR()!=null)
			{
				
				for (int i = 0; i < sORX.getListadoDescripcionTraslado().size(); i++) 
				{
					GuiaRemisionTransportistaDTO gRT=new GuiaRemisionTransportistaDTO();
					
					gRT.setDescTraslado(sORX.getListadoDescripcionTraslado().get(i).getDescripcionTraslado());
					gRT.setCantidad(sORX.getListadoDescripcionTraslado().get(i).getCantidad());
					gRT.setIdTipoUnidadMedida(sORX.getListadoDescripcionTraslado().get(i).getIdTipoUnidadMedida());
					gRT.setDescTipoUnidadMedida(sORX.getListadoDescripcionTraslado().get(i).getDescTipoUnidadMedida());
					gRT.setPesoKg(sORX.getListadoDescripcionTraslado().get(i).getPesoKg());
					
					listadoGRT.add(gRT);
				}
				
			
					if (nivel.equals("condu")) 
					{
					request.setAttribute("r_sORX", sORX);
					miSesion.setAttribute("s_listadoGRT", listadoGRT);
					miSesion.setAttribute("s_listadoEquipoPersonalTraslado", sORX.getListadoEquipoPersonaRecojos());
					}		
				
			}
			request.getRequestDispatcher("pcRegistrarGRT.jsp").forward(request, response);

					
	
			
		} catch (Exception e) {
			System.out.println("Error en buscarSOR SvGestionaOrdenRecojo: "+e);
		}
		
	}



	private void listar(HttpServletRequest request, HttpServletResponse response) 
	{
			try 
			{
				HttpSession miSesion=request.getSession();
				
				String idEmpleado=request.getParameter("idEmpleado");
				String nivel=request.getParameter("nivel");
				
				ArrayList<SolicitudOrdenRecojoDTO> listadoOrdenRecojos=new ArrayList<SolicitudOrdenRecojoDTO>();
				
				if(idEmpleado==null)
				{
					
					 listadoOrdenRecojos=sOrdenRecojo.listarOrdenRecojos(null);
				}
				else
				{
					listadoOrdenRecojos=sOrdenRecojo.listarOrdenRecojos(idEmpleado);
				}
				
				if (listadoOrdenRecojos.size()>0) 
				{
				miSesion.setAttribute("listadoOrdenRecojos", listadoOrdenRecojos);	
				}
				
				if(nivel.equals("admin"))
				{
					request.getRequestDispatcher("paListarOrdenRecojos.jsp").forward(request, response);
				}
				else if(nivel.equals("recep"))
				{
					request.getRequestDispatcher("prListarOrdenRecojos.jsp").forward(request, response);

				}
				else if(nivel.equals("condu"))
				{
					request.getRequestDispatcher("pcListarOrdenRecojos.jsp").forward(request, response);

				}
				
			}
			catch (Exception e) 
			{
				System.out.println("Error en listar SvGestionaOrdenRecojo: "+e);
			}
		
	}



	@SuppressWarnings("unchecked")
	private void registrar(HttpServletRequest request, HttpServletResponse response) 
	{
		
		try 
		{
			
			
			//Capturando datos para la tabla tb_OrdenRecojo
			
			String   idCliente=request.getParameter("txtIdCliente");
			String   direccionRecojoUbigeo=request.getParameter("cboDireccionesCliente");
			String[] direccionRecojo=direccionRecojoUbigeo.split(":");
			String fechaRecojo=request.getParameter("txtFechaRecojo");
			String horaRecojo=request.getParameter("txtHoraRecojo");
			String nivel=request.getParameter("nivel");
			if (nivel==null) {nivel="";}
			
			SolicitudOrdenRecojoDTO ordenRecojoX=new SolicitudOrdenRecojoDTO();
			ordenRecojoX.setIdCliente(idCliente);
			ordenRecojoX.setDireccionRecojo(direccionRecojo[1]);
			ordenRecojoX.setFechaRecojo(fechaRecojo);
			ordenRecojoX.setHoraRecojo(horaRecojo);
			
			
			System.out.println("Probando direcciones: "+direccionRecojo[1]);
			//Capturando las listas
			HttpSession miSesion=request.getSession();
			
			ArrayList<SolicitudOrdenRecojoDTO> cp_listadoDOR;
			ArrayList<SolicitudOrdenRecojoDTO> cp_listadoOR_EquipoPersonal;
			ArrayList<SolicitudOrdenRecojoDTO> cp_listadoOR_EquipoVehicular;
			
			if (miSesion.getAttribute("listadoDOR")==null) {
				cp_listadoDOR=new ArrayList<SolicitudOrdenRecojoDTO>();
			}
			else
			{
				cp_listadoDOR=(ArrayList<SolicitudOrdenRecojoDTO>)miSesion.getAttribute("listadoDOR");
			}
			
			if(miSesion.getAttribute("listadoOR_EquipoPersonal")==null)
			{
				cp_listadoOR_EquipoPersonal=new ArrayList<SolicitudOrdenRecojoDTO>();
			}
			else
			{
				cp_listadoOR_EquipoPersonal=(ArrayList<SolicitudOrdenRecojoDTO>)miSesion.getAttribute("listadoOR_EquipoPersonal");
			}
			if(miSesion.getAttribute("listadoOR_EquipoVehicular")==null)
			{
				cp_listadoOR_EquipoVehicular=new ArrayList<SolicitudOrdenRecojoDTO>();
			}
			else
			{
				cp_listadoOR_EquipoVehicular=(ArrayList<SolicitudOrdenRecojoDTO>)miSesion.getAttribute("listadoOR_EquipoVehicular");
			}

			
			System.out.println("Tamaño de la lista de traslados: "+ cp_listadoDOR.size());
			System.out.println("Tamaño de la lista de personal: "+ cp_listadoOR_EquipoPersonal.size());
			System.out.println("Tamaño de la lista de vehiculos: "+ cp_listadoOR_EquipoVehicular.size());
			
			
			
			//Capturando al empleado responsable
			String idEmpleadoR=(String)miSesion.getAttribute("idEmpleado");
			
			
			
			//Enviando por el service
			
			int r=sOrdenRecojo.registrarOrdenRecojo(ordenRecojoX, cp_listadoDOR, cp_listadoOR_EquipoPersonal, cp_listadoOR_EquipoVehicular, idEmpleadoR);
			
			if(r>0)
			{
			request.setAttribute("mensaje", "Solicitud de Orden de recojo registrado correctamente");	
			}
			else
			{
			request.setAttribute("mensaje", "Error al registrar Solicitud de Orden de recojo");	
			}
			listadoDOR.clear();
			listadoOR_EquipoPersonal.clear();
			listadoOR_EquipoVehicular.clear();
			
		    miSesion.removeAttribute("s_txtDireccionRecojo");
		    miSesion.removeAttribute("s_txtFechaRecojo");
		    miSesion.removeAttribute("s_txtHoraRecojo");
		    
		    miSesion.removeAttribute("sSOR_idCliente");
		    miSesion.removeAttribute("sSOR_nombreCompleto");
		    miSesion.removeAttribute("sSOR_tipoCliente");
		    
		    if (nivel.equals("ADMINISTRADOR")) {
				request.getRequestDispatcher("paRegistrarSolicitudRecojo.jsp").forward(request, response);

			}
		    else
		    {
				request.getRequestDispatcher("prRegistrarSolicitudRecojo.jsp").forward(request, response);

		    }
	
			
			
			System.out.println("Tamaño de la lista de traslados al finalizar: "+ cp_listadoDOR.size());
			System.out.println("Tamaño de la lista de personal al finalizar: "+ cp_listadoOR_EquipoPersonal.size());
			System.out.println("Tamaño de la lista de vehiculos al finalizar: "+ cp_listadoOR_EquipoVehicular.size());
			
		} 
		catch (Exception e) {
			System.out.println("Error  en registrar SvGestionaOrdenRecojo: "+e);
		}


		
	}



	// LISTADOS
	private void prelistarVehiculos(HttpServletRequest request, HttpServletResponse response) 
	{
		
		try 
		{	
			//Capturando los datos de las cajas de texto de "Descripcion del traslado"
			//String txtDireccionRecojo=request.getParameter("txtDireccionRecojo");
			String txtFechaRecojo=request.getParameter("txtFechaRecojo");
			String txtHoraRecojo=request.getParameter("txtHoraRecojo");
			
			
			//Capturamos la session Actual
			HttpSession sesioX=request.getSession();
			
			//sesioX.setAttribute("s_txtDireccionRecojo", txtDireccionRecojo);
			sesioX.setAttribute("s_txtFechaRecojo", txtFechaRecojo);
			sesioX.setAttribute("s_txtHoraRecojo", txtHoraRecojo);
			
			
		} 
		catch (Exception e) 
		{
		System.out.println("Error en preListarVehiculos SvGestionaVehiculos: "+e);
		}
		
		
	}


	private void listarVehiculos(HttpServletRequest request, HttpServletResponse response) {
		
		try 
		{               ArrayList<VehiculoDTO> listadoVehiculos=new ArrayList<VehiculoDTO>();
						CachedRowSet crs=sEntidades.listadoEntidades("select*From vistaListaVehiculos where Estado!='INACTIVO' AND estadoTrabajo!='OCUPADO'");
						
						while(crs.next())
							{
								listadoVehiculos.add(new VehiculoDTO(
																		crs.getString(1),
																		crs.getString(2),
																		crs.getString(3),
																		crs.getString(4), 
																		crs.getString(5), 
																		crs.getInt(6), 
																		crs.getInt(7), 
																		crs.getString(8), 
																		crs.getString(9)
																	)
	                                                );
							}

	

						
						HttpSession sesionX=request.getSession();
						sesionX.setAttribute("listadoVehiculos", listadoVehiculos);
						request.getRequestDispatcher("prListarVehiculos.jsp").forward(request, response);
		} 
		catch (Exception e) 
		{
		 System.out.println("Error al listarVehiculos SvGestionaOrdenRecojo: "+e);
		}
	}



	private void prelistarEmpleados(HttpServletRequest request, HttpServletResponse response) 
	{
		
		try 
		{
			
			//Capturando los datos de las cajas de texto de "Descripcion del traslado"
			//String direccionRecojo=request.getParameter("cboDireccionRecojo");
			String txtFechaRecojo=request.getParameter("txtFechaRecojo");
			String txtHoraRecojo=request.getParameter("txtHoraRecojo");
			
			
			//Capturamos la session Actual
			HttpSession sesioX=request.getSession();
			
			//sesioX.setAttribute("s_txtDireccionRecojo", direccionRecojo);
			sesioX.setAttribute("s_txtFechaRecojo", txtFechaRecojo);
			sesioX.setAttribute("s_txtHoraRecojo", txtHoraRecojo);
			
			
		} 
		catch (Exception e) 
		{
		System.out.println("Error en preListarEmpleados: "+e);
		}
		
	}



	private void listarEmpleados(HttpServletRequest request, HttpServletResponse response)
	{
		try 
		{               ArrayList<EmpleadoDTO> listadoEmpleados=new ArrayList<EmpleadoDTO>();
						CachedRowSet crs=sEntidades.listadoEntidades("select*From vistaListaEmpleados where estado!='INACTIVO' AND descEstado!='OCUPADO' && nomCargo!='ADMINISTRADOR'&& nomCargo!='RECEPCIONISTA'");
						while(crs.next())
						{
							EmpleadoDTO empleadoX=new EmpleadoDTO(crs.getString(1), crs.getString(2), crs.getString(3), crs.getString(4), crs.getString(5), crs.getString(6), crs.getString(7), crs.getString(8), crs.getString(9), crs.getString(10));	
						      
							listadoEmpleados.add(empleadoX);
						}

	

						
						HttpSession sesionX=request.getSession();
						sesionX.setAttribute("listadoEmpleados", listadoEmpleados);
						request.getRequestDispatcher("prListarEmpleados.jsp").forward(request, response);
		} 
		catch (Exception e) 
		{
		 System.out.println("Error al listar Clientes SvGestionaCliente: "+e);
		}
			
		
	}

	
	private void listarCliente(HttpServletRequest request, HttpServletResponse response) 
	{
		try 
		{
						ArrayList<ClienteDTO> listadoClientes=sCliente.listarCliente();
						HttpSession sesionX=request.getSession();
						sesionX.setAttribute("listadoClientes", listadoClientes);
						request.getRequestDispatcher("prListarClientes.jsp").forward(request, response);
		} 
		catch (Exception e) 
		{
		 System.out.println("Error al listar Clientes SvGestionaCliente: "+e);
		}	
		
	}
	
	


	
	// Gestion de las tablitas

	private void agregarDOR(HttpServletRequest request, HttpServletResponse response) 
	{
		try 
		{
			
			HttpSession sesionX=request.getSession();
			
			String descripcionTraslado=request.getParameter("descripcionTraslado");
			String descTipoUnidadMedida=request.getParameter("descTipoUnidadMedida");
			int idTipoUnidadMedida=Integer.parseInt(request.getParameter("idTipoUnidadMedida"));
			int cantidad=Integer.parseInt(request.getParameter("cantidad"));
			double PesokG=Double.parseDouble(request.getParameter("PesokG"));
			
			
			SolicitudOrdenRecojoDTO sOR=new SolicitudOrdenRecojoDTO();
			sOR.setDescripcionTraslado(descripcionTraslado);
			sOR.setDescTipoUnidadMedida(descTipoUnidadMedida);
			sOR.setCantidad(cantidad);
			sOR.setIdTipoUnidadMedida(idTipoUnidadMedida);
			sOR.setPesoKg(PesokG);
			listadoDOR.add(sOR);
			
			sesionX.setAttribute("listadoDOR", listadoDOR);
			String json=obJson.toJson(listadoDOR);
			PrintWriter out;
			
				out = response.getWriter();
				out.println(json);

			
		} 
		catch (Exception e) 
		{
		System.out.println("Error al agregar DOR SvGestionaOrdenRecojo: "+e);
		}
	
		
	}
	

	private void eliminarDOR(HttpServletRequest request, HttpServletResponse response)
	{
	
		try 
		{
			String descripcionTraslado=request.getParameter("descripcionTraslado");
			System.out.println(descripcionTraslado);
			for (int i = 0; i < listadoDOR.size(); i++) {
				if (listadoDOR.get(i).getDescripcionTraslado().equals(descripcionTraslado)) {
					listadoDOR.remove(i);
				}
			}
			
		} 
		catch (Exception e) 
		{
		System.out.println("Error al eliminaDOR SvGestionaOR: "+e);	
		}
		
	}
	
	private void limpiarDOR(HttpServletRequest request, HttpServletResponse response)
	{
		
	listadoDOR.clear();	
	}

	


	private void agregarOR_EquipoVehicular(HttpServletRequest request, HttpServletResponse response) 
	{
		
		try 
		{
			HttpSession sesionX=request.getSession();
			
			String txtIdVehiculo=request.getParameter("txtIdVehiculo");
			String txtPlacaVehiculo=request.getParameter("txtPlacaVehiculo");
			String txtCatVehiculo=request.getParameter("txtCatVehiculo");
			
			SolicitudOrdenRecojoDTO sOR_EquipoVehicular=new SolicitudOrdenRecojoDTO();
			sOR_EquipoVehicular.setIdVehiculo(txtIdVehiculo);
			sOR_EquipoVehicular.setPlacaVehiculo(txtPlacaVehiculo);
			sOR_EquipoVehicular.setDescCatVehiculo(txtCatVehiculo);
			
			
			listadoOR_EquipoVehicular.add(sOR_EquipoVehicular);
			sesionX.setAttribute("listadoOR_EquipoVehicular", listadoOR_EquipoVehicular);
			String json=obJson.toJson(listadoOR_EquipoVehicular);
			PrintWriter out;
			
				out = response.getWriter();
				out.println(json);

			
		} 
		catch (Exception e) {
	    System.out.println("Error en agregarOR_EquipoVehicular(): "+e);
		}
		
		
	}
	
	private void limpiarOR_EquipoVehicular(HttpServletRequest request, HttpServletResponse response)
	{
		try 
		{
			listadoOR_EquipoVehicular.clear();
		} 
		catch (Exception e) 
		{
		System.out.println("Error en limpiarOR_EquipoVehicular :"+e);
		}
	
		
	}
	
	private void eliminarOR_EquipoVehicular(HttpServletRequest request, HttpServletResponse response) 
	{
		
		try 
		{
			String idVehiculo=request.getParameter("idVehiculo");
			if(listadoOR_EquipoVehicular.size()>0)
			{
			   for (int i = 0; i < listadoOR_EquipoVehicular.size(); i++) 
			   {
					if (listadoOR_EquipoVehicular.get(i).getIdVehiculo().equals(idVehiculo)) 
					{
						listadoOR_EquipoVehicular.remove(i);
					}
		       }	
			}
		} 
		catch (Exception e) 
		{
		System.out.println("Error en eliminarOR_EquipoVehicular :"+e);
		}
	
		
		
	}




	private void agregarOR_EquipoPersponal(HttpServletRequest request, HttpServletResponse response) {
		try 
		{
			
			HttpSession sesionX=request.getSession();
		
			String txtIdEmpleado=request.getParameter("txtIdEmpleado");
			String txtDescTipoEmpleado=request.getParameter("txtDescTipoEmpleado");
			String txtNomCompletoEmp=request.getParameter("txtNomCompletoEmp");

			      
			
			SolicitudOrdenRecojoDTO sOR_EquipoPersonal=new SolicitudOrdenRecojoDTO();
			sOR_EquipoPersonal.setIdEmpleado(txtIdEmpleado);
			sOR_EquipoPersonal.setNomCompleto(txtNomCompletoEmp);
			sOR_EquipoPersonal.setDescTipoEmpleado(txtDescTipoEmpleado);

			listadoOR_EquipoPersonal.add(sOR_EquipoPersonal);
			
			
			sesionX.setAttribute("listadoOR_EquipoPersonal", listadoOR_EquipoPersonal);
			String json=obJson.toJson(listadoOR_EquipoPersonal);
			PrintWriter out;
			
				out = response.getWriter();
				out.println(json);

			
		} 
		catch (Exception e) 
		{
		System.out.println("Error al agregar DOR SvGestionaOrdenRecojo: "+e);
		}
		
	}




	private void eliminarOR_EquipoPersonal(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			
			String idEmpleado=request.getParameter("idEmpleado");
			System.out.println("Llefo para eliminar!!!!!!");
			if(listadoOR_EquipoPersonal.size()>0)
			{
				for (int i = 0; i < listadoOR_EquipoPersonal.size(); i++) 
				{
					if(listadoOR_EquipoPersonal.get(i).getIdEmpleado().equals(idEmpleado))
					{
					listadoOR_EquipoPersonal.remove(i);	
					}
				}
			}
			
			
		} catch (Exception e) {
			System.out.println("Error en eliminarOR_EquipoPersonal SvGestionaOrdenRecojo: "+e);
		}
		
	}

	
	private void limpiarOR_EquipoPersonal(HttpServletRequest request, HttpServletResponse response) {
		
		listadoOR_EquipoPersonal.clear();
	}






	private void buscarCliente(HttpServletRequest request, HttpServletResponse response) 
	{
		try 
		{
			
			//Capturamos la session actual
			HttpSession sesionX=request.getSession();
			
			String nivel=request.getParameter("nivel");
			if (nivel==null) {nivel="";}
			String idCliente=request.getParameter("idCliente");
			String nombreCompleto=request.getParameter("nombreCompleto");
			String tipoCliente=request.getParameter("tipoCliente");
			
			sesionX.setAttribute("sSOR_idCliente", idCliente);
			sesionX.setAttribute("sSOR_nombreCompleto", nombreCompleto);
			sesionX.setAttribute("sSOR_tipoCliente", tipoCliente);
			
			if(nivel.equals("ADMINISTRADOR"))
			{
				request.getRequestDispatcher("paRegistrarSolicitudRecojo.jsp").forward(request, response);
			}
			else if(nivel.equals("RECEPCIONISTA"))
			{
				request.getRequestDispatcher("prRegistrarSolicitudRecojo.jsp").forward(request, response);

			}
			
			

		} 
		catch (Exception e) 
		{
			System.out.println("Error en el buscar SvGestionaOrdenRecojo: "+e);
		}	
		
	}
	
	
	/*private void buscarVehiculo(HttpServletRequest request, HttpServletResponse response)
	{
		
		try 
		{
			HttpSession sesionX=request.getSession();
			
			String idVehiculo=request.getParameter("idVehiculo");
			String placa=request.getParameter("placa");
			String descCategoriaVeh=request.getParameter("descCategoriaVeh");
			
			sesionX.setAttribute("s_idVehiculo", idVehiculo);
			sesionX.setAttribute("s_placa", placa);
			sesionX.setAttribute("s_descCategoriaVeh", descCategoriaVeh);
			
			request.getRequestDispatcher("prListarVehiculos.jsp").forward(request, response);
			
		}
		catch (Exception e) 
		{
			
		}
		
	}
	
	

	private void buscarEmpleado(HttpServletRequest request, HttpServletResponse response) 
	{
	
		try 
		{
			
			//Capturamos la session actual
			//HttpSession sesionX=request.getSession();
			
			String idEmpleado=request.getParameter("idEmpleado");
			String nomCompletoEmp=request.getParameter("nombreCompleto");
			String tipoEmpleado=request.getParameter("tipoEmpleado");
			
			request.setAttribute("idEmpleado",idEmpleado );
			request.setAttribute("nomCompletoEmp", nomCompletoEmp);
			request.setAttribute("tipoEmpleado", tipoEmpleado);
			
            request.getRequestDispatcher("prRegistrarSolicitudRecojo.jsp").forward(request, response);
			
		}
		catch (Exception e) 
		{
			System.out.println("Error al buscarEmpleado SvGestionaOrdenRecojo: "+e);
		}
		
	}*/

}
