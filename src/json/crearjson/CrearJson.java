package json.crearjson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class CrearJson {

	
	public static String crearJson(Object objeto) {
		
		// 调用GSON jar工具包封装好的toJson方法，可直接生成JSON字符串
		Gson gson=new GsonBuilder().setPrettyPrinting().create();
		
		
		String json=gson.toJson(objeto);
		
		return json;
	}
	
	
}
