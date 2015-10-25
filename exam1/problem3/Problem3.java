public class Problem3
{
    public static void main(String[ ] args)
    {
        Location a, b, c;
        a = new Location(10, 20);
        b = new Location(10, 20);
        c = b;

        System.out.println("a");
        System.out.println(a);
        System.out.println("b");
        System.out.println(b);
        System.out.println("c");
        System.out.println(c);

        System.out.println("output");
        System.out.println("a == b");
        System.out.println(a == b);
        System.out.println("a.equals(b)");
        System.out.println(a.equals(b));
        System.out.println("a == c");
        System.out.println(a == c);
        System.out.println("a.equals(c)");
        System.out.println(a.equals(c));
        System.out.println("b == c");
        System.out.println(b == c);
        System.out.println("b.equals(c)");
        System.out.println(b.equals(c));
    }//main()
}//Problem3