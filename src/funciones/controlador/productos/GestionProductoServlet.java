package funciones.controlador.productos;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.filter.ComprobacionToken;
import com.manda.android.controlador.Comida;
import com.manda.android.controlador.ControladorBuscaProducto;
import com.manda.android.controlador.Mercancia;
import com.manda.android.controlador.Productos;
import com.manda.android.controlador.Servicio;



public class GestionProductoServlet extends BaseServlet{


    private ProducotService productoService=new ProductoServiceImpl();


    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  
    }



    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    	
	int id_tienda=ComprobacionToken.vertificaIdTienda(req);
	
    	Productos producto=new Productos();
    
 
    	String nombre=req.getParameter("nombre");
    	
    	String precio=req.getParameter("precio");
    	
    	String categoria=req.getParameter("categoria");
    	String descripcion=req.getParameter("descripcion");
    	
    	producto.setNombre(nombre);
    	
    	producto.setCategoria(categoria);
    	producto.setId_tienda(id_tienda);
    	producto.setPrecio(Double.parseDouble(precio));
    	
    	
    	
    	productoService.addProdducto(producto);
    	
    	if(categoria.equals("mercancia")) {
    		
    		Mercancia mercancia=new Mercancia();
    		
    		mercancia.setCodigo(req.getParameter("codigo"));
   
    		mercancia.setUrl_foto("mercancia");
    		
    		mercancia.setStock(Integer.parseInt(req.getParameter("stock")));
    		
    		mercancia.setDescripcion(descripcion);
    	
    		productoService.addMercancia(mercancia);
    	
    	}else if(categoria.equals("comida")) {
    		
    		Comida comida=new Comida();
    		comida.setIngrediente(descripcion);
    		
    		comida.setUrl_foto("comida");
    		productoService.addComida(comida);
    		
    	}else {
    		
    		Servicio servicio=new Servicio();
    		
    		servicio.setDescripcion(descripcion);
    		

    		productoService.addServicio(servicio);
    		
    	}
    	
    
    	
    	
 
    	// evita bug si pulsa f5 vuelve a crear otro producto mismo
    	resp.sendRedirect(req.getContextPath()+"/manager/productoservlet?action=list");

    }



    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	
    	String id=req.getParameter("id");
    	String categoria=req.getParameter("categoria");
    	
    	
    	productoService.deleteProductoByID(Integer.parseInt(id), categoria);
    	
    	productoService.deleteProductoByID(Integer.parseInt(id), "producto");
    	

    	// evita bug si pulsa f5 vuelve a crear otro producto mismo
    	resp.sendRedirect(req.getContextPath()+"/manager/productoservlet?action=list");

    }



    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    	

   
   		int idtienda=Integer.parseInt(req.getParameter("idtienda"));
    	int idproducto=Integer.parseInt(req.getParameter("id"));
    	
    	Productos producto=new Productos();
   
    	String nombre=req.getParameter("nombre");
    	
    	String precio=req.getParameter("precio");
    	
    	String categoria=req.getParameter("categoria");
    	String descripcion=req.getParameter("descripcion");
    	
    
    	producto.setNombre(nombre);
    	producto.setId_producto(idproducto);
    	producto.setCategoria(categoria);
    	producto.setId_tienda(idtienda);
    	producto.setPrecio(Double.parseDouble(precio));
    	
    
    	productoService.updateProducto(producto);
    	
    	
    	if(categoria!=null) {
    	if(categoria.equals("mercancia")) {
    		
    		Mercancia mercancia=new Mercancia();
    		
    		mercancia.setCodigo(req.getParameter("codigo"));
   
    		mercancia.setUrl_foto("mercancia");
    		
    		mercancia.setStock(Integer.parseInt(req.getParameter("stock")));
    		
    		mercancia.setDescripcion(descripcion);
    	
    		mercancia.setId_producto(idproducto);
    		productoService.updateMercancia(mercancia);
    	
    	}else if(categoria.equals("comida")) {
    		
    		Comida comida=new Comida();
    		comida.setIngrediente(descripcion);
    		comida.setId_producto(idproducto);
    		comida.setUrl_foto("comida");
    		productoService.updateComida(comida);
    		
    	}else {
    		
    		Servicio servicio=new Servicio();
    		
    		servicio.setDescripcion(descripcion);
    		servicio.setId_producto(idproducto);

    		productoService.updateServicio(servicio);
    		
    	}
    	
    	}
    	
    	
 
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



    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	
    	
    	List<Productos> productos=productoService.queryProductos(2);
    	

    	for(Productos i:productos) {
		
		i.setIdentificacion(i.getId_producto());
		
	}

    	req.setAttribute("productos", productos);
    
    	req.getRequestDispatcher("/pagefunciones/addupdate.jsp").forward(req, resp);
    
    
    		
    }


	
	
}
