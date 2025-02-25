public interface Lista<E> {
    void agregar(E item);
    E removerUltimo();
    E obtenerUltimo();
    int tamano();
    boolean estaVacia();
}