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
}