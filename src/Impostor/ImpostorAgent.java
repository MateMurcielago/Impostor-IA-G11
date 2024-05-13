package Impostor;

import frsf.cidisi.faia.agent.search.SearchBasedAgent;
import frsf.cidisi.faia.solver.search.AStarSearch;
import frsf.cidisi.faia.solver.search.BreathFirstSearch;
import frsf.cidisi.faia.solver.search.IEstimatedCostFunction;
import frsf.cidisi.faia.solver.search.IStepCostFunction;
import frsf.cidisi.faia.solver.search.Search;
import frsf.cidisi.faia.solver.search.UniformCostSearch;
import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.Problem;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import Impostor.Actions.*;

public class ImpostorAgent extends SearchBasedAgent {
	public ImpostorAgent() {
		//El gol del impostor
		ImpostorGoal goal = new ImpostorGoal();
		
		ImpostorAgentState estado = new ImpostorAgentState();
		this.setAgentState(estado);
		
		Vector<SearchAction> operadores = new Vector<SearchAction>();
		operadores.add(new Matar());
		operadores.add(new MoverA());
		operadores.add(new MoverB());
		operadores.add(new MoverC());
		operadores.add(new MoverD());
		operadores.add(new MoverE());
		operadores.add(new MoverF());
		operadores.add(new Sabotear());
		
		Problem problema = new Problem(goal, estado, operadores);
		this.setProblem(problema);
	}
	
	@Override
    public Action selectAction() {
		//1° Estrategia
		IStepCostFunction costFunction = new CostFunction();
		UniformCostSearch estrategia = new UniformCostSearch(costFunction);
		
		//2° Estrategia
		//BreathFirstSearch estrategia = new BreathFirstSearch();
		
		//3° Estrategia
		//IStepCostFunction cost = new CostFunction();
        //IEstimatedCostFunction heuristic = new Heuristic();
        //AStarSearch strategy = new AStarSearch(cost, heuristic);
		
		Search searchSolver = new Search(estrategia);
		searchSolver.setVisibleTree(Search.EFAIA_TREE);
		this.setSolver(searchSolver);
		Action selectedAction = null;
        try {
            selectedAction =
                    this.getSolver().solve(new Object[]{this.getProblem()});
        } catch (Exception ex) {
            Logger.getLogger(ImpostorAgent.class.getName()).log(Level.SEVERE, null, ex);
        }
        return selectedAction;
	}
	
	@Override
    public void see(Perception p) {
        this.getAgentState().updateState(p);
    }
}
