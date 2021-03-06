package com.web.servlet.managefunction.servlet.producto;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.android.api.impletProductos.Comida;
import com.android.api.impletProductos.Mercancia;
import com.android.api.impletProductos.Productos;
import com.android.api.impletProductos.Servicio;
import com.android.api.mandalistProductos.controlador.ControladorBuscaProducto;
import com.web.filter.ComprobacionToken;
import com.web.servlet.managefunction.controlador.productos.ProducotService;
import com.web.servlet.managefunction.controlador.productos.ProductoServiceImpl;



@WebServlet("/manager/productoservlet")
public class GestionProductoServlet extends BaseServlet{


    private ProducotService productoService=new ProductoServiceImpl();


    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  
    }


    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	int id_tienda=ComprobacionToken.vertificaIdTienda(req);
    	
    	List<Productos> productos=productoService.queryProductos(id_tienda);
    	

    	for(Productos i:productos) {
		
		i.setIdentificacion(i.getId_producto());
		
	}

    	req.setAttribute("productos", productos);
    
    	req.getRequestDispatcher("/pagefunciones/addupdate.jsp").forward(req, resp);
    
    
    		
    }


    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	
    	String id=req.getParameter("id");
    	String categoria=req.getParameter("categoria");
    	
    	
    	productoService.deleteProductoByID(Integer.parseInt(id), categoria);
    	
    	productoService.deleteProductoByID(Integer.parseInt(id), "producto");
    	

    	// evita bug si pulsa f5 vuelve a crear otro producto mismo
    	resp.sendRedirect(req.getContextPath()+"/manager/productoservlet?action=list");

    }
	
    protected void getproducto(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    	
        int id=Integer.parseInt(req.getParameter("id"));
        	
        
        String categoria=req.getParameter("categoria");
        
        ControladorBuscaProducto queproducto=new ControladorBuscaProducto();
        
       
    	if(categoria.equals("mercancia")) {
    		

    	      req.setAttribute("mercancia",queproducto.consultarMercancia(id) );

    	}else if(categoria.equals("comida")) {
    		
    		
    		Comida comida=queproducto.consultaComida(id) ;
    	    req.setAttribute("comida",comida );
    	    
    	}else {
    		
    		 req.setAttribute("servicio",queproducto.consultarServicio(id));
    	}
        
        
       
          Productos pro=	productoService.queryProductoById(id);
          
          pro.setIdentificacion(id);
          
          req.setAttribute("producto", pro);
        	
          
          req.getRequestDispatcher("/pagefunciones/addproducto.jsp").forward(req, resp);
       
        	
        }

}
