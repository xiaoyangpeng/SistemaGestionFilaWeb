
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
		
<link type="text/css" rel="stylesheet" href="cssfunciones/darnumero.css" />
	<script type="text/javascript" src="script/jquery-3.5.1.js"></script>
	<script type="text/javascript" src="funcionesjsscript/darnumero.js"></script>
		
</head>
<body>

		<jsp:include page="botones.jsp"/>
		
		<div class="centro">
			
			
			<div class="boton">
				
				
					<button onclick="peticionTurno()">Dar siguiente Turno</button>
				
						
						<span>Siguiente Turno</span>
							
								<input type="text" placeholder="TURNO"  
									name="turno" id="turno"
								disabled="true"
							
						/>
			</div>
			
			
			
		</div>
		


</body>
</html>