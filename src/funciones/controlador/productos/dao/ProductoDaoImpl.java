package funciones.controlador.productos.dao;

import java.io.File;
import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.fileupload.FileItem;

import com.manda.android.controlador.Comida;
import com.manda.android.controlador.Mercancia;
import com.manda.android.controlador.Productos;
import com.manda.android.controlador.Servicio;

import dao.utils.BaseDao;
import variables.DirectorioImagen;

public class ProductoDaoImpl extends BaseDao implements ProdcutoDao {

			
	
	
			@Override
			public int addProdducto(Productos producto) {
				
			    // (id_producto,precio,nombre,categoria,id_tienda)
			String sql="insert into producto(PRECIO, NOMBRE, ID_TIENDA, CATEGORIA) values(?,?,?,?)";
			
				
				// TODO Auto-generated method stub
				return update(sql, producto.getPrecio(),producto.getNombre(),producto.getId_tienda(),producto.getCategoria());
			}
			
			@Override
			public int deleteProductoByID(Integer id,String que) {
				// TODO Auto-generated method stub
				
				String sql="delete from "+que+" where id_producto=?";
			
				
				return update(sql, id);
			}
			
			@Override
			public int updateProducto(Productos producto) {
				// TODO Auto-generated method stub
				
				String sql="update producto set precio=?,nombre=?,categoria=? where id_producto=?";
				
				return update(sql, producto.getPrecio(),producto.getNombre(),producto.getCategoria(),producto.getId_producto());
			}
			
			@Override
			public Productos queryProductoById(Integer id) {
				// TODO Auto-generated method stub
				
				String sql="SELECT precio,nombre,categoria,id_tienda from producto where id_producto=?";
				
				return queryForOne(Productos.class, sql, id);
			}
			
			@Override
			public List<Productos> queryProductos(Integer id_tienda) {
				// TODO Auto-generated method stub
				
				
				String sql="SELECT id_producto,precio,producto.nombre,producto.categoria,producto.id_tienda from\r\n"
						+ "	     tienda join producto on producto.id_tienda=tienda.id_tienda\r\n"
						+ "		       where tienda.id_tienda=? ";
				
				return queryForList(Productos.class, sql, id_tienda);
			}

			@Override
			public int addComida(Comida comida,FileItem fileFoto) {
				// TODO Auto-generated method stub
				
				
				BigDecimal id_producto=(BigDecimal) queryForUnValor("select max(id_producto) from producto", null);
						
				
				String sql="INSERT INTO COMIDA (ID_PRODUCTO, URL_FOTO, INGREDIENTE) VALUES (?, ?, ?)";
				
				String directorio=DirectorioImagen.DIRECOTRIO_IMAGE+"\\comida\\"+id_producto.toString()+".png";
				
				copiarFoto(fileFoto, directorio);
				
				return update(sql,id_producto,
						directorio
						,comida.getIngrediente());
			}

			@Override
			public int addMercancia(Mercancia mercancia,FileItem fileFoto) {
				// TODO Auto-generated method stub
				
				BigDecimal id_producto=(BigDecimal) queryForUnValor("select max(id_producto) from producto", null);
				String sql="INSERT INTO MERCANCIA (ID_PRODUCTO, URL_FOTO, DESCRIPCION, STOCK, CODIGO) "
		
						+ "VALUES (?,?,?,?,?)";
				
				String directorio=	DirectorioImagen.DIRECOTRIO_IMAGE+"\\mercancia\\"+id_producto.toString()+".png";
				
				copiarFoto(fileFoto, directorio);
				
				return update(sql,id_producto,directorio,mercancia.getDescripcion(),mercancia.getStock()
						,mercancia.getCodigo());
			}

			@Override
			public int addServicio(Servicio servicio) {
				// TODO Auto-generated method stub
				
				
				BigDecimal id_producto=(BigDecimal) queryForUnValor("select max(id_producto) from producto", null);
				String sql="INSERT INTO SERVICIO (ID_PRODUCTO, DESCRIPCION) VALUES (?,?)";
				
				
				return update(sql,id_producto,servicio.getDescripcion());
			}

			@Override
			public int updateComida(Comida comida,FileItem fileFoto) {
				// TODO Auto-generated method stub
				
				String sql="UPDATE COMIDA SET INGREDIENTE = ?, URL_foto=?"
						+ "	WHERE id_producto=?";
		
				
				String directorio=	DirectorioImagen.DIRECOTRIO_IMAGE+"\\comida\\"+String.valueOf(comida.getId_producto())+".png";
				
				
				copiarFoto(fileFoto, directorio);	
				
				return update(sql, comida.getIngrediente(),directorio,comida.getId_producto());
			}

			@Override
			public int updateMercancia(Mercancia mercancia,FileItem fileFoto) {
		
				String sql=
				"UPDATE MERCANCIA SET URL_FOTO = ?, DESCRIPCION = ?, STOCK = ?, CODIGO = ?"
						+ " WHERE id_producto=?";
					
				String directorio=	DirectorioImagen.DIRECOTRIO_IMAGE+"\\mercancia\\"+String.valueOf(mercancia.getId_producto())+".png";
				
				copiarFoto(fileFoto, directorio);
				
				return update(sql, directorio,mercancia.getDescripcion(),mercancia.getStock(),
						mercancia.getCodigo(),mercancia.getId_producto());
			}

			@Override
			public int updateServicio(Servicio servicio) {
				
				String sql="UPDATE SERVICIO  SET DESCRIPCION = ?"
	
						+ " WHERE id_produco=?";
					
				return update(sql, servicio.getDescripcion(),servicio.getId_producto());
			}

		
			
		private void copiarFoto(FileItem fileFoto,String directorio) {
				
				if(fileFoto.getSize()!=0) {
					try {
						fileFoto.write(new File(directorio));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
				
				
}
