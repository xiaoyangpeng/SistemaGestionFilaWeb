package com.android.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.token.JwtUtil;

import json.crearjson.CrearJson;


@WebServlet("/androidlogin")
public class LoginAndroid extends HttpServlet{

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String email=req.getParameter("email");
	
		String password=req.getParameter("password");
		
		 ControladorUsuarioLogin login=new ControladorUsuarioLogin();
		 
		 int correcto=login.mandarInformacionAcceso(email, password.hashCode());
		
		
			resp.setContentType("application/json;charset=UTF-8");
			resp.setCharacterEncoding("utf-8");
			PrintWriter out = new PrintWriter(resp.getOutputStream());
		
			String json=null;
		 
		
		 if(correcto==1) {
			 
			 String token= JwtUtil.crearAndoird(email,login.buscarIdUsuario(email));
			 
			// resp.setStatus(200);
			 
			RespuestaLogin repuesta=new RespuestaLogin(token);
			 json=	CrearJson.crearJson(repuesta);
			 
		
		 }
		 else {
			 RespuestaLogin repuesta=new RespuestaLogin(String.valueOf(correcto));
			 json=	CrearJson.crearJson(repuesta);
			 
			
		 }
		 
		 	out.print(json);
			out.flush();
			out.close();
		
	}
	
}
