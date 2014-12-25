package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bonansa.beans.LogDTO;
import com.bonansa.services.LogService;

/**
 * Servlet implementation class SvGestionaLog
 */
@WebServlet("/SvGestionaLog")
public class SvGestionaLog extends HttpServlet {
	private static final long serialVersionUID = 1L;


	
	
	LogService sLog=new LogService();
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			String operacion=request.getParameter("operacion");
			
			System.out.println("Llego al servide del log");
			
			if(operacion.equals("listar")){
				this.listar(request, response);
			}
			
		} catch (Exception e) {
			System.out.println("Error en el service del log: "+e);
		}
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			
			HttpSession sesionX=request.getSession();
			ArrayList<LogDTO> listadoLogs=sLog.listaLog();
			
			System.out.println(listadoLogs.size());
			sesionX.setAttribute("listadoLogs", listadoLogs);
			request.getRequestDispatcher("paLog.jsp").forward(request, response);
			
		} catch (Exception e) {
			System.out.println("Error al listarLog: "+e);
		}
		
	}

}
