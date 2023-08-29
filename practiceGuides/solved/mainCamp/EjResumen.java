import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;

public class EjResumen {
    public static void main(String[] args) {
        Scanner consolein = new Scanner(System.in);
        int opt = 0, exit = 3, back = 5, opt2 = 0;
        try {

            do {
                showMainMenu();
                opt = consolein.nextInt();

                switch (opt) {
                    case 1:
                        System.out.println("Listado de libros");
                        System.out.println(listarLibros());
                        break;
                    case 2:
                        do {
                            showMenu2();
                            opt2 = consolein.nextInt();

                            switch (opt2) {
                                case 1:
                                    System.out.println("Libro mas leido");
                                    System.out.println(libroMasLeido());
                                    break;
                                case 2:
                                    System.out.println("Libro menos leido");
                                    System.out.println(libroMenosLeido());
                                    break;
                                case 3:
                                    System.out.println("Promedio de lecturas por dias");
                                    System.out.println(promedioLecturasDia());
                                    break;
                                case 4:
                                    System.out.println("Promedio de lecturas por libro");
                                    System.out.println(promedioLecturasLibro());
                                    break;
                            }

                        } while (opt2 != back);
                        break;
                    case 3:
                        System.out.println("Gracias por usar el servicio, hasta luego!");
                        break;
                }

            } while (opt != exit);

        } catch (Exception e) {
            System.out.println("Error found: " + e.getMessage());
        } finally {
            System.out.println("Done!");
        }
    }

    public static void showMainMenu() {
        System.out.println("""
                1. Listar libros
                2. Detalles de libros
                3. Salir
                """);
    }

    public static void showMenu2() {
        System.out.println("""
                1. Libro mas leido
                2. Libro menos leido
                3. Promedio de lecturas por dia
                4. Promedio de lecturas por libro
                5. Atras
                """);
    }

    public static String listarLibros() {
        String msg = "", bookName = "";
        try {
            FileReader reader = new FileReader("libreria.txt");
            BufferedReader buff = new BufferedReader(reader);

            String line = buff.readLine();

            while (line != null) {
                // System.out.println(line);
                bookName = line;

                for (int i = 0; i < 5; i++) {
                    buff.readLine();
                }
                msg += bookName + "\n";
                line = buff.readLine();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return msg;

    }

    public static String libroMasLeido() {
        String msg = "-1", bookName = "", maxBookName = "";
        int reads = 0, maxReads = 0;
        try {
            FileReader reader = new FileReader("libreria.txt");
            BufferedReader buff = new BufferedReader(reader);

            String line = buff.readLine();

            while (line != null) {
                // System.out.println(line);
                bookName = line;
                reads = 0;

                for (int i = 0; i < 5; i++) {
                    reads += Integer.parseInt(buff.readLine());
                }
                if (reads > maxReads) {
                    maxReads = reads;
                    maxBookName = bookName;
                }
                line = buff.readLine();
            }
            msg = "El libro mas leido es " + maxBookName + " con " + maxReads + " lecturas";
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return msg;
    }

    public static Float promedioLecturasDia() {
        int acum = 0, reads = 0;
        Float prom = 0f;
        try {
            FileReader reader = new FileReader("libreria.txt");
            BufferedReader buff = new BufferedReader(reader);

            String line = buff.readLine();
            reads = 0;
            while (line != null) {
                // System.out.println(line);
                for (int i = 0; i < 5; i++) {
                    reads = Integer.parseInt(buff.readLine());
                    acum += reads;
                }
                line = buff.readLine();
            }
            prom = (float) acum / 5f;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return prom;

    }

    public static Float promedioLecturasLibro() {
        int acum = 0, reads = 0, counter = 0;
        Float prom = 0f;
        try {
            FileReader reader = new FileReader("libreria.txt");
            BufferedReader buff = new BufferedReader(reader);

            String line = buff.readLine();
            reads = 0;
            while (line != null) {
                // System.out.println(line);
                for (int i = 0; i < 5; i++) {
                    reads = Integer.parseInt(buff.readLine());
                    acum += reads;
                    counter++;
                }
                line = buff.readLine();
            }
            prom = (float) acum / counter;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return prom;

    }

    public static String libroMenosLeido() {
        String msg = "-1", bookName = "", minBookName = "";
        int reads = 0, minReads = 1000000;
        try {
            FileReader reader = new FileReader("libreria.txt");
            BufferedReader buff = new BufferedReader(reader);

            String line = buff.readLine();

            while (line != null) {
                // System.out.println(line);
                bookName = line;
                reads = 0;

                for (int i = 0; i < 5; i++) {
                    reads += Integer.parseInt(buff.readLine());
                }
                if (reads < minReads) {
                    minReads = reads;
                    minBookName = bookName;
                }
                line = buff.readLine();
            }
            msg = "El libro menos leido es " + minBookName + " con " + minReads + " lecturas";
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return msg;
    }
}