package com.filter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.token.JwtUtil;

public class ComprobacionToken {

	
	
	
	public static int vertificaSihayToken(HttpServletRequest req) {
		

		int id_cola=0;
		
		Cookie[] cookies=req.getCookies();
		
		for(Cookie c:cookies) {
			
			if(c.getName().equals("token")) {
				
				id_cola=JwtUtil.vertificar(c.getValue());
				break;
			}
		
			
		}
		
		return id_cola;
		
	}
	
	public static int vertificaIdTienda(HttpServletRequest req) {
		

		int id_tienda=0;
		
		Cookie[] cookies=req.getCookies();
		
		for(Cookie c:cookies) {
			
			if(c.getName().equals("token")) {
				
				id_tienda=JwtUtil.vettificar_id_tienda(c.getValue());
				break;
			}
		
			
		}
		
		return id_tienda;
		
	}
	
	
}
