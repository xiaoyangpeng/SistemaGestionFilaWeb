package com.web.servlet.managefunction.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.filter.ComprobacionToken;
import com.web.servlet.managefunction.controlador.gestionfila.ActivacionFila;



@WebServlet("/cargarmenu")
public class CargaActicaDesFila extends HttpServlet{

	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		int id_cola=ComprobacionToken.vertificaidColaToken(req);
		
		ActivacionFila fila=new ActivacionFila();
		
		boolean activado=fila.estaActivado(id_cola);
		
		if(activado) {
			
			req.setAttribute("activado", activado);
		}
		
		req.getRequestDispatcher("/pagefunciones/generaqr.jsp").forward(req, resp);
		
			
	}
	
}
