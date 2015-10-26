public class Problem8
{
    public static void main(String[ ] args)
    {
        IntArrayBag bag1 = new IntArrayBag();
        IntArrayBag bag2 = new IntArrayBag();

        bag1.add(1);
        System.out.println("** 1 **");
        System.out.println(bag1.dataToString());
        System.out.println(bag1.dataCountsToString());
        System.out.println(bag1.getManyDataItems());
        System.out.println(bag1.getManyItems());
        if ( !(bag1.getManyDataItems() == 1) || !(bag1.getManyItems() == 1) || !(bag1.getDataArraySize() == 10) || !(bag1.getDataCountsArraySize() == 10) )
        {
            System.out.println("1. There is something wrong with add().");
            System.exit(-1);
        }

        System.out.println("");

        bag1.add(2);
        System.out.println("** 2 **");
        System.out.println(bag1.dataToString());
        System.out.println(bag1.dataCountsToString());
        System.out.println(bag1.getManyDataItems());
        System.out.println(bag1.getManyItems());
        if ( !(bag1.getManyDataItems() == 2) || !(bag1.getManyItems() == 2) || !(bag1.getDataArraySize() == 10) || !(bag1.getDataCountsArraySize() == 10) )
        {
            System.out.println("2. There is something wrong with add().");
            System.exit(-1);
        }

        System.out.println("");

        bag1.add(1);
        System.out.println("** 3 **");
        System.out.println(bag1.dataToString());
        System.out.println(bag1.dataCountsToString());
        System.out.println(bag1.getManyDataItems());
        System.out.println(bag1.getManyItems());
        if ( !(bag1.getManyDataItems() == 2) || !(bag1.getManyItems() == 3) || !(bag1.getDataArraySize() == 10) || !(bag1.getDataCountsArraySize() == 10) )
        {
            System.out.println("3. There is something wrong with add().");
            System.exit(-1);
        }

        System.out.println("");

        bag1.add(1);
        System.out.println("** 4 **");
        System.out.println(bag1.dataToString());
        System.out.println(bag1.dataCountsToString());
        System.out.println(bag1.getManyDataItems());
        System.out.println(bag1.getManyItems());
        if ( !(bag1.getManyDataItems() == 2) || !(bag1.getManyItems() == 4) || !(bag1.getDataArraySize() == 10) || !(bag1.getDataCountsArraySize() == 10) )
        {
            System.out.println("4. There is something wrong with add().");
            System.exit(-1);
        }

        System.out.println("");

        bag1.add(3);
        bag1.add(4);
        bag1.add(5);
        bag1.add(6);
        bag1.add(7);
        bag1.add(8);
        bag1.add(9);
        bag1.add(10);
        bag1.add(11);
        bag1.add(11);
        bag1.add(12);
        bag1.add(13);
        System.out.println("** 5 **");
        System.out.println(bag1.dataToString());
        System.out.println(bag1.dataCountsToString());
        System.out.println(bag1.getManyDataItems());
        System.out.println(bag1.getManyItems());
        if ( !(bag1.getManyDataItems() == 13) || !(bag1.getManyItems() == 16) || !(bag1.getDataArraySize() == 20) || !(bag1.getDataCountsArraySize() == 20) )
        {
            System.out.println("5. There is something wrong with add().");
            System.exit(-1);
        }

        System.out.println("");

        bag1.add(6);
        bag1.remove(5);
        bag1.remove(0);
        System.out.println("** 6 **");
        System.out.println(bag1.dataToString());
        System.out.println(bag1.dataCountsToString());
        System.out.println(bag1.getManyDataItems());
        System.out.println(bag1.getManyItems());
        if ( !(bag1.getManyDataItems() == 12) || !(bag1.getManyItems() == 16) || !(bag1.getDataArraySize() == 20) || !(bag1.getDataCountsArraySize() == 20) ) {
            System.out.println("6. There is something wrong with add() or remove().");
            System.exit(-1);
        }

        System.out.println("");

        bag1.remove(1);
        bag1.remove(1);
        bag1.remove(1);
        bag1.remove(1);
        System.out.println("** 7 **");
        System.out.println(bag1.dataToString());
        System.out.println(bag1.dataCountsToString());
        System.out.println(bag1.getManyDataItems());
        System.out.println(bag1.getManyItems());
        if ( !(bag1.getManyDataItems() == 11) || !(bag1.getManyItems() == 13) || !(bag1.getDataArraySize() == 20) || !(bag1.getDataCountsArraySize() == 20) ) {
            System.out.println("7. There is something wrong with add() or remove().");
            System.exit(-1);
        }

        System.out.println("");

        System.out.println("The IntArrayBag class passed all the tests.");
    }//main()
}//Problem8