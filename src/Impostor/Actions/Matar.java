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
		int pos = impostorState.getPosicion();
		
		//Solo puede matar si en donde est� hay uno o m�s tripulantes
		if(impostorState.getTripulantesEnEstaSala() > 0){
			impostorState.setTripulantesVivos(impostorState.getTripulantesVivos() - 1);
			impostorState.setTripulantesEnEstaSala(impostorState.getTripulantesEnEstaSala() - 1);
			impostorState.aumentarContador(2);
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
			environmentState.asesinato(pos);
			//Actualiza al agente
			impostorState.setTripulantesVivos(impostorState.getTripulantesVivos() - 1);
			impostorState.setTripulantesEnEstaSala(impostorState.getTripulantesEnEstaSala() - 1);
			return environmentState;
		}
		
		return null;
	}
	
	@Override
    public Double getCost() {
		/*Double costo = 0.0;
        return costo;*/

        return new Double(0);
    }
	
    @Override
    public String toString() {
        return "Mata a un tripulante";
    }
}
