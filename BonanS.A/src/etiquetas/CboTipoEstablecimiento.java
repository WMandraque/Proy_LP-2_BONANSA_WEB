package etiquetas;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;
import javax.sql.rowset.CachedRowSet;

import org.apache.poi.hssf.util.HSSFColor.SKY_BLUE;

import extras.ServicioEntidades;

public class CboTipoEstablecimiento extends TagSupport {

    
	
	//Servicio
	ServicioEntidades sEntidades=new ServicioEntidades();
	
	//Crs
	CachedRowSet crs=null;
	
	//Atributo
	private int idTipoEstablec;

	public int getIdTipoEstablec() {
		return idTipoEstablec;
	}


	public void setIdTipoEstablec(int idTipoEstablec) {
		this.idTipoEstablec = idTipoEstablec;
	}
	
	
	
	public String getQuery(int paramQuery){
		
		switch (paramQuery) {
		case 0:
			return "select*From tb_tipoestablecimiento";

		default:
			return "select*From tb_tipoestablecimiento where="+getIdTipoEstablec();
		}
	}


	@Override
	public int doStartTag() throws JspException {
		
		try {
			
			JspWriter out=pageContext.getOut();
			String writterInicial="<select class='select' name='cboTipoEstablecimiento'  id='cboTipoEstablecimiento'>";
			out.println(writterInicial);
			writterCuerpo();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return SKIP_BODY;
	}

	
	private void writterCuerpo() {
		try {
			JspWriter out=pageContext.getOut();
			if (getIdTipoEstablec()==0) {
				
				crs=sEntidades.listadoEntidades(getQuery(0));
				while(crs.next()){
					int idTipoEstablec=crs.getInt(1);
					String descTipoEstablec=crs.getString(3);
					out.println("<option value='" + idTipoEstablec + "'>" + descTipoEstablec+ "</option>");
				}
			}else{

				crs=sEntidades.listadoEntidades(getQuery(getIdTipoEstablec()));
				if(crs.next()){
					int idTipoEstablec=crs.getInt(1);
					String descTipoEstablec=crs.getString(3);
					out.println("<option value='" + idTipoEstablec + "'>" + descTipoEstablec+ "</option>");
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
			if (getIdTipoEstablec()==0) {
				out.println("</select>");
				
			}else{

				crs=sEntidades.listadoEntidades("select*From tb_tipoestablecimiento where idEstado!="+getIdTipoEstablec());
				while(crs.next()){
					int idTipoEstablec=crs.getInt(1);
					String descTipoEstablec=crs.getString(3);
					out.println("<option value='" + idTipoEstablec + "'>" + descTipoEstablec+ "</option>");
					
				}
				
				out.println("</select>");
				
			}
			
			
			
		} catch (Exception e) {
			System.out.println("Error en el cuerpo: "+e);
		}
		
	}


	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
