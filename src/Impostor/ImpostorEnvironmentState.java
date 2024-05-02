package Impostor;

import frsf.cidisi.faia.state.EnvironmentState;

public class ImpostorEnvironmentState extends EnvironmentState {
	private int[] mapa;
	private int[][] estructuraMapa;
	private int tripulantes;
	private int posImpostor;
	
	public ImpostorEnvironmentState() {
		mapa = new int[1];
		this.initState();
	}
	
	@Override
	public void initState() {
		//Generar el mapa
		
		//Colocar a los tripulantes
		
		//Colocar al impostor y definir su energía
		
		/*Por alguna razón ahora se me pintó por comentar así*/
	}
	
	@Override
	public String toString() {
		//Permite obtener una versión en string del estado
		String str = "";
		return "mondongo";
	}
}
