package tienda.controlador;


import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.sql.Timestamp;

import dao.implet.Cuenta_tienda;
import dao.implet.InfoTienda;
import dao.utils.BaseDao;
import variables.FechaYhora;
import variables.ResultadoLogin;
import variables.VariableSqlWEB;

public class ControladorLogin extends BaseDao {

	
	

	public Cuenta_tienda cuenta_tienda;


	
	
	
	/*
	public static void main(String[] args) {
		
		ControladorLogin co=new ControladorLogin();
		
		System.out.println(co.mandarInformacionAcceso("123123@gmail.com", 1449589344));
		
	}*/
	

	
	/**
	 * 
	 * @return  -1 contraseña o email incorrecto
	  1   exito
	  2    no esta activado
	   3    ya esta en linea
	 */
	public int mandarInformacionAcceso(String email,int contrasena) {
		
		this.cuenta_tienda= queryForOne(Cuenta_tienda.class, VariableSqlWEB.BUSCA_CUENTA_TIENDA, email);
		
		if(cuenta_tienda!=null) {
			
				if(cuenta_tienda.getContrasena()==contrasena) {
					
						
							if(cuenta_tienda.getActivado()==1) {
								
										if(cuenta_tienda.getEn_linea()==0) {
											
											return ResultadoLogin.EXITO_LOGIN;
											
										}else {
											
											
											return ResultadoLogin.ESTA_EN_LINEA;
										}
								
							}else {
								
				
								return ResultadoLogin.NO_ACTIVADO;
								
							}
					
				}else {
					
					return ResultadoLogin.ERROR_POSSWORD_EMAIL;
				}
			
		}else {
			
			return ResultadoLogin.ERROR_POSSWORD_EMAIL;
		}
		
	}
	

	/*public static void main(String[] args) {
		ControladorUsuarioLogin co=new ControladorUsuarioLogin();
		//Usuario u=;
		//System.out.println(co.mandarInformacion());
		
		//co.modificaUsuarioEnlinea(1,"8888");
		
		co.probarCodigoActivacion("8888","1KpjghfSlm");
	}*/
	
	public synchronized void modificaUsuarioEnlinea(int enlinea,String email) {
		
		update(VariableSqlWEB.USAURIO_ENLINEA, enlinea,email);
		
	}
	
	
	public  boolean probarCodigoActivacion(String email,String codigoAcvacion) {
		
		String codigoaux=(String)queryForUnValor(VariableSqlWEB.BUSCAR_CODIGO_ACTIVACION,email);
		
		if(codigoAcvacion.equals(codigoaux)) {
			
			activarCuenta(email);
			
			return true;
			
		}else return false;
		
		
	}
	
	private synchronized void activarCuenta(String email) {
		
		update(VariableSqlWEB.ACTIVAR_LA_CUENTA, email);
		
	}
	
	
	
	public  void cambairCodigoActivacion(String email,String codigo) {
		
		update(VariableSqlWEB.ACTUALIZAR_CODIGO_ACTIVACION,codigo,email);
		
	}
	
	public boolean buscaFehcaColaEsHoy(int id_cola) {
		
		
	Timestamp  antes=(Timestamp )queryForUnValor("select fecha from cola where id_cola=?", id_cola);
	
	Date now = new Date();
	Calendar cal1 = Calendar.getInstance();
	cal1.setTime(now);
	// 将时分秒,毫秒域清零
	cal1.set(Calendar.HOUR_OF_DAY, 0);
	cal1.set(Calendar.MINUTE, 0);
	cal1.set(Calendar.SECOND, 0);
	cal1.set(Calendar.MILLISECOND, 0);

	Timestamp  today=new Timestamp(cal1.getTime().getTime());

	return today.equals(antes);
	}

	
	/*public static void main(String[] args) {
		ControladorLogin l=new ControladorLogin();
		
		l.buscaFehcaColaEsHoy(221);
	}*/
	
	public  int  crearcola(int id_tienda) {
		
		BigDecimal hay=(BigDecimal)queryForUnValor(VariableSqlWEB.BUSCAR_SI_HAY_COLA_CRADA,id_tienda,FechaYhora.fechaHoy() );
		
	
		if(hay==null) {
			
				update(VariableSqlWEB.CREA_COLA_NUEVA,id_tienda,FechaYhora.fechaHoy());
					
				BigDecimal id_cola=(BigDecimal)	queryForUnValor(VariableSqlWEB.BUSCAR_UTLIMO_ID_COLA);
				
				return Integer.parseInt(id_cola.toString());
		}
		else {
			
			return Integer.parseInt(hay.toString());
		}
	}
	
	
	public InfoTienda buscarIdTienda(String email) {
		
		

		InfoTienda tienda=queryForOne(InfoTienda.class, VariableSqlWEB.CON_EMIAL_BUSCA_INFORMACION_TIENDA, email);
		
		return tienda;
		
		
	}
	
}
