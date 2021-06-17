package com.android.api.incorporar.remota;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.android.filtro.FiltroAndroid;

import variables.RespuestaAndroid;



@WebServlet("/incorporarRemota")
public class IncorporarRemota extends HttpServlet{

	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id_user=FiltroAndroid.filtro(req, resp);
		
		
		if(id_user!=0) {
			
			
			String tiempoQuiere=req.getParameter("tiempo");
			
			String id_cola=req.getParameter("id_cola");
			
			ControladorIncorporarRemota remota=new ControladorIncorporarRemota(Integer.parseInt(tiempoQuiere),
					Integer.parseInt(id_cola),id_user);
			
			
			boolean respuesta=remota.buscarSiYaestaDentrodeLacola();
			
			resp.setContentType("text/plain;charset=UTF-8");
			resp.setCharacterEncoding("utf-8");
			
			PrintWriter out = new PrintWriter(resp.getOutputStream());
			out.print(respuesta);
			out.flush();
			
			out.close();
			
			
		}else {
			resp.setStatus(RespuestaAndroid.NO_HAY_AUTORIZACION);
		}
		
		
		
	}
	
	
}
