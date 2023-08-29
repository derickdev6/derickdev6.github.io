import java.util.Random;
import java.util.Scanner;

public class first {

    // Public arrays from 5 to 15 slots filled randomly
    static Random r = new Random();
    static int[] numericalArray = new int[r.nextInt(5, 16)];
    static String[] textArray = new String[r.nextInt(5, 16)];

    public static void main(String[] args) {

        try {
            fillArrays();
            System.out.println("Program started...");

            System.out.println(numericalArray.length);
            System.out.println(textArray.length);

            for (int i = 0; i < numericalArray.length; i++) {
                System.out.print(i + ": " + numericalArray[i] + "    ");
            }
            System.out.println();
            for (int i = 0; i < textArray.length; i++) {
                System.out.print(i + ": " + textArray[i] + "    ");
            }
            System.out.println();

            int opt = 0, opt2 = 0, opt3 = 1, exit = 7;
            Scanner consolein = new Scanner(System.in);
            do {
                showMenu(0);
                opt = consolein.nextInt();
                switch (opt) {
                    case 1:
                        System.out.println("Recorrer arreglos:");
                        showMenu(1);

                        opt2 = consolein.nextInt();
                        if (opt2 != 1 && opt2 != 2) {
                            System.out.println("\n\tEl tipo de arreglo seleccionado es incorrecto...\n");
                            continue;
                        }
                        showMenu(2);
                        opt3 = consolein.nextInt();
                        if (opt3 != 0) {
                            showArray(opt2, true);
                            break;
                        }
                        showArray(opt2, false);
                        break;
                    case 2:
                        System.out.println("Actualizar posicion:");
                        showMenu(1);

                        opt2 = consolein.nextInt();
                        if (opt2 != 1 && opt2 != 2) {
                            System.out.println("\n\tEl tipo de arreglo seleccionado es incorrecto...\n");
                            continue;
                        }

                        System.out.println("Seleccionar posicion");
                        opt3 = consolein.nextInt();

                        System.out.println("Ingrese el nuevo valor");
                        if (opt2 == 1) {
                            int newVal = consolein.nextInt();
                            updateValueN(opt3, newVal);
                        } else if (opt2 == 2) {
                            String newVal = consolein.next();
                            updateValueT(opt3, newVal);
                        }

                        break;
                    case 3:
                        System.out.println("Añadir posicion:");
                        showMenu(1);

                        opt2 = consolein.nextInt();
                        if (opt2 != 1 && opt2 != 2) {
                            System.out.println("\n\tEl tipo de arreglo seleccionado es incorrecto...\n");
                            continue;
                        }

                        break;
                    case 4:
                        System.out.println("Borrar posicion:");
                        break;
                    case 5:
                        System.out.println("Ordenar arreglo:");
                        break;
                    case 6:
                        System.out.println("Busqueda:");
                        break;

                }
            } while (opt != exit);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void fillArrays() {

        // Fill the numerical array with random ints from 1 to 99
        // 20% of the slots will be left empty (zeros)
        for (int i = 0; i < numericalArray.length; i++) {
            int decision = r.nextInt(0, 5);
            if (decision < 4) {
                int temp = r.nextInt(1, 100);
                numericalArray[i] = temp;
            }
        }

        for (int i = 0; i < textArray.length; i++) {
            int decision = r.nextInt(0, 5);
            if (decision < 4) {
                String temp = "aa";
                textArray[i] = temp;
            }
        }
    }

    public static void showMenu(int id) {
        switch (id) {
            case 0:
                System.out.println("\n1 Recorrer arreglos");
                System.out.println("2 Actualizar posicion");
                System.out.println("3 Añadir posicion");
                System.out.println("4 Borrar posicion");
                System.out.println("5 Ordenar arreglo");
                System.out.println("6 Busqueda");
                System.out.println("7 Terminar\n");
                break;
            case 1:
                System.out.println("\n1 Numerico");
                System.out.println("2 Texto\n");
                break;
            case 2:
                System.out.println("\n1 Inicio a fin");
                System.out.println("0 Fin a inicio\n");
                break;

        }
    }

    public static void showArray(int type, Boolean order) {
        // Reads an array depending on the type given in the parameter
        // The order is also given by parameter
        if (type == 1) {
            System.out.println("\tNumerico");
            if (order) {
                System.out.println("\tAl derecho");
                for (int i = 0; i < numericalArray.length; i++) {
                    System.out.println("\t\t" + i + ": " + numericalArray[i]);
                }
            } else {
                System.out.println("\tAl reves");
                for (int i = numericalArray.length - 1; i >= 0; i--) {
                    System.out.println("\t\t" + i + ": " + numericalArray[i]);
                }
            }
        } else if (type == 2) {
            System.out.println("\tTexto");
            if (order) {
                System.out.println("\tAl derecho");
                for (int i = 0; i < textArray.length; i++) {
                    System.out.println("\t\t" + i + ": " + textArray[i]);
                }
            } else {
                System.out.println("\tAl reves");
                for (int i = textArray.length - 1; i >= 0; i--) {
                    System.out.println("\t\t" + i + ": " + textArray[i]);
                }
            }
        } else {
            System.out.println("Unknown type | neither numerical or textual");
        }
    }

    public static void updateValueN(int pos, int value) {
        try {
            if (pos < 0 || pos >= numericalArray.length) {
                System.out.println("\n\tPosicion por fuera de los limites\n");
                return;
            }
            numericalArray[pos] = value;

            showArray(1, true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void updateValueT(int pos, String value) {
        try {
            if (pos < 0 || pos >= textArray.length) {
                System.out.println("\n\tPosicion por fuera de los limites\n");
                return;
            }
            textArray[pos] = value;

            showArray(2, true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}