package funciones.controlador.qr;

import dao.utils.BaseDao;
import variables.GeneraCodigo;
import variables.VariableSqlWEB;

public class ContorladorQr  extends BaseDao{

	public String buscaQRporId(int id_tienda) {
		
		
		return (String) queryForUnValor(VariableSqlWEB.BUSCAR_QR_POR_ID_TIENDA, id_tienda);
		
	}
	
	
	public String cambiarQR(int id_tienda) {
		
		
		String qr=GeneraCodigo.GeneraQRAleatoria()+String.valueOf(id_tienda).hashCode();
		
		update(VariableSqlWEB.ANADIR_QR, qr,id_tienda);
		
		return qr;
	}
	
	
	
}
