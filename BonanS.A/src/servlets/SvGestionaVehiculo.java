package servlets;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import utils.MySQLConexion;

import com.bonansa.beans.VehiculoDTO;
import com.bonansa.services.VehiculoService;

import extras.ServicioFoto;

@SuppressWarnings("serial")
@MultipartConfig(maxFileSize = 16177215)
@WebServlet("/SvGestionaVehiculo")
public class SvGestionaVehiculo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
	VehiculoService sVehiculo=new VehiculoService();
	ServicioFoto sFoto=new ServicioFoto();
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			String operacion=request.getParameter("operacion");
			     if(operacion.equals("registrar")) {this.registrar(request, response);}
			else if(operacion.equals("actualizar")){this.actualizar(request, response);}
			else if(operacion.equals("eliminar")){this.eliminar(request, response);}
			else if(operacion.equals("listar")){this.listar(request, response);}
			else if(operacion.equals("buscar")){this.Buscar(request, response);}
			else if (operacion.equals("fotoVehiculo")){this.mostrarFoto(request, response);}		
			
		} catch (Exception e) {
			System.out.println("Error en el service del servlet SvGestionaUsuario: "+e);
		}
	}

	private void Buscar(HttpServletRequest request, HttpServletResponse response) {
		
		try {

			String tipo=request.getParameter("tipo");
			String idVehiculo=request.getParameter("idVehiculo");
			
			VehiculoDTO vehiculoX=sVehiculo.buscarVehiculo(idVehiculo);
			request.setAttribute("vehiculoX", vehiculoX);
			if (vehiculoX!=null) {
				
				switch (tipo) {
				case "A":
					request.getRequestDispatcher("paActualizarVehiculo.jsp").forward(request, response);
					break;

				default:
					request.getRequestDispatcher("paEliminarVehiculo.jsp").forward(request, response);
					break;
				}
			}
			
		} catch (Exception e) {
			System.out.println("Sv_Error al buscar empleado: "+e);
		}
		
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			
			ArrayList<VehiculoDTO> listadoVehiculos=sVehiculo.listarVehiculos();
			HttpSession sesionX=request.getSession();
			
			sesionX.setAttribute("listadoVehiculos", listadoVehiculos);
			request.getRequestDispatcher("paListarVehiculos.jsp").forward(request, response);
			
		} catch (Exception e) {
			System.out.println("Error al listar vehiculos SvGestionaVehiculo: "+e);
		}
		
	}


	private void mostrarFoto(HttpServletRequest request, HttpServletResponse response) {
		
		InputStream is=null;

		try {
			    String idVehiculo=request.getParameter("idVehiculo");
				is=sFoto.getFotoVehiculo(idVehiculo);
			
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
			System.out.println("Error al mostrar fotoVehiculo: "+e);
		}

	}


	private void registrar(HttpServletRequest request,HttpServletResponse response)  {
		
		try {
			
			
			String placaVeh=request.getParameter("txtPlacaVehiculo");
			int    idCategoriaVeh=Integer.parseInt(request.getParameter("cboCategoriaVehiculo"));
			String marcaVeh=request.getParameter("txtMarcaVehiculo");
			String modeloVeh=request.getParameter("txtModeloVehiculo");
			int    numAsientosVeh=Integer.parseInt(request.getParameter("txtNumAsiento"));

			int    anhoFabricVeh=Integer.parseInt(request.getParameter("txtAñoFabricacion"));
			
			String numSerieMotorVeh=request.getParameter("txtNumSerieMotor");
			double largoVeh=Double.parseDouble(request.getParameter("txtLargo"));
			
			double anchoVeh=Double.parseDouble(request.getParameter("txtAncho"));
			double alturaVeh=Double.parseDouble(request.getParameter("txtAltura"));
			double cargaBrutaVeh=Double.parseDouble(request.getParameter("txtCargaBruta"));
			double cargaUtilVeh=Double.parseDouble(request.getParameter("txtCargaUtil"));
			double cargaNetaVeh=Double.parseDouble(request.getParameter("txtCargaNeta"));
			
			InputStream inputStream = null; 
	        byte[] fotoVehiculo = null;
	        
	        Part filePart = request.getPart("txtFoto");
	        if (filePart != null) {
	            
	             
	          
	            inputStream = filePart.getInputStream();
	            
	           
	            ByteArrayOutputStream bos = new ByteArrayOutputStream();
	            byte[] tmp = new byte[4096];
	            int ret = 0;

	            while((ret = inputStream.read(tmp)) > 0)
	            {
	                bos.write(tmp, 0, ret);
	            }

	            fotoVehiculo = bos.toByteArray();
	            
	        }
	      
			
			
			
			HttpSession sesionX=request.getSession();
			
			String   ip_idEmpleadoR=(String)sesionX.getAttribute("idEmpleado");
			

			VehiculoDTO vehiculoX=new VehiculoDTO(placaVeh, idCategoriaVeh, marcaVeh, modeloVeh, numAsientosVeh, anhoFabricVeh, numSerieMotorVeh, largoVeh, anchoVeh, alturaVeh, cargaBrutaVeh, cargaUtilVeh, cargaNetaVeh, fotoVehiculo);

		
			int r=sVehiculo.registrarVehiculo(vehiculoX, ip_idEmpleadoR);
			
			if (r>0) {
				
			    request.setAttribute("mensaje", "Vehiculo registrado correctamente");
			}
			else{
				request.setAttribute("mensaje", "Error al registrar vehiculo");
			}
			
			request.getRequestDispatcher("paRegistrarVehiculo.jsp").forward(request, response);
			
		} catch (Exception e) {
			System.out.println("Error al registrarVehiculo: "+e);
		}
		
	}
	
	

	private void actualizar(HttpServletRequest request, HttpServletResponse response){
		try {
			
			String idVeh=request.getParameter("txtIdVeh");
			String placaVeh=request.getParameter("txtPlacaVehiculo");
			int    idCategoriaVeh=Integer.parseInt(request.getParameter("cboCategoriaVehiculo"));
			String marcaVeh=request.getParameter("txtMarcaVehiculo");
			String modeloVeh=request.getParameter("txtModeloVehiculo");
			int    numAsientosVeh=Integer.parseInt(request.getParameter("txtNumAsiento"));
			int    anhoFabricVeh=Integer.parseInt(request.getParameter("txtAñoFabricacion"));
			String numSerieMotorVeh=request.getParameter("txtNumSerieMotor");
			double largoVeh=Double.parseDouble(request.getParameter("txtLargo"));
			double anchoVeh=Double.parseDouble(request.getParameter("txtAncho"));
			double alturaVeh=Double.parseDouble(request.getParameter("txtAltura"));
			double cargaBrutaVeh=Double.parseDouble(request.getParameter("txtCargaBruta"));
			double cargaUtilVeh=Double.parseDouble(request.getParameter("txtCargaUtil"));
			double cargaNetaVeh=Double.parseDouble(request.getParameter("txtCargaNeta"));
			String idEstado=request.getParameter("cboEstado");
			String idEstadoTrabajo=request.getParameter("cboEstadoTrabajo");
			
			
			//Proceso para convertir la foto en binario
			InputStream inputStream = null; // input stream of the upload file
	        byte[] fotoVehiculo = null;
	        
	        Part filePart = request.getPart("txtFoto");
	        if (filePart != null) {
	            // obtains input stream of the upload file
	            inputStream = filePart.getInputStream();
	            
	            //CONVIERTE INPUTSTREAM EN BYTES[]
	            ByteArrayOutputStream bos = new ByteArrayOutputStream();
	            byte[] tmp = new byte[4096];
	            int ret = 0;

	            while((ret = inputStream.read(tmp)) > 0)
	            {
	                bos.write(tmp, 0, ret);
	            }

	            fotoVehiculo = bos.toByteArray();
	            //./CONVIERTE INPUTSTREAM EN BYTES[]
	            inputStream.close();
	            bos.close();
	            
	        }
	        // ./INPUTSTREAM
	        
	        //Capturando al responsable de la accion
	        
	        HttpSession sesionX=request.getSession();
	        String     ip_idEmpleadoR=(String)sesionX.getAttribute("idEmpleado");
	        

			VehiculoDTO vehiculoX=new VehiculoDTO(idVeh, placaVeh, idCategoriaVeh, marcaVeh, modeloVeh, numAsientosVeh, anhoFabricVeh, numSerieMotorVeh, largoVeh, anchoVeh, alturaVeh, cargaBrutaVeh, cargaUtilVeh, cargaNetaVeh, fotoVehiculo, idEstado, idEstadoTrabajo);
			
			int r=sVehiculo.actualizarVehiculo(vehiculoX, ip_idEmpleadoR);
			
			if (r>0) {
				request.setAttribute("mensaje", "Vehiculo actualizado correctamente");
			}
			else{
				request.setAttribute("mensaje", "Error al actualizar vehiculo");
			}
			
			request.getRequestDispatcher("paActualizarVehiculo.jsp").forward(request, response);
			
		} catch (Exception e) {
			System.out.println("Error al actualizarVehiculo: "+e);
		}
		
	}
	
	
	private void eliminar(HttpServletRequest request, HttpServletResponse response) {
		try {
			
			String idVehiculo=request.getParameter("txtIdVeh");
			
			HttpSession sesionX=request.getSession();
			String idEmpleadoR=(String)sesionX.getAttribute("idEmpleado");
			
			int r=sVehiculo.eliminarVehiculo(idVehiculo, idEmpleadoR);
			
			if(r>0){
				
				request.setAttribute("mensaje", "Vehiculo eliminado correctamente: "+idVehiculo);
				
			}
			else{
				request.setAttribute("mensaje", "Error al eliminar vehiculo: "+idVehiculo);
				
			}
			request.getRequestDispatcher("paEliminarVehiculo.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println("Error al eliminarVehiculo: "+e);
		}
		
	}





}
