package com.token;

import java.util.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

public class JWTContrasena {
	
	
public static void main(String[] args) {
		
		
		String token=crearTokenRecuperaContrasena(5, "usuario");
		String d="afdsdfafdf";

		
		//token="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZF8iOjUsImV4cCI6MTYyMTA4NTQ4Miwicm9sIjoiamFqYSJ9.uAsfQjXcHAWS9lhqbnnXme1lxkxAJHCXRdwaRJOaS0w";
		
		/*token="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZF8iOjUsImV4cCI6MTYyMTA4NTU0OSwicm9sIjoiamFqYSJ9.K20XGLL5HbLr8hQhb4rErualKOVibTJH1V3fJlUyepU";
		*/
		System.out.println(token);
		System.out.println(vertificaRol(token).equals("\"usuario\""));
		
	}
	
	public static String crearTokenRecuperaContrasena(int id,String rol) {
		
		
		long nowMillis = System.currentTimeMillis();
		
		long expMillis=nowMillis+(600000);
		Date exP=new Date(expMillis);
		
		 String token = null ;
			try {
			    Algorithm algorithm = Algorithm.HMAC256("FADSFOASHDIUFASHDOFHADSOFHJO");
			    token = JWT.create()
			        .withClaim("id",id )
			        .withClaim("rol",rol)
			        .withExpiresAt(exP)
			        .sign(algorithm);
			} catch (JWTCreationException exception){
			    //Invalid Signing configuration / Couldn't convert Claims.
			}
			
			
			return token;
	}
	
	
	
	public static int vettificar_id(String token) {
		
		
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
		
		return Integer.parseInt(jwt.getClaim("id").toString());
		
	}
	
	
	public static String vertificaRol(String token) {
		

	    DecodedJWT jwt=null ;
	    
	    
		try {
		    Algorithm algorithm = Algorithm.HMAC256("FADSFOASHDIUFASHDOFHADSOFHJO");
		    JWTVerifier verifier = JWT.require(algorithm)
		        .build(); //Reusable verifier instance
		    jwt = verifier.verify(token);
		      
		} catch (JWTVerificationException exception){
		    //Invalid signature/claims
			// error de token
			return null;
		}
		
		return jwt.getClaim("rol").toString();
	}
	
	
}
