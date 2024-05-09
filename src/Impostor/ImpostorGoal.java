package Impostor;

import frsf.cidisi.faia.agent.search.GoalTest;
import frsf.cidisi.faia.state.AgentState;

public class ImpostorGoal extends GoalTest{
	
	@Override
    public boolean isGoalState(AgentState agentState) {
		int aux = 0;
		for(int i = 0; i < 3; i++) {
			if(((ImpostorAgentState) agentState).getSalasSaboteadas()[i] > -1) aux++;
		}
		if(((ImpostorAgentState) agentState).getEnergia() > 0 && 
				((ImpostorAgentState) agentState).getTripulantesVivos() == 0 && aux == 3) {
			return true;
		} else return false;
	}
	
}
