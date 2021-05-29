package com.filter;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(filterName = "CharsetFilter",
urlPatterns = 
{"/qr",/*ͨ�����*����ʾ�����е�web��Դ��������*/
"/siguiente",
"/listausuarioweb",
"/manager/*",
"/cargarmenu",
"/pagefunciones/*"

},
initParams = {
        @WebInitParam(name = "charset", value = "utf-8")/*������Է�һЩ��ʼ���Ĳ���*/
})

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
		
		HttpServletResponse httpServletResponse=(	HttpServletResponse )response;
		
		
		String basePath=	httpServletRequest.getScheme()
				+"://"
				+	httpServletRequest.getServerName()
				+":"
				+	httpServletRequest.getServerPort()
				+	httpServletRequest.getContextPath();
		
		
		
		
		int id_tienda=ComprobacionToken.vertificaIdTienda(httpServletRequest);
		
		// aun no ha hecho su login
		if(id_tienda==0) {
			
	
			
			httpServletResponse.sendRedirect(basePath+"/pages/login.jsp");
		
			
			// ya ha hehco su login
		}else {
			/*if(httpServletRequest.getSession()==null) {
				
				httpServletRequest.getRequestDispatcher("/entrada").forward(request, response);
				
			}else {*/
				chain.doFilter(request, response);
			//}
		
			
		}
		
	}
		

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	
	}
			

}
