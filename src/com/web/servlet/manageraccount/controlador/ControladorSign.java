package com.web.servlet.manageraccount.controlador;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dao.impletDaoWeb.Tienda_entrada;
import com.dao.utils.BaseDao;
import com.dao.utils.ConectarBBDD;
import com.mandarEmail.Email;

import variables.FechaYhora;
import variables.GeneraCodigo;
import variables.VariableSqlWEB;

public class ControladorSign extends BaseDao{
 
	private Tienda_entrada tiendaEntrada;
	private PreparedStatement preparedStatement;
	private Connection conecion;
	private ResultSet resultado = null;
	
	private int id_tienda;
	private String codigoActivacion ;
	private BigDecimal idCategoria;
	public ControladorSign(Tienda_entrada datosTienda) {
	
		this.tiendaEntrada=datosTienda;
	
	}
	
	/*
	
	public static void main(String[] args) {
	
	
	Tienda_entrada u=new Tienda_entrada();
	
	u.contrasena=1234;
	
	u.email="vanela8760@naymeo.com";
	
	u.nombre="jaja";
	
	u.categoria="Otros";
	
	u.telefono=123456789;
	
	u.direccion="callesprueba";
	
	
	ControladorSign controladorSign=new ControladorSign(u);
	

		//try {
			//controladorSign.anadirCuentaUsuario();
			
			
			controladorSign.buscaCategoria();
			
			System.out.println(controladorSign.idCategoria.toString());
			
			controladorSign.anadirTienda();
			
			
			controladorSign.siExisteEmail();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
}*/

	public boolean siExisteEmail() {
		
		
		String emailAux=(String)queryForUnValor(VariableSqlWEB.BUSCA_EMAIL_TIENDA, tiendaEntrada.getEmail());
			
		if(emailAux==null) {
			
			return false;
		
		}else return true;
		
	}
	public void andairInformacionTienda() {
		
		try {
			
			buscaCategoria();
			
			
			anadirTienda();
			// primero anadir el usuario en bbdd
				// como el id usuario es autoincrementa
			// hace falta un metodo para obtener su id


			anadirQR();
			
			
			anadirCuentaTienda();
		
					// como en tabla cuenta_tienda
		    				// hace falta el id_usuario como calve ajena 
		    				// por eso antes de ejecutar hay que obetener su id_tienda

		    
		    
		    // una vez creado usuario y cuenta_usuario manta el codigo de activacion
		    // al email del usuario
		    /*Email mandaemail=new Email(tiendaEntrada.getEmail(),codigoActivacion);
		    
		    mandaemail.mantar("activa",null);*/
		    
			MandaEmailActivacion mantar=new MandaEmailActivacion();
			mantar.start();
			
		    cerrarConexion();
			
			ControladorUsuarioSign controladorSign=new ControladorUsuarioSign(tiendaEntrada.getNombre(),tiendaEntrada.getEmail());
			
			controladorSign.crear();
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	    
	}
	
	
	class MandaEmailActivacion extends Thread{
		
		@Override
		public void run() {
		
			Email mandaemail=new Email(tiendaEntrada.getEmail(),codigoActivacion);
		    
		    mandaemail.mantar("activa",null);
			
		}
		
	}
	
	

	private void buscaCategoria() {
		
		idCategoria=(BigDecimal) queryForUnValor(VariableSqlWEB.BUSCA_CATEGORIA,tiendaEntrada.getCategoria().toLowerCase());
		
	}
	
	

	private  synchronized void anadirTienda() throws SQLException{
	
			ConectarBBDD conectar=new ConectarBBDD();
			
			conecion=conectar.conectarOracle();
			
			preparedStatement=conecion.prepareStatement(VariableSqlWEB.ANADAIR_TIENDA,PreparedStatement.RETURN_GENERATED_KEYS);
			
			preparedStatement.setInt(1, tiendaEntrada.getTelefono());
			
			preparedStatement.setString(2,FechaYhora.fechaHoy() );
			
			preparedStatement.setString(3,tiendaEntrada.getNombre());
			
			preparedStatement.setString(4,tiendaEntrada.getDireccion());
			
			preparedStatement.setBigDecimal(5, idCategoria);
			
			
			preparedStatement.setInt(6, tiendaEntrada.getHorario());
			preparedStatement.executeUpdate();
			
			// coge rowid de esta nueva fila, con el rowid busca el id del usuario
			resultado=preparedStatement.getGeneratedKeys();
			
			if(resultado.next()) {
				
				String ROWID = resultado.getString(1); 
		
				conRowidBuscaIDUsuario(ROWID);
				
			}
			
		
	}
	
	
	private void  conRowidBuscaIDUsuario(String ROWID) throws SQLException {
		
		preparedStatement=conecion.prepareStatement(VariableSqlWEB.CON_ROWID_BUSCA_IDTIENDA);
	
		preparedStatement.setString(1, ROWID);
		
		resultado=preparedStatement.executeQuery();
	
		
		if(resultado.next()) {
			
			id_tienda=resultado.getInt("ID_TIENDA");
			
		}
	
	}
	
	
	
	private  synchronized  void anadirQR() throws SQLException {
		
		preparedStatement=conecion.prepareStatement(VariableSqlWEB.ANADIR_QR);
		
		preparedStatement.setString(1, GeneraCodigo.LetraAleatoria(20)+String.valueOf(id_tienda).hashCode());
		
		preparedStatement.setInt(2, id_tienda);
		
		preparedStatement.execute();
		
		
	}
	
	private synchronized void anadirCuentaTienda() throws SQLException {
		
		
		codigoActivacion=GeneraCodigo.LetraAleatoria(4);
		
		preparedStatement=conecion.prepareStatement(VariableSqlWEB.REGITARAR_CUENTA_TIENDA);
		
		
		preparedStatement.setString(1, tiendaEntrada.email);
		
		preparedStatement.setInt(2, id_tienda);
		
		preparedStatement.setString(3, codigoActivacion);

		preparedStatement.setInt(4,tiendaEntrada.getContrasena());
		
		preparedStatement.execute();
		

		
	}
	
	public void cerrarConexion() {
		
		try {
			
		if(preparedStatement!=null) preparedStatement.close();
		
		if(resultado!=null) resultado.close();
		
		if(conecion!=null) 	conecion.close();
		
		} catch (SQLException e) {
			
				e.printStackTrace();
			
		}
		
	}
	
	
}
