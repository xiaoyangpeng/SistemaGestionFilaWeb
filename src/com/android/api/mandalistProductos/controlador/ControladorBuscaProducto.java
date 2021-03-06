package com.android.api.mandalistProductos.controlador;


import java.math.BigDecimal;
import java.util.ArrayList;

import com.android.api.impletProductos.Comida;
import com.android.api.impletProductos.Incorporar;
import com.android.api.impletProductos.Mercancia;
import com.android.api.impletProductos.Productos;
import com.android.api.impletProductos.Servicio;
import com.dao.utils.BaseDao;

import variables.VariableSqlWEB;

public class ControladorBuscaProducto extends BaseDao{
	

	private	String id_cola;
	
	private int id_usuario;
	
	private ArrayList<Incorporar> listaUsuario;

		private String nombreProducto;
	
		public ControladorBuscaProducto(String id_cola, int id_usuario,String nombreProducto) {
			
				this.id_cola = id_cola;
				this.id_usuario = id_usuario;
				this.nombreProducto=nombreProducto.toLowerCase();

			}
		
		
		public ControladorBuscaProducto(String id_cola, int id_usuario) {
		
			this.id_cola = id_cola;
			this.id_usuario = id_usuario;

			this.listaUsuario=(ArrayList<Incorporar>) queryForList(Incorporar.class, VariableSqlWEB.BUSCAR_INCORPORAR, id_cola,id_usuario);
			
		}
	
		
		public ControladorBuscaProducto() {
			
		}
		
		

	public ArrayList<Productos> consultaListaProducto(){
		
		
		BigDecimal id_tienda=(BigDecimal)queryForUnValor("select id_tienda from cola where id_cola=?", Integer.parseInt(id_cola));
		
		
		ArrayList<Productos> productos;
		
		productos=(ArrayList<Productos>) queryForList(Productos.class, VariableSqlWEB.BUSCAR_LISTA_PRODUCTO, id_tienda,"%"+nombreProducto+"%");
		
		return productos;
		
	}
		
		
	
	
	
	public Comida consultaComida(int id_prodcuto) {
		
		Comida comida;
		
		
		comida=(Comida) queryForOne(Comida.class, VariableSqlWEB.BUSCAR_COMIDA_CON_ID, id_prodcuto);
		
		
		// encaso que el usuario si ha elegido antes algun producto
		// asignar su cantidad de producto 
		
	if(this.listaUsuario!=null) {
		
				for(Incorporar i:listaUsuario) {
					
					if(i.getId_producto()==comida.getId_producto()) {
						
						comida.setCantidad(i.getCantidad_producto());
					}
					
				
			}
		}
			
		return comida;
	
	}
	
	
	public Servicio consultarServicio(int id_prodcuto) {
		
		Servicio servicios;
		
		servicios=(Servicio ) queryForOne(Servicio.class, VariableSqlWEB.BUSCAR_SERVICIO_CON_ID,id_prodcuto);
		
		if(this.listaUsuario!=null) {
			
			for(Incorporar i:listaUsuario) {
				
				if(i.getId_producto()==servicios.getId_producto()) {
					
					servicios.setCantidad(i.getCantidad_producto());
				}
				
			}
		}
	
		
		return servicios;
		
		
	}
	
	
	public Mercancia consultarMercancia(int id_prodcuto) {
		
		Mercancia mercancia;
		
		mercancia=(Mercancia ) queryForOne(Mercancia.class, VariableSqlWEB.BUSCAR_MERCANCIA_CON_QR,id_prodcuto);
	
		
		if(this.listaUsuario!=null) {
			
			for(Incorporar i:listaUsuario) {
				
				if(i.getId_producto()==mercancia.getId_producto()) {
					
					mercancia.setCantidad(i.getCantidad_producto());
				}
				
			}
		
		}
		
		return mercancia;
	}

}
