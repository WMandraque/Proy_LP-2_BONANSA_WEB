package etiquetas;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;
import javax.sql.rowset.CachedRowSet;

import extras.ServicioEntidades;

public class cboTipoDocumento extends TagSupport {
	
	
	//Atributo
	private String idTipoDocumento;

	public String getIdTipoDocumento() {
		return idTipoDocumento;
	}




	public void setIdTipoDocumento(String idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}




	@Override
	public int doStartTag() throws JspException {
		
		try {
			
			JspWriter out=pageContext.getOut();
			out.println("<select class='select'name='cboTipoDocumento'>");
			if(getIdTipoDocumento().equals("1") || getIdTipoDocumento().equals("")){
				out.println("<option value='1'>DNI</option>");
				out.println("<option value='2'>RUC</option>");
			}
			else if(getIdTipoDocumento().equals("2")){
				out.println("<option value='2'>RUC</option>");
				out.println("<option value='1'>DNI</option>");
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
