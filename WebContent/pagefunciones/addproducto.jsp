

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Añadir modificar Productos</title>

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


		
		<jsp:include page="botones.jsp"/>
		
		
			<div class="centro">
			
			
			
					<div class="tabla">
			
					<form action="manager/addproducto" method="post" enctype="multipart/form-data">
					
								<input type="hidden" name="action" value="${param.method}" />
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
						
								<input type="file" id="foto" name="foto" />
				
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
			
				
				<div class="imagen">
				
					
					<c:if test="${not empty requestScope.comida}">	
					
							<img id="img" src="imagenes/${ requestScope.producto.categoria}/${ requestScope.producto.getIdentificacion()}.png"/>
				
					
						
					</c:if>
				
				
					<c:if test="${not empty requestScope.mercancia }">	
					
							<img  id="img"  src="imagenes/${ requestScope.producto.categoria}/${ requestScope.producto.getIdentificacion()}.png"/>
							

					</c:if>
					
					
						
					<c:if test="${param.method == 'add' }">	
					
							<img  id="img" />
							

					</c:if>
					
				
				</div>
			
			
				
			</div>

		
</body>
</html>