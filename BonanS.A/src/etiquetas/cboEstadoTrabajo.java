package etiquetas;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;
import javax.sql.rowset.CachedRowSet;

import extras.ServicioEntidades;

public class cboEstadoTrabajo extends TagSupport {
	
	
	//Atributo
	private String idEstadoTrabajo;

	
    ServicioEntidades sEntidades=new ServicioEntidades();
	
	public String getIdEstadoTrabajo() {
		return idEstadoTrabajo;
	}

	public void setIdEstadoTrabajo(String idEstadoTrabajo) {
		this.idEstadoTrabajo = idEstadoTrabajo;
	}

	
	
	public String getQuery(String paramQuery){
	
		switch (paramQuery) {
		case "":
			
			return "Select*from tb_estadoTrabajo";

		default:
			return "Select*from tb_estadoTrabajo where idEstadoTrabajo="+getIdEstadoTrabajo();
		}
		
		
		
	}


	@Override
	public int doStartTag() throws JspException {
		try {
			
			JspWriter out=pageContext.getOut();
			String writterInicial="<select class='select'name='cboEstadoTrabajo'>";
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
			
			if (getIdEstadoTrabajo().equals("")) {
				
				CachedRowSet crs=sEntidades.listadoEntidades(getQuery(""));
				
				while(crs.next()){
					String idEstadoTrabajo=crs.getString(1);
					String descEstado=crs.getString(2);
					
					out.println("<option value='" + idEstadoTrabajo + "'>" + descEstado+ "</option>");	
				}
				
			}else{
				
               CachedRowSet crs=sEntidades.listadoEntidades(getQuery(getIdEstadoTrabajo()));
				
				if(crs.next()){
					String idEstadoTrabajo=crs.getString(1);
					String descEstado=crs.getString(2);
					
					out.println("<option value='" + idEstadoTrabajo + "'>" + descEstado+ "</option>");	
				}	
			}
			
			writterFinal();
			
		} catch (Exception e) {
			System.out.println("Error en el writterCuerpo: "+e);
		}
			
	}

	private void writterFinal() {
		
		try {
			

			JspWriter out=pageContext.getOut();
			CachedRowSet crs;
			
			if (getIdEstadoTrabajo().equals("")) {
				
				out.println("</select>");
			}
			else{
				
				crs=sEntidades.listadoEntidades("select*From tb_estado where idEstado!="+getIdEstadoTrabajo());
				while(crs.next()){
					String idEstadoTrabajo=crs.getString(1);
					String descEstado=crs.getString(2);
					
					out.println("<option value='" + idEstadoTrabajo + "'>" + descEstado+ "</option>");
				}
				
				out.println("</select>");
			}
			
		} catch (Exception e) {
			System.out.println("Error en el writterFinal: "+e);
		}
		
	}

	@Override
	public int doEndTag() throws JspException {
		
		return EVAL_PAGE;
	}


}
