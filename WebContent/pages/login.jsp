
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

		<%   // para coger directorio  del proyecto
		String basePath=request.getScheme()
		+"://"
		+request.getServerName()
		+":"
		+request.getServerPort()
		+request.getContextPath()
		+"/";
		
		%>


	<base href="<%=basePath%>">

	<link type="text/css" rel="stylesheet" href="css/login.css" />
	
	<script type="text/javascript" src="script/jquery-3.5.1.js"></script>
	<script type="text/javascript" src="script/mueveanuncio.js">	</script>
	<script type="text/javascript" src="script/login.js">	</script>
	
	

</head>
<body>



		<div id="login_header"  >
			<a href="pages/login.jsp"><img class="logo_img" alt="" src="img/logo.png" ></a>
		</div>
		
	
	
	<div class="centro">
	
			<div id="contenedor_anuncio" >
			
					<div id="caja_anuncio">
					
						<div id="anuncio">
		
						
				 			<a href="img/auncio/1.png" target="_blank"><img id="imgAuncio"  alt="" src="img/auncio/1.png"></a>
							<a href="img/auncio/2.png" target="_blank"><img id="imgAuncio"  alt="" src="img/auncio/2.png"></a> 
								
						</div>
						
						<div id="copia_anuncio"></div>
						
					</div>
				</div>

	
    <div class="form" style="position:relative">		
    
    
    
    	<!-- Entrar normal  -->
        <div class="login_normal" style="position:absolute">  
       
            <form action="login" method="post">
                <h1>Identificate</h1>
                
                 	 <div class="info">
                  
                 		 <span class="switch login_Btn">Entrar como trabajador</span>
                		  <a  href="pages/registrar.jsp">Registrar</a>
                	  </div>
                
                		<span class="errorMsg">
                		
                		<%=request.getAttribute("msg")==null?"Pone su Email y contraseña":request.getAttribute("msg")%>
                		
                		</span>
							
              
                
				   <div class="caja_datos">       
				     
				                <div class="form_item">
				                   
				                    <input type="text" name="email" id="email" placeholder="Email" 
				                    value="<%=request.getParameter("email")==null?"":request.getParameter("email")%>" >
				                </div>
				                <div class="form_item">
				                 
				                    <input type="password" name="password" id="password" placeholder="Password" 
				                    oninvalid="setCustomValidity('No puede ser vacío')" oninput="setCustomValidity('')" autofocus required>
				                </div>
				                
                
                </div>    
                
                
                
              <div class="caja_olvidar">
									
					<a id="olvidar" href="olvidar.jsp">¿Olvidaste tu contraseña?</a>
								
			</div>
         	<div class="form_login">
					<button  value="login" type="submit" id="sub_btn" >Entrar tu cuenta</button >
			</div>
            </form>
          
        </div>	
    
   
			
	<!--entrar normal-->
        <div class="login_trabajador" >
			
			<form action="login" method="post">
				<h1>Identificate como Trabajador</h1>
		
				<div class="info"><span class="switch register_Btn" >Entrar normal</span></div>
							
						<span class="errorMsgTrabajador"></span>
						
						   <div class="caja_datos">    		
									
									<div class="form_item">
								
										<input type="text" name="emailTrabajador" id="emailTrabajador" placeholder="Email" >
									</div>
									
										
									<div class="form_item">
								
										<input type="text" name="usuario" id="usuario" placeholder="Usuario"
										placeholder="Password" oninvalid="setCustomValidity('No puede ser vacío')" oninput="setCustomValidity('')" autofocus required >
										
									</div>
									
									<div class="form_item">
									
										<input type="password" name="passwordTrabajador" id="passwordTrabajador" placeholder="Password" oninvalid="setCustomValidity('No puede ser vacío')" oninput="setCustomValidity('')" autofocus required>
										
									</div>
						</div>		
			
				<div class="form_login">
				
					<button  value="login_trabajador" type="submit" id="sub_btntrabajador" >Accede como Trabajador</button >
				</div>
				
			</form>
	
			
         </div>
	

			
	
			
			
</div>
			
				
	</div>
		
	
		



</body>
</html>