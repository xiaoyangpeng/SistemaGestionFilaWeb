package com.web.servlet.managefunction.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import com.token.JwtUtil;
import com.web.filter.ComprobacionToken;
import com.web.servlet.managefunction.controlador.qr.ContorladorQr;
import com.web.servlet.managefunction.controlador.qr.QRCodeUtil;

import variables.DirectorioImagen;
import variables.VariableFijo;
import variables.hayquemodificar.DirecotrioDescargaApp;


@WebServlet("/qr")

public class GeneraQR extends HttpServlet{
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int id_tienda=ComprobacionToken.vertificaIdTienda(req);
		
		
		String cambiar=req.getParameter("cambia");
		
		String qr=null;
		String dowloadFile="";
		
		if(cambiar!=null) {
			dowloadFile="QRparaDesacargarApp.png";
			qr=DirecotrioDescargaApp.DIRAPP;
			
		}else {
			
			qr=new ContorladorQr().buscaQRporId(id_tienda);
			dowloadFile="qrDeMitienda.png";
		}



	
		ServletContext servletContext=getServletContext();
		
		// decir al 客户端 tipo de datos que va ha devolver 
		String tipoDeArchivo=servletContext.getMimeType("/imagnes/"+dowloadFile);
		
		resp.setContentType(tipoDeArchivo);
		
		// 用来下载
		resp.setHeader("Content-Disposition", "attament ;filename="+dowloadFile);
		
	
		OutputStream outputStream=resp.getOutputStream();
		
		QRCodeUtil uti=new QRCodeUtil();
		
		try {
			uti.encoderQRCode(qr, outputStream);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
		
	}

	
}
