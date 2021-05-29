package com.mpdificar.cuenta;

import com.android.getuserbyid.Usuario;

import dao.utils.BaseDao;

public class ControladorMidifica extends BaseDao{
	
	
	
	public void modificarAndroid(Usuario user,int id) {
		
		
		String sql="update usuario set nombre=?,sexo=?,telefono=? where id_usuario=?";
		
		
		update(sql, user.getNombre(),user.getSexo(),user.getTelefono().toString(),id);
		
		
		String sql2="update cuenta_usuario set email=? where id_usuario=?";
		
		update(sql2, user.getEmail(),id);
		
		
	}

}
