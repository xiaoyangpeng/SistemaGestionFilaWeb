
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Recuperar Contaseña</title>



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
</head>
<body>


		<div id="login_header"  >
				<img class="logo_img" alt="" src="img/logo.png" >
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
    
   
       
            <form action="recupera" method="post">
            
            
                <h1>Recuperar Contraseña</h1>
                 
					<span class="errorMsg">	<%=request.getAttribute("mensaje")==null?"":request.getAttribute("mensaje")%></span>
    
				   <div class="caja_datos">       
				     
				                <div class="form_item">
				                
				                    <input type="text" name="codigoActivacion" id="codigoActivacion" placeholder="Pon su Email" oninvalid="setCustomValidity('No puede ser vacio')"          autofocus required>
				                </div>
				                
				       
				    
                </div>    
                
    
					<button   value="login" type="submit" id="boton_activa" 
						<c:if test="${not empty requestScope.valido}">disabled="disabled"
						</c:if>
					>Enviar a mi Email</button >
		
          
  
    			<span>Enviaremos una enlace a su email para reestablacer su contraseña.</span>

			</form>
			
		</div>
			
				
	</div>
		
	


</body>
</html>