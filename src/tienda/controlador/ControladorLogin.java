package tienda.controlador;


import java.math.BigDecimal;

import dao.implet.Cuenta_tienda;
import dao.utils.BaseDao;
import variables.FechaYhora;
import variables.ResultadoLogin;
import variables.VariableSqlWEB;

public class ControladorLogin extends BaseDao {

	
	

	private Cuenta_tienda cuenta_tienda;


	
	
	
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
	
	
	
	public synchronized void cambairCodigoActivacion(String email,String codigo) {
		
		update(VariableSqlWEB.ACTUALIZAR_CODIGO_ACTIVACION,codigo,email);
		
	}
	
	

	
	public int  crearcola() {
		
		BigDecimal hay=(BigDecimal)queryForUnValor(VariableSqlWEB.BUSCAR_SI_HAY_COLA_CRADA,cuenta_tienda.getId_tienda(),FechaYhora.fechaHoy() );
		
	
		if(hay==null) {
			
				update(VariableSqlWEB.CREA_COLA_NUEVA,cuenta_tienda.getId_tienda(),FechaYhora.fechaHoy());
					
				BigDecimal id_cola=(BigDecimal)	queryForUnValor(VariableSqlWEB.BUSCAR_UTLIMO_ID_COLA);
				
				return Integer.parseInt(id_cola.toString());
		}
		else {
			
			return Integer.parseInt(hay.toString());
		}
	}
	
	
	
}
