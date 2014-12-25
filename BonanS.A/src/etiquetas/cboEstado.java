package etiquetas;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;
import javax.sql.rowset.CachedRowSet;

import extras.ServicioEntidades;

public class cboEstado extends TagSupport {
	
	
	//Atributo
	private String idEstado;
	
	
	//Servicio a usar:
	ServicioEntidades sEntidades=new ServicioEntidades();

	public String getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(String idEstado) {
		this.idEstado = idEstado;
	}
	
	
	//Metodo que recibe el idEstado para definir el query
	public String getQuery(String paramQuery) {

		switch (paramQuery) {
		case "":
			return "select*From tb_estado;";
	
		default:
			return "select*From tb_estado where idEstado="+getIdEstado();
		}
	}
	
	
	
	

	@Override
	public int doStartTag() throws JspException {
		
		try {
			
			JspWriter out=pageContext.getOut();
			String writterInicial="<select class='select'name='cboEstado'>";
			
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
			
			if(getIdEstado().equals("")){
				
					CachedRowSet crs=sEntidades.listadoEntidades(getQuery(""));
					
					while (crs.next()) {
						String idEstado=crs.getString(1);
						String descEstado=crs.getString(2);
						out.println("<option value='" + idEstado + "'>" + descEstado+ "</option>");
					}
			}
			else{
					CachedRowSet crs=sEntidades.listadoEntidades(getQuery(getIdEstado()));
					if(crs.next()){
						String idEstado=crs.getString(1);
						String descEstado=crs.getString(2);
						out.println("<option value='" + idEstado + "'>" + descEstado+ "</option>");
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
			
			if(getIdEstado().equals("")){
	
		    }
			else{
					CachedRowSet crs=sEntidades.listadoEntidades("select*From tb_estado where idEstado!="+getIdEstado());
					while(crs.next()){
						String idEstado=crs.getString(1);
						String descEstado=crs.getString(2);
						out.println("<option value='" + idEstado + "'>" + descEstado+ "</option>");
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
