package com.android.api.informacionfila;



public class InformacionColaJson {

	
	private int timepo;
	
	
	private String turnoActual;

	private String turnoQueda;

	private String miturno;
	
	private String id_cola;


	


	public InformacionColaJson(int timepo, String turnoActual, String turnoQueda, String miturno, String id_cola) {
		this.timepo = timepo;
		this.turnoActual = turnoActual;
		this.turnoQueda = turnoQueda;
		this.miturno = miturno;
		this.id_cola = id_cola;
	}


	public String getId_cola() {
		return id_cola;
	}


	public void setId_cola(String id_cola) {
		this.id_cola = id_cola;
	}


	public int getTimepo() {
		return timepo;
	}


	public void setTimepo(int timepo) {
		this.timepo = timepo;
	}


	public String getTurnoActual() {
		return turnoActual;
	}


	public void setTurnoActual(String turnoActual) {
		this.turnoActual = turnoActual;
	}


	public String getTurnoQueda() {
		return turnoQueda;
	}


	public void setTurnoQueda(String turnoQueda) {
		this.turnoQueda = turnoQueda;
	}


	public String getMiturno() {
		return miturno;
	}


	public void setMiturno(String miturno) {
		this.miturno = miturno;
	}


	
	
	
}
