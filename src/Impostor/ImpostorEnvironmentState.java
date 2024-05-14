package Impostor;

import frsf.cidisi.faia.state.EnvironmentState;
import Extras.*;

public class ImpostorEnvironmentState extends EnvironmentState {
	private Mapa mapa;
	private int[][] estructuraMapa;
	private int tripulantes;
	private int posImpostor;
	private int globalCooldown;
	private int energiaImpostor;
	
	public ImpostorEnvironmentState() {
		mapa = new Mapa();
		this.initState();
	}
	
	@Override
	public void initState() {
		//Colocar a los tripulantes
		
		//Colocar al impostor y definir su energía
		
		this.globalCooldown = 3;
	}
	
	@Override
	public String toString() {
		//Permite obtener una versión en string del estado
		String str = "";
		str = str + "Impostor: " + this.mapa.getNombreSala(this.getPosImpostor()) + "\n";
		//Ubicaciones Tripulantes
		str = str + "Reactor ";
		if(mapa.getFueSaboteadaSala(3)) str = str + "sabotado\n";
		else str = str + "sin sabotear\n";
		str = str + "Electricidad ";
		if(mapa.getFueSaboteadaSala(6)) str = str + "sabotada\n";
		else str = str + "sin sabotear\n";
		str = str + "Armas";
		if(mapa.getFueSaboteadaSala(11)) str = str + "sabotadas\n";
		else str = str + "sin sabotear\n";
		str = str + "Energía del impostor: " + this.getEnergiaImpostor() + "\n";
		str = str + "Ciclos Restantes para Vista Global: " + this.globalCooldown + "\n";
		return str;
	}
	
	//El resto de funciones las ire definiendo según vea
	public int getPosImpostor() {
		return this.posImpostor;
	}
	
	public void setPosImpostor(int p) {
		this.posImpostor = p;
	}
	
	public int getTripulantes() {
		return this.tripulantes;
	}
	
	public void  setTripulantes(int t) {
		this.tripulantes = t;
	}
	
	public int getTripulantesSala(int i) {
		return this.mapa.getTripulantesSala(i);
	}
	
	public void setTripulantesSala(int i, int t) {
		this.mapa.setTripulantesSalas(i, t);
	}
	
	public Boolean getEsSaboteableSala(int i) {
		return this.mapa.getEsSaboteableSala(i);
	}
	
	public void setFueSaboteadaSala(int i, Boolean s) {
		this.mapa.setFueSaboteadaSala(i, s);
	}
	
	public Boolean getFueSaboteadaSala(int i) {
		return this.mapa.getFueSaboteadaSala(i);
	}
	
	public int[] getSalasAdyacentesSala(int i) {
		int[] ady = new int[14];
		for(int j = 0; j < 14; j++) {
			ady[j] = this.mapa.getConexiones()[i][j];
		}
		return ady;
	}

	public int getEnergiaImpostor() {
		return energiaImpostor;
	}

	public void setEnergiaImpostor(int energiaImpostor) {
		this.energiaImpostor = energiaImpostor;
	}
	
	public Boolean getSalaASabotear(int i) {
		if(this.getEsSaboteableSala(i) && this.getFueSaboteadaSala(i)) {
			return true;
		} else return false;
	}

	public int getGlobalCooldown() {
		return globalCooldown;
	}

	public void setGlobalCooldown(int globalCooldown) {
		this.globalCooldown = globalCooldown;
	}
	
	public int[][] getConexiones() {
		return this.mapa.getConexiones();
	}
}
