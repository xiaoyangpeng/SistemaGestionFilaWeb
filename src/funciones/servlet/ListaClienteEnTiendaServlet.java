package funciones.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.filter.ComprobacionToken;

import funciones.controlador.usuarioentienda.ControladorClienteEnTienda;
import funciones.controlador.usuarioentienda.UsuarioEnProceso;
import json.crearjson.CrearJson;

@WebServlet("/clienteentienda")
public class ListaClienteEnTiendaServlet extends HttpServlet {
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		int id_cola=ComprobacionToken.vertificaidColaToken(req);
		
		if(id_cola!=0) {
			
			String valor=req.getParameter("id_usuario");
			
			String listaToJson="";
			

			ControladorClienteEnTienda enproceso=new ControladorClienteEnTienda();
			
			if(valor!=null) {
				
				
				int id_user=Integer.parseInt(valor);
			
				ArrayList<UsuarioEnProceso> listaUser=enproceso.dejarEstadoClienteEnT(id_cola, id_user);
				
				
				listaToJson	=CrearJson.crearJson(listaUser);
				
				
			}else {
				ArrayList<UsuarioEnProceso> listaUser=enproceso.todosUsuarioEnProceso(id_cola);
				
				listaToJson	=CrearJson.crearJson(listaUser);
				
			}
		
			
			resp.setCharacterEncoding("utf-8");
			PrintWriter out = new PrintWriter(resp.getOutputStream());
			out.print(listaToJson);
			out.flush();
			out.close();

			
		}else {
			
			resp.sendRedirect(req.getContextPath()+"/pages/login.jsp");
			
		}
		
		
		
	}
	

}
