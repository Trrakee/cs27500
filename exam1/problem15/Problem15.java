class Problem15
{
    public static void main(String[] args)
    {
        Sequence A = new SequenceImpl();
        System.out.println("A.add(0, 4)");
        A.add(0, 4);
        System.out.println(A.toString());
        System.out.println(A.size());
        System.out.println("************");
        System.out.println("A.add(0, 3)");
        A.add(0, 3);
        System.out.println(A.toString());
        System.out.println(A.size());
        System.out.println("************");
        System.out.println("A.addFirst(2)");
        A.addFirst(2);
        System.out.println(A.toString());
        System.out.println(A.size());
        System.out.println("************");
        System.out.println("A.addLast(7)");
        A.addLast(7);
        System.out.println(A.toString());
        System.out.println(A.size());
        System.out.println("************");
        System.out.println("A.add(2, 1)");
        A.add(2, 1);
        System.out.println(A.toString());
        System.out.println(A.size());
        System.out.println("************");
        System.out.println("A.add(1, 4)");
        A.add(1, 4);
        System.out.println(A.toString());
        System.out.println(A.size());
        System.out.println("************");
        System.out.println("A.add(1, 5)");
        A.add(1, 5);
        System.out.println(A.toString());
        System.out.println(A.size());
        System.out.println("************");
        System.out.println("A.add(3, 2)");
        A.add(3, 2);
        System.out.println(A.toString());
        System.out.println(A.size());
        System.out.println("************");
    }//main
}//Problem15