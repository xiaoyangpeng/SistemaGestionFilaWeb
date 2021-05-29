package funciones.controlador.productos;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.filter.ComprobacionToken;
import com.manda.android.controlador.Comida;
import com.manda.android.controlador.ControladorBuscaProducto;
import com.manda.android.controlador.Mercancia;
import com.manda.android.controlador.Productos;
import com.manda.android.controlador.Servicio;

public class AddProducto extends HttpServlet {

	
	 private ProducotService productoService=new ProductoServiceImpl();
	/**
	 *
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		Productos productos=new Productos();
		
		StringBuilder action=new StringBuilder();
		
		List<FileItem> list = null;
		
		FileItem fileFoto=null;
		
		if(ServletFileUpload.isMultipartContent(req)) {
			
			// 创建工厂实现类
			FileItemFactory fileItemFactory=new DiskFileItemFactory();
			
			ServletFileUpload servletFileUpload=new ServletFileUpload(fileItemFactory);
		
			try {
	
			list=servletFileUpload.parseRequest(req);
			
			for(FileItem fileItem :list ) {
			
				
			
				if(fileItem.isFormField()) {
					// 普通表单项目
					crearProducto(fileItem,productos,action);
	
				}else {
					
					fileFoto=fileItem;
					
					
				}
				
			}
			
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			queOperacion(req, action, productos, list,fileFoto);
		}else {
			
			//add(req, resp);
			
		}
		
		
		// evita bug si pulsa f5 vuelve a crear otro producto mismo
    	resp.sendRedirect(req.getContextPath()+"/manager/productoservlet?action=list");
	}
	

	private void queOperacion(HttpServletRequest req,StringBuilder action,Productos productos,	List<FileItem> list,FileItem fileFoto) {
		
		if(action.toString().equals("add")) {
			
			add(req, productos, list,fileFoto);
			
		}else if(action.toString().equals("update")) {
			
			update(productos, list,fileFoto);
		}
		
	}
	
	
	private void crearProducto(FileItem fileItem, Productos productos,StringBuilder action) {
		
		switch (fileItem.getFieldName()) {
		case "action":
			action.append(valorFileItem(fileItem));
			break;
			
		case "id":	
			productos.setId_producto(stringToInt(valorFileItem(fileItem)));
			break;
			
		case "idtienda":
			
			productos.setId_tienda(stringToInt(valorFileItem(fileItem)));
			break;
			
		case "nombre":
			
			productos.setNombre(valorFileItem(fileItem).toLowerCase());
			break;
			
			
		case "precio":
			
			productos.setPrecio(stringToDouble(valorFileItem(fileItem)));
			
			break;
			
		case "categoria":
			productos.setCategoria(valorFileItem(fileItem));
			break;
			}
		
	}
	
	
	private void addupdateComida(String action,List<FileItem> list,Comida comida,FileItem fileFoto) {
		
		for(FileItem fileItem :list ) {
			
			if(fileItem.isFormField()) {
				// 普通表单项目
				if(fileItem.getFieldName().equals("descripcion")) {
					comida.setIngrediente(valorFileItem(fileItem));
					break;
				}
			}
		}
		
		if(action.equals("add")) {
			
			productoService.addComida(comida,fileFoto);
		}else {
			
			productoService.updateComida(comida,fileFoto);
		}
	}
	
	
	
	private void addupdateServicio(String action,List<FileItem> list,Servicio servicio) {
		
		for(FileItem fileItem :list ) {
			
			if(fileItem.isFormField()) {
				// 普通表单项目
				if(fileItem.getFieldName().equals("descripcion")) {
					servicio.setDescripcion(valorFileItem(fileItem));
					break;
				}
			}
		}
		
		if(action.equals("add")) {
			
			productoService.addServicio(servicio);
		}else {
			
			productoService.updateServicio(servicio);
		}
	}
	
	

	private void addupdateMercancia(String action,List<FileItem> list,Mercancia mercancia,FileItem fileFoto) {
		
		for(FileItem fileItem :list ) {
			
			if(fileItem.isFormField()) {
				// 普通表单项目
				
				switch (fileItem.getFieldName()) {
				
				case "descripcion":
					
					mercancia.setDescripcion(valorFileItem(fileItem));
				break;
				
				case "codigo":
					
					mercancia.setCodigo(valorFileItem(fileItem));
				break;
				case "stock":
					
					mercancia.setStock(stringToInt(valorFileItem(fileItem)));
	    
	    		break;
	    	
				}
			}
		}
		
		if(action.equals("add")) {
			
			productoService.addMercancia(mercancia,fileFoto);
		}else {
			
			productoService.updateMercancia(mercancia,fileFoto);
		}
	}
	
	
    protected void add(HttpServletRequest req,Productos productos,	List<FileItem> list,FileItem fileFoto) {
    	
    	int id_tienda=ComprobacionToken.vertificaIdTienda(req);
   
    	productos.setId_tienda(id_tienda);
   
    	productoService.addProdducto(productos);
    	
    	if(productos.getCategoria().equals("mercancia")) {
    		
    		Mercancia mercancia=new Mercancia();
    		
			addupdateMercancia("add", list, mercancia,fileFoto);
    
    	
    	}else if(productos.getCategoria().equals("comida")) {
    		
    		Comida comida=new Comida();
    		addupdateComida("add", list, comida,fileFoto);
    
    	}else {
    		
    		Servicio servicio=new Servicio();
    		
    		addupdateServicio("add", list, servicio);
    		
    	}
    	
 
    }


    protected void update(Productos productos,	List<FileItem> list,FileItem fileFoto)  {

  
    	productoService.updateProducto(productos);
   
    	if(productos.getCategoria().equals("mercancia")) {
    		
    		Mercancia mercancia=new Mercancia();
   
    		mercancia.setId_producto(productos.getId_producto());
    		
    		addupdateMercancia("update", list, mercancia,fileFoto);
    	
    	}else if(productos.getCategoria().equals("comida")) {
    		
    		Comida comida=new Comida();

    		comida.setId_producto(productos.getId_producto());
    	
    		addupdateComida("update", list, comida,fileFoto);
    		
    	}else {
    		
    		Servicio servicio=new Servicio();
    	
    		servicio.setId_producto(productos.getId_producto());

    		addupdateServicio("update", list, servicio);
    		
    	}
    	
    	
    	
    }



	private double stringToDouble(String valor) {
		
		try {
			
			return Double.parseDouble(valor);
		} catch (Exception e) {
			// TODO: handle exception
			return 0.0;
		}
		
		}
	
	
	private int stringToInt(String valor) {
		
		try {
			
			return Integer.parseInt(valor);
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
		
	}
	
		
	private String valorFileItem(FileItem fileItem)  {
	
		String valor=null;
		try {
	
			valor=fileItem.getString("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return valor;
	}
	
}
