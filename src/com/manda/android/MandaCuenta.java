package com.manda.android;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;


public class MandaCuenta extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		
		String id_prodcuto=req.getParameter("idproducto");
		
		String categoria=req.getParameter("categoria");


		
		String dowloadFile=categoria+"/"+id_prodcuto+".png";
		
		
		ServletContext servletContext=getServletContext();
		
		// decir al 客户端 tipo de datos que va ha devolver 
		String tipoDeArchivo=servletContext.getMimeType("/imagenes/"+dowloadFile);
		
		resp.setContentType(tipoDeArchivo);
		
		// 用来下载
		//resp.setHeader("Content-Disposition", "attament ;filename="+dowloadFile);
		
		InputStream input=servletContext.getResourceAsStream("/imagenes/"+dowloadFile);
		
		
		if(input==null) {
			
			input=servletContext.getResourceAsStream("/imagenes/logo.png");
		}
		
		OutputStream outputStream=resp.getOutputStream();
		
		
		//读取流中的数据 ， 复制到输出流， 输出给客户端
		IOUtils.copy(input, outputStream);
   
		
		
		
		
	}

}
