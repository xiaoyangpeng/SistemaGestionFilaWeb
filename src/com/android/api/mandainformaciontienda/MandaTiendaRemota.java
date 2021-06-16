package com.android.api.mandainformaciontienda;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.android.api.mandainformaciontienda.controlador.ControladorInfTienda;
import com.android.filtro.FiltroAndroid;
import com.json.CrearJson;

import variables.RespuestaAndroid;


@WebServlet("/mandatiendaremota")
public class MandaTiendaRemota  extends HttpServlet

{
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id_usuarioaux=FiltroAndroid.filtro(req, resp);
		
		
		if(id_usuarioaux!=0) {
		
		String id_tienda=req.getParameter("idtienda");

		

		ControladorInfTienda remota=new ControladorInfTienda(Integer.parseInt(id_tienda));
		
		remota.turnoActualTiempo();
		
		
		String json=	CrearJson.crearJson(remota.getRemota());
		
	
		
		System.out.println(json);
		resp.setContentType("application/json;charset=UTF-8");
		resp.setCharacterEncoding("utf-8");
		PrintWriter out = new PrintWriter(resp.getOutputStream());
		out.print(json);
		out.flush();
		
		out.close();
		}else {
			
			
			resp.setStatus(RespuestaAndroid.NO_HAY_AUTORIZACION);
		}
		

		
	}
	
	
	
	
	

}
