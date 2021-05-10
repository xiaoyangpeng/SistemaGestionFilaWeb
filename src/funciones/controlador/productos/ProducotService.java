package funciones.controlador.productos;

import java.util.List;

import com.manda.android.controlador.Comida;
import com.manda.android.controlador.Mercancia;
import com.manda.android.controlador.Productos;
import com.manda.android.controlador.Servicio;

public interface ProducotService {
	
	
	public void deleteProductoByID(Integer id,String que);
	
	public int addComida(Comida comida);
	public int addMercancia(Mercancia comida);
	
	
	public int addServicio(Servicio comida);
	
	
	public void addProdducto(Productos producto);
	
	public void updateProducto(Productos producto);
	
	
	public Productos queryProductoById(Integer id);
	
	
	

	public int updateComida(Comida  comida);
	
	
	public int updateMercancia(Mercancia mercancia);
	
	
	public int updateServicio(Servicio servicio);
	
	
	
	
	public List<Productos> queryProductos(Integer id_tienda);
	

}
