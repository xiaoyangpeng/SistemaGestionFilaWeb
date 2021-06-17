package com.web.servlet.manageraccount.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mandarEmail.Email;
import com.mandarEmail.MandarEmailRecuperarContrasena;
import com.token.JWTContrasena;
import com.web.servlet.manageraccount.controlador.ControladorContrasena;

import variables.UrlEmailRecuperaContrasena;


@WebServlet("/recupera")
public class RecuperaContrasena extends HttpServlet {

	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String email=req.getParameter("codigoActivacion");
		
		ControladorContrasena vertifica=new ControladorContrasena();
		
		int id_usuario=vertifica.existeUsuario(email);
		
		int id_tienda=vertifica.existeEmialTienda(email);
		
		
		
		
		if(id_tienda!=0) {
			
			emailCorrecto(req, resp);
			
			
			MandarEmailRecuperarContrasena manda=new MandarEmailRecuperarContrasena(email, "tienda", id_tienda);
			
			
			manda.start();
			
		}else if(id_usuario!=0) {
			
			emailCorrecto(req, resp);
			
			MandarEmailRecuperarContrasena manda=new MandarEmailRecuperarContrasena(email, "usuario", id_usuario);
			
			manda.start();
			
		}else {
			
			
			emaiIncorrecto(req, resp);
		}
		
		


	}
	


	
	private void emailCorrecto(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		req.setAttribute("valido", true);
		
		
		req.setAttribute("mensaje", "Ya te hemos enviado a su email");
		
		req.getRequestDispatcher("pages/recuperacontrasena.jsp").forward(req, resp);
	
	}
	
	private void emaiIncorrecto(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		
		req.setAttribute("mensaje", "No existe Este Email");
		
		req.getRequestDispatcher("pages/recuperacontrasena.jsp").forward(req, resp);
	}
	
	
}
