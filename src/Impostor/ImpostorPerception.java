package Impostor;

import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class ImpostorPerception extends Perception {
	private int tripulantes;
	private int posicion;
	private Boolean salaASabotear;
	private Boolean global;
	private int[] salasConTripulantes;
	private int energia;
	
	public ImpostorPerception() {
		this.energia = 50;
	}
	
	@Override
    public void initPerception(Agent agent, Environment environment) {
		//ImpostorAgent impostor = (ImpostorAgent) agent;
		ImpostorEnvironment ambiente = (ImpostorEnvironment) environment;
		ImpostorEnvironmentState estadoAmbiente = ambiente.getEnvironmentState();
		
		this.setPosicion(estadoAmbiente.getPosImpostor());
		this.setTripulantes(estadoAmbiente.getTripulantesSala(this.posicion));
		this.setSalaASabotear(estadoAmbiente.getSalaASabotear(this.posicion));
		this.setGlobal(estadoAmbiente.getGlobal());
		this.salasConTripulantes = new int[14];
		if(this.global) this.setSalasConTripulantes(estadoAmbiente.getSalasConTripulantes());
	}

	public int getTripulantes() {
		return tripulantes;
	}

	public void setTripulantes(int tripulantes) {
		this.tripulantes = tripulantes;
	}

	public int getPosicion() {
		return posicion;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}

	public Boolean getSalaASabotear() {
		return salaASabotear;
	}

	public void setSalaASabotear(Boolean salaASabotear) {
		this.salaASabotear = salaASabotear;
	}

	public Boolean getGlobal() {
		return global;
	}

	public void setGlobal(Boolean global) {
		this.global = global;
	}

	public int[] getSalasConTripulantes() {
		return salasConTripulantes;
	}

	public void setSalasConTripulantes(int[] salasConTripulantes) {
		this.salasConTripulantes = salasConTripulantes;
	}

	public int getEnergia() {
		return energia;
	}

	public void setEnergia(int energia) {
		this.energia = energia;
	}
}
