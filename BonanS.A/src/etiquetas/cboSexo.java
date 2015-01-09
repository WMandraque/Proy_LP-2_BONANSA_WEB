package etiquetas;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;
import javax.sql.rowset.CachedRowSet;

import extras.ServicioEntidades;

public class cboSexo extends TagSupport {
	
	
	//Atributo
	private String idSexo;

	public String getIdSexo() {
		return idSexo;
	}

	public void setIdSexo(String idSexo) {
		this.idSexo = idSexo;
	}




	@Override
	public int doStartTag() throws JspException {
		
		try {
			
			JspWriter out=pageContext.getOut();
			out.println("<select class='select'name='cboSexo'>");
			if(getIdSexo().equals("M") || getIdSexo().equals("")){
				out.println("<option value='M'>MASCULINO</option>");
				out.println("<option value='F'>FEMENINO</option>");
			}
			else if(getIdSexo().equals("F")){
				out.println("<option value='F'>FEMENINO</option>");
				out.println("<option value='M'>MASCULINO</option>");
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
