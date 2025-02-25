import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        // Se obtienen opciones del usuario
        System.out.println("Seleccione la implementación del Stack:");
        System.out.println("1. ArrayList");
        System.out.println("2. Vector");
        System.out.println("3. Lista enlazada");
        int opcionPila = entrada.nextInt();

        int tipoEstructura = 0;
        if (opcionPila == 3) {
            // Si el usuario eligió 'Lista enlazada', preguntamos qué tipo
            System.out.println("Seleccione el tipo de lista:");
            System.out.println("1. Lista simplemente enlazada");
            System.out.println("2. Lista doblemente enlazada");
            tipoEstructura = entrada.nextInt();
        }

        // Se delega la creación del Stack a la fábrica
        Stack<Double> pila = StackFactory.createStack(opcionPila, tipoEstructura);

        // (Resto del código para usar la Calculadora y leer el archivo)
        Calculadora calculadora = Calculadora.obtenerInstancia(pila);

        try (BufferedReader lector = new BufferedReader(new FileReader("datos.txt"))) {
            String expresion;
            while ((expresion = lector.readLine()) != null) {
                try {
                    String notacionPostfija = InfixToPostfix.transformar(expresion);
                    double resultado = calculadora.calcular(notacionPostfija);
                    System.out.println("Expresión: " + expresion
                                       + " -> Postfix: " + notacionPostfija
                                       + " = " + resultado);
                } catch (Exception e) {
                    System.err.println("Error al evaluar la expresión: " + expresion);
                    System.err.println("Motivo: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }

        entrada.close();
    }
}

