public class InternetCo extends MidCap
{
    InternetCo()
    {
        /* null constructor */
        System.out.println("*** InternetCo() object created.");
        System.out.println(this);
    }

    public void printMe()
    {
        System.out.println("Be cool.");
    }

    public static void main(String[] args)
    {
        System.out.println("1");
        Company mid = new MidCap();
        System.out.println("1");
        System.out.println("2");
        MidCap netscape = new InternetCo();
        System.out.println("2");
        System.out.println("3");
        Object obj = new Organization();
        System.out.println("3");
        System.out.println("4");
        Organization startup = new Company();
        System.out.println("4");
        System.out.println("5");
        mid.printMe();
        System.out.println("5");
        System.out.println("6");
        netscape.printMe();
        System.out.println("6");
        System.out.println("7");
        ((Organization) obj).printMe();
        System.out.println("7");
        obj = netscape;
        ((MidCap) obj).printMe();
        obj = startup;
        System.out.println("11");
        ((Organization) obj).printMe();
        System.out.println("11");
    }
}