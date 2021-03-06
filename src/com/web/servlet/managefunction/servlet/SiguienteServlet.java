package com.web.servlet.managefunction.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.json.CrearJson;
import com.token.JwtUtil;
import com.web.filter.ComprobacionToken;
import com.web.servlet.managefunction.controlador.siguiente.ControladorSiguiente;
import com.web.servlet.managefunction.controlador.siguiente.UsuarioEnCola;



@WebServlet("/siguiente")
public class SiguienteServlet extends HttpServlet{
	
		
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	int id_cola=ComprobacionToken.vertificaidColaToken(req);
		
		
		if(id_cola!=0) {
		
				ControladorSiguiente siguiente=new ControladorSiguiente();
		
				String valor=req.getParameter("siguiente");
				
				if(valor!=null&&valor.equals("true")) {
					
				
					siguiente.llamaSiguiente(id_cola);
		
				}
				
		
				ArrayList<UsuarioEnCola> usuarioencola=new ArrayList<>();
				
				usuarioencola=siguiente.getTodosTurno(id_cola);
				
				String formatoJson=CrearJson.crearJson(usuarioencola);
				
				resp.setContentType("application/json;charset=UTF-8");
				resp.setCharacterEncoding("utf-8");
				PrintWriter out = new PrintWriter(resp.getOutputStream());
				out.print(formatoJson);
				out.flush();
				out.close();
		
		}else {
			
	
			resp.setContentType("application/json;charset=UTF-8");
			resp.setCharacterEncoding("utf-8");
			
			PrintWriter out = new PrintWriter(resp.getOutputStream());
			out.write("<script language='javasrcipt'>alert('No se puede borrar Cookie');</script>");
		
			out.flush();
			out.close();
		}
		
		

	}
	
	
	
}
