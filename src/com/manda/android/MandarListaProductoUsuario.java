package com.manda.android;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.manda.android.controlador.BuscaListaProductoUsuario;
import com.manda.android.controlador.ListaProducto;
import com.manda.android.controlador.ListaProductoAux;

import json.crearjson.CrearJson;
import variables.RespuestaAndroid;

public class MandarListaProductoUsuario extends HttpServlet

{
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		int id_usuarioaux=FiltroAndroid.filtro(req, resp);
		
		String id_cola=req.getParameter("idcola");
		String id_usuario=req.getParameter("idusuario");
		


		if(Integer.parseInt(id_usuario)==id_usuarioaux) {
		
		BuscaListaProductoUsuario buscaListaProductoUsuario=new BuscaListaProductoUsuario(Integer.parseInt(id_cola),Integer.parseInt(id_usuario));
		
		
		ListaProductoAux listaProductoAux=new ListaProductoAux();
		
		listaProductoAux.setListaproducto(buscaListaProductoUsuario.buscar());
		

		String json= CrearJson.crearJson(listaProductoAux);		
		
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

