package com.web.servlet.managefunction.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.android.api.impletProductos.ListaProducto;
import com.android.api.impletProductos.ListaProductoAux;
import com.android.api.mandalistproductoUsuario.controlador.BuscaListaProductoUsuario;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.web.filter.ComprobacionToken;






@WebServlet("/listausuarioweb")
public class MandarListaProductoUsuarioWeb extends HttpServlet

{
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		
		int id_cola=ComprobacionToken.vertificaidColaToken(req);
		String id_usuario=req.getParameter("idusuario");
		
	
		BuscaListaProductoUsuario buscaListaProductoUsuario=new BuscaListaProductoUsuario(id_cola,Integer.parseInt(id_usuario));
		
		
		ArrayList<ListaProducto> listaproductoaux=buscaListaProductoUsuario.buscar();
		
		// 调用GSON jar工具包封装好的toJson方法，可直接生成JSON字符串
		Gson gson=new GsonBuilder().setPrettyPrinting().create();
		
		
		String json= gson.toJson(listaproductoaux);
		
		
		resp.setContentType("application/json;charset=UTF-8");
		resp.setCharacterEncoding("utf-8");
		PrintWriter out = new PrintWriter(resp.getOutputStream());
		out.print(json);
		out.flush();
		
		out.close();
		
		
		
		System.out.println(json);
		
	}
	
	
	
	
	

}
