public class Problem9
{
    public static void main(String[ ] args)
    {
        LinkedList linked_list1 = new LinkedList();

        linked_list1.add(1);
        System.out.println(linked_list1);
        System.out.println(linked_list1.getSize());
        linked_list1.add(2);
        System.out.println(linked_list1);
        System.out.println(linked_list1.getSize());
        linked_list1.add(3);
        System.out.println(linked_list1);
        System.out.println(linked_list1.getSize());
        linked_list1.remove();
        System.out.println(linked_list1);
        System.out.println(linked_list1.getSize());
        linked_list1.remove();
        System.out.println(linked_list1);
        System.out.println(linked_list1.getSize());
        linked_list1.remove();
        System.out.println(linked_list1);
        System.out.println(linked_list1.getSize());
//        linked_list1.remove(); // runtime error - java.lang.IllegalStateException: The linked list has no elements.
    }//main()
}//Problem9