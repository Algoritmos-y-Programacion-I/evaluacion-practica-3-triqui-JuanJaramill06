package model;

import java.util.Random;

public class Controladora {

    private String[][] tableroTresEnRaya;

    /**
     * Constructor de la clase Controladora para inicializar
     *
     * @pre No se requieren precondiciones específicas.
     * @post Se crea una instancia de Controladora 
     */
    public Controladora() {
        tableroTresEnRaya = new String[3][3];
        inicializarTablero();
    }

    /**
     * Inicializa el tablero con valores vacíos.
     */
    private void inicializarTablero() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tableroTresEnRaya[i][j] = " ";
            }
        }
    }

    /**
     * Devuelve el tablero en formato String.
     */
    public String obtenerTableroComoString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(tableroTresEnRaya[i][j]);
                if (j < 2) sb.append("|");
            }
            sb.append("\n");
            if (i < 2) sb.append("-----\n");
        }
        return sb.toString();
    }

    /**
     * Realiza una jugada aleatoria para la máquina.
     */
    public void jugadaAleatoria() {
        Random rand = new Random();
        int i, j;
        do {
            i = rand.nextInt(3);
            j = rand.nextInt(3);
        } while (!tableroTresEnRaya[i][j].equals(" "));
        tableroTresEnRaya[i][j] = "X";
    }

    public boolean jugadaHumana(int f, int c){
    if(f >= 0 && f < 3 && c >= 0 && c < 3 && tableroTresEnRaya[f][c].equals(" ")) {
        tableroTresEnRaya[f][c] = "O";
        return true;
    }
    return false;
}

    public String verificarGanador(){
      int[][] combinaciones = {
        {0, 0, 0, 1, 0, 2},  
        {1, 0, 1, 1, 1, 2},  
        {2, 0, 2, 1, 2, 2},  
        {0, 0, 1, 0, 2, 0},  
        {0, 1, 1, 1, 2, 1},  
        {0, 2, 1, 2, 2, 2},  
        {0, 0, 1, 1, 2, 2},  
        {0, 2, 1, 1, 2, 0}   
    };

    for (int[] combinacion : combinaciones) {
        String opcionUno = tableroTresEnRaya[combinacion[0]][combinacion[1]];
        String opcionDos = tableroTresEnRaya[combinacion[2]][combinacion[3]];
        String opcionTres = tableroTresEnRaya[combinacion[4]][combinacion[5]];

        if (opcionUno.equals(opcionDos) && opcionDos.equals(opcionTres) && !opcionUno.equals(" ")) {
            return opcionUno; 
        }
    }

   
    return null;
    }
}