public class Company extends Organization
{
    Company()
    {
        /* null constructor */
        System.out.println("*** Company() object created.");
        System.out.println(this);
    }

    public void printMe()
    {
        System.out.println("Be productive.");
    }
}