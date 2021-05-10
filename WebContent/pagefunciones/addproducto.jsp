

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
		
<link type="text/css" rel="stylesheet" href="cssfunciones/addproducto.css" />

			<script src="https://www.jq22.com/jquery/jquery-1.10.2.js"></script>

<script type="text/javascript" src="script/jquery-3.5.1.js"></script>
			<script type="text/javascript" src="funcionesjsscript/addproducto.js"></script>
		
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
			
			
			
					<div class="tabla">
			
					<form action="manager/productoservlet" method="get">
					
							<input type="hidden" name="action" value="${param.method }" />
								<input type="hidden" name="id" value="${ requestScope.producto.getIdentificacion()}" />
						<input type="hidden" name="idtienda" value="${ requestScope.producto.id_tienda}" />
					
									Nombre
				
							<input type="text" placeholder="Nombre"  name="nombre"  id="nombre" oninvalid="setCustomValidity('No puede ser vacío')" oninput="setCustomValidity('')" autofocus required
								
								
								value="${requestScope.producto.nombre} "
								
			/>
						
						
							Precio
					
							<input type="text" placeholder="Precio"   	onkeyup="this.value=this.value.replace(/[^\d\.\d{0,2}]/g,'')"  name="precio"  id="precio" oninvalid="setCustomValidity('No puede ser vacÃ­o')" oninput="setCustomValidity('')" autofocus required
	
								value="${requestScope.producto.precio} "
						/>
						
						
					Categoria
							<select name="categoria" id="categoria" >
									<option value="none" selected disabled hidden>Categoria</option>
									  <option value ="servicio" <c:if test="${not empty requestScope.servicio }">selected="selected"</c:if>>servicio</option>
									  <option value ="comida" <c:if test="${not empty requestScope.comida }">selected="selected"</c:if>>comida</option>
									    <option value ="mercancia" <c:if test="${not empty requestScope.mercancia }">selected="selected"</c:if>>mercancia</option>
					
							</select>
			
				
					<div class="abajo">
										
						Descripcion
								<div>
							
					<textarea placeholder="...Descripcion.." name="descripcion"  id="descripcion">
					${requestScope.comida.ingrediente}
								${requestScope.servicio.descripcion}
								${requestScope.mercancia.descripcion}
					</textarea>
							</div>
						
								<input type="file" id="foto" placeholder="Eligefoto" /> 
				
				
				
							<div id="divmercancia" >
							
							Stock
										<input type="text" placeholder="Stock" 
										oninput = "value=value.replace(/[^\d]/g,'')"
										 name="stock"  id="stock"  oninput="setCustomValidity('')" autofocus 
										 
									 value="${requestScope.mercancia.stock}"
										/>
											
										</br>
											<p id="textCodigo">Codigo en su tienda</p>
										<input type="text" placeholder="codigo en su tienda" 
										 name="codigo"  id="codigo" oninput="setCustomValidity('')" autofocus 
										 				 value="		${requestScope.mercancia.codigo}"
										/>
							</div>
						</div>	
						
						
						
							<button class="btn btn-danger btn-block"  type="submit" >Aceptar</button >                
						
						
				</form>			
							
							
				</div>
			
					
			
			
				
			</div>

		
</body>
</html>