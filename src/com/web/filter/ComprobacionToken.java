package com.web.filter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.dao.utils.BaseDao;
import com.token.JwtUtil;

public class ComprobacionToken{

	
	
	
	public static int vertificaidColaToken(HttpServletRequest req) {
		

		int id_cola=0;
		
		Cookie[] cookies=req.getCookies();
		
		if(cookies!=null) {
				for(Cookie c:cookies) {
					
					if(c.getName().equals("token")) {
						
						id_cola=JwtUtil.vertificar_id_cola(c.getValue());
						break;
					}
				
					
				}
		}
		return id_cola;
		
	}
	
	public static int vertificaIdTienda(HttpServletRequest req) {
		

		int id_tienda=0;
		
		Cookie[] cookies=req.getCookies();
		
		
		if(cookies!=null) {
		for(Cookie c:cookies) {
			
			if(c.getName().equals("token")) {
				
				id_tienda=JwtUtil.vettificar_id_tienda(c.getValue());

				break;
			}
		
			
		}
		}
		return id_tienda;
		
	}
	

	
}
