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
		ImpostorPerception percepcion = new ImpostorPerception();
		
		int posicion = this.getEnvironmentState().getPosImpostor();
		int tripulantes = this.getEnvironmentState().getTripulantesSala(posicion);
		Boolean salaASabotear = this.getEnvironmentState().getSalaASabotear(posicion);
		int[] salasAdyacentes = this.getEnvironmentState().getSalasAdyacentesSala(posicion);
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
		percepcion.setSalasAdyacentes(salasAdyacentes);
		percepcion.setGlobal(global);
		percepcion.setSalasConTripulantes(salasConTripulantes);
		
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
	
	public int[][] getConexiones() {
		return this.getEnvironmentState().getConexiones();
	}
}
