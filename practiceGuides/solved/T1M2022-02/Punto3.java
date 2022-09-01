import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Punto3 {
    public static void main(String[] args) {
        try {
            File f = new File("test.txt");
            Scanner scan = new Scanner(f);

            String estudianteMax = "";
            float maxProm = 0;
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] tokens = line.split(",");
                String estudiante = tokens[0];
                System.out.println(estudiante);
                float acum = 0;
                float prom = 0;
                for (int i = 1; i < tokens.length; i++) {
                    System.out.print(tokens[i] + "  ");
                    float nota = Float.parseFloat(tokens[i]);
                    acum += nota;
                }
                prom = acum / 3;
                if (prom > maxProm) {
                    maxProm = prom;
                    estudianteMax = estudiante;
                }
                System.out.print("Promedio =" + prom + "\n");
            }
            System.out.println("Promedio mas alto de " + estudianteMax + " con promedio de " + maxProm);
            scan.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
            e.printStackTrace();
        } finally {
        }
    }
}
