package etiquetas;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import javax.sql.rowset.CachedRowSet;

import extras.ServicioEntidades;

public class cboCategoriaVehiculo extends TagSupport {

	ServicioEntidades sE = new ServicioEntidades();

	// Atributo como parametro de entrada
	public int idCatVeh;

	public void setIdCatVeh(int idCatVeh) {
		this.idCatVeh = idCatVeh;
	}

	public int getIdCatVeh() {
		return idCatVeh;
	}

	public String getQuery(int tipoQuery) {

		switch (tipoQuery) {
		case 0:
			return "select*From tb_categoriavehiculo";

		default:
			return "select*From tb_categoriavehiculo where idCategoriaVeh="
					+ getIdCatVeh();
		}
	}

	@Override
	public int doEndTag() throws JspException {

		try {

			JspWriter out = pageContext.getOut();
			String writterInicio = "<select  class='select' name='cboCategoriaVehiculo'>";

			out.println(writterInicio);
			writterCuerpo();

		} catch (Exception e) {
			throw new JspException(e.getMessage());
		}
		return SKIP_BODY;
	}

	public void writterCuerpo() {

		try {

			JspWriter out = pageContext.getOut();

			if (idCatVeh == 0) {

				CachedRowSet crs = sE.listadoEntidades(getQuery(0));
				while (crs.next()) {
					int idCatVeh = crs.getInt(1);
					String desCatVeh = crs.getString(2);
					out.println("<option value='" + idCatVeh + "'>" + desCatVeh+ "</option>");
				}

			} else {

				CachedRowSet crs = sE.listadoEntidades(getQuery(getIdCatVeh()));
				while (crs.next()) {
					int idCatVeh = crs.getInt(1);
					String desCatVeh = crs.getString(2);
					out.println("<option value='" + idCatVeh + "'>" + desCatVeh+ "</option>");
				}

			}

			writterFinal();

		} catch (Exception e) {
			System.out.println("Error en la escritura del cuerpo: " + e);
		}

	}

	public void writterFinal() {

		try {

			JspWriter out = pageContext.getOut();

			if (idCatVeh == 0) {
				
				out.println("</select>");

				
			} else {
				
				CachedRowSet crs = sE.listadoEntidades("Select*from tb_categoriavehiculo where  idCategoriaVeh!="+ getIdCatVeh());
				while (crs.next()) {
					int idCatVeh = crs.getInt(1);
					String desCatVeh = crs.getString(2);
					out.println("<option value='" + idCatVeh + "'>" + desCatVeh+ "</option>");
				}
				out.println("</select>");
				
			}

		} catch (Exception e) {
			System.out.println("Error en la escritura final: " + e);
		}
	}

	@Override
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		return EVAL_PAGE;
	}

}
