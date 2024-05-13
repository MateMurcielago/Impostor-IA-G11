package Impostor.Actions;

import Impostor.ImpostorAgentState;
import Impostor.ImpostorEnvironmentState;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

public class MoverE extends SearchAction {
	@Override
    public SearchBasedAgentState execute(SearchBasedAgentState s) {
		ImpostorAgentState impostorState = (ImpostorAgentState) s;
		
		int siguienteSala = impostorState.getSalasAdyacentes()[2];
		//Solo puede realizar esta acción si hay una tercera sala a la que ir
		if(siguienteSala >= 0) {
			impostorState.setPosicion(siguienteSala);
			//Moverse cuesta energía
			impostorState.setEnergia(impostorState.getEnergia() - 1);
			impostorState.aumentarContador();
			//Como no vuelve a percibir, para las siguientes salas a las que moverse se basa en la info que recolectó
			impostorState.setSalasAdyacentes(siguienteSala);
			return impostorState;
		}
		return null;
	}
	
	@Override
    public EnvironmentState execute(AgentState ast, EnvironmentState est) {
		ImpostorEnvironmentState environmentState = (ImpostorEnvironmentState) est;
		ImpostorAgentState impostorState = (ImpostorAgentState) ast;
		
		int siguienteSala = impostorState.getSalasAdyacentes()[2];
		
		if(siguienteSala >= 0) {
			impostorState.setPosicion(siguienteSala);
			impostorState.setEnergia(impostorState.getEnergia() - 1);
			impostorState.aumentarContador();
		
			environmentState.setPosImpostor(siguienteSala);
			environmentState.setEnergiaImpostor(impostorState.getEnergia() - 1);
		}
		
		return environmentState;
	}
	
	@Override
    public Double getCost() {
		Double costo = 1.0;
        return costo;
    }
	
	@Override
    public String toString() {
        return "Se mueve";
    }
}
