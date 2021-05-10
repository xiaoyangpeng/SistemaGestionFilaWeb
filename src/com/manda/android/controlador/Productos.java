package com.manda.android.controlador;

import java.util.ArrayList;

public class Productos {
	
	
	public Integer id_producto;
	
	private double precio;
	
	private String nombre;


	private String categoria;
	
	public  Integer id_tienda;
	
	private Integer identificacion;


	
	
	
	



	public Integer getIdentificacion() {
		return identificacion;
	}


	public void setIdentificacion(Integer identificacion) {
		this.identificacion = identificacion;
	}


	public Integer getId_producto() {
		return id_producto;
	}

	
	public void setId_producto(Integer id_producto) {
		this.id_producto = id_producto;
	}

	public double getPrecio() {
		return precio;
	}

	
	
	
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Integer getId_tienda() {
		return id_tienda;
	}

	public void setId_tienda(Integer id_tienda) {
		this.id_tienda = id_tienda;
	}
	
	
	
	
	
	

}




