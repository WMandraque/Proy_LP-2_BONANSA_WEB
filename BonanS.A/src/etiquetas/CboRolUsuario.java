package etiquetas;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

import javax.servlet.jsp.tagext.TagSupport;
import javax.sql.rowset.CachedRowSet;

import extras.ServicioEntidades;

public class CboRolUsuario extends TagSupport {
	
	//Atributo
	private String idRol;
	
	ServicioEntidades sEntidades=new ServicioEntidades();
	CachedRowSet crs=null;

	public String getIdRol() {
		return idRol;
	}

	public void setIdRol(String idRol) {
		this.idRol = idRol;
	}
	
	public String getQuery(String paramQuery){
		switch (paramQuery) {
		case "":
			return "SELECT * FROM tb_rol";

		default:
			return "SELECT * FROM tb_rol WHERE idRol="+getIdRol();
		}
	}

	@Override
	public int doStartTag() throws JspException {
		try {
			JspWriter out=pageContext.getOut();
			String writerInicio="<select  class='select' name='cboRolUsuario'>";
			out.println(writerInicio);
			writterCuerpo();
			
		} catch (Exception e) {
			throw new JspException(e.getMessage());
		}
		return SKIP_BODY;
	}
	
	

private void writterCuerpo() {
		
		try {
			
			JspWriter out=pageContext.getOut();
			
			if(getIdRol().equals("")){
				
					CachedRowSet crs=sEntidades.listadoEntidades(getQuery(""));
					
					while (crs.next()) {
						String idRol=crs.getString(1);
						String descRol=crs.getString(2);
						out.println("<option value='" + idRol + "'>" + descRol+ "</option>");
					}
			}
			else{
					CachedRowSet crs=sEntidades.listadoEntidades(getQuery(getIdRol()));
					if(crs.next()){
						String idRol=crs.getString(1);
						String descRol=crs.getString(2);
						out.println("<option value='" + idRol + "'>" + descRol+ "</option>");
					}
					
					
			}
			
			writterFinal();
			
		} catch (Exception e) {
			System.out.println("Error el writter cuerpo: "+e);
		}
		
	}

	private void writterFinal() {
		try {
			
			JspWriter out=pageContext.getOut();
			
			if(getIdRol().equals("")){
	
		    }
			else{
					CachedRowSet crs=sEntidades.listadoEntidades("SELECT * FROM tb_rol WHERE idRol!="+getIdRol());
					while(crs.next()){
						String idRol=crs.getString(1);
						String descRol=crs.getString(2);
						out.println("<option value='" + idRol + "'>" + descRol+ "</option>");
					}
					
			  
			}
			
			 out.println("</select>");
		} catch (Exception e) {
			System.out.println("Error en el writter Final: "+e);
		}
		
	}

	@Override
	public int doEndTag() throws JspException {
		
		return EVAL_PAGE;
	}



}
