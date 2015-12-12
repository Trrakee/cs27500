import java.util.ArrayDeque;

public class Stack<T>
{
//    private Queue<T> queue = new Queue<T>(); // COMPILER ERROR!
    private ArrayDeque<T> queue = new ArrayDeque<T>();

    public void push(T item)
    {
        queue.add(item);
    }

    public T pop()
    {
        T result = null;

        if (!queue.isEmpty()) {
            for (int i = 0; i < queue.size() - 1; i++) {
                queue.add(queue.remove());
            }
        }
        result = queue.remove();

        // DEBUG
//        System.out.println("STACK DEBUG");
//        System.out.println(queue.toString());

        return result;
    }
}