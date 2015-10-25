public class Problem1A
{
    public static void main(String[ ] args)
    {
        A a = new A(100);
        System.out.println("before a");
        System.out.println(a);
        A b = new A(150);
        System.out.println("before b");
        System.out.println(b);
        A c = b;
        System.out.println("before c");
        System.out.println(c);
        b = a;
        a = null;

        System.out.println("a");
        System.out.println(a);
//        System.out.println(a.getX()); // null
        System.out.println("b");
        System.out.println(b);
        System.out.println(b.getX());
        System.out.println("c");
        System.out.println(c);
        System.out.println(c.getX());
    }//main()
}//Problem1A