/**

 */
public class TestIntArraySet
{
    public static void main(String[ ] args)
    {
        IntArraySet set1 = new IntArraySet( );
        IntArraySet set2 = new IntArraySet( );

        set1.add(42);
        if ( !set1.contains(42) )
        {
            System.out.println("1. There is something wrong with add() or contains().");
            System.exit(-1);
        }
        boolean r = set1.remove(42);
        if ( !r || set1.contains(42) )
        {
            System.out.println("2. There is something wrong with remove() or contains().");
            System.exit(-1);
        }
        r = set1.remove(42);
        if ( r )
        {
            System.out.println("3. There is something wrong with remove().");
            System.exit(-1);
        }

        set1.add(-42);
        set1.add(-42);
        r = set1.remove(-42);
        if ( !r || set1.contains(-42) )
        {
            System.out.println("4. There is something wrong with add(), remove(), or contains().");
            System.exit(-1);
        }

        set1.add(15);
        set1.add(16);
        set1.addMany(25, 26, 27);
        if ( 5 != set1.size() )
        {
            System.out.println("5. There is something wrong with size().");
            System.exit(-1);
        }
        if ( !set1.contains(15)
                || !set1.contains(16)
                || !set1.contains(25)
                || !set1.contains(26)
                || !set1.contains(27) )
        {
            System.out.println("6. There is something wrong with addMany().");
            System.exit(-1);
        }

        set1.addAll( set1 );
        if ( 5 != set1.size()
                || !set1.contains(15)
                || !set1.contains(16)
                || !set1.contains(25)
                || !set1.contains(26)
                || !set1.contains(27) )
        {
            System.out.println("7. There is something wrong with addAll().");
            System.exit(-1);
        }

        set1.keepCommonElements( set1 );
        if ( 5 != set1.size()
                || !set1.contains(15)
                || !set1.contains(16)
                || !set1.contains(25)
                || !set1.contains(26)
                || !set1.contains(27) )
        {
            System.out.println("8. There is something wrong with keepCommonElements().");
            System.exit(-1);
        }

        set1.subtractAll( set1 );
        if ( 0 != set1.size() )
        {
            System.out.println("9. There is something wrong with subtractAll().");
            System.exit(-1);
        }


        set1 = new IntArraySet( );
        set1.addMany( 8,  9, 10, 11, 12);
        set2.addMany(10, 11, 12, 13, 14, 15, 16);

        set1.keepCommonElements( set2 );
        if ( 3 != set1.size()
                || !set1.contains(10)
                || !set1.contains(11)
                || !set1.contains(12) )
        {
            System.out.println("10. There is something wrong with keepCommonElements().");
            System.exit(-1);
        }

        set1.addAll( set2 );
        if ( 7 != set1.size()
                || !set1.contains(10)
                || !set1.contains(11)
                || !set1.contains(12)
                || !set1.contains(13)
                || !set1.contains(14)
                || !set1.contains(15)
                || !set1.contains(16) )
        {
            System.out.println("11. There is something wrong with addAll().");
            System.exit(-1);
        }

        set1.subtractAll( set2 );
        if ( 0 != set1.size() )
        {
            System.out.println("12. There is something wrong with subtractAll().");
            System.exit(-1);
        }


        set1 = new IntArraySet(5);
        set2 = new IntArraySet(5);
        set1.addMany(18,  19, 20, 21, 22);
        set2.addMany(20, 21, 22, 23, 24, 25, 26);

        IntArraySet set3 = set1.union( set2 );
        System.out.println( "set1 = " + set1 );
        System.out.println( "set2 = " + set2 );
        System.out.println( "set3 = set1 union with set2 = " + set3 );
        System.out.println();
        if ( 9 != set3.size()
                || !set3.contains(18)
                || !set3.contains(19)
                || !set3.contains(20)
                || !set3.contains(21)
                || !set3.contains(22)
                || !set3.contains(23)
                || !set3.contains(24)
                || !set3.contains(25)
                || !set3.contains(26) )
        {
            System.out.println("13. There is something wrong with union().");
            System.exit(-1);
        }
        if ( 5 != set1.size()
                || !set1.contains(18)
                || !set1.contains(19)
                || !set1.contains(20)
                || !set1.contains(21)
                || !set1.contains(22) )
        {
            System.out.println("14. There is something wrong with union().");
            System.exit(-1);
        }
        if ( 7 != set2.size()
                || !set2.contains(20)
                || !set2.contains(21)
                || !set2.contains(22)
                || !set2.contains(23)
                || !set2.contains(24)
                || !set2.contains(25)
                || !set2.contains(26) )
        {
            System.out.println("15. There is something wrong with union().");
            System.exit(-1);
        }

        set3 = set1.intersection( set2 );
        System.out.println( "set1 = " + set1 );
        System.out.println( "set2 = " + set2 );
        System.out.println( "set3 = set1 intersection with set2 = " + set3 );
        System.out.println();
        if ( 3 != set3.size()
                || !set3.contains(20)
                || !set3.contains(21)
                || !set3.contains(22) )
        {
            System.out.println("16. There is something wrong with intersection().");
            System.exit(-1);
        }
        if ( 5 != set1.size()
                || !set1.contains(18)
                || !set1.contains(19)
                || !set1.contains(20)
                || !set1.contains(21)
                || !set1.contains(22) )
        {
            System.out.println("17. There is something wrong with intersection().");
            System.exit(-1);
        }
        if ( 7 != set2.size()
                || !set2.contains(20)
                || !set2.contains(21)
                || !set2.contains(22)
                || !set2.contains(23)
                || !set2.contains(24)
                || !set2.contains(25)
                || !set2.contains(26) )
        {
            System.out.println("18. There is something wrong with intersection().");
            System.exit(-1);
        }

        set3 = set1.minus( set2 );
        System.out.println( "set1 = " + set1 );
        System.out.println( "set2 = " + set2 );
        System.out.println( "set3 = set1 minus set2 = " + set3 );
        System.out.println();
        if ( 2 != set3.size()
                || !set3.contains(18)
                || !set3.contains(19) )
        {
            System.out.println("19. There is something wrong with minus().");
            System.exit(-1);
        }
        if ( 5 != set1.size()
                || !set1.contains(18)
                || !set1.contains(19)
                || !set1.contains(20)
                || !set1.contains(21)
                || !set1.contains(22) )
        {
            System.out.println("20. There is something wrong with minus().");
            System.exit(-1);
        }
        if ( 7 != set2.size()
                || !set2.contains(20)
                || !set2.contains(21)
                || !set2.contains(22)
                || !set2.contains(23)
                || !set2.contains(24)
                || !set2.contains(25)
                || !set2.contains(26) )
        {
            System.out.println("21. There is something wrong with minus().");
            System.exit(-1);
        }

        System.out.println("Your class IntArraySet passed all the tests.");
    }//main()
}//TestIntArraySet