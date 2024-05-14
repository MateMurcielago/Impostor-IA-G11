package Extras;

public class Mapa {
	private Sala[] salas;
	private int [][] conexiones;
	
	public Mapa() {
		//Crea las salas
		this.salas = new Sala[14];
		this.conexiones = new int[14][14];
		salas[0] = new Sala(0, "Cafetería", false, false, 0);
		for (int i = 0; i < 14; i++) {
			if(i == 1 || i == 2 || i == 7 || i == 9 || i == 11) {
				conexiones[0][i] = 1;
			} else conexiones [0][i] = 0;
		}
		salas[1] = new Sala(1, "Medicina", false, false, 0);
		for (int i = 0; i < 14; i++) {
			if(i == 0 || i == 2) {
				conexiones[1][i] = 1;
			} else conexiones [1][i] = 0;
		}
		salas[2] = new Sala(2, "Maquinaria Superior", false, false, 0);
		for (int i = 0; i < 14; i++) {
			if(i == 0 || i == 3 || i == 5) {
				conexiones[2][i] = 1;
			} else conexiones [2][i] = 0;
		}
		salas[3] = new Sala(3, "Reactor", true, false, 0);
		for (int i = 0; i < 14; i++) {
			if(i == 2 || i == 4 || i == 5) {
				conexiones[3][i] = 1;
			} else conexiones [3][i] = 0;
		}
		salas[4] = new Sala(4, "Maquinaria Inferior", false, false, 0);
		for (int i = 0; i < 14; i++) {
			if(i == 2 || i == 3 || i == 5 || i == 6 || i == 7) {
				conexiones[4][i] = 1;
			} else conexiones [4][i] = 0;
		}
		salas[5] = new Sala(5, "Seguridad", false, false, 0);
		for (int i = 0; i < 14; i++) {
			if(i == 2 || i == 4) {
				conexiones[5][i] = 1;
			} else conexiones [5][i] = 0;
		}
		salas[6] = new Sala(6, "Electricidad", true, false, 0);
		for (int i = 0; i < 14; i++) {
			if(i == 4 || i == 7) {
				conexiones[6][i] = 1;
			} else conexiones [6][i] = 0;
		}
		salas[7] = new Sala(7, "Almacén", false, false, 0);
		for (int i = 0; i < 14; i++) {
			if(i == 0 || i == 4 || i == 6 || i == 8 || i == 9 || i == 13) {
				conexiones[7][i] = 1;
			} else conexiones [7][i] = 0;
		}
		salas[8] = new Sala(8, "Comunicaciones", false, false, 0);
		for (int i = 0; i < 14; i++) {
			if(i == 7 || i == 13) {
				conexiones[8][i] = 1;
			} else conexiones [8][i] = 0;
		}
		salas[9] = new Sala(9, "Administración", false, false, 0);
		for (int i = 0; i < 14; i++) {
			if(i == 0 || i == 7) {
				conexiones[9][i] = 1;
			} else conexiones [9][i] = 0;
		}
		salas[10] = new Sala(10, "Oxígeno", false, false, 0);
		for (int i = 0; i < 14; i++) {
			if(i == 11 || i == 12 || i == 13) {
				conexiones[10][i] = 1;
			} else conexiones [10][i] = 0;
		}
		salas[11] = new Sala(11, "Armas", true, false, 0);
		for (int i = 0; i < 14; i++) {
			if(i == 0 || i == 10 || i == 12 || i == 13) {
				conexiones[11][i] = 1;
			} else conexiones [11][i] = 0;
		}
		salas[12] = new Sala(12, "Navegación", false, false, 0);
		for (int i = 0; i < 14; i++) {
			if(i == 10 || i == 11 || i == 13) {
				conexiones[12][i] = 1;
			} else conexiones [12][i] = 0;
		}
		salas[13] = new Sala(13, "Escudos", false, false, 0);
		for (int i = 0; i < 14; i++) {
			if(i == 7 || i == 8 || i == 10 || i == 11 || i == 12) {
				conexiones[13][i] = 1;
			} else conexiones [13][i] = 0;
		}
	}
	
	public int getIDSala(int i) {
		return this.salas[i].getId();
	}
	
	public String getNombreSala(int i) {
		return this.salas[i].getNombre();
	}
	
	public Boolean getEsSaboteableSala(int i) {
		return this.salas[i].getEsSaboteable();
	}
	
	public void setEsSaboteableSala(int i, Boolean esSaboteable) {
		this.salas[i].setEsSaboteable(esSaboteable);
	}
	
	public Boolean getFueSaboteadaSala(int i) {
		return this.salas[i].getFueSaboteado();
	}
	
	public void setFueSaboteadaSala(int i, Boolean fueSaboteado) {
		this.salas[i].setFueSaboteado(fueSaboteado);
	}
	
	public int getTripulantesSala(int i) {
		return this.salas[i].getTripulantes();
	}
	
	public void setTripulantesSalas(int i, int t) {
		this.salas[i].setTripulantes(t);
	}
	
	//Traductor para el impostor
	public static String traducirPosicion(int i) {
		switch(i) {
		case 0:
			return "Cafetería";
		case 1:
			return "Medicina";
		case 2:
			return "Maquinaria Superior";
		case 3:
			return "Reactor";
		case 4:
			return "Maquinaria Inferior";
		case 5:
			return "Seguridad";
		case 6:
			return "Electricidad";
		case 7:
			return "Almacén";
		case 8:
			return "Comunicaciones";
		case 9:
			return "Administración";
		case 10:
			return "Oxígeno";
		case 11:
			return "Armas";
		case 12:
			return "Navegación";
		case 13:
			return "Escudos";
		default:
			return "";
		}
	}

	public int[][] getConexiones() {
		return conexiones;
	}
}
