package com.mpdificar.cuenta;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import javax.annotation.PostConstruct;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.android.getuserbyid.ControladorByIDUser;
import com.android.getuserbyid.Usuario;
import com.android.recibeproducto.ProductoMandaUsuario;
import com.google.gson.Gson;
import com.manda.android.FiltroAndroid;
import com.token.JwtUtil;

import json.crearjson.CrearJson;
import variables.RespuestaAndroid;
import webutil.WebUtil;

@WebServlet("/auth/modificar")
public class ModificarCuenta extends HttpServlet{
	
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	
		int id_user=FiltroAndroid.filtro(req, resp);
		
		if(id_user!=0) {
		
			BufferedReader br = req.getReader();
			
		    StringBuilder sb = new StringBuilder("");
		    String str;
	        while ((str = br.readLine()) != null)
	        {
	            sb.append(str);
	        }
	        
	        
	        Gson gson=new Gson();
	        
	       Usuario user=gson.fromJson(sb.toString(),Usuario.class);
			
		
	       ControladorMidifica modifica=new ControladorMidifica();
			
			modifica.modificarAndroid(user, id_user);
		
			ControladorByIDUser controlador=new ControladorByIDUser();
			
			user=controlador.findUser(id_user);
			
			String json=	CrearJson.crearJson(user);
			
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
