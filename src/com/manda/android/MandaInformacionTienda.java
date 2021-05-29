package com.manda.android;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.manda.android.controlador.buscatienda.ControladorBuscarTienda;
import com.manda.android.controlador.buscatienda.TiendaArray;

import json.crearjson.CrearJson;
import variables.RespuestaAndroid;

public class MandaInformacionTienda extends HttpServlet{

	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		int id_usuario=FiltroAndroid.filtro(req, resp);
		
		if(id_usuario!=0) {
			
		String nombre=req.getParameter("nombre");
		
	
		TiendaArray tiendaArray=new TiendaArray();
		
		ControladorBuscarTienda buscaTienda=new ControladorBuscarTienda(nombre);
		
		tiendaArray.setTiendaArray(buscaTienda.buscaTienda());
	
		String formatoJson=CrearJson.crearJson(tiendaArray);
	
		resp.setContentType("application/json;charset=UTF-8");
		resp.setCharacterEncoding("utf-8");
		PrintWriter out = new PrintWriter(resp.getOutputStream());
		out.print(formatoJson);
		out.flush();
		out.close();
		}else {
			
			resp.setStatus(RespuestaAndroid.NO_HAY_AUTORIZACION);
		}
	}
	
}
