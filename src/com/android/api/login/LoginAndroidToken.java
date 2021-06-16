package com.android.api.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.android.api.login.controlador.RespuestaLogin;
import com.android.filtro.FiltroAndroid;
import com.json.CrearJson;
import com.token.JwtUtil;


@WebServlet("/androidlogin/token")
public class LoginAndroidToken extends HttpServlet{

	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int id_usuario=FiltroAndroid.filtro(req, resp);
		String result="";
		if(id_usuario==0) {
			
			result="-1";
		}else {
			
			result="5";
		}
		
		
		resp.setContentType("application/json;charset=UTF-8");
		resp.setCharacterEncoding("utf-8");
		PrintWriter out = new PrintWriter(resp.getOutputStream());
	
		String json=null;
	
		RespuestaLogin repuesta=new RespuestaLogin(result);
		 json=	CrearJson.crearJson(repuesta);
		
	 	out.print(json);
		out.flush();
		out.close();
		
	}
}
