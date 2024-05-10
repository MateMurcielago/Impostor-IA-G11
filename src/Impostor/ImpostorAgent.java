package Impostor;

import frsf.cidisi.faia.agent.search.SearchBasedAgent;
import frsf.cidisi.faia.solver.search.UniformCostSearch;
import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.search.Problem;
import frsf.cidisi.faia.agent.search.SearchAction;
import java.util.Vector;
import Impostor.Actions.*;

public class ImpostorAgent extends SearchBasedAgent {
	public ImpostorAgent() {
		//El gol del impostor
		ImpostorGoal goal = new ImpostorGoal();
		
		ImpostorAgentState estado = new ImpostorAgentState();
		this.setAgentState(estado);
		
		Vector<SearchAction> operadores = new Vector<SearchAction>();
		operadores.add(new Matar());
		//operadores.add(new Moverse()); etc
		
		Problem problema = new Problem(goal, estado, operadores);
		this.setProblem(problema);
	}
	
	@Override
    public Action selectAction() {
		UniformCostSearch estrategia = new UniformCostSearch();
	}
}
