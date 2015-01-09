package etiquetas;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;
import javax.sql.rowset.CachedRowSet;

import org.apache.poi.hssf.util.HSSFColor.SKY_BLUE;

import extras.ServicioEntidades;

public class CboTipoUnidadMedida extends TagSupport {
	
	//Atributo
	private int idTipoUnidadMedida;
	
	ServicioEntidades sEntidades=new ServicioEntidades();
	CachedRowSet crs=null;

	public int getIdTipoUnidadMedida() {
		return idTipoUnidadMedida;
	}

	public void setIdTipoUnidadMedida(int idTipoUnidadMedida) {
		this.idTipoUnidadMedida = idTipoUnidadMedida;
	}

	public String getQuery(int paramQuery){
		switch (paramQuery) {
		case 0:
			return "SELECT * FROM tb_tipoUnidadMedida";

		default:
			return "SELECT * FROM tb_tipoUnidadMedida WHERE idTipoUnidadMedida="+getIdTipoUnidadMedida();
		}
	}

	@Override
	public int doStartTag() throws JspException {
		try {
			JspWriter out=pageContext.getOut();
			String writerInicio="<select  class='select' name='cboTipoUnidadMedida' id='cboTipoUnidadMedida'>";
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
			if (getIdTipoUnidadMedida()==0) {
                crs=sEntidades.listadoEntidades(getQuery(0));
				while(crs.next()){
					int idTipoUnidadMedida=crs.getInt(1);
					String descTipoUnidadMedida=crs.getString(2);
					out.println("<option value='" + idTipoUnidadMedida + "'>" + descTipoUnidadMedida+ "</option>");	
				}
				
			}else{
				 crs=sEntidades.listadoEntidades(getQuery(0));
				 if(crs.next()){
					   int idTipoUnidadMedida=crs.getInt(1);
						String descTipoUnidadMedida=crs.getString(2);
						out.println("<option value='" + idTipoUnidadMedida + "'>" + descTipoUnidadMedida+ "</option>");	
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
			
			if (getIdTipoUnidadMedida()==0) {
			}
			else{
				
				crs=sEntidades.listadoEntidades("SELECT * FROM tb_tipoUnidadMedida WHERE idTipoUnidadMedida !="+getIdTipoUnidadMedida());
				while(crs.next()){
					   int idTipoUnidadMedida=crs.getInt(1);
					   String descTipoUnidadMedida=crs.getString(2);
					   out.println("<option value='" + idTipoUnidadMedida + "'>" + descTipoUnidadMedida+ "</option>");	
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
