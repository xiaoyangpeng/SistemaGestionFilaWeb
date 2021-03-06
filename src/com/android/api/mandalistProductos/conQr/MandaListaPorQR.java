package com.android.api.mandalistProductos.conQr;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.android.api.impletProductos.ProductosAux;
import com.android.api.mandalistProductos.controlador.ControladorBuscaProducto;
import com.android.filtro.FiltroAndroid;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import variables.RespuestaAndroid;






@WebServlet("/mandaListaporqr")
public class MandaListaPorQR extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		int id_usuarioaux=FiltroAndroid.filtro(req, resp);
		

		String id_cola=req.getParameter("idcola");
		
		String nombreProducto=req.getParameter("nombreproducto");

		nombreProducto=nombreProducto.toLowerCase();
		
		if(id_cola!=null&&nombreProducto!=null) {
			
					
				ControladorBuscaProducto buscar=new ControladorBuscaProducto(id_cola,id_usuarioaux,nombreProducto);
				
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
				
	}else {
		
		resp.setStatus(RespuestaAndroid.NO_HAY_AUTORIZACION);
		
	}
}
	
}
