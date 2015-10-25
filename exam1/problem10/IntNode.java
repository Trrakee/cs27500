class IntNode
{
    private int data;
    private IntNode link;

    public IntNode(int data, IntNode link)
    {
        this.data = data;
        this.link = link;
    }

    public int getData() { return data; }
    public IntNode getLink() { return link; }
    public void setData(int data) { this.data = data; }
    public void setLink(IntNode link) { this.link = link; }

    public static int countZeros(IntNode node)
    {
        int count = 0;
        IntNode cursor = node;
        while(cursor.link != null) {
            if (cursor.data == 0) {
                count++;
            }
            cursor = cursor.link;
        }

        if (cursor.data == 0) {
            count++;
        }

        return count;
    }

    public static String list2String(IntNode node)
    {
        if (node == null) {
            return "[]";
        }

        IntNode cursor = node;
        String str = "[ ";
        while(cursor.link != null) {
            str += cursor.data;
            str += " ";
            cursor = cursor.link;
        }
        str += cursor.data;
        str += " ]";

        return str;
    }

    public static IntNode removeFirst(IntNode head)
    {
        head = head.link;
        return head;
    }

    public static IntNode addFirst(int element, IntNode head)
    {
        IntNode new_head = new IntNode(element, head);
        return new_head;
    }

    public static void set(int element, int i, IntNode head)
    {
        int cursor_count = 0;
        IntNode cursor = head;
        while(cursor.link != null) {
            if (cursor_count == i) {
                cursor.data = element;
            }
            cursor = cursor.link;
            cursor_count++;
        }

        if (cursor_count == i) {
            cursor.data = element;
        }
    }
}