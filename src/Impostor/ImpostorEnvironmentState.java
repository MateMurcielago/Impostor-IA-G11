package Impostor;

import frsf.cidisi.faia.state.EnvironmentState;
import Extras.*;

public class ImpostorEnvironmentState extends EnvironmentState {
	private Mapa mapa;
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
		this.tripulantes = CantTripulantes.max;
		
		//Colocar a los tripulantes
		this.setTripulantesSala(1, 1);
		this.setTripulantesSala(5, 1);
		this.setTripulantesSala(7, 3);
		this.setTripulantesSala(8, 1);
		this.setTripulantesSala(9, 2);
		this.setTripulantesSala(12, 1);
		
		//Colocar al impostor y definir su energía
		this.setPosImpostor(0);
		this.setEnergiaImpostor(30);
		
		this.globalCooldown = 0;
	}
	
	@Override
	public String toString() {
		//Permite obtener una versión en string del estado
		String str = "";
		str = str + "Tripulantes Vivos: " + this.getTripulantes() + "\n";
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
	
	//Funciones específicas del ambiente
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
	
	//Se usa para mover a los tripulantes
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
	
	public Boolean getGlobal() {
		if(this.globalCooldown == 0) {
			return true;
		} else return false;
	}
	
	public int[] getSalasConTripulantes() {
		int[] s = new int[14];
		for(int i = 0; i < 14; i++) {
			s[i] = this.getTripulantesSala(i);
		}
		return s;
	}
	
	public void asesinato(int sala) {
		this.setTripulantes(this.getTripulantes() - 1);
		this.setTripulantesSala(sala, this.getTripulantesSala(sala) - 1);
	}
}
