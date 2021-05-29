

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

<link type="text/css" rel="stylesheet" href="cssfunciones/funcion.css" />
		
<link type="text/css" rel="stylesheet" href="cssfunciones/addupdate.css" />
		
		
</head>
<body>


		<jsp:include page="botones.jsp"/>

	
	<div class="centro">

			<div class="producto">
			
				<table>
				
				
						<tr>
								<td>Nombre</td>
								<td>Precio</td>
								<td>Categoria</td>
								<td>Operacion</td>
						</tr>		
	
	

			<c:forEach items="${requestScope.productos}" var="productos">
			
					<tr>
								<td>${productos.getNombre()}</td>
								<td>${productos.precio} </td>
								<td>${productos.getCategoria()} </td>
								
								<td><a href="/proyectoFinalEntrada/manager/productoservlet?action=delete&id=${productos.getIdentificacion()}&categoria=${productos.getCategoria()}
								
						">
								Eliminar</a></td>
								
								
								<td><a href="/proyectoFinalEntrada/manager/productoservlet?action=getproducto&id=${productos.getIdentificacion()}&categoria=${productos.getCategoria()
								
							
					}	&method=update">
								Modificar</a></td>
								
							</tr>	
			
			</c:forEach>
	
	
	
	
		<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="pagefunciones/addproducto.jsp?method=add">AnadirProducto</a></td>
			</tr>	
	
	
				</table>
			
			
			</div>
			
		
			
	</div>
		




</body>
</html>