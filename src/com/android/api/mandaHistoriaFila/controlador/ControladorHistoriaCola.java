package com.android.api.mandaHistoriaFila.controlador;

import java.util.ArrayList;

import com.dao.utils.BaseDao;

public class ControladorHistoriaCola extends BaseDao {

	
	
	
	public static void main(String[] args) {
		
		ControladorHistoriaCola controlador=new ControladorHistoriaCola();
		
		controlador.listaHistoriaEnFila(222);
		
	}
	
	
	
	
	public ArrayList<HistoriaEnFila>  listaHistoriaEnFila(int id_user) {
		
		
		ArrayList<HistoriaEnFila> listaHistoria=new ArrayList<>();
		
		String sql="select fecha,tienda.nombre,hora_entrada,hora_terminada from usuarioencola\r\n"
				+ "join cola on cola.id_cola=usuarioencola.id_cola\r\n"
				+ "join tienda on tienda.id_tienda=cola.id_tienda\r\n"
				+ "where usuarioencola.id_usuario=?\r\n"
				+ "order by fecha";
		
		
		
		listaHistoria=(ArrayList<HistoriaEnFila>)queryForList(HistoriaEnFila.class, sql, id_user);
		
		
		
		return listaHistoria;
		
	}
	
}
