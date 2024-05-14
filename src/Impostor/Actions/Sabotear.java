package Impostor.Actions;

import Impostor.ImpostorAgentState;
import Impostor.ImpostorEnvironmentState;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

public class Sabotear extends SearchAction {
	public SearchBasedAgentState execute(SearchBasedAgentState s) {
		ImpostorAgentState impostorState = (ImpostorAgentState) s;
		
		//Solo puede sabotear si la sala en la que está es saboteable (ya que no vuelve a percibir)
		int pos = impostorState.getPosicion();
		
		if(impostorState.getSalaASabotear()) {
			for(int i = 0; i < 3; i++) {
				if(impostorState.getSalasSaboteadas()[i] != -1) {
					impostorState.setSalaSaboteada(i, pos);
				}
			}
			impostorState.setSalaASabotear(false);
			impostorState.aumentarContador(3);
			return impostorState;
		}
		
		return null;
	}
	
	@Override
    public EnvironmentState execute(AgentState ast, EnvironmentState est) {
		ImpostorEnvironmentState environmentState = (ImpostorEnvironmentState) est;
		ImpostorAgentState impostorState = (ImpostorAgentState) ast;

		//Solo puede sabotear si la sala es saboteable y no la saboteó antes
		int aux = 0;
		int pos = impostorState.getPosicion();
		for(int i = 0; i < 3; i++) {
			if(impostorState.getSalasSaboteadas()[i] == pos) aux++;
		}
		
		if(impostorState.getSalaASabotear() && aux == 0) {
			for(int i = 0; i < 3; i++) {
				if(impostorState.getSalasSaboteadas()[i] != -1) {
					impostorState.setSalaSaboteada(i, pos);
				}
			}
			impostorState.setSalaASabotear(false);
			environmentState.setFueSaboteadaSala(pos, true);
		}
		
		return environmentState;
	}
	
	@Override
    public Double getCost() {
		Double costo = 0.0;
        return costo;
    }
	
	@Override
    public String toString() {
        return "Sala saboteada";
    }
}
