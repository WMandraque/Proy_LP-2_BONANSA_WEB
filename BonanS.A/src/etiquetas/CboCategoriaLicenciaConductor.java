package etiquetas;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;
import javax.sql.rowset.CachedRowSet;

import org.apache.poi.hssf.util.HSSFColor.SKY_BLUE;

import extras.ServicioEntidades;

public class CboCategoriaLicenciaConductor extends TagSupport {
	
	//Atributo
	private int idCategorialic;
	
	ServicioEntidades sEntidades=new ServicioEntidades();
	CachedRowSet crs=null;

	public int getIdCategorialic() {
		return idCategorialic;
	}

	public void setIdCategorialic(int idCategorialic) {
		this.idCategorialic = idCategorialic;
	}
	
	public String getQuery(int paramQuery){
		switch (paramQuery) {
		case 0:
			return "SELECT * FROM tb_categorialicencia_conductor";

		default:
			return "SELECT * FROM tb_categorialicencia_conductor WHERE idCategorialic="+getIdCategorialic();
		}
	}

	@Override
	public int doStartTag() throws JspException {
		try {
			JspWriter out=pageContext.getOut();
			String writerInicio="<select  class='select' name='cboCategoriaLicenciaConductor'>";
			out.println(writerInicio);
			writerCuerpo();
			
		} catch (Exception e) {
			throw new JspException(e.getMessage());
		}
		return SKIP_BODY;
	}
	
	

	
	private void writerCuerpo() {
		try {
			JspWriter out=pageContext.getOut();
			if (getIdCategorialic()==0) {
                crs=sEntidades.listadoEntidades(getQuery(0));
				while(crs.next()){
					int idCategorialic=crs.getInt(1);
					String descCategorialic=crs.getString(2);
					out.println("<option value='" + idCategorialic + "'>" + descCategorialic+ "</option>");	
			}
				
			}else{
				 crs=sEntidades.listadoEntidades(getQuery(0));
				 if(crs.next()){
						int idCategorialic=crs.getInt(1);
						String descCategorialic=crs.getString(2);
						out.println("<option value='" + idCategorialic + "'>" + descCategorialic+ "</option>");	
					}
			}
			
			writerFinal();
		} catch (Exception e) {
			System.out.println("Error el writerCuerpo: "+e);
		}
		
	}

	private void writerFinal() {
		
try {
			

			JspWriter out=pageContext.getOut();
			CachedRowSet crs;
			
			if (getIdCategorialic()==0) {
			}
			else{
				
				crs=sEntidades.listadoEntidades("SELECT * FROM tb_categorialicencia_conductor WHERE idCategorialic!="+getIdCategorialic());
				while(crs.next()){
					String idEstadoTrabajo=crs.getString(1);
					String descEstado=crs.getString(2);
					
					out.println("<option value='" + idEstadoTrabajo + "'>" + descEstado+ "</option>");
				}
				
				
			}
			
			out.println("</select>");
		} catch (Exception e) {
			System.out.println("Error en el writterFinal: "+e);
		}
		
	}

	@Override
	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}


	
}
