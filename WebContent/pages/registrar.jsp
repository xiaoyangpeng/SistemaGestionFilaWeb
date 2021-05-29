
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>Home</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="utf-8">
<meta name="keywords" content="" />

	
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

<link href="http://fonts.googleapis.com/css?family=Raleway:400,500,600,700,800,900" rel="stylesheet">
<link type="text/css" rel="stylesheet"  media="all" href="css/fondo_registrar.css" />
<link type="text/css" rel="stylesheet" href="css/registrar.css"/>
<link rel="stylesheet" href="css/data.css" />

<script src="https://www.jq22.com/jquery/jquery-1.10.2.js"></script>

<script type="text/javascript" src="script/jquery-3.5.1.js"></script>
		
			
<script type="text/javascript" src="script/registrar.js">	</script>
		
	
	

	
</head>
<body>
<div class="signupform">



		<h1><a href="pages/login.jsp">QUEUE</a></h1>

	<div class="container">
		
		<div class="agile_info">
			<div class="w3l_form">
			
				<div class="left_grid_info">
				
			
				 	<a href="img/auncio/1.png" target="_blank"><img id="imgAuncio"  alt="" src="img/auncio/1.png"/></a>
			
		
				 	<a href="img/auncio/1.png" target="_blank"><img id="imgAuncio"  alt="" src="img/auncio/1.png"/></a>
		
					
			
				 	<a href="img/auncio/2.png" target="_blank"><img id="imgAuncio"  alt="" src="img/auncio/2.png"/></a>
	
				</div>
			</div>
			<div class="w3_info">
				<h2>Crear Cuenta</h2>
				
				
						<form action="registServlet" method="post">
						<div class="input-group">
							<span><i class="fa fa-user" aria-hidden="true"></i></span>
							<input type="text" placeholder="Nombre Tienda"  name="nombre"  id="nombre" oninvalid="setCustomValidity('No puede ser vacío')" oninput="setCustomValidity('')" autofocus required
							
							value="<%=request.getParameter("nombre")==null?"":request.getParameter("nombre") %>" 
							> 
						</div>
						<div class="input-group">
							<span><i class="fa fa-envelope" aria-hidden="true"></i></span>
							
							<input type="text" placeholder="Email" 
							
							 autocomplete="off" tabindex="1" name="email" id="email"
							 
							  value="<%=request.getParameter("email")==null?"":request.getParameter("email") %>" 
							 > 
						</div>
						<div class="input-group">
							<span><i class="fa fa-lock" aria-hidden="true"></i></span>
							<input type="Password" placeholder="Password"
							autocomplete="off" tabindex="1" name="password" id="password" 
					
							 >
						</div>
						
						
						<div class="input-group">
							<span><i class="fa fa-lock" aria-hidden="true"></i></span>
							<input type="Password" placeholder="Confirm Password"
							 autocomplete="off" tabindex="1" name="repwd" id="repwd" 
							 
						/>
						</div>
						
						
						<div class="input-group">
						
							<span><i class="fa fa-phone" aria-hidden="true"></i></span>
							
								<!-- solo permite numeros -->
							<input style="IME-MODE: disabled; " onkeyup="this.value=this.value.replace(/\D/g,'')"
																				
							onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="9" size="14" 
							
							type="text" placeholder="Telefono" 
							 autocomplete="off" tabindex="1" name="telefono" id="telefono" 
							  value="<%=request.getParameter("telefono")==null?"":request.getParameter("telefono") %>" 
							/>
						</div>
						
				
						<div class="input-group">
						
						<span><i class="fa fa-home" aria-hidden="true"></i></span>
							
								<input type="text" placeholder="Dirección"  
							name="direccion" id="direccion"
							oninvalid="setCustomValidity('No puede ser vacío')" oninput="setCustomValidity('')" autofocus required	
							
							  value="<%=request.getParameter("direccion")==null?"":request.getParameter("direccion") %>" 
							
							/> 

						</div>
						
						<div class="input-group">
							<span><i class="fa fa-list-ul" aria-hidden="true"></i></span>
							
							<select name="categoria" id="categoria" >
									<option value="none" selected disabled hidden>Categoría</option>
									  <option value ="Restaurante" >Restaurante</option>
									  <option value ="Peluqueria" >Peluquería</option>
									    <option value ="Supermercado">Supermercado</option>
									  <option value="Entretenimiento ">Entretenimiento </option>
									  <option value="Otros" >Otros</option>
							</select>
						</div>
						
							<div class="input-group">
							<span><i class="fa fa-list-ul" aria-hidden="true"></i></span>
							
							<select name="horario" id="horario" >
									<option value="none" selected disabled hidden>Tiempo estamado de espera</option>
									  <option value ="10" >10 Min</option>
									  <option value ="20" >20 Min</option>
									    <option value ="30">30 Min</option>
									  <option value="40 ">40 Min</option>
									    <option value="50 ">50 Min</option>
									  <option value="60" >60 Min</option>
							</select>
						</div>
						
						
						
						
		
						<div class="input-group">
						
							<span>
							<input type="text" type="text" id="codigo" placeholder="Código"  
							name="codigo"
							oninvalid="setCustomValidity('No puede ser vacío')" oninput="setCustomValidity('')" autofocus required	/> 
							</span>
							<span><img id="imgCodigo"  alt="" src="http://localhost:8088/proyectoFinalEntrada/kapth.jpg"   /></span>
						</div>
				
					
					
	
							<button class="btn btn-danger btn-block" value="registrar" type="submit" id="sub_btn" >Crear tu cuenta</button >                
					</form>
					
					
					<p>
								<span class="errorMsg">
								
									<%=request.getAttribute("msg")==null?"":request.getAttribute("msg")%>
                
							
								<br/>
				</p>
			</div>
		
				
			</div>
			
		</div>
		<div class="footer">

 <p>Copyright &copy; 2018.Company name All rights reserved.<a target="_blank" href="http://sc.chinaz.com/moban/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a></p>
 </div>
	</div>
	</body>
</html>