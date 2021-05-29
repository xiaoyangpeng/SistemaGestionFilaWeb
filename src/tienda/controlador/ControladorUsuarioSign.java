package tienda.controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mandarEmail.Email;

import dao.utils.BaseDao;
import dao.utils.ConectarBBDD;
import variables.GeneraCodigo;
import variables.VariableSQL;

public class ControladorUsuarioSign extends BaseDao{


	private PreparedStatement preparedStatement;
	private Connection conecion;
	private ResultSet resultado = null;
	
	private int id_usuario;
	private String codigoActivacion ;
	
	private String nombreTienda;
	
	private String email;
	public ControladorUsuarioSign(String nombreTienda,String email) {
	
		this.nombreTienda=nombreTienda;
		this.email=email;
	
	}
	
	/*public static void main(String[] args) {
	

	
		ControladorUsuarioSign controladorSign=new ControladorUsuarioSign("jajja","asdfasf");
	
controladorSign.crear();
	

	
}*/

	public void crear() {
		
	
	
			
			try {
				anadirUsuario();
				// primero anadir el usuario en bbdd
 				// como el id usuario es autoincrementa
				// hace falta un metodo para obtener su id


			    anadirCuentaUsuario(); // como en tabla cuenta_usuario 
			    				// hace falta el id_usuario como calve ajena 
			    				// por eso antes de ejecutar hay que obetener su id_usuario
	
			    
			    
		    	cerrarConexion();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		    
			

			
			

		
	}
	

	private  synchronized void anadirUsuario() throws SQLException{
	
			ConectarBBDD conectar=new ConectarBBDD();
			conecion=conectar.conectarOracle();
			
			preparedStatement=conecion.prepareStatement(VariableSQL.ANADAIR_USUARIO,PreparedStatement.RETURN_GENERATED_KEYS);
			
			preparedStatement.setString(1, nombreTienda);
			
			preparedStatement.setString(2, null);
			
		
			preparedStatement.setString(3, null);
	
			
			preparedStatement.setString(4, null);
			
			preparedStatement.executeUpdate();
			
			// coge rowid de esta nueva fila, con el rowid busca el id del usuario
			resultado=preparedStatement.getGeneratedKeys();
			
			if(resultado.next()) {
				
				String ROWID = resultado.getString(1); 
		
				conRowidBuscaIDUsuario(ROWID);
			}
			
		
	}
	
	
	private void  conRowidBuscaIDUsuario(String ROWID) throws SQLException {
		
		preparedStatement=conecion.prepareStatement(VariableSQL.CON_ROWID_BUSCA_IDUSUARIO);
	
		preparedStatement.setString(1, ROWID);
		
		resultado=preparedStatement.executeQuery();
	
		
		if(resultado.next()) {
			
			id_usuario=resultado.getInt("ID_USUARIO");
			
		

		}
	
	}
	
	private synchronized void anadirCuentaUsuario() throws SQLException {
		
		preparedStatement=conecion.prepareStatement(VariableSQL.REGITARAR_CUENTA_USUARIO);
		
		
		preparedStatement.setString(1,email);
		
		preparedStatement.setInt(2, id_usuario);
		
		preparedStatement.setInt(3, GeneraCodigo.GeneraQRAleatoria().hashCode());
		
		
		
		preparedStatement.setString(4,codigoActivacion);
		
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
