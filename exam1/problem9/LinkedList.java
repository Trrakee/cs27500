class LinkedList
{
    private ListNode head;
    private int size;

    public LinkedList()
    {
        this.head = null;
        this.size = 0;
    }

    class ListNode
    {
        public int item;      // An item in the list.
        public ListNode next; // Reference to next item in the list.
    }

    /**
     * Add a ListNode to the head of the LinkedList.
     *
     * @param element - item that is stored in the new ListNode.
     */
    public void add(int element)
    {
        ListNode new_node = new ListNode();
        new_node.item = element;
        if (size == 0)
        {
            // There is currently no ListNode's in the LinkedList.
            new_node.next = null;

        } else {
            // There are ListNode's already in the LinkedList.
            new_node.next = head;
        }
        head = new_node;
        size++;
    }

    /**
     * Remove the head ListNode from the LinkedList.
     *
     * @return item that was in the removed ListNode.
     */
    public int remove()
    {
        if (size == 0) {
            throw new IllegalStateException("The linked list has no elements.");
        } else {
            int removed_item = head.item;
            head = head.next;
            size--;
            return removed_item;
        }
    }

    public int getSize( )
    {
        return size;
    }

    public String toString( )
    {
        String result = "[";
        ListNode ptr = head;
        while (ptr != null)
        {
            result += ptr.item;
            ptr = ptr.next;
            if (ptr != null)
            {
                result += ", ";
            }
        }
        result += "]";
        return result;
    }
}