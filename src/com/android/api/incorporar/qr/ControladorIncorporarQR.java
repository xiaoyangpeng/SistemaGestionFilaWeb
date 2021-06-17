package com.android.api.incorporar.qr;



import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import com.dao.utils.BaseDao;
import com.dao.utils.JdbcUtils;

import variables.FechaYhora;
import variables.VariableSQL;

public class ControladorIncorporarQR extends BaseDao{

	
	private String codigoQR;
	
	
	private BigDecimal id_cola;
	
	private int id_usuario;

	public ControladorIncorporarQR(int id_usuario, String codigoQR) {
		this.id_usuario=id_usuario;
		this.codigoQR = codigoQR;
	}
	

	/*
	public static void main(String[] args) {
		
		ControladorIncorporarQR qr=new ControladorIncorporarQR("8888","ASDF");
		
		System.out.println(qr.siExisteQR());

		qr.incorporar();
	//	ControladorIncorporarQR qr=new ControladorIncorporarQR();
		/*
		ProductoMandaUsuario productoMandaUsuario=new ProductoMandaUsuario();
		
		productoMandaUsuario.setCantidad(100);
		
		productoMandaUsuario.setId_producto(42);
		
		productoMandaUsuario.setId_cola(1);
		
		productoMandaUsuario.setId_usuario(222);
		
		qr.usuario_anadir_productos(productoMandaUsuario);



		
	}*/
	
    /**
    *
    * @return -1: error QR
    * 1 QR correcto
    * 2 ya esta dentro de la cola
    */
	public int siExisteQR() {
		
		
		id_cola=(BigDecimal)queryForUnValor(VariableSQL.BUSCAR_ID_COLA_CON_QR, codigoQR,FechaYhora.fechaHoy());
		
		if(id_cola==null) {
			
			return -1;
		}else {
		
			return buscarSiYaestaDentrodeLacola();
		}
	

	}

	private int buscarSiYaestaDentrodeLacola() {
		
		BigDecimal id=(BigDecimal)queryForUnValor(VariableSQL.BUSCAR_SI_USUARIO_YA_ESTA_EN_COLA,id_cola,id_usuario );
		
		if(id==null) {
			
			 incorporar();
			 
			return 1;
			
		}else {
			return 2;
		}
		
	}
	
	
	public String incorporar() {

		Connection connection= JdbcUtils.getConeection();
		CallableStatement call=null;
		int turnoCola=0;
		try {

			call=connection.prepareCall("begin ElijeUltimoTurno(? ,?) ; end;");

			call.setInt(1,Integer.parseInt(id_cola.toString()));

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
