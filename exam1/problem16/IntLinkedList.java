public class IntLinkedList
{
    IntNode head;
    IntNode tail;
    int manyItems;

    public IntLinkedList()
    {
        tail = new IntNode(0, null);
        head = new IntNode(0, tail);
        System.out.println("** start part (a)");
        System.out.println("**** tail");
        System.out.println(tail);
        System.out.println("**** head");
        System.out.println(head);
        System.out.println("** end part (a)");
        System.out.println("");
        manyItems = 0;
    }

    /** Add a new node to the beginning of the list. */
    public void addFirst(int n)
    {
        IntNode new_node = new IntNode(n, head);
        head = new_node;
        manyItems++;
    }

    /** Remove the first node from a nonempty list and return its data. */
    public int removeFirst()
    {
        int removed = head.getData();
        head = head.getLink();
        return removed;
    }

    /** Not part of the problem. For testing purposes only. */
    public IntNode getHead()
    {
        return head;
    }

    /** Not part of the problem. For testing purposes only. */
    public IntNode getTail()
    {
        return tail;
    }

    /** Not part of the problem. For testing purposes only. */
    public String toString()
    {
        IntNode cursor = head;
        String result = "[ ";
        while (cursor.getLink() != null)
        {
            result += cursor.getData();
            result += " ";
            cursor = cursor.getLink();
        }

        result += cursor.getData();
        result += " ]";
        return result;
    }
}//IntLinkedList