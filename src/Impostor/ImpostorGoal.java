package Impostor;

import frsf.cidisi.faia.agent.search.GoalTest;
import frsf.cidisi.faia.state.AgentState;

public class ImpostorGoal extends GoalTest{
	
	@Override
    public boolean isGoalState(AgentState agentState) {
		if(((ImpostorAgentState) agentState).getEnergia() > 0 && 
				((ImpostorAgentState) agentState).getTripulantesVivos() == 0 &&
				((ImpostorAgentState) agentState).getSalasSaboteadas().length == 3) {
			return true;
		} else return false;
	}
	
}
