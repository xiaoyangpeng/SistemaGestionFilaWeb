package com.manda.android.controlador;

import java.util.ArrayList;


import dao.utils.BaseDao;
import variables.VariableSqlWEB;

public class BuscaListaProductoUsuario extends BaseDao{

	
	private int id_cola;
	
	private int id_usuario;

	public BuscaListaProductoUsuario(int id_cola, int id_usuario) {
		this.id_cola = id_cola;
		this.id_usuario = id_usuario;
	}
	
	
	/*
	public static void main(String[] args) {
		
		BuscaListaProductoUsuario buscaListaProductoUsuario=new BuscaListaProductoUsuario(1, 222);
		buscaListaProductoUsuario.buscar();
	}*/
	
	
	public ArrayList<ListaProducto> buscar() {
		
		
		ArrayList<ListaProducto> lista;
		
		
		lista=(ArrayList<ListaProducto>) queryForList(ListaProducto.class, VariableSqlWEB.BUSCAR_LISTA_PRODUCTOS_USUARIO, id_cola,id_usuario);
		
		
		for(ListaProducto i:lista) {
		
			i.setPrecioTotal(i.getPrecio()*i.getCantidad_producto());
			
			
		}
		
		return lista;
	}
	
	
	
	
}
