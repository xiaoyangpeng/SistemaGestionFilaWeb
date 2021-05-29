<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
<div id="siguiente_header"  >
			<a href="/proyectoFinalEntrada/pagefunciones/siguiente.jsp"><img class="logo_img" alt="" src="img/logo.png" ></a>
		</div>
		
		
		<div class="botones">
		
				<a href="/proyectoFinalEntrada/pagefunciones/siguiente.jsp"><span class="boton_dentro" id="siguiente">Siguiente</span></a>
				<a href="/proyectoFinalEntrada/manager/productoservlet?action=list"><span class="boton_dentro" id="addupdate">Añadir modificar producto</span></a>
				<a href="/proyectoFinalEntrada/pagefunciones/darnumero.jsp"><span class="boton_dentro" id="darnumero">Dar numero</span></a>
				<a href="/proyectoFinalEntrada/cargarmenu"><span class="boton_dentro" id="generaqr">Otros</span></a>
			
				<a href="/proyectoFinalEntrada/logout"><span class="boton_out_cuenta" >Salir </span></a>
				<span class="hola">Hola propietario de Tienda ${sessionScope.nombretienda} </span>
		</div>