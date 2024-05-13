package Impostor;

import Extras.Mapa;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;

public class ImpostorAgentState extends SearchBasedAgentState {
	private int posicion;
	private int[] salasSaboteadas;
	private int energia;
	private int tripulantesVivos;
	private int[][] conexionesMapa;
	private int[] salasConTripulantes;
	private int tripulantesEnEstaSala;
	private Boolean salaASabotear;
	private int salasVisitadas;
	private int[] salasAdyacentes;
	
	public ImpostorAgentState() {
		this.posicion = -1;
		this.salasSaboteadas = new int[3];
		this.energia = 0;
		this.tripulantesVivos = 5; //ponele
		this.conexionesMapa = new int[14][14];
		this.salasConTripulantes = new int[14];
		
		for(int i = 0; i < 3; i++) {
			this.salasSaboteadas[i] = 0;
		}
		
		for(int i = 0; i < 14; i++) {
			for(int j = 0; j < 14; j++) {
				this.conexionesMapa[i][j] = 0;
			}
		}
		
		for(int i = 0; i < 14; i++) {
			this.salasConTripulantes[i] = 0;
		}
		this.salaASabotear = false;
		this.tripulantesEnEstaSala = 0;
		this.salasVisitadas = 0;
		this.salasAdyacentes = new int[6];
	}
	
	public ImpostorAgentState(int posicion, int[] salasSaboteadas, int energia, int tripulantesVivos, 
			int[][] conexionesMapa, int[] salasConTripulantes, int tripulantesEnEstaSala, Boolean salaASabotear, 
			int salasVisitadas, int[] salasAdyacentes) {
		this.posicion = posicion;
		this.salasSaboteadas = salasSaboteadas;
		this.energia = energia;
		this.tripulantesVivos = tripulantesVivos;
		this.conexionesMapa = conexionesMapa;
		this.salasConTripulantes = salasConTripulantes;
		this.tripulantesEnEstaSala = tripulantesEnEstaSala;
		this.salaASabotear = salaASabotear;
		this.salasVisitadas = salasVisitadas;
		this.salasAdyacentes = salasAdyacentes;
	}
	
	@Override
	public SearchBasedAgentState clone() {
		int posicion = this.posicion;
		int[] salasSaboteadas = new int[3];
		for(int i = 0; i < 3; i++) {
			salasSaboteadas[i] = this.salasSaboteadas[i];
		}
		int energia = this.energia;
		int tripulantesVivos = this.tripulantesVivos;
		int[][] conexionesMapa = new int[14][14];
		for(int i = 0; i < 14; i++) {
			for(int j = 0; j < 14; j++) {
			conexionesMapa[i][j] = this.conexionesMapa[i][j];
			}
		}
		int[] salasConTripulantes = new int[14];
		for(int i = 0; i < 14; i++) {
			salasConTripulantes[i] = this.salasConTripulantes[i];
		}
		int tripulantesEnEstaSala = this.tripulantesEnEstaSala;
		Boolean salaASabotear = this.salaASabotear;
		int salasVisitadas = this.salasVisitadas;
		int[] salasAdyacentes = this.salasAdyacentes;
		
		ImpostorAgentState estado = new ImpostorAgentState(posicion, salasSaboteadas, energia, tripulantesVivos, 
				conexionesMapa, salasConTripulantes, tripulantesEnEstaSala, salaASabotear, salasVisitadas, 
				salasAdyacentes);
		return estado;
	}
	
	@Override
    public void updateState(Perception p) {
		ImpostorPerception percepcion = (ImpostorPerception) p;
		this.tripulantesEnEstaSala = percepcion.getTripulantes();
		this.posicion = percepcion.getPosicion();
		this.salaASabotear = percepcion.getSalaASabotear();
		this.salasAdyacentes = percepcion.getSalasAdyacentes();
		if(percepcion.getGlobal()) this.salasConTripulantes = percepcion.getSalasConTripulantes();
	}
	
	@Override
    public void initState() {
		
	}
	
