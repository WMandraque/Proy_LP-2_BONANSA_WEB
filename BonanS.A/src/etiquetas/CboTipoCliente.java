package etiquetas;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import javax.sql.rowset.CachedRowSet;

import extras.ServicioEntidades;

public class CboTipoCliente extends TagSupport{

	
	
	ServicioEntidades sEntidades=new ServicioEntidades();
	
	private int idTipoCliente;
	
	
	public int getIdTipoCliente() {
		return idTipoCliente;
	}

	public void setIdTipoCliente(int idTipoCliente) {
		this.idTipoCliente = idTipoCliente;
	}
	
	
	
	private String getQuery(int paramQuery){
		switch (paramQuery) {
		case 0:
			return "select*From tb_tipo_cliente";
		default:
			return "select*From tb_tipo_cliente where="+getIdTipoCliente();
		}
	}

	@Override
	public int doStartTag() throws JspException {
		
		
		
		try {
			
			JspWriter out=pageContext.getOut();
			String writterInicial="<select class='select'name='cboTipoCliente' id='cboTipoCliente' >";
			out.println(writterInicial);
			writterCuerpo();
		} catch (Exception e) {
			throw new JspException(e.getMessage());
		}
		return SKIP_BODY;
	}
	
	private void writterCuerpo() {
		CachedRowSet crs=null;
		try {
			JspWriter out=pageContext.getOut();
			out.println("<option value='0'>SELECCIONA</option>");
			if (getIdTipoCliente()==0) {
		
				crs=sEntidades.listadoEntidades(getQuery(0));
					
				while (crs.next()) {
					int idTipoCliente=crs.getInt(1);
					String descTipoCliente=crs.getString(2);
					out.println("<option value='" + idTipoCliente + "'>" + descTipoCliente+ "</option>");	
					
				}
				
			}
			else{
				
				crs=sEntidades.listadoEntidades(getQuery(getIdTipoCliente()));
				if(crs.next()) {
					int idTipoCliente=crs.getInt(1);
					String descTipoCliente=crs.getString(2);
					out.println("<option value='" + idTipoCliente + "'>" + descTipoCliente+ "</option>");	
					
				}
			}
			
			writterFinal();
			
		} catch (Exception e) {
			System.out.println("Error en el writterCuerpo: "+e);
		}
		
	}

	private void writterFinal() {
		
		CachedRowSet crs=null;
		
		try {
			JspWriter out=pageContext.getOut();
			
			if (getIdTipoCliente()==0) {
				
				out.println("</select>");
			}
			else{
				
				crs=sEntidades.listadoEntidades("select*From tb_estado where idEstado!="+getIdTipoCliente());
				while(crs.next()){
					int idTipoCliente=crs.getInt(1);
					String descTipoCliente=crs.getString(2);
					out.println("<option value='" + idTipoCliente + "'>" + descTipoCliente+ "</option>");	
					
				}
				
				out.println("</select>");
			}
			
			
		} catch (Exception e) {
			System.out.println("Error en el writterFinal:" +e);
		}
		
	}

	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		return EVAL_PAGE;
	}


}
