
    
  <%@page import="javax.websocket.Session"%>
<%@page import="org.eclipse.jdt.internal.compiler.ast.ClassLiteralAccess"%>
<%@ page import="java.util.*" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Activar tu cuenta</title>

	<base href="http://localhost:8088/proyectoFinalEntrada/">

	<link type="text/css" rel="stylesheet" href="css/login.css" />
	<script type="text/javascript" src="script/jquery-3.5.1.js"></script>
	<script type="text/javascript" src="script/mueveanuncio.js">	</script>
</head>
<body>


		<div id="login_header"  >
			<a href="login.html"><img class="logo_img" alt="" src="img/logo.png" ></a>
		</div>
		
	
	
	<div class="centro">
	
			<div id="contenedor_anuncio" >
			
					<div id="caja_anuncio">
					
						<div id="anuncio">
		
						
				 			<a href="img/auncio/1.png" target="_blank"><img id="imgAuncio"  alt="" src="img/auncio/1.png" style="width: 703px; height: 552px; "></a>
							<a href="img/auncio/2.png" target="_blank"><img id="imgAuncio"  alt="" src="img/auncio/2.png"></a> 
								
						</div>
						
						<div id="copia_anuncio"></div>
						
					</div>
				</div>






    <div class="form_activacion" style="position:relative">		
    
   
       
            <form action="activacionCuenta" method="post">
            
            
                <h1>Activar Tu Cuenta</h1>
                 
						<span class="mensajeActivacio">Hemos enviado un código a Correo electrónico 
						<%out.print(request.getSession().getAttribute("email")); %> Introdúcelo a continuación.</span>
                
				   <div class="caja_datos">       
				     
				                <div class="form_item">
				                   
				                    <input type="text" name="codigoActivacion" id="codigoActivacion" placeholder="Código Activación" oninvalid="setCustomValidity('No puede ser vacío')" oninput="setCustomValidity('')" autofocus required >
				                </div>
				                
				          <span class="errorMsg" >
                		
                		<%=request.getAttribute("msg")==null?"":request.getAttribute("msg")%>
                		
                		</span>
				    
                </div>    
                
    
					<button   value="login" type="submit" id="boton_activa" >Activar tu cuenta</button >
		
          
  
    

			
			
		</div>
			
				
	</div>
		
	


</body>
</html>