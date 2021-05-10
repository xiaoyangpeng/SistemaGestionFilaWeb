package funciones.controlador.productos;

import java.util.List;

import com.manda.android.controlador.Comida;
import com.manda.android.controlador.Mercancia;
import com.manda.android.controlador.Productos;
import com.manda.android.controlador.Servicio;

import funciones.controlador.productos.dao.ProdcutoDao;
import funciones.controlador.productos.dao.ProductoDaoImpl;

public class ProductoServiceImpl implements ProducotService {

	
	
	
	private ProdcutoDao productoDao=new ProductoDaoImpl();
	
	@Override
	public void addProdducto(Productos producto) {
		// TODO Auto-generated method stub
		
		productoDao.addProdducto(producto);
		
	}

	@Override
	public void deleteProductoByID(Integer id,String que) {
		// TODO Auto-generated method stub
		productoDao.deleteProductoByID(id,que);
	}

	@Override
	public void updateProducto(Productos producto) {
		// TODO Auto-generated method stub
		productoDao.updateProducto(producto);
	}

	@Override
	public Productos queryProductoById(Integer id) {
		// TODO Auto-generated method stub
		return productoDao.queryProductoById(id);
	}

	@Override
	public List<Productos> queryProductos(Integer id_tienda) {
		// TODO Auto-generated method stub
		return productoDao.queryProductos(id_tienda);
	}

	@Override
	public int addComida(Comida comida) {
		// TODO Auto-generated method stub
		return productoDao.addComida(comida);
	}

	@Override
	public int addMercancia(Mercancia mercancia) {
		// TODO Auto-generated method stub
		return productoDao.addMercancia(mercancia);
	}

	@Override
	public int addServicio(Servicio servicio) {
		// TODO Auto-generated method stub
		return productoDao.addServicio(servicio);
	}

	@Override
	public int updateComida(Comida comida) {
		// TODO Auto-generated method stub
		return productoDao.updateComida(comida);
	}

	@Override
	public int updateMercancia(Mercancia mercancia) {
		// TODO Auto-generated method stub
		return productoDao.updateMercancia(mercancia);
	}

	@Override
	public int updateServicio(Servicio servicio) {
		// TODO Auto-generated method stub
		return productoDao.updateServicio(servicio);
	}

}
