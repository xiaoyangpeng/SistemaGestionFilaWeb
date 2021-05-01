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

public class MandarListaProductoUsuario extends HttpServlet

{
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		
		String id_cola=req.getParameter("idcola");
		String id_usuario=req.getParameter("idusuario");
		
		
	
		BuscaListaProductoUsuario buscaListaProductoUsuario=new BuscaListaProductoUsuario(Integer.parseInt(id_cola),Integer.parseInt(id_usuario));
		
		
		ListaProductoAux listaProductoAux=new ListaProductoAux();
		
		listaProductoAux.setListaproducto(buscaListaProductoUsuario.buscar());
		
		
		// 调用GSON jar工具包封装好的toJson方法，可直接生成JSON字符串
		Gson gson=new GsonBuilder().setPrettyPrinting().create();
		
		
		String json= gson.toJson(listaProductoAux);
		
		
		resp.setContentType("application/json;charset=UTF-8");
		resp.setCharacterEncoding("utf-8");
		PrintWriter out = new PrintWriter(resp.getOutputStream());
		out.print(json);
		out.flush();
		
		out.close();
		
		
	}
	
	
	
	
	

}

