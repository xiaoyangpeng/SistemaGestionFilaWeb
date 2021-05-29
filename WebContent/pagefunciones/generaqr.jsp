



<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Operacion QR y Fila</title>


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
		
<link type="text/css" rel="stylesheet" href="cssfunciones/generaqr.css" />


		<script type="text/javascript" >
	
			function elegido(){
				
				var checkBox=document.getElementById("onoffswitch");
				
				var resul=	confirm("estas seguro dejar fila en "+checkBox.checked +" ?");
				
				if(resul==true){
					
					document.gesionfila.submit();
				}
			}
		
		</script>
		
</head>
<body>

		<jsp:include page="botones.jsp"/>


	<div class="centro">
	
		<div class="menu">
			<form action="qr" method="get">
				<button type="submit" >Descargar QR</button >   
			</form>
			
			<form action="qr" method="get">
				<input type="hidden" name="cambia" value="cambia" />
				<button type="submit" >Generar QR Desacarga App Android</button >   
			</form>
			
	
			<form action="gestionfila" method="get" name="gesionfila">
						
						<span> Activa / Desactiva Fila</span>
						<div class="swith">
				
									<div class="testswitch">	
	
											<input class="testswitch-checkbox" id="onoffswitch" type="checkbox"
											 name="checkbox"
											 <c:if test="${not empty requestScope.activado}">checked="checked"</c:if>
											>
											<label class="testswitch-label" for="onoffswitch">
												<span class="testswitch-inner" data-on="SI" data-off="NO"></span>
												<span class="testswitch-switch"></span>
											</label>
					
										</div>		
						</div>
				
						<button onclick="elegido()" id="aceptar" type="button" >Aceptar</button>
		
				</form>		
		</div>
</div>
</body>
</html>