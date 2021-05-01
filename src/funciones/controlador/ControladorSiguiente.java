package funciones.controlador;

import java.math.BigDecimal;
import java.util.ArrayList;

import dao.utils.BaseDao;
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
		
		
		usuarioEncola=(ArrayList<UsuarioEnCola>) queryForList(UsuarioEnCola.class,VariableSqlWEB.LISTAR_RPIMEROS_5_TURNOS, id_cola);
		

		BigDecimal turno=(BigDecimal)queryForUnValor(VariableSqlWEB.TURNO_ACTUAL_EN_COLA, id_cola);
		
	
		
		return usuarioEncola;
		
	}
	
	
	public void  llamaSiguiente(int id_cola) {
	
	
	
	ArrayList<UsuarioEnCola> usuarioEncola=(ArrayList<UsuarioEnCola>)getPrimerCincoTurno(id_cola);
	
			// aun hay gente en la fila
		if(usuarioEncola.size()>0) {
				
			int turnoCliente=usuarioEncola.get(0).getTurno();
			
			// dejar estado del usuario anterior en terminado
			update(VariableSqlWEB.DEJAR_UTLIMO_USUARIO_P_EN_T,FechaYhora.horaMomento(),id_cola);
			
			update(VariableSqlWEB.USUARIO_EN_PROCESO,turnoCliente,id_cola);
			
			// actualizar turno actual en tabla cola
			update(VariableSqlWEB.ACTURALIZAR_TRUNO_ACTUAL,turnoCliente,id_cola);
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
