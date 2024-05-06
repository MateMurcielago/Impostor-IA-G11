package Extras;

public class Mapa {
	private Sala[] salas;
	private int [][] conexiones;
	
	public Mapa() {
		//Crea las salas
		this.salas = new Sala[14];
		this.conexiones = new int[14][14];
		salas[0] = new Sala(0, "Cafetería", false, false, 0);
		conexiones[0][0] = 0;
		conexiones[0][1] = 1;
		conexiones[0][2] = 1;
		conexiones[0][3] = 0;
		conexiones[0][4] = 0;
		conexiones[0][5] = 0;
		conexiones[0][6] = 0;
		conexiones[0][7] = 1;
		conexiones[0][8] = 0;
		conexiones[0][9] = 1;
		conexiones[0][10] = 0;
		conexiones[0][11] = 1;
		conexiones[0][12] = 0;
		conexiones[0][13] = 0;
		salas[1] = new Sala(1, "Medicina", false, false, 0);
		conexiones[1][0] = 1;
		conexiones[1][1] = 0;
		conexiones[1][2] = 1;
		conexiones[1][3] = 0;
		conexiones[1][4] = 0;
		conexiones[1][5] = 0;
		conexiones[1][6] = 0;
		conexiones[1][7] = 0;
		conexiones[1][8] = 0;
		conexiones[1][9] = 0;
		conexiones[1][10] = 0;
		conexiones[1][11] = 0;
		conexiones[1][12] = 0;
		conexiones[1][13] = 0;
		salas[2] = new Sala(2, "Maquinaria Superior", false, false, 0);
		conexiones[2][0] = 1;
		conexiones[2][1] = 0;
		conexiones[2][2] = 0;
		conexiones[2][3] = 1;
		conexiones[2][4] = 0;
		conexiones[2][5] = 1;
		conexiones[2][6] = 0;
		conexiones[2][7] = 0;
		conexiones[2][8] = 0;
		conexiones[2][9] = 0;
		conexiones[2][10] = 0;
		conexiones[2][11] = 0;
		conexiones[2][12] = 0;
		conexiones[2][13] = 0;
		salas[3] = new Sala(3, "Reactor", true, false, 0);
		conexiones[3][0] = 0;
		conexiones[3][1] = 0;
		conexiones[3][2] = 1;
		conexiones[3][3] = 0;
		conexiones[3][4] = 1;
		conexiones[3][5] = 1;
		conexiones[3][6] = 0;
		conexiones[3][7] = 0;
		conexiones[3][8] = 0;
		conexiones[3][9] = 0;
		conexiones[3][10] = 0;
		conexiones[3][11] = 0;
		conexiones[3][12] = 0;
		conexiones[3][13] = 0;
		salas[4] = new Sala(4, "Maquinaria Inferior", false, false, 0);
		conexiones[4][0] = 0;
		conexiones[4][1] = 0;
		conexiones[4][2] = 1;
		conexiones[4][3] = 1;
		conexiones[4][4] = 0;
		conexiones[4][5] = 1;
		conexiones[4][6] = 1;
		conexiones[4][7] = 1;
		conexiones[4][8] = 0;
		conexiones[4][9] = 0;
		conexiones[4][10] = 0;
		conexiones[4][11] = 0;
		conexiones[4][12] = 0;
		conexiones[4][13] = 0;
		salas[5] = new Sala(5, "Seguridad", false, false, 0);
		conexiones[5][0] = 0;
		conexiones[5][1] = 0;
		conexiones[5][2] = 1;
		conexiones[5][3] = 0;
		conexiones[5][4] = 1;
		conexiones[5][5] = 0;
		conexiones[5][6] = 0;
		conexiones[5][7] = 0;
		conexiones[5][8] = 0;
		conexiones[5][9] = 0;
		conexiones[5][10] = 0;
		conexiones[5][11] = 0;
		conexiones[5][12] = 0;
		conexiones[5][13] = 0;
		salas[6] = new Sala(6, "Electricidad", true, false, 0);
		conexiones[6][0] = 0;
		conexiones[6][1] = 0;
		conexiones[6][2] = 0;
		conexiones[6][3] = 0;
		conexiones[6][4] = 1;
		conexiones[6][5] = 0;
		conexiones[6][6] = 0;
		conexiones[6][7] = 1;
		conexiones[6][8] = 0;
		conexiones[6][9] = 0;
		conexiones[6][10] = 0;
		conexiones[6][11] = 0;
		conexiones[6][12] = 0;
		conexiones[6][13] = 0;
		salas[7] = new Sala(7, "Almacén", false, false, 0);
		conexiones[7][0] = 1;
		conexiones[7][1] = 0; //Jaja 7-1
		conexiones[7][2] = 0;
		conexiones[7][3] = 0;
		conexiones[7][4] = 1;
		conexiones[7][5] = 0;
		conexiones[7][6] = 1;
		conexiones[7][7] = 0;
		conexiones[7][8] = 1;
		conexiones[7][9] = 1;
		conexiones[7][10] = 0;
		conexiones[7][11] = 0;
		conexiones[7][12] = 0;
		conexiones[7][13] = 0;
		salas[8] = new Sala(8, "Comunicaciones", false, false, 0);
		conexiones[8][0] = 0;
		conexiones[8][1] = 0;
		conexiones[8][2] = 0;
		conexiones[8][3] = 0;
		conexiones[8][4] = 0;
		conexiones[8][5] = 0;
		conexiones[8][6] = 0;
		conexiones[8][7] = 1;
		conexiones[8][8] = 0;
		conexiones[8][9] = 0;
		conexiones[8][10] = 0;
		conexiones[8][11] = 0;
		conexiones[8][12] = 0;
		conexiones[8][13] = 1;
		salas[9] = new Sala(9, "Administración", false, false, 0);
		conexiones[9][0] = 1;
		conexiones[9][1] = 0;
		conexiones[9][2] = 0;
		conexiones[9][3] = 0;
		conexiones[9][4] = 0;
		conexiones[9][5] = 0;
		conexiones[9][6] = 0;
		conexiones[9][7] = 1;
		conexiones[9][8] = 0;
		conexiones[9][9] = 0;
		conexiones[9][10] = 0;
		conexiones[9][11] = 0; //Jaja 9/11
		conexiones[9][12] = 0; //Ja...
		conexiones[9][13] = 0;
		salas[10] = new Sala(10, "Oxígeno", false, false, 0);
		conexiones[10][0] = 0;
		conexiones[10][1] = 0;
		conexiones[10][2] = 0;
		conexiones[10][3] = 0;
		conexiones[10][4] = 0;
		conexiones[10][5] = 0;
		conexiones[10][6] = 0;
		conexiones[10][7] = 0;
		conexiones[10][8] = 0;
		conexiones[10][9] = 0;
		conexiones[10][10] = 0;
		conexiones[10][11] = 1;
		conexiones[10][12] = 1;
		conexiones[10][13] = 1;
		salas[11] = new Sala(11, "Armas", true, false, 0);
		conexiones[11][0] = 1;
		conexiones[11][1] = 0;
		conexiones[11][2] = 0;
		conexiones[11][3] = 0;
		conexiones[11][4] = 0;
		conexiones[11][5] = 0;
		conexiones[11][6] = 0;
		conexiones[11][7] = 0;
		conexiones[11][8] = 0;
		conexiones[11][9] = 0;
		conexiones[11][10] = 1;
		conexiones[11][11] = 0;
		conexiones[11][12] = 1;
		conexiones[11][13] = 1;
		salas[12] = new Sala(12, "Navegación", false, false, 0);
		conexiones[12][0] = 0;
		conexiones[12][1] = 0;
		conexiones[12][2] = 0;
		conexiones[12][3] = 0;
		conexiones[12][4] = 0;
		conexiones[12][5] = 0;
		conexiones[12][6] = 0;
		conexiones[12][7] = 0;
		conexiones[12][8] = 0;
		conexiones[12][9] = 0;
		conexiones[12][10] = 1;
		conexiones[12][11] = 1;
		conexiones[12][12] = 0;
		conexiones[12][13] = 1;
		salas[13] = new Sala(13, "Escudos", false, false, 0);
		conexiones[13][0] = 0;
		conexiones[13][1] = 0;
		conexiones[13][2] = 0;
		conexiones[13][3] = 0;
		conexiones[13][4] = 0;
		conexiones[13][5] = 0;
		conexiones[13][6] = 0;
		conexiones[13][7] = 1;
		conexiones[13][8] = 1;
		conexiones[13][9] = 0;
		conexiones[13][10] = 1;
		conexiones[13][11] = 1;
		conexiones[13][12] = 1;
		conexiones[13][13] = 0;
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
}
