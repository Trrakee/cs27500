public class Problem6
{
    public static void main(String[ ] args)
    {
        Pair1<Integer> p1 = new Pair1<Integer>(1, 2);
        Pair2<Integer> p2 = new Pair2<Integer>(3, 4);
        Pair3<Integer> p3 = new Pair3<Integer>(5, 6);

        // PAIR 1 - The field data of p1 can be compared to any other objects which implement the Comparable interface.
        System.out.println(p1.getFirst() > 6);
        System.out.println(p1.getFirst() > 6.0);

        System.out.println("");

        // PAIR 2 - p2 can only be compared with other objects of the same type.
        System.out.println(p2.compareTo(3));

        System.out.println("");

        // PAIR 3 - p3 can only be compared with other instances of Pair3 of the same type.
        Pair3<Integer> p3_compare1 = new Pair3<Integer>(5, 6);
        Pair3<Integer> p3_compare2 = new Pair3<Integer>(6, 6);
        Pair3<Integer> p3_compare3 = new Pair3<Integer>(5, 5);
        System.out.println(p3.compareTo(p3_compare1));
        System.out.println(p3.compareTo(p3_compare2));
        System.out.println(p3.compareTo(p3_compare3));
    }//main()
}//Problem6