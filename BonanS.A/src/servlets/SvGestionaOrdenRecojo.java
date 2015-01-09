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
import com.bonansa.beans.SolicitudOrdenRecojoDTO;
import com.bonansa.beans.VehiculoDTO;
import com.bonansa.services.ClienteService;
import com.bonansa.services.EmpleadoService;
import com.google.gson.Gson;

import extras.ServicioEntidades;

/**
 * Servlet implementation class SvGestionaOrdenRecojo
 */
@WebServlet("/SvGestionaOrdenRecojo")
public class SvGestionaOrdenRecojo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	ClienteService sCliente=new ClienteService();
	EmpleadoService sEmpleado=new EmpleadoService();
	ServicioEntidades sEntidades=new ServicioEntidades();
	ArrayList<SolicitudOrdenRecojoDTO> listadoDOR=new ArrayList<SolicitudOrdenRecojoDTO>();
	ArrayList<SolicitudOrdenRecojoDTO> listadoOR_EquipoPersonal=new ArrayList<SolicitudOrdenRecojoDTO>();
	ArrayList<SolicitudOrdenRecojoDTO> listadoOR_EquiVehicular=new ArrayList<SolicitudOrdenRecojoDTO>();
	Gson obJson=new Gson();
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		/*	HttpSession sesionX=request.getSession();
			sesionX.setAttribute("s_listadoDOR", listadoDOR);*/
		
			try 
			{
				
				String operacion=request.getParameter("operacion");
				
		
				if(operacion.equals("listarClientes"))
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



	// LISTADOS
	private void prelistarVehiculos(HttpServletRequest request, HttpServletResponse response) 
	{
		
		try 
		{	
			//Capturando los datos de las cajas de texto de "Descripcion del traslado"
			String txtDireccionRecojo=request.getParameter("txtDireccionRecojo");
			String txtFechaRecojo=request.getParameter("txtFechaRecojo");
			String txtHoraRecojo=request.getParameter("txtHoraRecojo");
			
			
			//Capturamos la session Actual
			HttpSession sesioX=request.getSession();
			
			sesioX.setAttribute("s_txtDireccionRecojo", txtDireccionRecojo);
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
			String txtDireccionRecojo=request.getParameter("txtDireccionRecojo");
			String txtFechaRecojo=request.getParameter("txtFechaRecojo");
			String txtHoraRecojo=request.getParameter("txtHoraRecojo");
			
			
			//Capturamos la session Actual
			HttpSession sesioX=request.getSession();
			
			sesioX.setAttribute("s_txtDireccionRecojo", txtDireccionRecojo);
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
			sOR.setPesokG(PesokG);
			listadoDOR.add(sOR);
			
			
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
			
			
			listadoOR_EquiVehicular.add(sOR_EquipoVehicular);
			sesionX.setAttribute("listadoOR_EquiVehicular", listadoOR_EquiVehicular);
			String json=obJson.toJson(listadoOR_EquiVehicular);
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
			listadoOR_EquiVehicular.clear();
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
			if(listadoOR_EquiVehicular.size()>0)
			{
			   for (int i = 0; i < listadoOR_EquiVehicular.size(); i++) 
			   {
					if (listadoOR_EquiVehicular.get(i).getIdVehiculo().equals(idVehiculo)) 
					{
						listadoOR_EquiVehicular.remove(i);
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
		
			String txtIdEmpleado=request.getParameter("txtIdEmpleado");
			String txtDescTipoEmpleado=request.getParameter("txtDescTipoEmpleado");
			String txtNomCompletoEmp=request.getParameter("txtNomCompletoEmp");

			      System.out.println("Des: "+txtDescTipoEmpleado);
			
			SolicitudOrdenRecojoDTO sOR_EquipoPersonal=new SolicitudOrdenRecojoDTO();
			sOR_EquipoPersonal.setIdEmpleado(txtIdEmpleado);
			sOR_EquipoPersonal.setNomCompleto(txtNomCompletoEmp);
			sOR_EquipoPersonal.setDescTipoEmpleado(txtDescTipoEmpleado);

			listadoOR_EquipoPersonal.add(sOR_EquipoPersonal);
			
			System.out.println("Tmño EPER: "+listadoOR_EquipoPersonal.size());
			
			//sesionX.setAttribute("s_listadoDOR", listadoDOR);
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
			
			String idCliente=request.getParameter("idCliente");
			String nombreCompleto=request.getParameter("nombreCompleto");
			String tipoCliente=request.getParameter("tipoCliente");
			
			sesionX.setAttribute("sSOR_idCliente", idCliente);
			sesionX.setAttribute("sSOR_nombreCompleto", nombreCompleto);
			sesionX.setAttribute("sSOR_tipoCliente", tipoCliente);
			
			request.getRequestDispatcher("prRegistrarSolicitudRecojo.jsp").forward(request, response);
			

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
