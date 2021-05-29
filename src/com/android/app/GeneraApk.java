package com.android.app;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import com.filter.ComprobacionToken;

import funciones.controlador.qr.ContorladorQr;
import funciones.controlador.qr.QRCodeUtil;


@WebServlet("/descargaapp")
public class GeneraApk extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
			
		ServletContext servletContext=getServletContext();
		
		// decir al 客户端 tipo de datos que va ha devolver 
		String tipoDeArchivo=servletContext.getMimeType("app/app-debug.apk");
		
		resp.setContentType(tipoDeArchivo);
		
		// 用来下载
		resp.setHeader("Content-Disposition", "attament; filename=queue.apk");
		
	
		InputStream recouce=servletContext.getResourceAsStream("/app/app-debug.apk");
		
		
		OutputStream outputStream=resp.getOutputStream();
		
		IOUtils.copy(recouce, outputStream);
		
		
		
	}

	
}
