public class StackFactory {
    public static Stack<Double> createStack(int opcion, int tipoLista) {
        switch (opcion) {
            case 1:
                return new StackArrayLis<>();
            case 2:
                return new StackVector<>();
            case 3:
                // Se delega la creación de la lista a ListaFactory (Commit #2),
                // pero aquí asumimos que ya existe:
                return new StackLista<>(ListaFactory.createLista(tipoLista));
            default:
                // Opción inválida -> usar Vector por defecto
                return new StackVector<>();
        }
    }
}