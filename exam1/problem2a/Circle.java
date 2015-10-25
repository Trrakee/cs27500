/*
 * NOTE: This 'Circle' class has an unfixed privacy leak!
 */
class Circle
{
    private Point c; // center
    private double r; // radius

    public Circle(Point c, double r)
    {
        this.r = r;
        this.c = c;
        System.out.println("this.c");
        System.out.println(this.c);
    }
}