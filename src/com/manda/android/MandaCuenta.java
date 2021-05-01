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

import sun.nio.ch.IOUtil;

public class MandaCuenta extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		
		
		String dowloadFile="22.png";
		
		
		ServletContext servletContext=getServletContext();
		
		
		// decir al 客户端 tipo de datos que va ha devolver 
		String tipoDeArchivo=servletContext.getMimeType("/file/"+dowloadFile);
		
		resp.setContentType(tipoDeArchivo);
		
		// 用来下载
		//resp.setHeader("Content-Disposition", "attament ;filename="+dowloadFile);
		
		InputStream input=servletContext.getResourceAsStream("/file/"+dowloadFile);
		
		OutputStream outputStream=resp.getOutputStream();
		
		
		//读取流中的数据 ， 复制到输出流， 输出给客户端
		IOUtils.copy(input, outputStream);
   
		
		
		
		
	}

}
