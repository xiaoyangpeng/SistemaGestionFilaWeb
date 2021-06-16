package com.web.servlet.managefunction.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.json.CrearJson;
import com.web.filter.ComprobacionToken;
import com.web.servlet.managefunction.controlador.darnumero.ControladorDarNumero;


@WebServlet("/darnumero")
public class DarNumero extends HttpServlet {
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int id_cola=ComprobacionToken.vertificaidColaToken(req);
		
		ControladorDarNumero darnumero=new ControladorDarNumero(id_cola);
		
		String formatoJson=CrearJson.crearJson(darnumero.incorporar());
		
		resp.setContentType("application/json;charset=UTF-8");
		resp.setCharacterEncoding("utf-8");
		PrintWriter out = new PrintWriter(resp.getOutputStream());
		out.print(formatoJson);
		out.flush();
		out.close();
		
	}

}
