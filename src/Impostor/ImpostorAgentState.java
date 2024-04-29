package Impostor;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;

public class ImpostorAgentState extends SearchBasedAgentState {
	private int[] salasSaboteadas;
	private int energia;
	private int tripulantesVivos;
	private int[][] mapa;
	private int[] salasConTripulantes;
	private int globalCooldown;
}
