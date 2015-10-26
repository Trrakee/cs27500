class Problem13B
{
    public static void main(String[] args)
    {
        // THIS PROGRAM DEMONSTRATES A "WIDENING" ASSIGNMENT FOR REFERENCE
        // VARIABLES!

        A x;
        B y = new B();

        // Widen B to an A because B is an A.
        x = y;

        System.out.println("** x");
        // The statement below will output 'B doStuff() called.'.
        System.out.println("**** x.doStuff();");
        x.doStuff();
        System.out.println("**** x.doOtherStuff();");
        x.doOtherStuff();
        System.out.println("**** x.doMoreStuff() will result in a compiler error as this is defined in class B only.");
        // A compiler error will occur on the statement below since x is now a
        // reference variable to a B object with type A (so the methods on B
        // which override methods on A are available).
//        x.doMoreStuff();
        System.out.println("");
        System.out.println("** y");
        System.out.println("**** y.doStuff();");
        y.doStuff();
        System.out.println("**** y.doMoreStuff();");
        y.doMoreStuff();

        System.out.println("");
    }//main
}//Problem13B