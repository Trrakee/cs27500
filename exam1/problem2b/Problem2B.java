public class Problem2B
{
    public static void main(String[ ] args)
    {
        Point p = new Point(1,2);
        System.out.println("p");
        System.out.println(p);
        Circle c = new Circle(p, 10);
        System.out.println("c");
        System.out.println(c);
        p.setX(100);
    }//main()
}//Problem2B