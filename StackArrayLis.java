import java.util.ArrayList;

public class StackArrayLis<E> implements Stack<E> {
    protected ArrayList<E> data = new ArrayList<>();

    public void push(E item) {
        data.add(item);
    }

    public E pop() {
        return data.remove(size() - 1);
    }

    public E peek() {
        return data.get(size() - 1);
    }

    public int size() {
        return data.size();
    }

    public boolean empty() {
        return size() == 0;
    }
}