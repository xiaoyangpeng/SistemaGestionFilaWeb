package variables;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FechaYhora {


	
	
	public static String fechaHoy() {
		
		
		Date now = new Date();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
	
		return sdf.format(now);
	
	}
	
	public static String horaMomento() {
		
		
		Date now = new Date();
		
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	
		return sdf.format(now);
	
	}
	
	public static Long StringtoDaLong(String fecha) {
		
		 SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		 
		 Date date = null;
		try {
			date = (Date)formatter.parse(fecha);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 return date.getTime();
	}
	

}
