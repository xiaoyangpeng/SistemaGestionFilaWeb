package com.android.api.incorporar.qr;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.android.filtro.FiltroAndroid;

import variables.RespuestaAndroid;



@WebServlet("/incorporarqr")
public class IncorporarQr extends HttpServlet{
	
	  /**
    *
    * @return -1: error QR
    * 1 QR correcto
    * 2 ya esta dentro de la cola
    */
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		int id_user=FiltroAndroid.filtro(req, resp);
		
		
		if(id_user!=0) {
			
			String qr=req.getParameter("qr");
			
			ControladorIncorporarQR controladorIncorporarQR=new ControladorIncorporarQR(id_user, qr);
			
			
			int respuesta=controladorIncorporarQR.siExisteQR();
			
			resp.setContentType("text/plain;charset=UTF-8");
			resp.setCharacterEncoding("utf-8");
			
			PrintWriter out = new PrintWriter(resp.getOutputStream());
			out.print(respuesta);
			out.flush();
			
			out.close();
			
			
			
		}else {
			resp.setStatus(RespuestaAndroid.NO_HAY_AUTORIZACION);
		}
		
		
		
	}
	

}
