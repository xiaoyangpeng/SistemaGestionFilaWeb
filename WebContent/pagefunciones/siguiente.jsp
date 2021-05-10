


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

		<link type="text/css" rel="stylesheet" href="cssfunciones/funcion.css" />
		
		<link type="text/css" rel="stylesheet" href="cssfunciones/siguiente.css" />
		
		
			<script type="text/javascript" src="funcionesjsscript/siguiente.js"></script>
	
	
</head>
<body>



		<%@include file="/pagefunciones/botones.jsp" %>


	<div class="centro">
		

			<div class="producto">
			
			
				<table>
				
				
				
					<thead>
							<tr>
								<td>Nombre</td>
								<td>Precio</td>
								<td>Categoria</td>
								<td>Total</td>
							</tr>		
							
				</thead>	
				
				<tbody id="tbLista"></tbody>  
					
				</table>
				
				
		
			
			</div>
			
				<div class="total">
				
					Total&nbsp; &nbsp; 
							<span id="totalprecio"></span>
					</div>

			<div id="turnoActual"> Turno Actual
			&nbsp; &nbsp; 
				<span id="miTurno"></span>
			
			</div>
			
			<div class="turno">
							
				<table id="tableturno">
				<thead>
							<tr>
								<td>Nombre</td>
								<td>Turno</td>
								<td>Hora Entrada</td>
								<td>Formato</td>
							</tr>		
					<thead>		
					 <tbody id="tbMain"></tbody>  		
				</table>
			
			</div>
		
			
			<div class="boton">
			
	
				<button class="btn btn-danger btn-block"  type="submit" >Anterior</button >   

		
				<button class="btn btn-danger btn-block"  type="submit" id="btn_siguiente" onclick="mandasiguiente()">Siguiente</button >   

			
			
			</div>
		
			
	</div>
		

	

	

</body>
</html>