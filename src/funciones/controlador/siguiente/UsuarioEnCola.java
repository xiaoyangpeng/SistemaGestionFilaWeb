package funciones.controlador.siguiente;

public class UsuarioEnCola {

	
	private int id_usuario;
	
	
	private int turno;
	
	
	private String formato;
	
	private String nombre;
	
	private String hora_entrada;

	private int turno_actual;

	
	



	public int getTurno_actual() {
		return turno_actual;
	}



	public void setTurno_actual(int turno_actual) {
		this.turno_actual = turno_actual;
	}



	public int getId_usuario() {
		return id_usuario;
	}



	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}




	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public int getTurno() {
		return turno;
	}



	public void setTurno(int turno) {
		this.turno = turno;
	}



	public String getFormato() {
		return formato;
	}



	public void setFormato(String formato) {
		this.formato = formato;
	}



	public String getHora_entrada() {
		return hora_entrada;
	}



	public void setHora_entrada(String hora_entrada) {
		this.hora_entrada = hora_entrada;
	}
	
	
	
	
	
	
	
}
