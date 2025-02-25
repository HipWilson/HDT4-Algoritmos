public class ListaDoble<E> implements Lista<E> {
    private NodoLista<E> primerNodo, ultimoNodo;
    private int cantidadElementos = 0;

    public void insertar(E elemento) {
        NodoLista<E> nuevoNodo = new NodoLista<>(elemento, null, ultimoNodo);
        if (ultimoNodo != null) ultimoNodo.siguiente = nuevoNodo;
        ultimoNodo = nuevoNodo;
        if (primerNodo == null) primerNodo = nuevoNodo;
        cantidadElementos++;
    }

    public E eliminarUltimo() {
        if (ultimoNodo == null) return null;
        E elemento = ultimoNodo.valor;
        ultimoNodo = ultimoNodo.anterior;
        if (ultimoNodo != null) ultimoNodo.siguiente = null;
        else primerNodo = null;
        cantidadElementos--;
        return elemento;
    }

    public E consultarUltimo() {
        return ultimoNodo != null ? ultimoNodo.valor : null;
    }

    public int obtenerTamano() {
        return cantidadElementos;
    }

    public boolean estaVacia() {
        return cantidadElementos == 0;
    }

    private static class NodoLista<T> {
        T valor;
        NodoLista<T> siguiente, anterior;

        NodoLista(T valor, NodoLista<T> siguiente, NodoLista<T> anterior) {
            this.valor = valor;
            this.siguiente = siguiente;
            this.anterior = anterior;
        }
    }
}
