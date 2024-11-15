package ui;

import java.util.Scanner;
import model.Controladora;

public class Executable {

    private Scanner reader;
    private Controladora cont;
    private static boolean flag;

    private Executable() {
        reader = new Scanner(System.in);
        cont = new Controladora();
    }

    public void run(boolean flag) {

        flag = false;

        while (!flag) {

            System.out.println("\n\nBienvenido al menu:\n");
            System.out.println("Opciones:\n" + "1. Imprimir tablero \n" + "2. Jugada de la maquina \n"
                    + "3. Jugada de humano \n" + "4. Verificar ganador \n" + "5. Salir del programa \n");

            int option = reader.nextInt();
            reader.nextLine();

            switch (option) {
                case 1:
                    imprimirTablero();
                    break;
                case 2:
                    jugadaMaquina();
                    break;
                case 3:
                    jugadaHumano();
                    break;
                case 4:
                    validarGanador();
                    break;
                case 5:
                    flag = true;
                    System.exit(0);
                    break;
                default:
                    System.out.print("Por favor ingrese una opcion valida");
                    continue;
            }

        }

    }

    public static void main(String[] args) {
        Executable mainApp = new Executable();
        mainApp.run(flag);
    }

    private void imprimirTablero() {
        System.out.println(cont.obtenerTableroComoString());
    }

    private void jugadaMaquina() {
        cont.jugadaAleatoria();
        System.out.println("La maquina ha realizado su jugada.");
        imprimirTablero();
    }

     private void jugadaHumano() {
        System.out.println(" \n Ingrese la fila donde va a realizar su jugada, (Las filas van desde 0 hasta 2) : ");
        int f = reader.nextInt();
        System.out.println("\n Ingrese la columna donde va a realizar su jugada, (Las columnas van desde 0 hasta 2): ");
        int c = reader.nextInt();
        reader.nextLine();

        boolean jugadaExitosa = cont.jugadaHumana(f, c);
        if (jugadaExitosa) {
            System.out.println("\n Jugada realizada con exito. \n");
        } else {
            System.out.println("\n Jugada invalida, intente nuevamente. \n ");
        }
        imprimirTablero();
    }

    private void validarGanador() {
            String ganador = cont.verificarGanador();
        if (ganador != null) {
            System.out.println("\n\n El ganador de esta partida es: " + ganador + ".");
        } else {
            System.out.println("\n\nTodavia no hay un ganador decisivo en la partida actual.");
        }
    }
}