package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.implet.Tienda_entrada;
import tienda.controlador.ControladorSign;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;;

public class RegistServlet extends HttpServlet{

	
	String nada;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String codigoPrubea=req.getParameter("codigo");
		
		String codigoPruebaAux=(String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);

		
		// eliminar codigo prueba en seccion
		//evita el usuario una vez ha hecho con exito vuelve 
		req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);

		
		//cuanto codigo es correcto
		if(codigoPrubea.compareToIgnoreCase(codigoPruebaAux)==0) {
			
			Tienda_entrada tienda=new Tienda_entrada();
					
			tienda.email=req.getParameter("email");
					
			ControladorSign contoControladorSign=new ControladorSign(tienda);
			
				if(!contoControladorSign.siExisteEmail()) { //cuando no existe el email
						
						tienda.nombre=req.getParameter("nombre");
		
						tienda.contrasena=req.getParameter("password").hashCode();
						tienda.telefono=Integer.parseInt(req.getParameter("telefono"));
						tienda.direccion=req.getParameter("direccion");
						tienda.categoria=req.getParameter("categoria");
				
						contoControladorSign.andairInformacionTienda();
						
						req.getSession().setAttribute("email", req.getParameter("email"));
						
						req.getRequestDispatcher("/pages/codigoActivacion.jsp").forward(req, resp);
						
					}else {// cuando ya existe email
						
			
						req.setAttribute("msg", "Ya existe este Email");
						req.getRequestDispatcher("/pages/registrar.jsp").forward(req, resp);
					}
		
		}else {
			
			req.setAttribute("msg", "Código de vertificación incorrecto");
			req.getRequestDispatcher("/pages/registrar.jsp").forward(req, resp);
		}
		
	
	
		
	

		// 到时候再实验id 就是 在 js 里面 的	arrys 关于开门时间的
			/*String id = req.getParameter("id");
		
			System.out.println(id);*/
		
		//req.getRequestDispatcher("/pages/registrar.jsp").forward(req, resp);
	
	}
	
	
}
