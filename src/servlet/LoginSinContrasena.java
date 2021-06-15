package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.filter.ComprobacionToken;

import tienda.controlador.ControladorLogin;





public class LoginSinContrasena extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int id_cola=ComprobacionToken.vertificaidColaToken(req);
		
		if(id_cola==0) {
			
			resp.sendRedirect(req.getContextPath()+"/pages/login.jsp");
			
		}else {
			
			ControladorLogin controlador=new ControladorLogin();
			
			if(!controlador.buscaFehcaColaEsHoy(id_cola)) {
				
				controlador.crearcola(id_cola);
			}
			
			resp.sendRedirect(req.getContextPath()+"/pagefunciones/siguiente.jsp");
			
		}
	
		
	}
	
	
	
}
