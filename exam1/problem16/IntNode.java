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
}