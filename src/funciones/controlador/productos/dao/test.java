package funciones.controlador.productos.dao;

import java.util.ArrayList;

import com.manda.android.controlador.Productos;

public class test {

	
	public static void main(String[] args) {
		
		ProductoDaoImpl im=new ProductoDaoImpl();
		
	Productos p=new Productos();
		
		
	p.setCategoria("servicio");
		
	
	p.setId_producto(104);
		p.setId_tienda(2);
		
		p.setNombre("ffffff");
		
		p.setPrecio(111);
		//im.addProdducto(p);
		
		//im.updateProducto(p);
		
		//im.deleteProductoByID(104);
		/*p=im.queryProductoById(2);*/
	
		//System.out.println(p.getCategoria());
		
		
		ArrayList<Productos> pp=(ArrayList<Productos>) im.queryProductos(2);
		
		
		for( Productos i:pp) {
			
			System.out.println(i.getId_producto());
		}
		
	}
}
