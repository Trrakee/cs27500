import java.util.LinkedList;

public class Stack<T>
{
    private LinkedList<T> queue = new LinkedList<T>();

    public void push(T item)
    {
        queue.add(item);
    }

    public T pop() {
        T result = null;

        if (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n - 1; i++) {
                queue.add(queue.remove());
            }
            result = queue.remove();
        }

        // DEBUG
//        System.out.println("STACK DEBUG");
//        System.out.println(queue.toString());

        return result;
    }
}