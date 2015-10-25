public class Problem10
{
    public static void main(String[ ] args)
    {
        IntNode head    = new IntNode(12, null);
        IntNode second  = new IntNode(0, null);
        IntNode third   = new IntNode(7, null);
        IntNode fourth  = new IntNode(-5, null);
        IntNode fifth   = new IntNode(0, null);
        IntNode sixth   = new IntNode(0, null);
        IntNode seventh = new IntNode(100, null);
        IntNode eighth  = new IntNode(42, null);
        IntNode ninth   = new IntNode(0, null);
        IntNode empty   = null;

        head.setLink(second);
        second.setLink(third);
        third.setLink(fourth);
        fourth.setLink(fifth);
        fifth.setLink(sixth);
        sixth.setLink(seventh);
        seventh.setLink(eighth);
        eighth.setLink(ninth);

        System.out.println("** start countZeros()");
        int zero_count1 = IntNode.countZeros(head);
        System.out.println(zero_count1);
        int zero_count2 = IntNode.countZeros(second);
        System.out.println(zero_count2);
        int zero_count3 = IntNode.countZeros(third);
        System.out.println(zero_count3);
        int zero_count4 = IntNode.countZeros(sixth);
        System.out.println(zero_count4);
        int zero_count5 = IntNode.countZeros(seventh);
        System.out.println(zero_count5);
        int zero_count6 = IntNode.countZeros(ninth);
        System.out.println(zero_count6);
        System.out.println("** end countZeros()");

        System.out.println("");

        System.out.println("** start list2String()");
        String list_string1 = IntNode.list2String(head);
        System.out.println(list_string1);
        String list_string2 = IntNode.list2String(second);
        System.out.println(list_string2);
        String list_string3 = IntNode.list2String(third);
        System.out.println(list_string3);
        String list_string4 = IntNode.list2String(ninth);
        System.out.println(list_string4);
        String list_string5 = IntNode.list2String(empty);
        System.out.println(list_string5);
        System.out.println("** end list2String()");

        System.out.println("");

        System.out.println("** start removeFirst()");
        System.out.println("**** 1");
        System.out.println(list_string1);
        IntNode new_head1 = IntNode.removeFirst(head);
        System.out.println(new_head1.getData());
        String new_list_string1 = IntNode.list2String(new_head1);
        System.out.println(new_list_string1);
        System.out.println("**** 2");
        System.out.println(new_list_string1);
        IntNode new_head2 = IntNode.removeFirst(new_head1);
        System.out.println(new_head2.getData());
        String new_list_string2 = IntNode.list2String(new_head2);
        System.out.println(new_list_string2);
        System.out.println("** end removeFirst()");

        System.out.println("");

        System.out.println("** start addFirst()");
        System.out.println("**** 1");
        System.out.println(list_string1);
        IntNode added_head1 = IntNode.addFirst(43, head);
        System.out.println(added_head1.getData());
        String added_list_string1 = IntNode.list2String(added_head1);
        System.out.println(added_list_string1);
        System.out.println("**** 2");
        System.out.println(added_list_string1);
        IntNode added_head2 = IntNode.addFirst(44, added_head1);
        System.out.println(added_head2.getData());
        String added_list_string2 = IntNode.list2String(added_head2);
        System.out.println(added_list_string2);
        System.out.println("** end addFirst()");

        System.out.println("");

        System.out.println("** start set()");
        System.out.println("**** 1");
        String list_string_set1 = IntNode.list2String(head);
        System.out.println(list_string_set1);
        IntNode.set(143, 0, head);
        String list_string_set2 = IntNode.list2String(head);
        System.out.println(list_string_set2);
        System.out.println("**** 2");
        System.out.println(list_string_set2);
        IntNode.set(1000, 8, head);
        String list_string_set3 = IntNode.list2String(head);
        System.out.println(list_string_set3);
        System.out.println("**** 3");
        System.out.println(list_string_set3);
        IntNode.set(2222, 10, head);
        String list_string_set4 = IntNode.list2String(head);
        System.out.println(list_string_set4);
        System.out.println("** end set()");

    }//main()
}//Problem10