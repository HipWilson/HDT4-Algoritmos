public class StackLista<E> implements Stack<E> {
    private Lista<E> lista;

    public StackLista(Lista<E> lista) {
        this.lista = lista;
    }

    public void push(E item) {
        lista.agregar(item);
    }

    public E pop() {
        return lista.removerUltimo();
    }

    public E peek() {
        return lista.obtenerUltimo();
    }

    public int size() {
        return lista.tamano();
    }

    public boolean empty() {
        return lista.estaVacia();
    }
}