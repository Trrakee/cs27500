public class Problem11
{
    public static void main(String[ ] args)
    {
        IntNode head = new IntNode(4, new IntNode(7, new IntNode(5, new IntNode(3, null))));

        System.out.println("** start part (a)");
        System.out.println("**** head");
        System.out.println(head);
        System.out.println(head.getData());
        System.out.println(head.getLink());
        System.out.println("**** list");
        System.out.println(IntNode.list2String(head));
        System.out.println("** end part (a)");
        System.out.println("");

        IntNode ptr = head.getLink().getLink();

        System.out.println("** start part (b)");
        System.out.println("**** head");
        System.out.println(head);
        System.out.println(head.getData());
        System.out.println(head.getLink());
        System.out.println("**** ptr");
        System.out.println(ptr);
        System.out.println(ptr.getData());
        System.out.println(ptr.getLink());
        System.out.println("**** list");
        System.out.println(IntNode.list2String(head));
        System.out.println("** end part (b)");
        System.out.println("");

        head.getLink().setLink( new IntNode(22, null) );

        System.out.println("** start part (c)");
        System.out.println("**** head");
        System.out.println(head);
        System.out.println(head.getData());
        System.out.println(head.getLink());
        System.out.println(IntNode.list2String(head));
        System.out.println("**** ptr");
        System.out.println(ptr);
        System.out.println(ptr.getData());
        System.out.println(ptr.getLink());
        System.out.println(IntNode.list2String(ptr));
        System.out.println("** end part (c)");
        System.out.println("");

        System.out.println("** start part (d)");
        System.out.println(IntNode.list2String(head));
        System.out.println("** end part (d)");
        System.out.println("");

        System.out.println("** start part (e)");
        System.out.println(IntNode.list2String(ptr));
        System.out.println("** end part (e)");
        System.out.println("");

        ptr.getLink().setLink( head.getLink() );

        System.out.println("** start part (f)");
        System.out.println(IntNode.list2String(ptr));
        System.out.println("** end part (f)");
        System.out.println("");

    }//main()
}//Problem11