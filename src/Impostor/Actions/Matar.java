package Impostor.Actions;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import Impostor.*;

public class Matar extends SearchAction {
	
	@Override
    public SearchBasedAgentState execute(SearchBasedAgentState s) {
		ImpostorAgentState impostorState = (ImpostorAgentState) s;
		
		//Solo puede matar si en donde est� hay uno o m�s tripulantes
		if(impostorState.getTripulantesEnEstaSala() > 0) {
			//Si mata se descuentan los tripulantes vivos y los de esa sala
			impostorState.setTripulantesVivos(impostorState.getTripulantesVivos() - 1);
			impostorState.setTripulantesEnEstaSala(impostorState.getTripulantesEnEstaSala() - 1);
			return impostorState;
		}
		
		return null;
	}
	
	@Override
    public EnvironmentState execute(AgentState ast, EnvironmentState est) {
		ImpostorEnvironmentState environmentState = (ImpostorEnvironmentState) est;
		ImpostorAgentState impostorState = (ImpostorAgentState) ast;
		
		int pos = impostorState.getPosicion();
		
		if(impostorState.getTripulantesEnEstaSala() > 0) {
			//Actualiza el mundo
			environmentState.setTripulantes(environmentState.getTripulantes() - 1);
			environmentState.setTripulantesSala(pos, environmentState.getTripulantesSala(pos) - 1);
			//Actualiza al agente
			impostorState.setTripulantesVivos(impostorState.getTripulantesVivos() - 1);
			impostorState.setTripulantesEnEstaSala(impostorState.getTripulantesEnEstaSala() - 1);
			return environmentState;
		}
		
		return null;
	}
	
	@Override
    public Double getCost() {
		Double costo = 0.0;
        return costo;
    }
	
    @Override
    public String toString() {
        return "Mata";
    }
}
