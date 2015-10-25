
/*
   WideOrNarrow.java
   Burton Rosenberg
   March 18, 1998

*/

class A
        extends Object {
    void f() { ; }   // {} works too. I meant it to be empty!
}

public class WideOrNarrow
        extends Object {

    public static void main(String [] argv)
    {
        Object o ;
        A a;

        a = new A() ;
        a.f() ;
        o = a ; // OK, widen A to an Object
//      o.f() ;   // Compiler error, not all Objects have f()

/*
appomattox> javac WideOrNarrow.java
WideOrNarrow.java:24: Method f() not found in class java.lang.Object.
      o.f() ;   // Compiler error, not all Objects have f()
         ^
1 error
appomattox>
*/

        a = (A) o ;  // narrow o to an A. Run time will check.
        a.f() ;   // Now it's OK, compiler knows that a has an f().

        o = new Object() ;
        a = (A) o ;  // now try to narrow o to an A ... but o is not an A.
        // compiles .. but will it run?

/*
appomattox> javac WideOrNarrow.java
appomattox> java WideOrNarrow
java.lang.ClassCastException: java.lang.Object
        at WideOrNarrow.main(WideOrNarrow.java:40)
appomattox>
*/

    }
}