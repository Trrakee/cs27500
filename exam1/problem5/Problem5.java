public class Problem5
{
    public static void f(Thing x, int y)
    {
        System.out.println("** inside f(Thing x, int y) function");
        System.out.println("**** x");
        System.out.println(x);
        x.a++;
        y++;
    }

    public static void main(String[ ] args)
    {
        Thing x = new Thing(1, 1);
        int y = 1;
        System.out.println("** outside f(Thing x, int y) function");
        System.out.println("**** x");
        System.out.println(x);
        f(x, y);
        System.out.println("x.a = " + x.a + " and x.b = " + x.b);
        System.out.println("  y = " + y);
    }//main()
}//Problem5