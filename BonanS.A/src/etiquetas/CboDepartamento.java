package etiquetas;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;
import javax.sql.rowset.CachedRowSet;

import extras.ServicioEntidades;

public class CboDepartamento extends TagSupport{

	
	
	private String codubigeo;
	
	public String getCodubigeo() {
		return codubigeo;
	}


	public void setCodubigeo(String codubigeo) {
		this.codubigeo = codubigeo;
	}


	CachedRowSet crs=null;
	ServicioEntidades sEntidades=new ServicioEntidades();
	
	
	private String getQuery(String paramQuery){
		switch (paramQuery) {
		case "":
			return "SELECT * FROM tb_ubigeo WHERE codprov = 0 AND coddist = 0";

		default:
		    return "SELECT * FROM tb_ubigeo WHERE coddpto ="+getCodubigeo() +" AND coddist = 0 AND codprov <> 0";
		}
	}

	
	@Override
	public int doEndTag() throws JspException {
		try {
			
			    JspWriter out=pageContext.getOut();
				String writterInicial="<select class='select'name='cboDepartamento' id='cboDepartamento'>";
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
					
					if (getCodubigeo().equals("")) {
								
								crs=sEntidades.listadoEntidades(getQuery(""));
								out.println("<option value=''>SELECCIONE</option>");
								while(crs.next()){
									int coddpto=crs.getInt(2);
									String nombre=crs.getString(5);
									out.println("<option value='" + coddpto + "'>" + nombre+ "</option>");
									
								}
								
					}
					else{
						
						
								crs=sEntidades.listadoEntidades(getQuery(getCodubigeo()));
								if(crs.next()){
									String codubigeo=crs.getString(1);
									String nombre=crs.getString(5);
									out.println("<option value='" + codubigeo + "'>" + nombre+ "</option>");
					     }
					
		              }
					
					writterFinal();
		} catch (Exception e) {
			System.out.println("Error en el cuerpo: "+e);
		}
		
	}


	private void writterFinal() {
		try {
			
			JspWriter out=pageContext.getOut();
			
			if(getCodubigeo().equals("")){
				
				out.println("</select>");
			}
			else{
				
				crs=sEntidades.listadoEntidades(getQuery(""));
				while(crs.next()){
					String codubigeo=crs.getString(1);
					String nombre=crs.getString(5);
					out.println("<option value='" + codubigeo + "'>" + nombre+ "</option>");
					
				}
				
			}
			
			out.println("</select>");
			
		} catch (Exception e) {
			System.out.println("Error en el writterFinal: "+e);
		}
		
	}


	@Override
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		return 0;
	}


}
