package com.web.servlet.managefunction.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.filter.ComprobacionToken;
import com.web.servlet.managefunction.controlador.gestionfila.ActivacionFila;



@WebServlet("/gestionfila")
public class GestionFila extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		String activar=req.getParameter("checkbox");
		
		int id_cola=ComprobacionToken.vertificaidColaToken(req);
		
			ActivacionFila controladoFila=new ActivacionFila();
		if(activar!=null && activar.equals("on")) {
			
			
			controladoFila.activarFila(id_cola);
		}else {
			
			controladoFila.desactivarFila(id_cola);
		}
		
		
		req.getRequestDispatcher("/pagefunciones/siguiente.jsp").forward(req, resp);
	}
	
}
