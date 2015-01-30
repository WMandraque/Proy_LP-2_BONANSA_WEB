package etiquetas;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;
import javax.sql.rowset.CachedRowSet;

import extras.ServicioEntidades;

public class CboEstadoIncidencia extends TagSupport {
	
	
	//Atributo
		private String idEstadoIncidencia;



		public String getIdEstadoIncidencia() {
			return idEstadoIncidencia;
		}




		public void setIdEstadoIncidencia(String idEstadoIncidencia) {
			this.idEstadoIncidencia = idEstadoIncidencia;
		}




		@Override
		public int doStartTag() throws JspException {
			
			try {
				
				JspWriter out=pageContext.getOut();
				out.println("<select class='select'name='cboEstadoIncidencia'>");
				if(getIdEstadoIncidencia().equals("")){
					out.println("<option value=''>SELECCIONE</option>");
					out.println("<option value='0'>PENDIENTE</option>");
					out.println("<option value='1'>APROBADA</option>");
				}
				else if(getIdEstadoIncidencia().equals("0"))
				{
					out.println("<option value='0'>PENDIENTE</option>");
					out.println("<option value=''>SELECCIONE</option>");
					out.println("<option value='1'>APROBADA</option>");
				}
				else if(getIdEstadoIncidencia().equals("1"))
				{
					out.println("<option value='1'>APROBADA</option>");
					out.println("<option value='0'>PENDIENTE</option>");
					out.println("<option value=''>SELECCIONE</option>");

				}

				out.println("</select>");
			} catch (Exception e) {
				throw new JspException(e.getMessage());
			}
			return SKIP_BODY;
		}
		

		

		@Override
		public int doEndTag() throws JspException {
			
			return EVAL_PAGE;
		}




}
