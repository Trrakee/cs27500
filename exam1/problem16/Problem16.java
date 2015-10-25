public class Problem16
{
    public static void main(String[ ] args)
    {
        IntLinkedList list = new IntLinkedList();

        // Part (b).
        System.out.println("** start part (b)");
        System.out.println("**** list.addFirst(42);");
        list.addFirst(42);
        System.out.println("**** list.toString()");
        System.out.println(list.toString());
        System.out.println("**** list.getHead().getData()");
        System.out.println(list.getHead().getData());
        System.out.println("**** list.getTail().getData()");
        System.out.println(list.getTail().getData());
        System.out.println("**** list.addFirst(43);");
        list.addFirst(43);
        System.out.println("**** list.toString()");
        System.out.println(list.toString());
        System.out.println("**** list.getHead().getData()");
        System.out.println(list.getHead().getData());
        System.out.println("**** list.getTail().getData()");
        System.out.println(list.getTail().getData());
        System.out.println("**** list.addFirst(44);");
        list.addFirst(44);
        System.out.println("**** list.toString()");
        System.out.println(list.toString());
        System.out.println("**** list.getHead().getData()");
        System.out.println(list.getHead().getData());
        System.out.println("**** list.getTail().getData()");
        System.out.println(list.getTail().getData());
        System.out.println("** end part (b)");

        System.out.println("");

        // Part (c).
        System.out.println("** start part (c)");
        System.out.println("**** list.toString()");
        System.out.println(list.toString());
        System.out.println("**** int removed_data1 = list.removeFirst();");
        int removed_data1 = list.removeFirst();
        System.out.println("**** removed_data1");
        System.out.println(removed_data1);
        System.out.println("**** list.toString()");
        System.out.println(list.toString());
        System.out.println("**** list.getHead().getData()");
        System.out.println(list.getHead().getData());
        System.out.println("**** int removed_data2 = list.removeFirst();");
        int removed_data2 = list.removeFirst();
        System.out.println("**** removed_data2");
        System.out.println(removed_data2);
        System.out.println("**** list.toString()");
        System.out.println(list.toString());
        System.out.println("**** list.getHead().getData()");
        System.out.println(list.getHead().getData());
        System.out.println("** end part (c)");
        System.out.println("");
    }//main()
}//Problem16