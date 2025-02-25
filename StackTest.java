import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class StackTest {
    private Stack<Integer> stackArray;
    private Stack<Integer> stackVector;
    private Stack<Integer> stackLista;

    @BeforeEach
    void setUp() {
        stackArray = new StackArrayLis<>();
        stackVector = new StackVector<>();
        stackLista = new StackLista<>(new ListaSimple<>());
    }

    @Test
    void testStackPushAndPop() {
        stackArray.push(10);
        stackVector.push(20);
        stackLista.push(30);
        
        assertEquals(10, stackArray.pop());
        assertEquals(20, stackVector.pop());
        assertEquals(30, stackLista.pop());
    }

    @Test
    void testStackPeek() {
        stackArray.push(5);
        stackVector.push(15);
        stackLista.push(25);
        
        assertEquals(5, stackArray.peek());
        assertEquals(15, stackVector.peek());
        assertEquals(25, stackLista.peek());
    }
    
    @Test
    void testStackEmpty() {
        assertTrue(stackArray.empty());
        stackArray.push(1);
        assertFalse(stackArray.empty());
    }
}

class ListaTest {
    private Lista<Integer> listaSimple;
    private Lista<Integer> listaDoble;

    @BeforeEach
    void setUp() {
        listaSimple = new ListaSimple<>();
        listaDoble = new ListaDoble<>();
    }

    @Test
    void testListaAgregarYRemover() {
        listaSimple.agregar(10);
        listaDoble.agregar(20);
        
        assertEquals(10, listaSimple.removerUltimo());
        assertEquals(20, listaDoble.removerUltimo());
    }
    
    @Test
    void testListaVacia() {
        assertTrue(listaSimple.estaVacia());
        listaSimple.agregar(1);
        assertFalse(listaSimple.estaVacia());
    }
}

class CalculadoraTest {
    private Calculadora calculadora;
    
    @BeforeEach
    void setUp() {
        calculadora = Calculadora.getInstance(new StackArrayList<>());
    }
    
    @Test
    void testEvaluarExpresionSimple() {
        double resultado = calculadora.evaluar("3 4 +");
        assertEquals(7.0, resultado);
    }
    
    @Test
    void testEvaluarExpresionMultiplicacion() {
        double resultado = calculadora.evaluar("3 4 *");
        assertEquals(12.0, resultado);
    }
    
    @Test
    void testEvaluarExpresionCompleja() {
        double resultado = calculadora.evaluar("10 2 + 3 *");
        assertEquals(36.0, resultado);
    }
}