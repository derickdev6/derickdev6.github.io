import java.util.Scanner;

public class Punto1new {
    public static void main(String[] args) {

        int acum, max = 0;

        // Voy a hacer 3 ciclos, 3 jugadores
        for (int i = 0; i < 3; i++) {
            System.out.println("Jugador numero " + (i + 1));
            // Declaro el acumulador como 0 al iniciar el conteo de cada jugador
            acum = 0;

            // Por cada jugador voy a sacar 4 cartas random
            for (int j = 0; j < 4; j++) {
                // Saco carta random
                // Acumulo
                // Muestro carta

            }
            // Muestro acumulador
            System.out.println("\tTotal = " + acum);
            // Si el acumulado de cartas del jugador actual es mayor que el maximo
            // El maximo pasa a ser el actual
            if (acum > max) {
                max = acum;
            }
        }
    }
}
