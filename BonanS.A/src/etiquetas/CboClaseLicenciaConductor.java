package etiquetas;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;
import javax.sql.rowset.CachedRowSet;

import org.apache.poi.hssf.util.HSSFColor.SKY_BLUE;

import extras.ServicioEntidades;

public class CboClaseLicenciaConductor extends TagSupport{
	
	
	
	private int idClaselic;
	
	public int getIdClaselic() {
		return idClaselic;
	}



	public void setIdClaselic(int idClaselic) {
		this.idClaselic = idClaselic;
	}

	CachedRowSet crs=null;
	ServicioEntidades sEntidades=new ServicioEntidades();

	
	
	private String getQuery(int paramQuery){
		switch (paramQuery) {
		case 0:
			return "SELECT * FROM tb_claselicencia_conductor";
		default:
			return "SELECT * FROM tb_claselicencia_conductor WHERE idClaselic="+getIdClaselic();
		}
	}
	
	
	
	@Override
	public int doStartTag() throws JspException{
		try {
			JspWriter out=pageContext.getOut();
			String writerInicio="<select  class='select' name='cboClaseLicenciaConductor'>";
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
			if (getIdClaselic()==0) {
				crs=sEntidades.listadoEntidades(getQuery(0));
				while (crs.next()) {
					int idClaselic=crs.getInt(1);
					String descClaselic=crs.getString(2);
					out.println("<option value='" + idClaselic + "'>" + descClaselic+ "</option>");
				}
				
			}else{
				crs=sEntidades.listadoEntidades(getQuery(getIdClaselic()));
				if (crs.next()) {
					int idClaselic=crs.getInt(1);
					String descClaselic=crs.getString(2);
					out.println("<option value='" + idClaselic + "'>" + descClaselic+ "</option>");
				}
			}
			writerFinal();
		} catch (Exception e) {
			System.out.println("Error en el writerCuerpo: "+e);
		}
		
	}

	private void writerFinal() {
		try {
			
			JspWriter out = pageContext.getOut();

			if (getIdClaselic() == 0) {
			} else {
				crs = sEntidades.listadoEntidades("SELECT * FROM tb_claselicencia_conductor WHERE idClaselic!="+getIdClaselic());
				while (crs.next()) {
					int idClaselic=crs.getInt(1);
					String descClaselic=crs.getString(2);
					out.println("<option value='" + idClaselic + "'>" + descClaselic+ "</option>");
				}
			}

		  out.println("</select>");
		} catch (Exception e) {
			System.out.println("Error en el writerFinal: "+e);
		}
	}



	@Override
	public int doEndTag() throws JspException{ 
		// TODO Auto-generated method stub
		return EVAL_PAGE;
	}

	

}
