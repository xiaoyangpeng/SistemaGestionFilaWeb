package com.android.api.usuarioAddProducto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.android.api.usuarioAddProducto.controlador.ControladorIncorporarQR;
import com.android.api.usuarioAddProducto.controlador.ProductoMandaUsuario;
import com.google.gson.Gson;



@WebServlet("/recibeproducto")
public class RecibeCambioProducto extends HttpServlet{

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = req.getReader();
		
	    StringBuilder sb = new StringBuilder("");
	    String str;
        while ((str = br.readLine()) != null)
        {
            sb.append(str);
        }
        
        
        Gson gson=new Gson();
        
        ProductoMandaUsuario productoMandaUsuario=gson.fromJson(sb.toString(), ProductoMandaUsuario.class);
        
        ControladorIncorporarQR controladorIncorporarQR=new ControladorIncorporarQR();
        
        controladorIncorporarQR.usuario_anadir_productos(productoMandaUsuario);
        
        
	}
}
