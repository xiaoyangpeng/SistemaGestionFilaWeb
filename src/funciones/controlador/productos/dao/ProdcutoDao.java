package funciones.controlador.productos.dao;

import java.util.List;

import com.manda.android.controlador.*;

public interface ProdcutoDao {
	
	
	public int addComida(Comida comida);
	public int addMercancia(Mercancia comida);
	
	
	public int addServicio(Servicio comida);
	public int addProdducto(Productos producto);

	public int deleteProductoByID(Integer id,String que);
	
	
	public int updateProducto(Productos producto);
	
	
	public int updateComida(Comida  comida);
	
	
	public int updateMercancia(Mercancia mercancia);
	
	
	public int updateServicio(Servicio servicio);
	
	
	public Productos queryProductoById(Integer id);
	
	
	public List<Productos> queryProductos(Integer id_tienda);
}
