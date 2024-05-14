package Impostor.Actions;

import Extras.Mapa;
import Impostor.ImpostorAgentState;
import Impostor.ImpostorEnvironmentState;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

public class Mover extends SearchAction {
	private int sala;
	
	public Mover(int sala) {
		this.sala = sala;
	}
	
	@Override
    public SearchBasedAgentState execute(SearchBasedAgentState s) {
		ImpostorAgentState impostorState = (ImpostorAgentState) s;
		
		//Solo se puede mover a esta sala si está en una adyacente
		if(impostorState.getAdyacencia(impostorState.getPosicion(), sala) == 1) {
			impostorState.setPosicion(sala);

			//Moverse cuesta energía
			impostorState.setEnergia(impostorState.getEnergia() - 1);
			impostorState.aumentarContador(1);
			return impostorState;
		} else return null;
	}
	
	@Override
    public EnvironmentState execute(AgentState ast, EnvironmentState est) {
		ImpostorEnvironmentState environmentState = (ImpostorEnvironmentState) est;
		ImpostorAgentState impostorState = (ImpostorAgentState) ast;
		
		//Solo se puede mover a esta sala si está en una adyacente
		if(impostorState.getAdyacencia(impostorState.getPosicion(), sala) == 1) {
			impostorState.setPosicion(sala);
			
			//Moverse cuesta energía
			impostorState.setEnergia(impostorState.getEnergia() - 1);
			impostorState.aumentarContador(1);
			
			environmentState.setPosImpostor(sala);
			environmentState.setEnergiaImpostor(impostorState.getEnergia() - 1);
			return environmentState;
		} else return null;
	}
	
	@Override
    public Double getCost() {
		Double costo = 1.0;
        return costo;
    }
	
	@Override
    public String toString() {
        return "Se mueve a " + Mapa.traducirPosicion(sala);
    }
}
