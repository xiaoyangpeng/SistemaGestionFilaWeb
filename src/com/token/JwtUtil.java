package com.token;


import java.math.BigDecimal;
import java.util.Date;

import javax.management.Query;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

import dao.utils.BaseDao;
import variables.GeneraCodigo;
import variables.VariableSqlWEB;



public class JwtUtil  extends BaseDao{


	
	public static String crearTokenWeb(int id_cola,int id_tienda) {
		
	    String token = null ;
		try {
		    Algorithm algorithm = Algorithm.HMAC256("FADSFOASHDIUFASHDOFHADSOFHJO");
		    token = JWT.create()
		        .withClaim("id_cola", id_cola)
		        .withClaim("id_tienda",id_tienda)
		        .withClaim("nada", GeneraCodigo.LetraAleatoria(5))
		        .sign(algorithm);
		} catch (JWTCreationException exception){
		    //Invalid Signing configuration / Couldn't convert Claims.
		}
		
		
		return token;
		
	}
	
	
	public static void main(String[] args) {
		//System.out.println(crearAndoird("dsaf",222 ));
		
		//System.out.println(vettificar_id_tienda("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJuYWRhIjoiRmtNU2siLCJpZF9jb2xhIjozMDEsImlkX3RpZW5kYSI6MH0.l6_1DbJ2K3kw_z-DgvgUJor2LFBxgJ0Gb7_qYj3lKbE"));
		//System.out.println(crearTokenWeb(2225555,55 ));
	}
	
	public static String crearAndoird(String email,int id_usuario) {
		
	    String token = null ;
		try {
		    Algorithm algorithm = Algorithm.HMAC256("FADSFOASHDIUFASHDOFHADSOFHJO");
		    token = JWT.create()
		        .withClaim("id_usuario", id_usuario)
		        .withClaim("email", email)
		        .withClaim("nada", GeneraCodigo.LetraAleatoria(5))
		        .sign(algorithm);
		} catch (JWTCreationException exception){
		    //Invalid Signing configuration / Couldn't convert Claims.
		}
		
		
		return token;
		
	}
	
	
	
	public static int vertificar_id_cola(String token) {
		
	    DecodedJWT jwt=null ;
		try {
		    Algorithm algorithm = Algorithm.HMAC256("FADSFOASHDIUFASHDOFHADSOFHJO");
		    JWTVerifier verifier = JWT.require(algorithm)
		        .build(); //Reusable verifier instance
		    jwt = verifier.verify(token);
		      
		} catch (JWTVerificationException exception){
		    //Invalid signature/claims
			// error de token
			return 0;
		}
		
		return Integer.parseInt(jwt.getClaim("id_cola").toString());
		
	}

	
	public static int vertificar_id_usuario(String token) {
		
	    DecodedJWT jwt=null ;
		try {
		    Algorithm algorithm = Algorithm.HMAC256("FADSFOASHDIUFASHDOFHADSOFHJO");
		    JWTVerifier verifier = JWT.require(algorithm)
		        .build(); //Reusable verifier instance
		    jwt = verifier.verify(token);
		      
		} catch (JWTVerificationException exception){
		    //Invalid signature/claims
			// error de token
			return 0;
		}
		
		return Integer.parseInt(jwt.getClaim("id_usuario").toString());
		
	}
	
	
	public static int vettificar_id_tienda(String token) {
		
		
	    DecodedJWT jwt=null ;
	    
	    
		try {
		    Algorithm algorithm = Algorithm.HMAC256("FADSFOASHDIUFASHDOFHADSOFHJO");
		    JWTVerifier verifier = JWT.require(algorithm)
		        .build(); //Reusable verifier instance
		    jwt = verifier.verify(token);
		      
		} catch (JWTVerificationException exception){
		    //Invalid signature/claims
			// error de token
			return 0;
		}
		
		return new JwtUtil().buscaSIexiteId((Integer.parseInt(jwt.getClaim("id_tienda").toString())));
		
	}
	
	
	
		public  int buscaSIexiteId(int id_tienda) {
		
		String sql="select id_tienda from tienda where id_tienda=?";
		
		BigDecimal id=(BigDecimal)queryForUnValor(sql, id_tienda);
		
		if(id==null) {
			return  0;
		}else {
			
			return Integer.parseInt(id.toString());
		}

		
	}
}