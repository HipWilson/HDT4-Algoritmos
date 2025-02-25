import java.util.Scanner;

public class Calculadora {
    private static Calculadora instanciaUnica; // Instancia única (Singleton)
    private Stack<Double> pilaValores; // Asociación con una implementación de Stack

    /**
     * Constructor privado para evitar instanciación directa.
     */
    private Calculadora(Stack<Double> pila) {
        this.pilaValores = pila;
    }

    /**
     * Método para obtener la única instancia de la calculadora.
     * Si no ha sido creada, la inicializa con la pila dada.
     *
     * @param pila estructura de datos para almacenar valores
     * @return la instancia única de Calculadora
     */
    public static Calculadora obtenerInstancia(Stack<Double> pila) {
        if (instanciaUnica == null) {
            instanciaUnica = new Calculadora(pila);
        }
        return instanciaUnica;
    }

    /**
     * Procesa una expresión en notación postfija y devuelve el resultado.
     *
     * @param expresion la cadena de entrada en postfix
     * @return resultado de la evaluación
     */
    public double calcular(String expresion) {
        // Se reinicia la pila antes de evaluar
        while (!pilaValores.empty()) {
            pilaValores.pop();
        }

        Scanner lector = new Scanner(expresion);

        while (lector.hasNext()) {
            if (lector.hasNextDouble()) {
                pilaValores.push(lector.nextDouble());
            } else {
                String operador = lector.next();
                if (pilaValores.size() < 2) {
                    throw new IllegalArgumentException("Expresión incorrecta: operandos insuficientes.");
                }
                double valorB = pilaValores.pop();
                double valorA = pilaValores.pop();
                pilaValores.push(realizarOperacion(valorA, valorB, operador));
            }
        }

        if (pilaValores.size() != 1) {
            throw new IllegalArgumentException("Expresión inválida o incompleta.");
        }
        return pilaValores.pop();
    }

    /**
     * Ejecuta la operación aritmética correspondiente.
     */
    private double realizarOperacion(double a, double b, String operador) {
        switch (operador) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/":
                if (b == 0) throw new ArithmeticException("Error: División por cero.");
                return a / b;
            default:
                throw new IllegalArgumentException("Operador no reconocido: " + operador);
        }
    }

}
