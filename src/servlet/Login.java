package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.Session;

import com.token.JwtUtil;

import tienda.controlador.ControladorLogin;
import variables.ResultadoLogin;
import variables.ResultadoLogin.*;



public class Login extends HttpServlet{

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		String email=req.getParameter("email");
		
		int contrasena=req.getParameter("password").hashCode();
	
		
		
		req.setCharacterEncoding("UTF-8");
		
		ControladorLogin login=new ControladorLogin();
		
		
		int res=login.mandarInformacionAcceso(email, contrasena);
		
		switch (res) {
		
		// exito
		case 1:
		
			req.getSession();
			
			crearTokenyCookie(resp,email,contrasena,login);
			
			//req.getRequestDispatcher("pagefunciones/siguiente.jsp").forward(req, resp);
			
			resp.sendRedirect(req.getContextPath()+"/pagefunciones/siguiente.jsp");
		
			break;
			
		case -1 :
			req.setAttribute("msg","Email o Contraseña incorrecto");
			
			req.getRequestDispatcher("pages/login.jsp").forward(req, resp);
			
			break;
		case 2:
			
	
			req.getSession().setAttribute("email", req.getParameter("email"));
			
			req.setAttribute("msg","No esta acticado <a href=\"http://localhost:8088/proyectoFinalEntrada/pages/codigoActivacion.jsp\">Activa mi cuenta</a>");
			
			req.getRequestDispatcher("pages/login.jsp").forward(req, resp);
			
			break;
		default:
			break;
		}
		
		
		

			
			
	
			
			// error contraseña
	
		
	}
	
	/*@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		
		//System.out.println(req.getParameter("ok"));
		
		resp.setContentType("text/plain");
		resp.setCharacterEncoding("utf-8");
		PrintWriter out = new PrintWriter(resp.getOutputStream());
		out.print("asdfdsfadsfdsafasfsfsf");
		out.flush();
	}*/
	
	
	
	public void crearTokenyCookie( HttpServletResponse resp,String email, int contrasena,ControladorLogin login) {
		
		
		
		String token=	JwtUtil.crearTokenWeb(email, contrasena, login.crearcola(),login.buscarIdTienda(email));
		
		Cookie cookie=new Cookie("token",token);
		
		resp.setContentType("text/html; charset=UTF-8");
		
		resp.addCookie(cookie);
	}
	
	
	
	
}