	@Override
    public String toString() {
		String str = "";
		str = str + "Sala actual: " + Mapa.traducirPosicion(this.getPosicion()) + "\n";
		str = str + "Salas Saboteadas: ";
		if (this.salasSaboteadas[0] == -1) {
			str = str + "Ninguna\n";
		} else {
			str = str + Mapa.traducirPosicion(this.salasSaboteadas[0]);
			for(int i = 1; i < 3; i++) {
				if(this.salasSaboteadas[i] != -1) str = str + ", " + Mapa.traducirPosicion(this.salasSaboteadas[i]); 
			}
			str = str + "\n";
		}
		str = str + "Energía Restante: " + this.getEnergia() + "\n";
		str = str + "Tripulantes Vivos: " + this.getTripulantesVivos() + "\n";
		str = str + "Salas con Tripulantes: ";
		int aux = 0;
		for(int i = 0; i < 14; i++) {
			if(this.salasConTripulantes[i] != -1) {
				if (i != 0) str = str + ", " ;
				str = str + Mapa.traducirPosicion(i) + " (" + this.salasConTripulantes[i] + ")"; 
			}
			aux++;
		}
		if(aux == 0) str = str + "Ninguna\n"; 
		else str = str + "\n";
		str = str + "Tripulantes en " + Mapa.traducirPosicion(this.getPosicion()) + ": " 
				+ this.getTripulantesEnEstaSala() + "\n";
		str = str + Mapa.traducirPosicion(this.getPosicion());
		if (!this.getSalaASabotear()) str = str + " no";
		str = str + " es saboteable\n";
		str = str + "Destinos Posibles: ";
		for(int i = 0; i < 14; i++) {
			if(this.salasAdyacentes[i] != -1) {
				if (i != 0) str = str + ", " ;
				str = str + Mapa.traducirPosicion(this.salasAdyacentes[i]); 
			}
			aux++;
		}
		str = str + "\n";
		return str;
	}
	
	//Funciones propias del impostor
	public int getPosicion() {
		return posicion;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}

	public int[] getSalasSaboteadas() {
		return salasSaboteadas;
	}

	public void setSalasSaboteadas(int[] salasSaboteadas) {
		this.salasSaboteadas = salasSaboteadas;
	}

	public int getEnergia() {
		return energia;
	}

	public void setEnergia(int energia) {
		this.energia = energia;
	}

	public int getTripulantesVivos() {
		return tripulantesVivos;
	}

	public void setTripulantesVivos(int tripulantesVivos) {
		this.tripulantesVivos = tripulantesVivos;
	}

	public int[][] getConexionesMapa() {
		return conexionesMapa;
	}

	public void setConexionesMapa(int[][] conexionesMapa) {
		this.conexionesMapa = conexionesMapa;
	}

	public int[] getSalasConTripulantes() {
		return salasConTripulantes;
	}

	public void setSalasConTripulantes(int[] salasConTripulantes) {
		this.salasConTripulantes = salasConTripulantes;
	}
	
	public int getTripulantesEnSala(int i) {
		return salasConTripulantes[i];
	}
	
	public void setTripulantesEnSala(int i, int t) {
		salasConTripulantes[i] = t;
	}
	
	public int getTripulantesEnEstaSala() {
		return this.tripulantesEnEstaSala;
	}
	
	public void setTripulantesEnEstaSala(int t) {
		this.tripulantesEnEstaSala = t;
	}

	public int getSalasVisitadas() {
		return salasVisitadas;
	}

	public void setSalasVisitadas(int salasVisitadas) {
		this.salasVisitadas = salasVisitadas;
	}

	public Boolean getSalaASabotear() {
		return salaASabotear;
	}

	public void setSalaASabotear(Boolean salaASabotear) {
		this.salaASabotear = salaASabotear;
	}

	public int[] getSalasAdyacentes() {
		return salasAdyacentes;
	}

	public void setSalasAdyacentes(int[] salasAdyacentes) {
		this.salasAdyacentes = salasAdyacentes;
	}
	
	//Usado en la búsqueda
	public void setSalasAdyacentes(int pos) {
		int[] s = new int[6];
		int aux = 0;
		for(int i = 0; i < 6; i++) s[i] = -1;
		for(int i = 0; i < 14; i++) {
			if(this.conexionesMapa[pos][i] == 1) {
				s[aux] = i;
				aux++;
			}
		}
	}
	
	public void setSalaSaboteada(int i, int s) {
		this.salasSaboteadas[i] = s;
	}
	
	public void aumentarContador() {
		this.salasVisitadas++;
	}
}
