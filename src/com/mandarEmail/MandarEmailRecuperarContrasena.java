package com.mandarEmail;

import com.token.JWTContrasena;

import variables.UrlEmailRecuperaContrasena;

public class MandarEmailRecuperarContrasena extends Thread {

	private String email;
	private String rol;
	private int id;
	
	
	public MandarEmailRecuperarContrasena(String email, String rol, int id) {
		this.email = email;
		this.rol = rol;
		this.id = id;
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub

		String url=JWTContrasena.crearTokenRecuperaContrasena(id, rol);
		
		url=UrlEmailRecuperaContrasena.URL+url;
		
		Email manda=new Email(email);
	
		manda.mantar("recuperar", url);
		
		
	}
	
	
	
}
