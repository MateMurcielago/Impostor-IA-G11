package Impostor;

import frsf.cidisi.faia.solver.search.IStepCostFunction;
import frsf.cidisi.faia.solver.search.NTree;

public class CostFunction implements IStepCostFunction {
	@Override
    public double calculateCost(NTree node) {
		return (2 * ((ImpostorAgentState) node.getAgentState()).getSalasVisitadas()) + 
				((ImpostorAgentState) node.getAgentState()).getAsesinatos() + 
				((ImpostorAgentState) node.getAgentState()).getSabotajes();
	}
}
