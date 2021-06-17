package com.android.api.informacionfila;

import java.math.BigDecimal;

import com.dao.utils.BaseDao;
import com.google.gson.Gson;

import variables.VariableSQL;

public class ControladorInformacionCola  extends BaseDao{

	private int id_cola;
	
	private int id_usuario;
	
	private String turnoActual;
	
	private String miturno;

	private int tiempomediaturno;
	
	public ControladorInformacionCola(int id_usuario) {
		this.id_usuario = id_usuario;

		
		String idcola=BuscaIdCola(id_usuario);
		
		if(idcola!=null) {
			this.id_cola = Integer.parseInt(idcola);
		}
	
		
		miturno=BuscaMiturno();
		
		tiempomediaturno=buscaTiempoMedia();
	
		turnoActual=buscaTurnoActual();
	}
	
	public ControladorInformacionCola() {
		
	}
	
	public String crearJsonInfFila() {
		
		int cuandoPersonaqueda=Integer.parseInt(miturno)-Integer.parseInt(turnoActual);
		
		InformacionColaJson cola=new InformacionColaJson((tiempomediaturno*cuandoPersonaqueda)*60,
				turnoActual,
				String.valueOf(cuandoPersonaqueda),
				miturno,
				String.valueOf(id_cola));
	
		Gson gosn=new Gson();
		
		return gosn.toJson(cola);
		
	}
	
	private String buscaTurnoActual() {
		
		return ((BigDecimal)queryForUnValor(VariableSQL.TURNO_ACTUAL_EN_COLA, id_cola)).toString();
		
	}

	private int buscaTiempoMedia(){


		String sql="select TIEMPOMEDIA from tienda\n" +
				"join cola on tienda.id_tienda=cola.id_tienda\n" +
				"\n" +
				"where id_cola=?";

		BigDecimal timepo=(BigDecimal)queryForUnValor(sql,id_cola);
		return
				Integer.parseInt(timepo.toString());

	}
	
	private String BuscaMiturno() {
		
		String sql="select turno from usuarioencola where id_usuario=? and id_cola=? and estado_cliente='E'";
		
		
		BigDecimal turno=(BigDecimal)queryForUnValor(sql, id_usuario,id_cola);
		
		return turno.toString();
		
		
	}
	
	public String BuscaIdCola(int id_usuario) {
		
	
		String sql="select id_cola from usuarioencola where id_usuario=? and estado_cliente='E'";
		
		BigDecimal id_cola=(BigDecimal)queryForUnValor(sql,id_usuario);
	
		if(id_cola==null) {
			
			return null;
			
		}else {
			return id_cola.toString();
		}
		
	}
	

	
}
