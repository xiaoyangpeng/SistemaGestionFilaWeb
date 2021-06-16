package com.web.servlet.manageraccount.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.token.JWTContrasena;
import com.web.servlet.manageraccount.controlador.ControladorContrasena;

import variables.RespuestaAndroid;




@WebServlet("/cambiacontrasena")
public class CambiaContrasena extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String token=req.getParameter("token");
		
		int id=JWTContrasena.vettificar_id(token);
		if(id!=0) {
	
		req.setAttribute("token", token);
		req.getRequestDispatcher("pages/reestablecer.jsp").forward(req, resp);
		
		}else {
			
			resp.setStatus(RespuestaAndroid.NO_HAY_AUTORIZACION);
		}
	
	

	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String token=req.getParameter("token");
	
		String rol=JWTContrasena.vertificaRol(token);
	
		String password=req.getParameter("password");
		
		
		int id=JWTContrasena.vettificar_id(token);
		
		if(rol!=null) {
			
		
			ControladorContrasena recupera=new ControladorContrasena();
			
			if(rol.equals("\"tienda\"")) {
				
				recupera.reestablecerTienda(password.hashCode(), id);
				
			}else if(rol.equals("\"usuario\"")){
				
				recupera.resetabalceerUsuario(password.hashCode(), id);
				
			}
	
			resp.sendRedirect(req.getContextPath()+"/entrada");
			
		}else {
			
			
			resp.setStatus(RespuestaAndroid.NO_HAY_AUTORIZACION);
		}
	
		
		
	}
	
}
