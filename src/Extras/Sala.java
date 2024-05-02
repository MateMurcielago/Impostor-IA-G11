package Extras;

public class Sala {
	private int id;
	private String nombre;
	private Boolean esSaboteable;
	private Boolean fueSaboteado;
	private int tripulantes;
	
	public Sala(int id, String nombre, Boolean esSaboteable, Boolean fueSaboteado, int tripulantes) {
		this.id = id;
		this.nombre = nombre;
		this.esSaboteable = esSaboteable;
		this.fueSaboteado = fueSaboteado;
		this.tripulantes = tripulantes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Boolean getEsSaboteable() {
		return esSaboteable;
	}

	public void setEsSaboteable(Boolean esSaboteable) {
		this.esSaboteable = esSaboteable;
	}

	public Boolean getFueSaboteado() {
		return fueSaboteado;
	}

	public void setFueSaboteado(Boolean fueSaboteado) {
		this.fueSaboteado = fueSaboteado;
	}

	public int getTripulantes() {
		return tripulantes;
	}

	public void setTripulantes(int tripulantes) {
		this.tripulantes = tripulantes;
	}
}
