package extras;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ServicioFechas {
	
	
	public String ip_formatearFechaMySQL(String fechaI)
	{
		
	String fechaO = null;	
		
	try {
		
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf2=new SimpleDateFormat("yyyy/MM/dd");
		Date fechaD=null;
		fechaD=sdf.parse(fechaI);
		
		fechaO=sdf2.format(fechaD);
		
	} catch (Exception e) {
		System.out.println("Error al formatear fechas para ingresar al mysql: "+e);
	}
		
	return fechaO;
	}
	
	
	public String op_formatearFechaMySQL(String fechaI)
	{
		
	String fechaO = null;	
		
	try {
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2=new SimpleDateFormat("dd/MM/yyyy");
		Date fechaD=null;
		fechaD=sdf.parse(fechaI);
		
		fechaO=sdf2.format(fechaD);
		
	} catch (Exception e) {
		System.out.println("Error al formatear fechas para ingresar al mysql: "+e);
	}
		
	return fechaO;
	}
	
	
	

}
