package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tienda.controlador.ControladorLogin;
import tienda.controlador.ControladorSign;

public class ActivacionCuenta extends HttpServlet {

	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub


	String codigoActivacion=req.getParameter("codigoActivacion");
		

	ControladorLogin activar=new ControladorLogin();
	
	boolean correcto=activar.probarCodigoActivacion((String)req.getSession().getAttribute("email"), req.getParameter("codigoActivacion"));

		if(correcto) {
			
			
			req.getRequestDispatcher("pages/login.jsp").forward(req, resp);
			
		}else {
			
			
			req.setAttribute("msg", "Codigo incorrecto");
			
			req.getRequestDispatcher("pages/codigoActivacion.jsp").forward(req, resp);
		}
		
	}
	
}

