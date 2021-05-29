package com.android.getuserbyid;


import com.manda.android.controlador.Comida;

import dao.utils.BaseDao;
import variables.VariableSqlWEB;

public class ControladorByIDUser extends BaseDao{
	
	
	
	/*public static void main(String[] args) {
		
		
		Controlador f=new Controlador();
				
				f.findUser(222);
	}*/
	
	public Usuario findUser(int id) {
		Usuario user;
		
		String sql="select email,nombre,telefono,sexo from usuario\r\n"
				+ "\r\n"
				+ "join cuenta_usuario on usuario.id_usuario=cuenta_usuario.id_usuario\r\n"
				+ "\r\n"
				+ "where usuario.id_usuario=?";
		user=(Usuario)queryForOne(Usuario.class, sql,id);
		
		return user;
	}

}
