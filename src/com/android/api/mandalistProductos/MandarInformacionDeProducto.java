package com.android.api.mandalistProductos;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;import org.apache.commons.dbutils.handlers.columns.IntegerColumnHandlerTest;

import com.android.api.impletProductos.Comida;
import com.android.api.impletProductos.Mercancia;
import com.android.api.impletProductos.Servicio;
import com.android.api.mandalistProductos.controlador.ControladorBuscaProducto;
import com.android.filtro.FiltroAndroid;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import variables.RespuestaAndroid;


@WebServlet("/mandarinformaciondeproducto")
public class MandarInformacionDeProducto extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id_usuarioaux=FiltroAndroid.filtro(req, resp);
		

		String id_cola=req.getParameter("idcola");
		
		String id_producto=req.getParameter("idproducto");
		
		String categoria=req.getParameter("categoria");
	
		
		if(id_usuarioaux!=0) {
		
	
		String json = null;
		
		ControladorBuscaProducto buscar=new ControladorBuscaProducto(id_cola,id_usuarioaux);

		// 调用GSON jar工具包封装好的toJson方法，可直接生成JSON字符串
		Gson gson=new GsonBuilder().setPrettyPrinting().create();
		
		
		if(categoria.equals("comida")) {
			
			
		Comida comida=buscar.consultaComida(Integer.parseInt(id_producto));
		
		
			
			json= gson.toJson(comida);
		}else if(categoria.equals("servicio")) {
			
			
			
			Servicio servicio=buscar.consultarServicio(Integer.parseInt(id_producto));
			json= gson.toJson(servicio);
			
		}else if(categoria.equals("mercancia")) {
			
			
			Mercancia mercancia=buscar.consultarMercancia(Integer.parseInt(id_producto));
			
			json= gson.toJson(mercancia);
	
			
		}
	
	
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
