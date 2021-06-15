package com.manda.android.controlador.mandainformaciocola;


import java.io.DataOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.Socket;

import com.google.gson.Gson;

import dao.utils.BaseDao;




public class MandaInformacionCola extends BaseDao{

	private BigDecimal id_cola;
	
	private BigDecimal id_usuario;
	
	private Socket misocket;
	
	
	private String turnoActual;
	
	private String miturno;

	private int tiempomediaturno;
	public MandaInformacionCola(Socket misocket,BigDecimal id_cola, BigDecimal id_usuario,String miturno) {
		this.misocket=misocket;
		this.id_cola = id_cola;
		this.id_usuario = id_usuario;
		this.miturno=miturno;
		tiempomediaturno=buscaTiempoMedia();
	}
	
		

	public int buscaTiempoMedia(){


		String sql="select TIEMPOMEDIA from tienda\n" +
				"join cola on tienda.id_tienda=cola.id_tienda\n" +
				"\n" +
				"where id_cola=?";

		BigDecimal timepo=(BigDecimal)queryForUnValor(sql,id_cola);
		return
				Integer.parseInt(timepo.toString());

	}
	
}
