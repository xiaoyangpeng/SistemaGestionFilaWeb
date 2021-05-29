package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mandarEmail.Email;

import tienda.controlador.ControladorLogin;
import variables.GeneraCodigo;




@WebServlet("/activacuenta")
public class MandaEmailActivacion extends HttpServlet {
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		String email=(String)req.getSession().getAttribute("email");
		
		String codigoActiva=GeneraCodigo.LetraAleatoria(4);
		
		ControladorLogin cambia=new ControladorLogin();
		
		cambia.cambairCodigoActivacion(email, codigoActiva);
		
		Email mandaemail=new Email(email,codigoActiva);
		
		mandaemail.mantar("activa", codigoActiva);
			
		req.getRequestDispatcher("pages/codigoActivacion.jsp").forward(req, resp);
	
	}

}
