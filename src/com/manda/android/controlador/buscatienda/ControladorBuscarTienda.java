package com.manda.android.controlador.buscatienda;

import java.util.ArrayList;

import com.sun.org.apache.regexp.internal.recompile;

import dao.utils.BaseDao;
import variables.VariableSqlWEB;

public class ControladorBuscarTienda extends BaseDao{

	
	
	private String nombre;

	public ControladorBuscarTienda(String nombre) {
		this.nombre = nombre;
	}
	
	
	/*
	public static void main(String[] args) {
	
		
		ControladorBuscarTienda tienda=new ControladorBuscarTienda("a");
		
		tienda.buscaTienda();
		
			
	}*/
	
	
	public ArrayList<Tienda> buscaTienda(){
		
		 ArrayList<Tienda> tienda;
		 
		 tienda =(ArrayList<Tienda>)queryForList(Tienda.class, VariableSqlWEB.BUSCAR_TIENDA_POR_NOMBRE_CALLE,"%"+nombre+"%","%"+nombre+"%");
		 
	
		 return tienda;
	}
	
	
	
}
