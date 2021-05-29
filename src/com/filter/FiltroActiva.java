package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;

import oracle.net.aso.h;



public class FiltroActiva {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		
		HttpServletRequest httpServletRequest=(HttpServletRequest) request;
		
		if(
				httpServletRequest.getSession()==null) {
			
			httpServletRequest.getRequestDispatcher("/pages/login.jsp").forward(request, response);
			
		}else {
			
			
			chain.doFilter(request, response);
		}
		
	}

	
	
	
}
