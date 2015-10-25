public class Problem1B
{
    public static void main(String[ ] args)
    {
        A a1 = new A(200);
        System.out.println("before a1");
        System.out.println(a1);
        A a2 = new A(250);
        System.out.println("before a2");
        System.out.println(a2);
        A a3 = a2;
        System.out.println("before a3");
        System.out.println(a3);
        a2 = a1;
        a1 = null;

        System.out.println("a1");
        System.out.println(a1);
//        System.out.println(a1.getX()); // null
        System.out.println("a2");
        System.out.println(a2);
        System.out.println(a2.getX());
        System.out.println("a3");
        System.out.println(a3);
        System.out.println(a3.getX());
    }//main()
}//Problem1B