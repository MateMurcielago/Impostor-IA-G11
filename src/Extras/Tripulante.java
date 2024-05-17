package Extras;

import Impostor.ImpostorEnvironmentState;

public class Tripulante {
	private int cooldownMoverse;
	private int posicion;
	private Boolean vivo;
	
	public Tripulante() {
		this.cooldownMoverse = 0;
		this.posicion = -1;
		this.vivo = true;
	}
	
	public Tripulante(int posicion) {
		this.cooldownMoverse = 0;
		this.setPosicion(posicion);
		this.vivo = true;
	}
	
	public int Mover(int[] opciones) {
		this.cooldownMoverse--;
		if(this.getCooldownMoverse() > 0) {
			int i = 0;
			this.setPosicion(opciones[i]);
			return opciones[i];
		} else return this.getPosicion();
	}
	
	public void Mover(ImpostorEnvironmentState s) {
		if(this.getCooldownMoverse() > 0) {
			int[] opciones = s.getSalasAdyacentesSala(this.getPosicion());
			int i = 0;
			s.setTripulantesSala(this.getPosicion(), s.getTripulantesSala(this.getPosicion()) - 1);
			s.setTripulantesSala(opciones[i], s.getTripulantesSala(opciones[i]) + 1);
			this.setPosicion(opciones[i]);
			this.setCooldownMoverse(0);
		} else this.setCooldownMoverse(this.getCooldownMoverse() - 1);
	}

	public int getCooldownMoverse() {
		return cooldownMoverse;
	}

	public void setCooldownMoverse(int cooldownMoverse) {
		this.cooldownMoverse = cooldownMoverse;
	}

	public int getPosicion() {
		return posicion;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}

	public Boolean estaVivo() {
		return vivo;
	}

	public void morir() {
		this.vivo = false;
	}
}
