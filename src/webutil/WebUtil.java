package webutil;

import java.util.Iterator;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

public class WebUtil {
	  public static <T> T copyParamToBean( Map value , T bean ){
	        try {
	        	
	        	
	  
	        		
	        		System.out.println(value.get("nombre"));
	        		System.out.println(value.get("sexo"));
	        		System.out.println(value.get("email"));
	            System.out.println("开始  " + bean);
	            
	            
	            BeanUtils.populate(bean, value);
	            System.out.println("结束   " + bean);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return bean;
	    }
}
