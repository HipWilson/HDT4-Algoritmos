public class ListaFactory {

    public static Lista<Double> createLista(int tipoLista) {
        switch (tipoLista) {
            case 1:
                return new ListaSimple<>();
            case 2:
                return new ListaDoble<>();
            default:
                // Opción inválida -> usar ListaSimple por defecto
                return new ListaSimple<>();
        }
    }
}