package com.web.servlet.managefunction.controlador.productos;

import java.util.List;

import org.apache.commons.fileupload.FileItem;

import com.android.api.impletProductos.Comida;
import com.android.api.impletProductos.Mercancia;
import com.android.api.impletProductos.Productos;
import com.android.api.impletProductos.Servicio;

public interface ProducotService {
	
	
	public void deleteProductoByID(Integer id,String que);
	
	public int addComida(Comida comida,FileItem fileFoto);
	public int addMercancia(Mercancia comida,FileItem fileFoto);
	
	
	public int addServicio(Servicio comida);
	
	
	public void addProdducto(Productos producto);
	
	public void updateProducto(Productos producto);
	
	
	public Productos queryProductoById(Integer id);
	
	
	

	public int updateComida(Comida  comida,FileItem fileFoto);
	
	
	public int updateMercancia(Mercancia mercancia,FileItem fileFoto);
	
	
	public int updateServicio(Servicio servicio);
	
	
	
	
	public List<Productos> queryProductos(Integer id_tienda);
	

}
