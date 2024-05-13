package Impostor.Actions;

import Impostor.ImpostorAgentState;
import Impostor.ImpostorEnvironmentState;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

public class MoverA extends SearchAction {
	@Override
    public SearchBasedAgentState execute(SearchBasedAgentState s) {
		ImpostorAgentState impostorState = (ImpostorAgentState) s;
		
		//Siempre va a poder utilizar esta acción (todas las salas tienen, al menos, una sala adyacente)
		int siguienteSala = impostorState.getSalasAdyacentes()[0];
		impostorState.setPosicion(siguienteSala);
		//Moverse cuesta energía
		impostorState.setEnergia(impostorState.getEnergia() - 1);
		impostorState.aumentarContador();
		//Como no vuelve a percibir, para las siguientes salas a las que moverse se basa en la info que recolectó
		impostorState.setSalasAdyacentes(siguienteSala);
		return impostorState;
	}
	
	@Override
    public EnvironmentState execute(AgentState ast, EnvironmentState est) {
		ImpostorEnvironmentState environmentState = (ImpostorEnvironmentState) est;
		ImpostorAgentState impostorState = (ImpostorAgentState) ast;
		
		int siguienteSala = impostorState.getSalasAdyacentes()[0];
		
		impostorState.setPosicion(siguienteSala);
		impostorState.setEnergia(impostorState.getEnergia() - 1);
		impostorState.aumentarContador();
		
		environmentState.setPosImpostor(siguienteSala);
		environmentState.setEnergiaImpostor(impostorState.getEnergia() - 1);
		
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
