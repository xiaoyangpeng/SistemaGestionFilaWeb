package com.filter;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

import oracle.net.aso.h;

public class ManagerFilter implements Filter{

	

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		
	

		HttpServletRequest httpServletRequest=(HttpServletRequest) request;
		
		int id_cola=ComprobacionToken.vertificaSihayToken(httpServletRequest);
		
		// aun no ha hecho su login
		if(id_cola==0) {
			
			httpServletRequest.getRequestDispatcher("/pages/login.jsp").forward(request, response);
			
			
			// ya ha hehco su login
		}else {
			
			chain.doFilter(request, response);
			
		}
		
	}
		

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	
	}
			

}
