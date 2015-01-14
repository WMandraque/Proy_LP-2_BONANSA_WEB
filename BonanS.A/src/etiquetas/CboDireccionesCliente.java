package etiquetas;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import javax.sql.rowset.CachedRowSet;

import extras.ServicioEntidades;

public class CboDireccionesCliente extends TagSupport {
	
	//Atributo
	private String idCliente;
	
	
	ServicioEntidades sEntidades=new ServicioEntidades();
	CachedRowSet crs=null;

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}
	

	@Override
	public int doStartTag() throws JspException {
		
	try 
	{
			JspWriter out=pageContext.getOut();
			out.println("<select class='select' name='cboDireccionesCliente' id='cboDireccionesCliente'>");
			
			
			 if(getIdCliente().equals(""))
			 {		
			        out.println("<option value='M'>ELIGA UN CLIENTE</option>");
		     }
		     else
		     {
					CachedRowSet crs=sEntidades.listadoEntidades("select*from tb_direccionescliente where idCliente='"+getIdCliente()+"'");
					
					while(crs.next()){
						String direcciones=crs.getString(3);
						String ubigeo=crs.getString(4);
						out.println("<option value='" + ubigeo +":"+direcciones+ "'>" + direcciones+ "</option>");
						
					}
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
