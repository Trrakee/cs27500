class Circle
{
    private Point c; // center
    private double r; // radius

    public Circle(Point c, double r)
    {
        this.r = r;
        this.c = new Point(c.getX(), c.getY());
        System.out.println("this.c");
        System.out.println(this.c);
    }
}