package Impostor;

import frsf.cidisi.faia.state.EnvironmentState;
import Extras.*;

public class ImpostorEnvironmentState extends EnvironmentState {
	private Mapa mapa;
	private int[][] estructuraMapa;
	private int tripulantes;
	private int posImpostor;
	
	public ImpostorEnvironmentState() {
		mapa = new Mapa();
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
	
	//El resto de funciones las ire definiendo seg�n vea
}
