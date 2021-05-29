package funciones.controlador.siguiente;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import dao.utils.BaseDao;
import dao.utils.JdbcUtils;
import variables.FechaYhora;
import variables.VariableSqlWEB;


public class ControladorSiguiente extends BaseDao {
	

	
public static void main(String[] args) {
		
		ControladorSiguiente siguiente=new ControladorSiguiente();
		
		
		//siguiente.getPrimerCincoTurno(1);
		
		
		siguiente.llamaSiguiente(1);
		
	}
	

	
	public  ArrayList<UsuarioEnCola> getPrimerCincoTurno(int id_cola){
		
		
		ArrayList<UsuarioEnCola> usuarioEncola=new 	ArrayList<UsuarioEnCola>();
		
		
		usuarioEncola=(ArrayList<UsuarioEnCola>) queryForList(UsuarioEnCola.class,VariableSqlWEB.LISTAR_RPIMEROS_TURNOS, id_cola);
		

		BigDecimal turno=(BigDecimal)queryForUnValor(VariableSqlWEB.TURNO_ACTUAL_EN_COLA, id_cola);
		
	
		
	
		
		return usuarioEncola;
		
	}
	
	
	public void  llamaSiguiente(int id_cola) {
	

	ArrayList<UsuarioEnCola> usuarioEncola=(ArrayList<UsuarioEnCola>)getPrimerCincoTurno(id_cola);
	
			// aun hay gente en la fila
		if(usuarioEncola.size()>0) {
				
			int turnoCliente=usuarioEncola.get(0).getTurno();
			
			// dejar estado del produco en T
			dejarProductoEnT(id_cola);
			
			
			// dejar estado del usuario anterior en terminado
			update(VariableSqlWEB.DEJAR_UTLIMO_USUARIO_P_EN_T,FechaYhora.horaMomento(),id_cola);
			
		
			// dejar el siguiente su estado en proceso
			update(VariableSqlWEB.USUARIO_EN_PROCESO,turnoCliente,id_cola);
			
			// actualizar turno actual en tabla cola
			update(VariableSqlWEB.ACTURALIZAR_TRUNO_ACTUAL,turnoCliente,id_cola);
		}
		
		
		
	}
	
	
	
	private void dejarProductoEnT(int id_cola) {
		
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
		
	}
	
	
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
