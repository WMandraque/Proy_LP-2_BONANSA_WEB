package etiquetas;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

public class CboClaseLicenciaConductor extends TagSupport{
	
	
	
	private int idCategorialic;
	

	public int getIdCategorialic() {
		return idCategorialic;
	}

	public void setIdCategorialic(int idCategorialic) {
		this.idCategorialic = idCategorialic;
	}

	
	
	
	
	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
