/*
   A simple example of creating a list of nodes
   using the author's IntNode class.

   Run this program using jGrasp in order to see a
   visualization of a list data structure in the
   memory of a running Java program.
*/

public class LinkedListExample
{
   public static void main(String[ ] args)
   {
      IntNode head = new IntNode( 12,
                                  new IntNode( 7,
                                               new IntNode( -5,
                                                            new IntNode(100, null))));

      IntNode ptr = head.getLink().getLink(); // you can set a breakpoint on this line

      System.out.println( "IntNode.listLength(head)" );
      System.out.println( IntNode.listLength(head) );
      System.out.println( "IntNode.listLength(ptr)" );
      System.out.println( IntNode.listLength(ptr) );

      ptr.removeNodeAfter();

      head.getLink().removeNodeAfter();

      // Add a new node at the beginning of the list.
      // Make sure you understand this line completely!
      head = new IntNode( 123, head );

      // Add another new node at the beginning of the list.
      head = new IntNode( 321, head );

      // Create a new linked list.
      IntNode head2 = null;            // Start with an empty list.
      head2 = new IntNode( 0, head2 ); // Add nodes to the list.
      head2 = new IntNode( 1, head2 );
      head2 = new IntNode( 2, head2 );
      head2 = new IntNode( 3, head2 );
      head2 = new IntNode( 4, head2 );

      // Now delete the first few nodes from the list.
      head2 = head2.getLink();
      head2 = head2.getLink();
      head2.removeNodeAfter();

      // Traverse (i.e., walk) the length of the list.
      for ( IntNode cursor = head; cursor != null; cursor = cursor.getLink() )
      {
         System.out.println( cursor.getData() );
      }

      // Another way to write the above loop.
      IntNode cursor2 = head;
      while ( cursor2 != null )
      {
         System.out.println( cursor2.getData() );
         cursor2 = cursor2.getLink();
      }


      // The two lists we built above were build from the tail towards the head.
      // Here is an example of building a list from the head towards the tail.
      // Notice that we need two node references this time, one for the head,
      // and one for the tail.
      IntNode head3 = new IntNode( 200, null ); // Start with a one item list.
      IntNode  tail = head3;
      tail.setLink( new IntNode( 201, null ) ); // Add nodes to the list.
      tail = tail.getLink();
      tail.setLink( new IntNode( 202, null ) );
      tail = tail.getLink();
      tail.setLink( new IntNode( 203, null ) );
      tail = tail.getLink();
      tail.setLink( new IntNode( 204, null ) );



      IntNode[] ptrs = IntNode.listCopyWithTail( head );
   }
}