package com.android.api.mandalistproductoUsuario;

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
import com.android.filtro.FiltroAndroid;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.json.CrearJson;

import variables.RespuestaAndroid;


@WebServlet("/mandarlistaproductousuario")
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

