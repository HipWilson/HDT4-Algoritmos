import java.util.Stack;

public class InfixToPostfix {
    public static String transformar(String expresion) {
        StringBuilder salida = new StringBuilder();
        Stack<Character> pilaOperadores = new Stack<>();
        boolean esNumeroPrevio = false;

        for (int i = 0; i < expresion.length(); i++) {
            char simbolo = expresion.charAt(i);

            if (Character.isDigit(simbolo) || simbolo == '.') { // Manejo de números decimales
                salida.append(simbolo);
                esNumeroPrevio = true;
            } else if (simbolo == '(') {
                pilaOperadores.push(simbolo);
                esNumeroPrevio = false;
            } else if (simbolo == ')') {
                while (!pilaOperadores.isEmpty() && pilaOperadores.peek() != '(') {
                    salida.append(" ").append(pilaOperadores.pop());
                }
                pilaOperadores.pop(); // Remover el paréntesis de apertura
                esNumeroPrevio = true;
            } else if (esSimboloOperador(simbolo)) {
                if (esNumeroPrevio) {
                    salida.append(" ");
                }
                while (!pilaOperadores.isEmpty() && obtenerPrioridad(simbolo) <= obtenerPrioridad(pilaOperadores.peek())) {
                    salida.append(pilaOperadores.pop()).append(" ");
                }
                pilaOperadores.push(simbolo);
                esNumeroPrevio = false;
            }
        }

        while (!pilaOperadores.isEmpty()) {
            salida.append(" ").append(pilaOperadores.pop());
        }

        return salida.toString().trim();
    }

    private static boolean esSimboloOperador(char simbolo) {
        return simbolo == '+' || simbolo == '-' || simbolo == '*' || simbolo == '/';
    }

    private static int obtenerPrioridad(char operador) {
        switch (operador) {
            case '+': case '-': return 1;
            case '*': case '/': return 2;
            default: return -1;
        }
    }

    public static String convertir(String expresion) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'convertir'");
    }
}
