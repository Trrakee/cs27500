/*
   This file tests mostly addFirst(), addLast(), removeFirst(), removeLast(),
                          addBefore(), addAfter(), and removeCurrent().
*/
public class OtherTestSeq
{
    public static void main(String[ ] args)
    {
        IntLinkedSeq seq1 = new IntLinkedSeq( );
        seq1.addFirst(42);
        seq1.addFirst(43);
        seq1.addFirst(44);
        System.out.println(seq1);
        seq1.advance();
        System.out.println(seq1);

        System.out.println("");

        IntLinkedSeq seq2 = new IntLinkedSeq();
        seq2.addLast(42);
        seq2.addLast(43);
        seq2.addLast(44);
        System.out.println(seq2);
        seq2.advance();
        System.out.println(seq2);

        System.out.println("");

        IntLinkedSeq seq3 = new IntLinkedSeq( );
        seq3.addLast(42);
        seq3.addLast(43);
        seq3.addLast(44);
        System.out.println(seq3);
        seq3.removeFirst();
        System.out.println(seq3);
        seq3.removeFirst();
        System.out.println(seq3);
        seq3.removeFirst();
        System.out.println(seq3);

        System.out.println("");

        IntLinkedSeq seq4 = new IntLinkedSeq( );
        seq4.addFirst(42);
        seq4.addFirst(43);
        seq4.addFirst(44);
        System.out.println(seq4);
        seq4.removeLast();
        System.out.println(seq4);
        seq4.removeLast();
        System.out.println(seq4);
        seq4.removeLast();
        System.out.println(seq4);

        System.out.println("");

        IntLinkedSeq seq5 = new IntLinkedSeq( );
        seq5.addFirst(42);
        seq5.addFirst(43);
        seq5.addFirst(44);
        System.out.println(seq5);
        seq5.setCurrent(1);
        System.out.println(seq5);
        seq5.setCurrent(0);
        System.out.println(seq5);
        seq5.setCurrent(2);
        System.out.println(seq5);

        System.out.println("");

        IntLinkedSeq seq6 = new IntLinkedSeq( );
        seq6.addBefore(242);
        seq6.addBefore(142);
        seq6.advance();
        seq6.addAfter(342);
        System.out.println(seq6);
        System.out.println(seq6.size());

        System.out.println("");

        IntLinkedSeq seq7 = new IntLinkedSeq( );
        seq7.addAfter(342);
        seq7.addBefore(142);
        seq7.addAfter(242);
        seq7.advance();
        seq7.addAfter(442);
        System.out.println(seq7);
        System.out.println(seq7.size());

        System.out.println("");
    }//main()
}//OtherTestSeq