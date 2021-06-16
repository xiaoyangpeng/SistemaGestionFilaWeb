package com.web.servlet.managefunction.controlador.usuarioentienda;

import java.util.ArrayList;

import com.dao.utils.BaseDao;

import variables.VariableSQL;
import variables.VariableSqlWEB;

public class ControladorClienteEnTienda extends BaseDao {
	
	
	
	public static void main(String[] args) {
		ControladorClienteEnTienda tienda=new ControladorClienteEnTienda();
		
		//tienda.todosUsuarioEnProceso();
		
		
	}
	
	
	
	public ArrayList<UsuarioEnProceso> todosUsuarioEnProceso(int id_cola) {
		
		ArrayList<UsuarioEnProceso> listaEnproceso=new ArrayList<>();
		
		
		listaEnproceso=(	ArrayList<UsuarioEnProceso> )queryForList(UsuarioEnProceso.class, VariableSqlWEB.LISTA_CLIENTE_EN_TIENDA, id_cola);
		
		
		return listaEnproceso;
	}
	
	
	public ArrayList<UsuarioEnProceso> dejarEstadoClienteEnT(int id_cola,int id_user) {
		
		// dejar estado del usuario anterior en terminado
		
		update(VariableSqlWEB.DEJAR_UTLIMO_USUARIO_P_EN_T,id_cola,id_user);
		
		update(VariableSqlWEB.DEJAR_ESTADO_PRODUCTO_EN_T,id_cola,id_user);
		
		return todosUsuarioEnProceso(id_cola);
		
		
	}
	
	
	

}
