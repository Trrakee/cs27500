public class Problem9C
{
    public static void main(String[ ] args)
    {
        LinkedList list = new LinkedList();

        System.out.println("** list.add(3).add(2).add(5).add(0).add(8)");
        list.add(3).add(2).add(5).add(0).add(8);
        System.out.println(list);
        System.out.println(list.getSize());
        System.out.println("** list.remove()");
        list.remove();
        System.out.println(list);
        System.out.println(list.getSize());
    }//main()
}//Problem9C