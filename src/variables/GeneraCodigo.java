package variables;



import org.apache.commons.lang3.RandomStringUtils;

public class GeneraCodigo {

	
	public static String LetraAleatoria(int cuanto) {
		
		return RandomStringUtils.randomAlphanumeric(cuanto);
		
	}
	
	
}
