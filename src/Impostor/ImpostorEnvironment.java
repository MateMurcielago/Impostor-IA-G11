package Impostor;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class ImpostorEnvironment extends Environment {
	public ImpostorEnvironment() {
		this.environmentState = new ImpostorEnvironmentState();
	}
	
	@Override
	public ImpostorEnvironmentState getEnvironmentState() {
		return (ImpostorEnvironmentState) super.getEnvironmentState();
	}
	
	@Override
	public Perception getPercept() {
		//Falta definir las percepciones
	}
}
