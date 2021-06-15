


<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
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
		
		<link type="text/css" rel="stylesheet" href="cssfunciones/userentienda.css" />
		
		<script type="text/javascript" src="script/jquery-3.5.1.js"></script>
		<script type="text/javascript" src="funcionesjsscript/userentienda.js"></script>
	
		<script src="funcionesjsscript/myPagination.js"></script>
	
</head>
<body>

	

		<jsp:include page="botones.jsp"/>
		

	
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

			<div id="turnoActual"> Turno Actual :
			&nbsp; &nbsp; 
			
					<span id="miTurno"></span>
					
					<span id="turnoEnfila"></span>
					
			</div>
			
			<div class="turno">
							
				<table id="tableturno">
				<thead>
							<tr>
								<td>Nombre</td>
								<td>Turno</td>
							</tr>		
					<thead>		
					 <tbody id="tbMain"></tbody>  		
				</table>
			
			</div>
		
		
		<div id="pagination" class="pagination"></div>
		

	</div>
		

	

	

</body>
</html>