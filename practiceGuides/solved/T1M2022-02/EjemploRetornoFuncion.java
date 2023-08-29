public class EjemploRetornoFuncion {
    public static void main(String[] args) {
        System.out.println("Inicio de programa");

        String saludito = bienvenido("Jorge");
        System.out.println(saludito);
    }

    public static String bienvenido(String nombre) {
        String mensaje = "Hola " + nombre + ", bienvenido!";
        return mensaje;
    }
}
