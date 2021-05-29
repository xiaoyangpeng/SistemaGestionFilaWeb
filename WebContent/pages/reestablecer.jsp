



    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


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
	
	<script type="text/javascript" src="funcionesjsscript/reestablecer.js"></script>

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
    
   			
       
            <form action="cambiacontrasena" method="post">
            
            
                <h1>Reestablecer Contraseña</h1>
                 
					<span class="errorMsg">	</span>
    
				   <div class="caja_datos">       
				     
				                <div class="form_item">
				                      	<input type="hidden" name="token" value="${requestScope.token}"  />
				                    <input type="password" name="password" id="password" placeholder="Pon su Contraseña" oninvalid="setCustomValidity('No puede ser vacio')"
				                    
				                          autofocus required
				                    >
				                    
				                    
				                      <input
				                       type="password" name="repwd" id="repwd" placeholder="Repite su Contraseña" oninvalid="setCustomValidity('No puede ser vacio')"
	                                     autofocus required
				                >
				                </div>
				                
				       
				    
                </div>    
                
    
					<button   value="login" type="submit" id="sub_btn" 
				
					>Reestablecer</button >
		
  
			</form>
			
		</div>
			
				
	</div>
		
	


</body>
</html>