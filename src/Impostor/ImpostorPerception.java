package Impostor;

public class ImpostorPerception {
	private int tripulantes;
	private int posicion;
	private Boolean salaASabotear;
	private int[] salasAdyacentes; //6
	private Boolean global;
	private int[] salasConTripulantes;
	private int energia;
	
	public ImpostorPerception() {
		this.energia = 50;
	}
}
