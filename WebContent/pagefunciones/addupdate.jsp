

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

	<div id="siguiente_header"  >
			<a href="/proyectoFinalEntrada/pagefunciones/siguiente.jsp"><img class="logo_img" alt="" src="img/logo.png" ></a>
		</div>

		<div class="botones">
		
				<a href="/proyectoFinalEntrada/pagefunciones/siguiente.jsp"><span class="boton_dentro" id="siguiente">Siguiente</span></a>
				<a href="visualizar.html"><span class="boton_dentro" id="visualizar">Visualizar Fila</span></a>
				<a href="/proyectoFinalEntrada/manager/productoservlet?action=list"><span class="boton_dentro" id="addupdate">Anadir modificar producto</span></a>
				<a href="/proyectoFinalEntrada/pagefunciones/activafila.html"><span class="boton_dentro" id="activafila">Activar/Desactivar Fila</span></a>
				<a href="darnumero.html"><span class="boton_dentro" id="darnumero">Dar numero</span></a>
				<a href="generaqr.html"><span class="boton_dentro" id="generaqr">Genera QR</span></a>
				
				<span class="boton_out_cuenta" >Salir </span>
		</div>


				
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