package etiquetas;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import javax.sql.rowset.CachedRowSet;



import extras.ServicioEntidades;

public class CboTipoEmpleado extends TagSupport {

	
	//Atributo
	private int idTipoEmpleado;
	
	//Servicio
	ServicioEntidades sEntidades=new ServicioEntidades();
	
	
	//Datos desconectados
	CachedRowSet crs=null;
	
	
	public int getIdTipoEmpleado() {
		return idTipoEmpleado;
	}



	public void setIdTipoEmpleado(int idTipoEmpleado) {
		this.idTipoEmpleado = idTipoEmpleado;
	}



	public String getQuery(int paramQuery){
		
		switch (paramQuery) {
		case 0:
			return "SELECT*FROM tb_tipo_empleado";

		default:
			return "SELECT*FROM tb_tipo_empleado where idTipoEmpleado="+getIdTipoEmpleado();
		}
	}
	
	@Override
	public int doEndTag() throws JspException {
		try {
			
			JspWriter out=pageContext.getOut();
			String writterInicial="<select class='select' name='cboTipoEmpleado' id='cboTipoEmpleado' >";
			out.println(writterInicial);
			writterCuerpo();
			
		} catch (Exception e) {
			throw new JspException(e.getMessage());
		}
		return SKIP_BODY;
	}

	private void writterCuerpo() {
		try {
			
			JspWriter out=pageContext.getOut();
			out.println("<option value='void'>SELECCIONA</option>");
			if (getIdTipoEmpleado()==0){
				
				crs=sEntidades.listadoEntidades(getQuery(0));
				while (crs.next()) {
					int idTipoEmpleado=crs.getInt(1);
					String nomCargo=crs.getString(2);
					out.println("<option value='" + idTipoEmpleado + "'>" + nomCargo+ "</option>");
				}
				
				
			}
			else{
				crs=sEntidades.listadoEntidades(getQuery(getIdTipoEmpleado()));
				if(crs.next()) {
					int idTipoEmpleado=crs.getInt(1);
					String nomCargo=crs.getString(2);
					out.println("<option value='" + idTipoEmpleado + "'>" + nomCargo+ "</option>");
				}
				
			}
			
			writterFinal();
		} catch (Exception e) {
			System.out.println("Error en writter cuerpo!!: "+e);
		}
		
	}



	private void writterFinal() {
		
		try {
			
			JspWriter out=pageContext.getOut();
			
			if(getIdTipoEmpleado()==0){
			}
			else{
				
				crs=sEntidades.listadoEntidades("SELECT*FROM tb_tipo_empleado where idTipoEmpleado!="+getIdTipoEmpleado());
				while (crs.next()) {
					int idTipoEmpleado=crs.getInt(1);
					String nomCargo=crs.getString(2);
					out.println("<option value='" + idTipoEmpleado + "'>" + nomCargo+ "</option>");
				}
				
				
			}
			out.println("</select>");
		} catch (Exception e) {
			System.out.println("Error en el writter final!!: "+e);
		}
	
		
	}



	@Override
	public int doStartTag() throws JspException {
		
		return EVAL_PAGE;
	}

	

}
