package variables;

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
	

}
