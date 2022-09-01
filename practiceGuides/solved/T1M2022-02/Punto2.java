import java.util.Random;
import java.util.Scanner;

public class Punto2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Numero de jugadores: ");
        int numJugadores = scanner.nextInt();

        System.out.println("Numero de dados por jugador: ");
        int numDados = scanner.nextInt();

        for (int i = 0; i < numJugadores; i++) {
            int[] jug1 = tirarDados(numDados);
            System.out.print("\nJugador " + i + ": ");

            for (int j = 0; j < numDados; j++) {
                System.out.print(jug1[j] + "  c ");
            }
        }
        System.out.println("\nFin");
    }

    public static int[] tirarDados(int numDados) {
        Random rand = new Random();
        int[] resDados = new int[numDados];
        if (numDados < 2 || numDados > 5) {
            for (int i = 0; i < numDados; i++) {
                resDados[i] = 0;
            }
        } else {
            for (int i = 0; i < numDados; i++) {
                resDados[i] = rand.nextInt(6) + 1;
            }
        }

        return resDados;
    }
}
