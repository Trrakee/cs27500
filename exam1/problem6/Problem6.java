public class Problem6
{
    public static void main(String[ ] args)
    {
        A a1 = new A();
        A a2 = new C();
        D d1 = new D();

        E e1 = new E();

        System.out.println("====== OUTPUT ======");
        System.out.println("A a3 = new B();");
        A a3 = new B();
        System.out.println("");
        System.out.println("B b1 = new A();");
        System.out.println("COMPILE TIME ERROR!");
//        B b1 = new A(); // compile time error - incompatible types: A cannot be converted to B
        System.out.println("");
        System.out.println("B b2 = (B) a1;");
        System.out.println("RUNTIME ERROR!");
//        B b2 = (B) a1; // runtime error - java.lang.ClassCastException: A cannot be cast to B
        System.out.println("");
        System.out.println("B b6 = (E) e1;");
        B b6 = (E) e1;
        System.out.println("");
        System.out.println("B b3 = (B) a2;");
        B b3 = (B) a2;
        System.out.println("");
        System.out.println("B b4 = (B) d1;");
        System.out.println("COMPILE TIME ERROR!");
//        B b4 = (B) d1; // compile time error - incompatible types: D cannot be converted to B
        System.out.println("");
        System.out.println("B b5 = (C)(A)new D();");
        System.out.println("RUNTIME ERROR!");
//        B b5 = (C)(A)new D(); // runtime error - java.lang.ClassCastException: D cannot be cast to C
        System.out.println("");
        System.out.println("A a4 = (A)new D();");
        A a4 = (A)new D();
    }//main()
}//Problem6