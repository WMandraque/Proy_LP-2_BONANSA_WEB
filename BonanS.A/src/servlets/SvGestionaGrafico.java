package servlets;

import java.awt.image.RenderedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.record.formula.functions.Char;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import extras.ServicioEntidades;

/**
 * Servlet implementation class SvGestionaGrafico
 */
/**
 * @author SHITD
 *
 */
/**
 * @author SHITD
 *
 */
/**
 * @author SHITD
 *
 */
@WebServlet("/SvGestionaGrafico")
public class SvGestionaGrafico extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ServicioEntidades se=new ServicioEntidades();
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
		String operacion=request.getParameter("operacion");
		if (operacion.equals("cliente")) 
		{
	    this.cliente(request, response);
		}
		else if(operacion.equals("empleado"))
		{
		this.empleado(request, response);	
		}
		else if(operacion.equals("vehiculo"))
		{
		this.vehiculo(request, response);
		}
		else if(operacion.equals("ordenRecojo"))
		{
		this.ordenRecojo(request, response);
		}
		else if(operacion.equals("GRT"))
		{
		this.GRT(request, response);
		}
		else if(operacion.equals("Incidencia"))
		{
		this.Incidencia(request, response);
		}
	}

	
	
	
	
	
	
	


   /*
   * Incidencia 
  */
	private void Incidencia(HttpServletRequest request, HttpServletResponse response) 
	{
		try 
		{
			
            String tipoReporte=request.getParameter("tipoReporte");
			
			if (tipoReporte.equals("reporteIncidenciasRegistrados2015")) 
			{
			this.reporteIncidenciasRegistrados2015(request, response);	
			}
			else if(tipoReporte.equals("reporteIncidenciaEstado"))
			{
			this.reporteIncidenciaEstado(request, response);
			}
			
		}
		catch (Exception e) 
		{
			System.out.println("Error --> Incidencia() SvGestionaGrafico: "+e);
		}
	}










	  private void reporteIncidenciaEstado(HttpServletRequest request, HttpServletResponse response)
	  {
		  try 
			{
	            response.setContentType("image/png");
				
				ServletOutputStream sos=response.getOutputStream();
				DefaultCategoryDataset dcd=new DefaultCategoryDataset();
				dcd.addValue(se.countQuery("SELECT COUNT(*) FROM tb_incidencias WHERE idEstadoIncidencia='0'"), "Grafica", "Pendiente");
				dcd.addValue(se.countQuery("SELECT COUNT(*) FROM tb_incidencias WHERE idEstadoIncidencia='1'"), "Grafica", "Aceptada");
				

				
				JFreeChart chart = ChartFactory.createBarChart("Incidencia Registradas 2015", "Meses","Cantidad", dcd, PlotOrientation.VERTICAL,false, true, false);
			
				RenderedImage chartImage = chart.createBufferedImage(1300, 900);
				ImageIO.write(chartImage, "png", sos);
				sos.flush();
				sos.close();
			}
			catch (Exception e) 
			{
				System.out.println("Error --> reporteIncidenciaEstado() SvGestionaGraficos: "+e);
			}		
	  }










	private void reporteIncidenciasRegistrados2015(HttpServletRequest request, HttpServletResponse response) 
	  {
		  try 
			{
	            response.setContentType("image/png");
				
				ServletOutputStream sos=response.getOutputStream();
				DefaultCategoryDataset dcd=new DefaultCategoryDataset();
				dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%Incidencia Registrada:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=1"), "Grafica", "Enero");
				dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%Incidencia Registrada:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=2"), "Grafica", "Febrero");
				dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%Incidencia Registrada:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=3"), "Grafica", "Marzo");
				dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%Incidencia Registrada:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=4"), "Grafica", "Abril");
				dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%Incidencia Registrada:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=5"), "Grafica", "Mayo");
				dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%Incidencia Registrada:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=6"), "Grafica", "Junio");
				dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%Incidencia Registrada:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=7"), "Grafica", "Julio");
				dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%Incidencia Registrada:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=8"), "Grafica", "Agosto");
				dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%Incidencia Registrada:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=9"), "Grafica", "Septiembre");
				dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%Incidencia Registrada:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=10"), "Grafica", "Octubre");
				dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%Incidencia Registrada:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=11"), "Grafica", "Noviembre");
				dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%Incidencia Registrada:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=12"), "Grafica", "Diciembre");



				
				JFreeChart chart = ChartFactory.createBarChart("Incidencias Registradas 2015", "Meses","Cantidad", dcd, PlotOrientation.VERTICAL,false, true, false);
			
				RenderedImage chartImage = chart.createBufferedImage(1300, 900);
				ImageIO.write(chartImage, "png", sos);
				sos.flush();
				sos.close();
			}
			catch (Exception e) 
			{
				System.out.println("Error --> reporteIncidenciasRegistrados2015() SvGestionaGraficos: "+e);
			}		
	  }










	/*
	   * GRT
	  * */
	private void GRT(HttpServletRequest request, HttpServletResponse response) 
	{
		try 
		{
			
            String tipoReporte=request.getParameter("tipoReporte");
			
			if (tipoReporte.equals("reporteGRTRegistrados2015")) 
			{
			this.reporteGRTRegistrados2015(request, response);	
			}
			else if(tipoReporte.equals("reporteGRTEstado"))
			{
			this.reporteGRTEstado(request, response);
			}
			
		}
		catch (Exception e) 
		{
			System.out.println("Error --> GRT() SvGestionaGrafico: "+e);
		}
		
	}












	private void reporteGRTEstado(HttpServletRequest request,HttpServletResponse response)
	{
		try 
		{
            response.setContentType("image/png");
			
			ServletOutputStream sos=response.getOutputStream();
			DefaultCategoryDataset dcd=new DefaultCategoryDataset();
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_GRT WHERE idEstadoGRT='0'"), "Grafica", "En camino");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_GRT WHERE idEstadoGRT='1'"), "Grafica", "Entregado");
			

			
			JFreeChart chart = ChartFactory.createBarChart("GRT Registrados 2015", "Meses","Cantidad", dcd, PlotOrientation.VERTICAL,false, true, false);
		
			RenderedImage chartImage = chart.createBufferedImage(1300, 900);
			ImageIO.write(chartImage, "png", sos);
			sos.flush();
			sos.close();
		}
		catch (Exception e) 
		{
			System.out.println("Error --> reporteGRTRegistrados2015() SvGestionaGraficos: "+e);
		}		
	}










	private void reporteGRTRegistrados2015(HttpServletRequest request,HttpServletResponse response) 
	{	
		try 
		{
            response.setContentType("image/png");
			
			ServletOutputStream sos=response.getOutputStream();
			DefaultCategoryDataset dcd=new DefaultCategoryDataset();
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%GRT Registrado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=1"), "Grafica", "Enero");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%GRT Registrado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=2"), "Grafica", "Febrero");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%GRT Registrado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=3"), "Grafica", "Marzo");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%GRT Registrado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=4"), "Grafica", "Abril");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%GRT Registrado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=5"), "Grafica", "Mayo");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%GRT Registrado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=6"), "Grafica", "Junio");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%GRT Registrado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=7"), "Grafica", "Julio");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%GRT Registrado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=8"), "Grafica", "Agosto");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%GRT Registrado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=9"), "Grafica", "Septiembre");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%GRT Registrado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=10"), "Grafica", "Octubre");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%GRT Registrado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=11"), "Grafica", "Noviembre");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%GRT Registrado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=12"), "Grafica", "Diciembre");


			
			JFreeChart chart = ChartFactory.createBarChart("GRT Registrados 2015", "Meses","Cantidad", dcd, PlotOrientation.VERTICAL,false, true, false);
		
			RenderedImage chartImage = chart.createBufferedImage(1300, 900);
			ImageIO.write(chartImage, "png", sos);
			sos.flush();
			sos.close();
		}
		catch (Exception e) 
		{
			System.out.println("Error --> reporteGRTRegistrados2015() SvGestionaGraficos: "+e);
		}		
	}










	/*
	 * ORDEN DE RECOJO
	 * */
	private void ordenRecojo(HttpServletRequest request, HttpServletResponse response) 
	{
		try 
		{
			
            String tipoReporte=request.getParameter("tipoReporte");
			
			if (tipoReporte.equals("reporteSORRegistrados2015")) 
			{
			this.reporteSORRegistrados2015(request, response);	
			}
			else if(tipoReporte.equals("reporteSOREstado"))
			{
			this.reporteSOREstado(request, response);
			}
			else if(tipoReporte.equals("reporteCategoriasVehiculo"))
			{
			this.reporteCategoriasVehiculo(request, response);
			}
			
		}
		catch (Exception e) 
		{
			System.out.println("Error --> vehiculo() SvGestionaEmpleado: "+e);
		}
	}




	private void reporteSOREstado(HttpServletRequest request,HttpServletResponse response)
	{
		try 
		{
            response.setContentType("image/png");
			
			ServletOutputStream sos=response.getOutputStream();
			DefaultCategoryDataset dcd=new DefaultCategoryDataset();
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM tb_ordenRecojo WHERE idOR=0"), "Grafica", "Pendiente");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM tb_ordenRecojo WHERE idOR=1"), "Grafica", "Aprobada");
			

			
			JFreeChart chart = ChartFactory.createBarChart("Orden Recojo por Estado", "Estado","Cantidad", dcd, PlotOrientation.VERTICAL,false, true, false);
		
			RenderedImage chartImage = chart.createBufferedImage(1300, 900);
			ImageIO.write(chartImage, "png", sos);
			sos.flush();
			sos.close();
		}
		catch (Exception e) 
		{
			System.out.println("Error --> reporteSORRegistrados2015() SvGestionaGraficos: "+e);
		}		
	}












	private void reporteSORRegistrados2015(HttpServletRequest request, HttpServletResponse response) 
	{
		try 
		{
            response.setContentType("image/png");
			
			ServletOutputStream sos=response.getOutputStream();
			DefaultCategoryDataset dcd=new DefaultCategoryDataset();
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%SOR Registrado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=1"), "Grafica", "Enero");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%SOR Registrado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=2"), "Grafica", "Febrero");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%SOR Registrado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=3"), "Grafica", "Marzo");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%SOR Registrado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=4"), "Grafica", "Abril");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%SOR Registrado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=5"), "Grafica", "Mayo");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%SOR Registrado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=6"), "Grafica", "Junio");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%SOR Registrado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=7"), "Grafica", "Julio");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%SOR Registrado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=8"), "Grafica", "Agosto");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%SOR Registrado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=9"), "Grafica", "Septiembre");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%SOR Registrado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=10"), "Grafica","Octubre");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%SOR Registrado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=11"), "Grafica", "Noviembre");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%SOR Registrado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=12"), "Grafica", "Diciembre");

			
			JFreeChart chart = ChartFactory.createBarChart("Orden Recojo Registrados 2015", "Meses","Cantidad", dcd, PlotOrientation.VERTICAL,false, true, false);
		
			RenderedImage chartImage = chart.createBufferedImage(1300, 900);
			ImageIO.write(chartImage, "png", sos);
			sos.flush();
			sos.close();
		}
		catch (Exception e) 
		{
			System.out.println("Error --> reporteSORRegistrados2015() SvGestionaGraficos: "+e);
		}		
	}









	/*Vehiculo*/
	private void vehiculo(HttpServletRequest request, HttpServletResponse response) 
	{
		try 
		{
			
            String tipoReporte=request.getParameter("tipoReporte");
			
			if (tipoReporte.equals("reporteVehiculosRegistrado2015")) 
			{
			this.reporteVehiculosRegistrado2015(request, response);	
			}
			else if(tipoReporte.equals("reporteVehiculosEliminados2015"))
			{
			this.reporteVehiculosEliminados2015(request, response);
			}
			else if(tipoReporte.equals("reporteCategoriasVehiculo"))
			{
			this.reporteCategoriasVehiculo(request, response);
			}
			
		}
		catch (Exception e) 
		{
			System.out.println("Error --> vehiculo() SvGestionaEmpleado: "+e);
		}
	}




	private void reporteCategoriasVehiculo(HttpServletRequest request, HttpServletResponse response)
	{
		
		try 
		{
            response.setContentType("image/png");
			
			ServletOutputStream sos=response.getOutputStream();
			DefaultCategoryDataset dcd=new DefaultCategoryDataset();
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM tb_vehiculo WHERE idCategoriaVeh='1'"), "Grafica", "N1");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM tb_vehiculo WHERE idCategoriaVeh='2'"), "Grafica", "N2");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM tb_vehiculo WHERE idCategoriaVeh='3'"), "Grafica", "N3");

			JFreeChart chart = ChartFactory.createBarChart("Categoria Vehiculo", "Tipo de Vehiculo","Cantidad", dcd, PlotOrientation.VERTICAL,false, true, false);
		
			RenderedImage chartImage = chart.createBufferedImage(1300, 900);
			ImageIO.write(chartImage, "png", sos);
			sos.flush();
			sos.close();
		}
		catch (Exception e) 
		{
			System.out.println("Error --> reporteCategoriasVehiculo() SvGestionaVehiculo: "+e);
		}
	}

	private void reporteVehiculosEliminados2015(HttpServletRequest request,HttpServletResponse response) 
	{
		
		try 
		{
            response.setContentType("image/png");
			
			ServletOutputStream sos=response.getOutputStream();
			DefaultCategoryDataset dcd=new DefaultCategoryDataset();
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%Vehiculo eliminado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=1"), "Grafica", "Enero");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%Vehiculo eliminado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=2"), "Grafica", "Febrero");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%Vehiculo eliminado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=3"), "Grafica", "Marzo");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%Vehiculo eliminado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=4"), "Grafica", "Abril");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%Vehiculo eliminado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=5"), "Grafica", "Mayo");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%Vehiculo eliminado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=6"), "Grafica", "Junio");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%Vehiculo eliminado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=7"), "Grafica", "Julio");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%Vehiculo eliminado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=8"), "Grafica", "Agosto");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%Vehiculo eliminado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=9"), "Grafica", "Septiembre");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%Vehiculo eliminado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=10"), "Grafica", "Octubre");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%Vehiculo eliminado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=11"), "Grafica", "Noviembre");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%Vehiculo eliminado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=12"), "Grafica", "Diciembre");
			
			
			
			JFreeChart chart = ChartFactory.createBarChart("Vehiculos Eliminados 2015", "Meses","Cantidad", dcd, PlotOrientation.VERTICAL,false, true, false);
		
			RenderedImage chartImage = chart.createBufferedImage(1300, 900);
			ImageIO.write(chartImage, "png", sos);
			sos.flush();
			sos.close();
		}
		catch (Exception e) 
		{
			System.out.println("Error --> reporteVehiculosEliminados2015() SvGestionaVehiculo: "+e);
		}
	}


	private void reporteVehiculosRegistrado2015(HttpServletRequest request,HttpServletResponse response) 
	{
		try 
		{
            response.setContentType("image/png");
			
			ServletOutputStream sos=response.getOutputStream();
			DefaultCategoryDataset dcd=new DefaultCategoryDataset();
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%Vehiculo registrado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=1"), "Grafica", "Enero");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%Vehiculo registrado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=2"), "Grafica", "Febrero");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%Vehiculo registrado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=3"), "Grafica", "Marzo");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%Vehiculo registrado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=4"), "Grafica", "Abril");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%Vehiculo registrado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=5"), "Grafica", "Mayo");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%Vehiculo registrado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=6"), "Grafica", "Junio");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%Vehiculo registrado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=7"), "Grafica", "Julio");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%Vehiculo registrado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=8"), "Grafica", "Agosto");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%Vehiculo registrado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=9"), "Grafica", "Septiembre");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%Vehiculo registrado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=10"), "Grafica", "Octubre");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%Vehiculo registrado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=11"), "Grafica", "Noviembre");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%Vehiculo registrado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=12"), "Grafica", "Diciembre");
			
			
			
			JFreeChart chart = ChartFactory.createBarChart("Vehiculos Registrados 2015", "Meses","Cantidad", dcd, PlotOrientation.VERTICAL,false, true, false);
		
			RenderedImage chartImage = chart.createBufferedImage(1300, 900);
			ImageIO.write(chartImage, "png", sos);
			sos.flush();
			sos.close();
		}
		catch (Exception e) 
		{
			System.out.println("Error --> reporteVehiculosRegistrado2015() SvGestionaVehiculo: "+e);
		}
	}









	/*Empleado*/
	private void empleado(HttpServletRequest request, HttpServletResponse response) 
	{
		try 
		{
			
            String tipoReporte=request.getParameter("tipoReporte");
			
			if (tipoReporte.equals("reporteEmpleadosRegistrado2015")) 
			{
			this.reporteEmpleadosRegistrado2015(request, response);	
			}
			else if(tipoReporte.equals("reporteEmpleadosEliminados2015"))
			{
			this.reporteEmpleadosEliminados2015(request, response);
			}
			else if(tipoReporte.equals("reporteTiposEmpleado"))
			{
			this.reporteTiposEmpleado(request, response);
			}
			
		}
		catch (Exception e) 
		{
			System.out.println("Error --> empleado() SvGestionaEmpleado: "+e);
		}
		
	}

	private void reporteTiposEmpleado(HttpServletRequest request, HttpServletResponse response) 
	{
		try 
		{
            response.setContentType("image/png");
			
			ServletOutputStream sos=response.getOutputStream();
			DefaultCategoryDataset dcd=new DefaultCategoryDataset();
			dcd.addValue(se.countQuery("SELECT count(*) FROM TB_EMPLEADO WHERE idTipoEmpleado=1"), "Grafica", "ADMINISTRADOR");
			dcd.addValue(se.countQuery("SELECT count(*) FROM TB_EMPLEADO WHERE idTipoEmpleado=2"), "Grafica", "RECEPCIONISTA");
			dcd.addValue(se.countQuery("SELECT count(*) FROM TB_EMPLEADO WHERE idTipoEmpleado=3"), "Grafica", "CONDUCTOR");
			dcd.addValue(se.countQuery("SELECT count(*) FROM TB_EMPLEADO WHERE idTipoEmpleado=4"), "Grafica", "ESTIBADOR");

			JFreeChart chart = ChartFactory.createBarChart("Tipos de Empleado registrados", "Tipo de empleado","Cantidad", dcd, PlotOrientation.VERTICAL,false, true, false);
		
			RenderedImage chartImage = chart.createBufferedImage(1300, 900);
			ImageIO.write(chartImage, "png", sos);
			sos.flush();
			sos.close();
		}
		catch (Exception e) 
		{
			System.out.println("Error --> reporteTiposEmpleado() SvGestionaEmpleado: "+e);
		}
		
	}

	private void reporteEmpleadosEliminados2015(HttpServletRequest request, HttpServletResponse response) 
	{
		
		try 
		{
            response.setContentType("image/png");
			
			ServletOutputStream sos=response.getOutputStream();
			DefaultCategoryDataset dcd=new DefaultCategoryDataset();
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%Empleado eliminado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=1"), "Grafica", "Enero");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%Empleado eliminado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=2"), "Grafica", "Febrero");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%Empleado eliminado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=3"), "Grafica", "Marzo");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%Empleado eliminado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=4"), "Grafica", "Abril");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%Empleado eliminado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=5"), "Grafica", "Mayo");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%Empleado eliminado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=6"), "Grafica", "Junio");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%Empleado eliminado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=7"), "Grafica", "Julio");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%Empleado eliminado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=8"), "Grafica", "Agosto");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%Empleado eliminado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=9"), "Grafica", "Septiembre");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%Empleado eliminado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=10"), "Grafica", "Octubre");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%Empleado eliminado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=11"), "Grafica", "Noviembre");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%Empleado eliminado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=12"), "Grafica", "Diciembre");

			
			JFreeChart chart = ChartFactory.createBarChart("Empleados Eliminados 2015", "Meses","Cantidad", dcd, PlotOrientation.VERTICAL,false, true, false);
		
			RenderedImage chartImage = chart.createBufferedImage(1300, 900);
			ImageIO.write(chartImage, "png", sos);
			sos.flush();
			sos.close();
		}
		catch (Exception e) 
		{
			System.out.println("Error --> reporteEmpleadosEliminados2015() SvGestionaEmpleado: "+e);
		}	
		
	}

	private void reporteEmpleadosRegistrado2015(HttpServletRequest request, HttpServletResponse response) 
	{
		try 
		{
            response.setContentType("image/png");
			
			ServletOutputStream sos=response.getOutputStream();
			DefaultCategoryDataset dcd=new DefaultCategoryDataset();
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%Empleado registrado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=1"), "Grafica", "Enero");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%Empleado registrado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=2"), "Grafica", "Febrero");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%Empleado registrado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=3"), "Grafica", "Marzo");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%Empleado registrado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=4"), "Grafica", "Abril");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%Empleado registrado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=5"), "Grafica", "Mayo");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%Empleado registrado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=6"), "Grafica", "Junio");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%Empleado registrado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=7"), "Grafica", "Julio");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%Empleado registrado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=8"), "Grafica", "Agosto");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%Empleado registrado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=9"), "Grafica", "Septiembre");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%Empleado registrado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=10"), "Grafica", "Octubre");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%Empleado registrado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=11"), "Grafica", "Noviembre");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%Empleado registrado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=12"), "Grafica", "Diciembre");

			
			JFreeChart chart = ChartFactory.createBarChart("Empleados Registrado 2015", "Meses","Cantidad", dcd, PlotOrientation.VERTICAL,false, true, false);
		
			RenderedImage chartImage = chart.createBufferedImage(1300, 900);
			ImageIO.write(chartImage, "png", sos);
			sos.flush();
			sos.close();
		}
		catch (Exception e) 
		{
			System.out.println("Error --> reporteEmpleadosRegistrado2015() SvGestionaEmpleado: "+e);
		}	
	}
	
	
	
	
	
	
	
	
	/*Cliente*/
	private void cliente(HttpServletRequest request, HttpServletResponse response) 
	{
		try 
		{
			
			
			String tipoReporte=request.getParameter("tipoReporte");
			
			if (tipoReporte.equals("reporteClientesRegistrado2015")) 
			{
			this.reporteClientesRegistrado2015(request, response);	
			}
			else if(tipoReporte.equals("reporteClientesEliminados2015"))
			{
			this.reporteClientesEliminados2015(request, response);
			}
			else if(tipoReporte.equals("reporteTiposCliente"))
			{
			this.reporteTiposCliente(request, response);
			}
			
			
		
		}
		catch (Exception e) 
		{
			System.out.println("Error --> clientes SvGestionGrafico(): "+e);
		}
		
	}

	private void reporteTiposCliente(HttpServletRequest request, HttpServletResponse response)
	{

		try 
		{
	
			response.setContentType("image/png");
			
			ServletOutputStream sos=response.getOutputStream();
			DefaultCategoryDataset dcd=new DefaultCategoryDataset();
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_CLIENTE WHERE idTipoCliente=1"), "Grafica", "Juridico");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_CLIENTE WHERE idTipoCliente=2"), "Grafica", "Natural");


			JFreeChart chart = ChartFactory.createBarChart("Tipos de Cliente registrados", "Tipo de cliente","Cantidad", dcd, PlotOrientation.VERTICAL,false, true, false);
		
			RenderedImage chartImage = chart.createBufferedImage(1300, 900);
			ImageIO.write(chartImage, "png", sos);
			sos.flush();
			sos.close();
			
		}
		catch (Exception e) 
		{
			System.out.println("Error --> reporteTiposCliente() SvGestionaGrafico: "+e);
		}	
	}

	private void reporteClientesEliminados2015(HttpServletRequest request, HttpServletResponse response) 
	{
		
		try 
		{
	
			response.setContentType("image/png");
			
			ServletOutputStream sos=response.getOutputStream();
			DefaultCategoryDataset dcd=new DefaultCategoryDataset();
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%Cliente eliminado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=1"), "Grafica", "Enero");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%Cliente eliminado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=2"), "Grafica", "Febrero");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%Cliente eliminado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=3"), "Grafica", "Marzo");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%Cliente eliminado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=4"), "Grafica", "Abril");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%Cliente eliminado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=5"), "Grafica", "Mayo");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%Cliente eliminado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=6"), "Grafica", "Junio");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%Cliente eliminado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=7"), "Grafica", "Julio");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%Cliente eliminado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=8"), "Grafica", "Agosto");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%Cliente eliminado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=9"), "Grafica", "Septiembre");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%Cliente eliminado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=10"), "Grafica", "Octubre");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%Cliente eliminado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=11"), "Grafica", "Noviembre");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%Cliente eliminado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=12"), "Grafica", "Diciembre");

			JFreeChart chart = ChartFactory.createBarChart("Clientes Eliminados en 2015", "Meses","Cantidad", dcd, PlotOrientation.VERTICAL,false, true, false);
		
			RenderedImage chartImage = chart.createBufferedImage(1300, 900);
			ImageIO.write(chartImage, "png", sos);
			sos.flush();
			sos.close();
			
		}
		catch (Exception e) 
		{
			System.out.println("reporteClientesRegistrado2015() SvGestionaGrafico: "+e);
		}
	}

	private void reporteClientesRegistrado2015(HttpServletRequest request, HttpServletResponse response)
	{
		try 
		{
		
			
			/*
			 Contexto de devolucion 
		    */
			response.setContentType("image/png");
			
			ServletOutputStream sos=response.getOutputStream();
			DefaultCategoryDataset dcd=new DefaultCategoryDataset();
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%Cliente registrado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=1"), "Grafica", "Enero");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%Cliente registrado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=2"), "Grafica", "Febrero");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%Cliente registrado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=3"), "Grafica", "Marzo");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%Cliente registrado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=4"), "Grafica", "Abril");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%Cliente registrado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=5"), "Grafica", "Mayo");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%Cliente registrado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=6"), "Grafica", "Junio");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%Cliente registrado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=7"), "Grafica", "Julio");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%Cliente registrado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=8"), "Grafica", "Agosto");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%Cliente registrado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=9"), "Grafica", "Septiembre");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%Cliente registrado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=10"), "Grafica", "Octubre");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%Cliente registrado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=11"), "Grafica", "Noviembre");
			dcd.addValue(se.countQuery("SELECT COUNT(*) FROM TB_LOGGENERAL WHERE descripcion LIKE '%Cliente registrado:%' AND YEAR(fecha)=2015 AND MONTH(fecha)=12"), "Grafica", "Diciembre");

			JFreeChart chart = ChartFactory.createBarChart("Clientes Registrados en 2015", "Meses","Cantidad", dcd, PlotOrientation.VERTICAL,false, true, false);
		
			RenderedImage chartImage = chart.createBufferedImage(1300, 900);
			ImageIO.write(chartImage, "png", sos);
			sos.flush();
			sos.close();
			
		}
		catch (Exception e) 
		{
			System.out.println("reporteClientesRegistrado2015() SvGestionaGrafico: "+e);
		}
		
	}

}
