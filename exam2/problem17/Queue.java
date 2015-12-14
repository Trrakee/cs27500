import java.util.Stack;

public class Queue<T>
{
    private Stack<T> forAdding = new Stack<T>();
    private Stack<T> forRemoving = new Stack<T>();

    public void add(T item)
    {
        forAdding.push(item);

        // DEBUG
//        System.out.println("QUEUE DEBUG - ADD METHOD");
//        System.out.println(forAdding.toString());
//        System.out.println(forRemoving.toString());
    }

    public T remove()
    {
        T result = null;

        if (forRemoving.isEmpty()) {
            while (!forAdding.isEmpty()) {
                forRemoving.push(forAdding.pop());
            }
        }
        result = forRemoving.pop();

        // DEBUG
//        System.out.println("QUEUE DEBUG - REMOVE METHOD");
//        System.out.println(forAdding.toString());
//        System.out.println(forRemoving.toString());

        return result;
    }
}