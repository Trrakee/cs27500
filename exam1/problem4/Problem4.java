public class Problem4
{
    public static void main(String[ ] args)
    {
        Location a, b, c;
        a = new Location(10, 20);
        b = (Location)a.clone();
//        b = (Location)((Location)a).clone();
        c = a;
        c.shift(2,0);

        System.out.println("a");
        System.out.println(a);
        System.out.println(a.getX());
        System.out.println(a.getY());
        System.out.println("b");
        System.out.println(b);
        System.out.println(b.getX());
        System.out.println(b.getY());
        System.out.println("c");
        System.out.println(c);
        System.out.println(c.getX());
        System.out.println(c.getY());

        System.out.println("");

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
}//Problem4