package com.android.api.mandainformaciontienda.controlador;

import java.math.BigDecimal;


import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import com.dao.utils.BaseDao;
import com.dao.utils.JdbcUtils;

import variables.FechaYhora;
import variables.VariableSqlWEB;


public class ControladorInfTienda extends BaseDao {

	
	private int id_tienda;
	
	
	
	private Tiendaremota remota;
	

	
	public ControladorInfTienda(int id_tienda) {
		this.id_tienda = id_tienda;
	}



	/*
	public static void main(String[] args) {
		
		
		ControladorInfTienda info=new ControladorInfTienda(2);
		
		info.turnoActualTiempo();
		
	}*/
	
	
	
	public void turnoActualTiempo() {
		
		remota=queryForOne(Tiendaremota.class,VariableSqlWEB.CON_ID_TIENDA_BUSCA_TIEMPO_TURNO_ACTUAL, id_tienda,FechaYhora.fechaHoy());
		
		ultimoTurno();
			
		int turnoqueda=remota.getUltimo_turno()-remota.getTurno_actual();
		remota.setTiempomedia(remota.getTiempomedia()*turnoqueda);
		
	}
	
	
		private  void ultimoTurno() {
		

		Connection connection= JdbcUtils.getConeection();
		CallableStatement call=null;

		try {

			call=connection.prepareCall("begin ElijeUltimoTurno(? ,?) ; end;");

			call.setInt(1,remota.getId_cola());

			call.registerOutParameter(2, Types.INTEGER);// poner salida

			call.execute();

			
			remota.setUltimo_turno(call.getInt(2));
			
		
	
			call.close();

			connection.close();

		} catch (SQLException throwables) {
			throwables.printStackTrace();

		}

	}



		public Tiendaremota getRemota() {
			return remota;
		}



		public void setRemota(Tiendaremota remota) {
			this.remota = remota;
		}
	
		
		
	
	
}
