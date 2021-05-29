package funciones.controlador.gestionfila;

import dao.utils.BaseDao;
import variables.VariableSqlWEB;

public class ActivacionFila extends BaseDao{
	
	
	
	public void activarFila(int id_cola) {
		
		update(VariableSqlWEB.ACTIVAR_FILA, id_cola);
		
	}
	
	public void desactivarFila(int id_cola) {
		
		update(VariableSqlWEB.DESACTIVAR_FILA, id_cola);
		
	}
	
	public boolean estaActivado (int id_cola) {
		
	String result=(String)	queryForUnValor(VariableSqlWEB.BUSCAR_ESTADO_FILA, id_cola);
		if(result.equals("a")) {
			
			return true;
		}else {
			return false;
		}
		
	}
	

}
