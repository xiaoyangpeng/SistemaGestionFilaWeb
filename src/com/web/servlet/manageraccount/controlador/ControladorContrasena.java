package com.web.servlet.manageraccount.controlador;

import java.math.BigDecimal;

import com.dao.utils.BaseDao;

import variables.VariableSQL;
import variables.VariableSqlWEB;

public class ControladorContrasena extends BaseDao {

	
	
	public int existeUsuario(String email) {
		
		BigDecimal id=(BigDecimal) queryForUnValor(VariableSQL.CON_EMAIL_BUSCAR_ID_USUARIO, email);
		
		
		if(id==null) {
			
			return 0;
		}
		
		return toInt(id.toString());
	}
	
	
	public int toInt(String numero) {
	
		try {		
			int id=0;
			
			id=Integer.parseInt(numero);
			return id;
			
		}catch(Exception e) {
			
			return 0;
			
		}
		
	}
	
	
	
	public int existeEmialTienda(String email) {
		
		BigDecimal id=(BigDecimal) queryForUnValor(VariableSqlWEB.CON_EMIAL_BUSCA_ID_TIENDA, email);
		
		if(id==null) {
			
			return 0;
		}
		
		
		return toInt(id.toString());
		
	}
	
	
	
	public void reestablecerTienda(int contrasena,int id_tienda) {
		
		update(VariableSqlWEB.RESETABLECER_CONTRASENA_TIENDA,contrasena,id_tienda);
		
	}
	
	
	public void resetabalceerUsuario(int contrasena,int id_usuario) {
		
		
		update(VariableSqlWEB.RESETABLECER_CONTRASENA_USUAIRO,contrasena,id_usuario);
	}
	
}
