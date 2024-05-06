package Impostor;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;

public class ImpostorAgentState extends SearchBasedAgentState {
	private int posicion;
	private int[] salasSaboteadas;
	private int energia;
	private int tripulantesVivos;
	private int[][] conexionesMapa;
	private int[] salasConTripulantes;
	private int globalCooldown;
	//agregar percepciones locales de la sala
	//quitar el cooldown y meterlo en el ambiente
	
	public ImpostorAgentState() {
		this.posicion = -1;
		this.salasSaboteadas = new int[3];
		this.energia = 0;
		this.tripulantesVivos = 5; //ponele
		this.conexionesMapa = new int[14][14];
		this.salasConTripulantes = new int[14];
		globalCooldown = 3;
		
		for(int i = 0; i < 3; i++) {
			this.salasSaboteadas[i] = 0;
		}
		
		for(int i = 0; i < 14; i++) {
			for(int j = 0; j < 14; j++) {
				this.conexionesMapa[i][j] = 0;
			}
		}
		
		for(int i = 0; i < 14; i++) {
			this.salasConTripulantes[i] = 0;
		}
	}
	
	public ImpostorAgentState(int posicion, int[] salasSaboteadas, int energia, int tripulantesVivos, 
			int[][] conexionesMapa, int[] salasConTripulantes, int globalCooldown) {
		this.posicion = posicion;
		this.salasSaboteadas = salasSaboteadas;
		this.energia = energia;
		this.tripulantesVivos = tripulantesVivos;
		this.conexionesMapa = conexionesMapa;
		this.salasConTripulantes = salasConTripulantes;
		this.globalCooldown = globalCooldown;
	}
	
	@Override
	public SearchBasedAgentState clone() {
		int posicion = this.posicion;
		int[] salasSaboteadas = new int[3];
		for(int i = 0; i < 3; i++) {
			salasSaboteadas[i] = this.salasSaboteadas[i];
		}
		int energia = this.energia;
		int tripulantesVivos = this.tripulantesVivos;
		int[][] conexionesMapa = new int[14][14];
		for(int i = 0; i < 14; i++) {
			for(int j = 0; j < 14; j++) {
			conexionesMapa[i][j] = this.conexionesMapa[i][j];
			}
		}
		int[] salasConTripulantes = new int[14];
		for(int i = 0; i < 14; i++) {
			salasConTripulantes[i] = this.salasConTripulantes[i];
		}
		int globalCooldown = this.globalCooldown;
		
		ImpostorAgentState estado = new ImpostorAgentState(posicion, salasSaboteadas, energia, tripulantesVivos, 
				conexionesMapa, salasConTripulantes, globalCooldown);
		return estado;
	}

	public int getPosicion() {
		return posicion;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}

	public int[] getSalasSaboteadas() {
		return salasSaboteadas;
	}

	public void setSalasSaboteadas(int[] salasSaboteadas) {
		this.salasSaboteadas = salasSaboteadas;
	}

	public int getEnergia() {
		return energia;
	}

	public void setEnergia(int energia) {
		this.energia = energia;
	}

	public int getTripulantesVivos() {
		return tripulantesVivos;
	}

	public void setTripulantesVivos(int tripulantesVivos) {
		this.tripulantesVivos = tripulantesVivos;
	}

	public int[][] getConexionesMapa() {
		return conexionesMapa;
	}

	public void setConexionesMapa(int[][] conexionesMapa) {
		this.conexionesMapa = conexionesMapa;
	}

	public int[] getSalasConTripulantes() {
		return salasConTripulantes;
	}

	public void setSalasConTripulantes(int[] salasConTripulantes) {
		this.salasConTripulantes = salasConTripulantes;
	}

	public int getGlobalCooldown() {
		return globalCooldown;
	}

	public void setGlobalCooldown(int globalCooldown) {
		this.globalCooldown = globalCooldown;
	}
}
