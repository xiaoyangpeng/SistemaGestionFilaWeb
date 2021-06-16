package com.android.api.getuserbyid;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.android.api.getuserbyid.controlador.ControladorByIDUser;
import com.android.api.getuserbyid.controlador.Usuario;
import com.android.filtro.FiltroAndroid;
import com.json.CrearJson;
import com.web.servlet.managefunction.controlador.qr.ContorladorQr;

import variables.RespuestaAndroid;


@WebServlet("/getuserbyid")
public class GerUserByID extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	
		int id_usuario=FiltroAndroid.filtro(req, resp);
	
		if(id_usuario!=0) {
			
			ControladorByIDUser find=new ControladorByIDUser();
			
			Usuario user=find.findUser(id_usuario);
			
			String json= CrearJson.crearJson(user);		
			
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
