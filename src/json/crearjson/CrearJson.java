package json.crearjson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class CrearJson {

	
	public static String crearJson(Object objeto) {
		
		// ����GSON jar���߰���װ�õ�toJson��������ֱ������JSON�ַ���
		Gson gson=new GsonBuilder().setPrettyPrinting().create();
		
		
		String json=gson.toJson(objeto);
		
		return json;
	}
	
	
}
