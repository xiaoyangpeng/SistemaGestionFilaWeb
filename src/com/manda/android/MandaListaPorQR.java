package com.manda.android;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.manda.android.controlador.ControladorBuscaProducto;
import com.manda.android.controlador.ProductosAux;



public class MandaListaPorQR extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String qr=req.getParameter("qr");
		
		String id_usuario=req.getParameter("idusuario");
		
		String id_cola=req.getParameter("idcola");
		
		String nombreProducto=req.getParameter("nombreproducto");
	
	
		
		if(qr!=null&&id_cola!=null&&id_usuario!=null&&nombreProducto!=null) {
			
				ControladorBuscaProducto buscar=new ControladorBuscaProducto(qr,id_cola,id_usuario,nombreProducto);
				
				ProductosAux productoAux=new ProductosAux(); // meter arrayList en un clase facilita trabajar luego
				
				productoAux.setProductos(buscar.consultaListaProducto());
			
				
				// 调用GSON jar工具包封装好的toJson方法，可直接生成JSON字符串
				Gson gson=new GsonBuilder().setPrettyPrinting().create();
				
				String json = gson.toJson(productoAux);
				
				resp.setContentType("application/json;charset=UTF-8");
				resp.setCharacterEncoding("utf-8");
				PrintWriter out = new PrintWriter(resp.getOutputStream());
				out.print(json);
				out.flush();
				
				out.close();
		}
	}
	
}
