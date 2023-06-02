package lab7p1_luishenriquez;

import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Lab7P1_LuisHenriquez {

    static Scanner lea = new Scanner(System.in);
    static Random ran = new Random();
    static Scanner leer = new Scanner(System.in);

    public static void main(String[] args) {

        String opciones = "Seleccione una opción:\n"
                + "1. She shoot, she scores!\n"
                + "2. Pierda, papel o ...";

        JOptionPane.showMessageDialog(null, opciones);

        String opc = JOptionPane.showInputDialog("Ingrese una opción");
        int OPC = Integer.parseInt(opc);

        switch (OPC) {
            case 1: {
                String fil = JOptionPane.showInputDialog("Ingrese cantidad de filas");
                int filas = Integer.parseInt(fil);

                String col = JOptionPane.showInputDialog("Ingrese cantidad de columnas");
                int columnas = Integer.parseInt(col);
                int M = filas * columnas;
                int[][] num = new int[filas][columnas];

                num = lectura(filas, columnas);

                print(num);
                System.out.println();
                balas(num, M);
            }
            break;

            case 2: {
                System.out.println("Elija una opción:");
                System.out.println("[1.Papel] [2.Piedra] [3.Lagarto] [4.Tijera] [5.Spock]");
                int PPLTS1 = leer.nextInt();
                piedraypapel(PPLTS1);

            }
            break;

        }//fin switch
    }//fin public main

    public static int[][] lectura(int f, int c) {
        int[][] matriz = new int[f][c];
        int VALIDAR = 0;
        int M = f * c;
        for (int i = 0; i < f; i++) {
            for (int j = 0; j < c; j++) {

                VALIDAR = 1 + ran.nextInt(M);

                while (menorque88yrepetido(matriz, VALIDAR, f, c, M)) {
                    VALIDAR = 1 + ran.nextInt(M);
                }
                matriz[i][j] = VALIDAR;
            }

        }
        balas(matriz, M);

        return matriz;
    }

    public static boolean menorque88yrepetido(int[][] temporal, int VALIDAR, int f, int c, int M) {

        boolean validar = false;

        for (int i = 0; i < f; i++) {
            for (int j = 0; j < c; j++) {

                if (VALIDAR == temporal[i][j]) {
                    validar = true;
                }

                if (M > 88) {
                    validar = true;
                }

            }//fin for 2
        }//fin for 1

        return validar;
    }

    public static String print(int[][] matriz) {
        String mostrar = " ";

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print("[" + matriz[i][j] + "]");

            }//for2
            System.out.println();
        }//for1

        return mostrar;

    }

    public static int[][] balas(int[][] tiros, int M) {

        System.out.println("Cuantos tiros tendran los jugadores");
        int disparos = lea.nextInt();

        while (disparos >= M / 2) {
            System.out.println("NO PUEDE TENER MAS BALAS QUE LA MATRIZ");
            System.out.println("Cuantos tiros tendran los jugadores");
            disparos = lea.nextInt();
        }
        //disparos = disparos * 2;
        int j1 = disparos;
        int j2 = disparos;
        for (int i = 0; i < tiros.length; i++) {
            for (int j = 0; j < tiros[i].length; j++) {
                System.out.print("[" + tiros[i][j] + "]");
            }//for2
            System.out.println();
        }//for1
        int p1 = 0;
        int p2 = 0;
        int fallo1 = 0;
        int fallo2 = 0;
        while (j1 > 0 || j2 > 0) {
            System.out.println("Elige a que numero disparar Jugador 1!");
            int tiro1 = lea.nextInt();

            for (int i = 0; i < tiros.length; i++) {
                for (int j = 0; j < tiros[i].length; j++) {
                    if (tiro1 == tiros[i][j]) {
                        tiros[i][j] = 99;
                        p1 += tiro1;
                    }
                }
            }

            for (int i = 0; i < tiros.length; i++) {
                for (int j = 0; j < tiros[i].length; j++) {
                    System.out.print("[" + tiros[i][j] + "]");
                }//for2
                System.out.println();
            }

            if (p1 == fallo1) {
                System.out.println("FALLO");
            } else {
                fallo1 = p1;
            }
            j1--;

            System.out.println("Elige a que numero disparar Jugador 2!");
            int tiro2 = lea.nextInt();

            for (int i = 0; i < tiros.length; i++) {
                for (int j = 0; j < tiros[i].length; j++) {
                    if (tiro2 == tiros[i][j]) {
                        tiros[i][j] = 88;
                        p2 += tiro2;
                    }
                }
            }

            for (int i = 0; i < tiros.length; i++) {
                for (int j = 0; j < tiros[i].length; j++) {
                    System.out.print("[" + tiros[i][j] + "]");
                }//for2
                System.out.println();
            }
            if (p2 == fallo2) {
                System.out.println("FALLO");
            } else {
                fallo2 = p2;
            }
            j2--;

        }

        if (p1 > p2) {
            System.out.println("FELICIDADES GANO EL JUGADOR 1");
        } else if (p2 > p1) {
            System.out.println("FELICIDADES GANO EL JUGADOR 2");
        } else if (p2 == p1) {
            System.out.println("FELICIDADES ES UN EMPATE");
        }

        return tiros;
    }

    //CASO 2
    public static void piedraypapel(int jugada) {
          int[][] OPC = {
            {0, 0, 0, 0, 0, 0},
            {0, 0, -1, 1, 1, -1},
            {0, 1, 0, -1, -1, 1},
            {0, -1, 1, 0, 1, -1},
            {0, -1, 1, -1, 0, 1},
            {0, 1, -1, 1, -1, 0}
        };
        //1 GANA JUGADOR, 0 EMPATE, -1 GANA MAQUINA
        int M = ran.nextInt(5) + 1;

        System.out.println("Jugador elige: " + jugada);
        System.out.println("Máquina elige: " + M);

        int ganador = ganadores(jugada, M, OPC);
        GANADOR(ganador);
    }

    

      public static int ganadores(int J1, int M, int[][] G) {
        return G[J1][M];
    }

    public static void GANADOR(int resultado) {
        if (resultado == 1) {
            System.out.println("¡Jugador Gana!");
        } else if (resultado == -1) {
            System.out.println("¡La máquina Gana!");
        } else {
            System.out.println("¡Empate!");
        }
    }

}
