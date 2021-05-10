package com.manda.android;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.token.JwtUtil;

public class FiltroAndroid {

	
	
	public static int filtro(HttpServletRequest httpServletRequest,HttpServletResponse  httpServletResponse) {
		
		
		String cabeza= httpServletRequest.getHeader("Authorization");
		
		if(cabeza==null) {
			
			return 0;
		}else {
			
			cabeza=cabeza.replace("Bearer","");
			cabeza=cabeza.trim();
		}
		
		return JwtUtil.vertificar_id_usuario(cabeza);
		
	}
	
	
}
