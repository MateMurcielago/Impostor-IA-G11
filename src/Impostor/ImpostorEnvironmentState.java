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
		
		//Colocar al impostor y definir su energ�a
		
		/*Por alguna raz�n ahora se me pint� por comentar as�*/
	}
	
	@Override
	public String toString() {
		//Permite obtener una versi�n en string del estado
		String str = "";
		return "mondongo";
	}
}
