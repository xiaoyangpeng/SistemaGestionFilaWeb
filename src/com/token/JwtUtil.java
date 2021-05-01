package com.token;


import javax.management.Query;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;



public class JwtUtil {

  
	
	public static String crearToken(String email,int password,int id_cola) {
		
	    String token = null ;
		try {
		    Algorithm algorithm = Algorithm.HMAC256("FADSFOASHDIUFASHDOFHADSOFHJO");
		    token = JWT.create()
		        .withClaim("id_cola", id_cola)
		        .withClaim("email", email)
		        .withClaim("password",password)
		        .sign(algorithm);
		} catch (JWTCreationException exception){
		    //Invalid Signing configuration / Couldn't convert Claims.
		}
		
		
		return token;
		
	}
	
	
	/*
	public static void main(String[] args) {
		
		
	//System.out.print(crearToken("1231312",123,555));
		
	System.out.println(vertificar("Ov4iZC6s1kewq9j-eEgeltFjC4-M9sImi0H7dqWQ"));
		
	}*/
	
	
	public static int vertificar(String token) {
		
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

}