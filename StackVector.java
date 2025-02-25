import java.util.Vector;

public class StackVector<E> implements Stack<E> {
    protected Vector<E> data = new Vector<>();

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