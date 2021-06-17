package com.android.api.informacionfila;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.android.filtro.FiltroAndroid;

import variables.RespuestaAndroid;

@WebServlet("/estaenfila")
public class MandaSiEstaEnFila extends HttpServlet  {

	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int id_user=FiltroAndroid.filtro(req, resp);
		
		if(id_user!=0) {
			
			
			ControladorInformacionCola infCola=new ControladorInformacionCola();
			
			String esta=infCola.BuscaIdCola(id_user);
			
			boolean estaEncola=(esta!=null);
			

			resp.setContentType("text/plain;charset=UTF-8");
			resp.setCharacterEncoding("utf-8");
			
			PrintWriter out = new PrintWriter(resp.getOutputStream());
			out.print(estaEncola);
			out.flush();
			
			out.close();
			
		}else {
			resp.setStatus(RespuestaAndroid.NO_HAY_AUTORIZACION);
		}
		
	}
	
}
