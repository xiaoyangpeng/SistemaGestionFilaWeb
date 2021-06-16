package com.android.api.mandaHistoriaFila;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.android.api.mandaHistoriaFila.controlador.ControladorHistoriaCola;
import com.android.api.mandaHistoriaFila.controlador.HistoriaEnFila;
import com.android.filtro.FiltroAndroid;
import com.json.CrearJson;

import variables.RespuestaAndroid;

@WebServlet("/historiafila")
public class MandaHistoriaEnFila extends HttpServlet {
	
	
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
			
	
			int id_usuario=FiltroAndroid.filtro(req, resp);
		
			if(id_usuario!=0){
			ControladorHistoriaCola historia=new ControladorHistoriaCola();
			
			ArrayList<HistoriaEnFila> listaHistoria=historia.listaHistoriaEnFila(id_usuario);
			
			
			String json= CrearJson.crearJson(listaHistoria);		
			
			resp.setContentType("application/json;charset=UTF-8");
			resp.setCharacterEncoding("utf-8");
			PrintWriter out = new PrintWriter(resp.getOutputStream());
			out.print(json);
			
			out.close();
			out.flush();
			}else {
				
				resp.setStatus(RespuestaAndroid.NO_HAY_AUTORIZACION);
			}
			
		}
}
