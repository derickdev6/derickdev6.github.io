import java.util.Random;
import java.io.FileWriter;

public class Punto4 {
    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("niños.txt");
            Random rand = new Random();
            for (int i = 1; i <= 20; i++) {
                String[] nin = contarDulces(rand.nextInt(16) + 10);
                System.out.println("\n" + i);
                writer.write("\n" + i);
                for (int j = 0; j < nin.length; j++) {
                    System.out.println("\t" + j + " " + nin[j]);
                    writer.write("\n\t" + j + " " + nin[j]);
                }
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("Error " + e.toString());
        }

    }

    public static String[] contarDulces(int numDulces) {
        String[] dulces = new String[numDulces];
        Random rand = new Random();
        for (int i = 0; i < numDulces; i++) {
            int opt = rand.nextInt(3);
            if (opt == 0) {
                dulces[i] = "chocolate";
            } else if (opt == 1) {
                dulces[i] = "fruna";
            } else {
                dulces[i] = "bonbonbum";
            }
        }

        return dulces;
    }
}
