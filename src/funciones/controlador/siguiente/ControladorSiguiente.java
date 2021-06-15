package funciones.controlador.siguiente;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import dao.utils.BaseDao;
import dao.utils.JdbcUtils;
import variables.FechaYhora;
import variables.VariableSqlWEB;


public class ControladorSiguiente extends BaseDao {
	

	
public static void main(String[] args) {
		
		ControladorSiguiente siguiente=new ControladorSiguiente();
		
		
		//siguiente.getPrimerCincoTurno(1);
		
		
			siguiente.llamaSiguiente(361);
	
	//siguiente.getTodosTurno(361);
		
	//System.out.println();
		
	}
	


	
	public  ArrayList<UsuarioEnCola> getTodosTurno(int id_cola){
		
		
		ArrayList<UsuarioEnCola> usuarioEncola=new 	ArrayList<UsuarioEnCola>();
		
		
		usuarioEncola=(ArrayList<UsuarioEnCola>) queryForList(UsuarioEnCola.class,VariableSqlWEB.LISTAR_RPIMEROS_TURNOS, id_cola);
		

		BigDecimal turno=(BigDecimal)queryForUnValor(VariableSqlWEB.TURNO_ACTUAL_EN_COLA, id_cola);
		

		return usuarioEncola;
		
	}
	
	
	public void  llamaSiguiente(int id_cola) {
	

	ArrayList<UsuarioEnCola> usuarioEncola=(ArrayList<UsuarioEnCola>)getTodosTurno(id_cola);
	
			// aun hay gente en la fila
		if(usuarioEncola.size()>0) {
				
			int turnoCliente=usuarioEncola.get(0).getTurno();
			
			//if(turnoCliente!=1) {
			// dejar estado del produco en T
				
			//dejarProductoEnT(id_cola);
			
			
			//}
			
			cogerSigueinte(usuarioEncola,id_cola);
		}
		
		

	}
	

	
	private boolean cogerSigueinte(ArrayList<UsuarioEnCola> usuarioEncola,int id_cola) {
	
	
		
		UsuarioEnCola user=usuarioEncola.get(0);
		
		if(user.getHora_cancelar()==null) {
			
				
			
		}else if(FechaYhora.StringtoDaLong(FechaYhora.horaMomento())<
				
				FechaYhora.StringtoDaLong(user.getHora_cancelar())) {
			
		String sql="update usuarioencola set turno=? where turno=? and id_cola=?";
		
		int turnoesteUser=user.getTurno();
		
		int[] mynumbero=mirarSiguientSiesRemota(usuarioEncola, 0);
		
			if(mynumbero!=null) {
				
				int turnoSiguenteUser=mynumbero[0];
				
				int idSiguienteUser=mynumbero[1];
				
				update(sql,turnoesteUser,turnoSiguenteUser,id_cola);
				
				
				String sql2="  update usuarioencola set turno=turno+1 where (turno>=? and turno<? )\r\n"
						+ "  \r\n"
						+ "  and id_cola=? and id_usuario!=?";
				
				update(sql2, turnoesteUser,turnoSiguenteUser+1,id_cola,idSiguienteUser);
				
			
			}else {
				
				return false;
			}
		
		
			
		}
		
		
	
		
		// dejar el siguiente su estado en proceso
		update(VariableSqlWEB.USUARIO_EN_PROCESO,FechaYhora.horaMomento(),user.getTurno(),id_cola);
						
		// actualizar turno actual en tabla cola
		update(VariableSqlWEB.ACTURALIZAR_TRUNO_ACTUAL,user.getTurno(),id_cola);
		
		return true;
	}
	
	
	private int[] mirarSiguientSiesRemota(ArrayList<UsuarioEnCola> usuarioEncola,int array) {
		
		if(usuarioEncola.size()==array) {
			return null;
		}
		
		UsuarioEnCola user=usuarioEncola.get(array);
		
		 if(user.getFormato().equals("QR")) {
			

			int[] mynumber={user.getTurno(), user.getId_usuario()};
			
			return mynumber ;
		}else {
			
			return mirarSiguientSiesRemota(usuarioEncola, array+1);
		}
		
	

		
	}
	

	
	
	/*private void dejarProductoEnT(int id_cola) {
		
		Connection connection= JdbcUtils.getConeection();
		CallableStatement call=null;
		
		try {

			call=connection.prepareCall("begin DejarIncorporarEnT(?) ; end;");

			call.setInt(1,id_cola);

			call.execute();


			call.close();

			connection.close();

		} catch (SQLException throwables) {
			throwables.printStackTrace();

		}
		
	}*/
	
	
	/*
	 * *BigDecimal turnoqueda=(BigDecimal)queryForUnValor(VariableSqlWEB.TURNO_QUEDA_EN_COLA,id_cola);	
		
		int turnos=Integer.parseInt(turnoqueda.toString());*/
	
	//if(turnos>0) {
		
		// coger turno actual
		//BigDecimal turno=	(BigDecimal) queryForUnValor(VariableSqlWEB.TURNO_ACTUAL_EN_COLA, id_cola);
				
		
		/*while(true) {
			
			BigDecimal sihay=(BigDecimal) queryForUnValor(VariableSqlWEB.SI_HAY_ESTE_TURNO_EN_FILA,turno);
			
			if(sihay==null) {
				// actualizar turno actual en tabla cola
				update(VariableSqlWEB.ACTURALIZAR_TRUNO_ACTUAL,id_cola,id_cola);
			}else {
				
				break;
			}
			turno=	(BigDecimal) queryForUnValor(VariableSqlWEB.TURNO_ACTUAL_EN_COLA, id_cola);
		}*/
						
		// dejar estado del usuario en terminado
					
		/*update(VariableSqlWEB.TERMINADO_SERVICIO_USUARIO,FechaYhora.horaMomento(),turno,id_cola);
		
		if(turnos>1) {
			
			// actualizar turno actual en tabla cola
			update(VariableSqlWEB.ACTURALIZAR_TRUNO_ACTUAL,id_cola,id_cola);
			
		}*/
		
	 

}
