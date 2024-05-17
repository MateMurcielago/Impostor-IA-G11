package Impostor;

import frsf.cidisi.faia.agent.Action;
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
		//this.getEnvironmentState().moverTripulantes();
		ImpostorPerception percepcion = new ImpostorPerception();
		
		int posicion = this.getEnvironmentState().getPosImpostor();
		int tripulantes = this.getEnvironmentState().getTripulantesSala(posicion);
		Boolean salaASabotear = this.getEnvironmentState().getSalaASabotear(posicion);
		Boolean global = false;
		int[] salasConTripulantes = new int[14];
		if(this.getEnvironmentState().getGlobalCooldown() == 0) {
			global = true;
			for(int i = 0; i < 14; i++) {
				salasConTripulantes[i] = this.getEnvironmentState().getTripulantesSala(i);
			}
		}
		
		percepcion.setPosicion(posicion);
		percepcion.setTripulantes(tripulantes);
		percepcion.setSalaASabotear(salaASabotear);
		percepcion.setGlobal(global);
		percepcion.setSalasConTripulantes(salasConTripulantes);
		
		if(this.getEnvironmentState().getGlobalCooldown() == 0) {
			this.getEnvironmentState().setGlobalCooldown(3);
		} else {
			this.getEnvironmentState().setGlobalCooldown(this.getEnvironmentState().getGlobalCooldown() - 1);
		}
		
		return percepcion;
	}
	
	@Override
    public boolean agentFailed(Action actionReturned) {
		ImpostorEnvironmentState environmentState = this.getEnvironmentState();
		int energiaImpostor = environmentState.getEnergiaImpostor();
		
		//Solo puede fallar si se le acaba la energía
		if(energiaImpostor <= 0) {
			return true;
		} else return false;
	}
	
	@Override
    public String toString() {
		return this.getEnvironmentState().toString();
	}
	
	public int[][] getConexiones() {
		return this.getEnvironmentState().getConexiones();
	}
}
