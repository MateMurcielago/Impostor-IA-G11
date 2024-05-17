package Impostor;

import frsf.cidisi.faia.exceptions.PrologConnectorException;
import frsf.cidisi.faia.simulator.SearchBasedAgentSimulator;

public class ImpostorSearchMain {
	public static void main(String[] args) throws PrologConnectorException {
		ImpostorAgent agente = new ImpostorAgent();
		ImpostorEnvironment ambiente = new ImpostorEnvironment();
		agente.setConexiones(ambiente.getConexiones());
		//Setear energía aleatoria
		
		System.out.println(ambiente.getEnvironmentState().toString());
		
		 SearchBasedAgentSimulator simulador = new SearchBasedAgentSimulator(ambiente, agente);
		 
		 simulador.start();
	}
}
