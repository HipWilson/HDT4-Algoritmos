public class ListaSimple<E> implements Lista<E> {
    private Nodo<E> cabeza;
    private int tamano = 0;

    public void agregar(E item) {
        cabeza = new Nodo<>(item, cabeza);
        tamano++;
    }

    public E removerUltimo() {
        if (cabeza == null) return null;
        E item = cabeza.valor;
        cabeza = cabeza.siguiente;
        tamano--;
        return item;
    }

    public E obtenerUltimo() {
        return cabeza != null ? cabeza.valor : null;
    }

    public int tamano() {
        return tamano;
    }

    public boolean estaVacia() {
        return tamano == 0;
    }
    
    // Definición de la clase Nodo dentro de ListaSimple
    private static class Nodo<T> {
        T valor;
        Nodo<T> siguiente;

        Nodo(T valor, Nodo<T> siguiente) {
            this.valor = valor;
            this.siguiente = siguiente;
        }
    }
}