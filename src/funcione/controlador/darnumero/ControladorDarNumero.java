package funcione.controlador.darnumero;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import dao.utils.BaseDao;
import dao.utils.JdbcUtils;
import variables.FechaYhora;
import variables.VariableSQL;
import variables.VariableSqlWEB;

public class ControladorDarNumero extends BaseDao{

	
	
	private int id_usuario;
	

	private int id_cola;
	
	

	
	public ControladorDarNumero( int id_cola) {
		
		this.id_cola = id_cola;
	}



/*
	public static void main(String[] args) {
		
		
		ControladorDarNumero numero=new ControladorDarNumero(301);
		
			System.out.println(	numero.incorporar());
	}
*/
	
	
	
	public String incorporar() {
		

		
		BigDecimal iduser=(BigDecimal) queryForUnValor(VariableSqlWEB.BUSCAR_ID_USER_POR_ID_COLA,id_cola);
		
		id_usuario=Integer.parseInt(iduser.toString());

		
		
		
		Connection connection= JdbcUtils.getConeection();
		CallableStatement call=null;
		int turnoCola=0;
		try {

			call=connection.prepareCall("begin ElijeUltimoTurno(? ,?) ; end;");

			call.setInt(1,id_cola);

			call.registerOutParameter(2, Types.INTEGER);// poner salida

			call.execute();

			turnoCola= call.getInt(2);

			call.close();

			connection.close();

		} catch (SQLException throwables) {
			throwables.printStackTrace();

		}
	
		update(VariableSQL.ANDAIR_USUARIOENCOLA_QR,id_usuario,id_cola,turnoCola,FechaYhora.horaMomento());
		
		return  String.valueOf(turnoCola);
	}
}
