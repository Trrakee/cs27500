/**
 * Course: CS 27500
 * Name: Adam Joseph Cook
 * Email: cook5@purduecal.edu
 * Assignment: 3
 */

import java.lang.System;

/***************************************************************************
* A <CODE>IntLinkedSeq</CODE> is a collection of <CODE>int</CODE> numbers.
* The sequence can have a special "current element," which is specified and
* accessed through four methods (start, getCurrent, advance, and isCurrent).
*
* <dt><b>Limitations:</b>
* <dd> Beyond Int.MAX_VALUE</CODE> elements, the <CODE>size</CODE> method
*      does not work.
***************************************************************************/


public class IntLinkedSeq
{
   private int manyItems;  // how many nodes are in this sequence
   private IntNode head;   // reference to the first node of the sequence
   private IntNode tail;   // reference to the last node of the sequence
   private IntNode cursor; // reference to the "current" node (null
                           // if there isn't one)

   /**
   * Initialize an empty sequence.
   *
   * @param none
   * @postcondition
   *   This sequence is empty. It does not have a current element.
   **/
   public IntLinkedSeq( )
   {
       // Point all parts of the linked list to NULL.
       head = null;
       tail = null;
       cursor = null;
       // No nodes (elements) in the list.
       manyItems = 0;
   }


   /**
   * Copy Constructor
   *
   * @param otherSequence
   *   Sequence to make a deep copy of.
   *
   * @postcondition
   *   This sequence is a DEEP copy of the parameter sequence.
   *   Subsequent changes to the copy will not affect the original, nor vice versa.
   *   The copy should have its cursor set in the appropriate
   *   place within its linked list.
   **/
   public IntLinkedSeq(IntLinkedSeq otherSequence)
   {
       IntNode temp_cursor = otherSequence.head;
       head = new IntNode(temp_cursor);
       IntNode copy_temp_cursor = head;
       while (temp_cursor.getLink() != null) {
           IntNode copy_node = new IntNode(temp_cursor.getLink().getData(), null);
           copy_temp_cursor.setLink(copy_node);
           if (otherSequence.isCurrent() && temp_cursor == otherSequence.cursor) {
               cursor = copy_temp_cursor;
           }
           temp_cursor = temp_cursor.getLink();
           copy_temp_cursor = copy_temp_cursor.getLink();
       }
       tail = copy_temp_cursor;
       manyItems = otherSequence.manyItems;
   }


   /**
   * Add a new element to this sequence, after the current element.
   *
   * @param element
   *   the new element that is being added
   * @postcondition
   *   A new copy of the element has been added to this sequence.
   *   If there was a current element, then the new element is placed
   *   after the current element. If there was no current element,
   *   then the new element is placed at the end of the sequence.
   *   In all cases, the new element becomes the new current element
   *   of this sequence.
   **/
   public void addAfter(int element)
   {
       if (isCurrent()) {
           IntNode temp_cursor = cursor;

           if (temp_cursor.getLink() == null) {
               // The cursor is already at the end of the list so add new node
               // to the end of the list.
               addLast(element);
               cursor = tail;
           } else {
               IntNode new_node = new IntNode(element, null);
               new_node.setLink(temp_cursor.getLink());
               temp_cursor.setLink(new_node);
               cursor = new_node;
               // Increment number of items in the list.
               manyItems++;
           }
       } else {
           // There is no current element so add the start of the list.
           addLast(element);
           cursor = tail;
       }
   }


   /**
   * Add a new element to this sequence, before the current element.
   *
   * @param element
   *   the new element that is being added
   * @postcondition
   *   A new copy of the element has been added to this sequence.
   *   If there was a current element, then the new element is placed
   *   before the current element. If there was no current element,
   *   then the new element is placed at the start of the sequence.
   *   In all cases, the new element becomes the new current element
   *   of this sequence.
   **/
   public void addBefore(int element)
   {
       if (isCurrent()) {
           IntNode temp_cursor = head;

           if (temp_cursor.getLink() == null) {
               // The cursor is already at the start of the list so add new node
               // to the start of the list.
               addFirst(element);
               cursor = head;
           }

           while(temp_cursor.getLink() != null) {
               if(temp_cursor.getLink() == cursor) {
                   IntNode new_node = new IntNode(element, null);
                   new_node.setLink(cursor);
                   temp_cursor.setLink(new_node);
                   cursor = new_node;
                   // Increment number of items in the list.
                   manyItems++;
                   break;
               }
               temp_cursor = temp_cursor.getLink();
           }
       } else {
           // There is no current element so add the start of the list.
           addFirst(element);
           cursor = head;
       }
   }


   /**
   * Place the contents of another sequence at the end of this sequence.
   *
   * @param addend
   *   a sequence whose contents will be placed at the end of this sequence
   * @precondition
   *   The parameter, addend, is not null.
   * @postcondition
   *   The elements from addend have been placed at the end of
   *   this sequence. The current element of this sequence remains where it
   *   was, and the addend is also unchanged.
   **/
   public void addAll(IntLinkedSeq addend)
   {
       IntNode addend_cursor = addend.head;
       while(addend_cursor != null) {
           IntNode copy_node = new IntNode(addend_cursor);
           tail.setLink(copy_node);
           tail = tail.getLink();
           addend_cursor = addend_cursor.getLink();
           manyItems++;
       }
   }


   /**
   * Add a new element to the beginning of this sequence.
   *
   * @param element
   *   the new element that is being added
   * @postcondition
   *   A new copy of the element has been added to the beginning
   *   of this sequence. The current element is unchanged.
   **/
   public void addFirst(int element)
   {
       // Check if the list is empty, if not add the provided element to the
       // beginning of the list.
       if (manyItems > 0) {
           IntNode new_node = new IntNode(element, null);
           new_node.setLink(head);
           head = new_node;
       } else {
           // There are no items currently in the list.
           // Add a new node (the first node) and set the cursor to this node.
           IntNode new_node = new IntNode(element, null);
           head = new_node; // Head and first nodes are the same.
           tail = new_node; // Tail and first nodes are the same.
       }
       // Increment number of items in the list.
       manyItems++;
   }


   /**
   * Add a new element to the end of this sequence.
   *
   * @param element
   *   the new element that is being added
   * @postcondition
   *   A new copy of the element has been added to the end
   *   of this sequence. The current element is unchanged.
   **/
   public void addLast(int element)
   {
       int index;
       if (manyItems > 0) {
           IntNode new_node = new IntNode(element, null);

           // Set the a temporary cursor to the head of the list.
           // A temporary cursor is needed because the current cursor location
           // must remain unchanged.
           IntNode temp_cursor = head;
           for (index = 0; (index < manyItems-1); index++) {
               temp_cursor = temp_cursor.getLink();
           }
           temp_cursor.setLink(new_node);
           tail = new_node;
       } else {
           // There are no items currently in the list.
           // Add a new node (the first node) and set the cursor to this node.
           IntNode new_node = new IntNode(element, null);
           head = new_node; // Head and last nodes are the same.
           tail = new_node; // Tail and last nodes are the same.
       }
       manyItems++; // Add one node from the count.
   }


   /**
   * Set the current element at the front of this sequence.
   *
   * @param none
   * @postcondition
   *   The front element of this sequence is now the current element
   *  (but if this sequence has no elements at all, then there is
   *  no current element).
   **/
   public void start( )
   {
       if (manyItems > 0) {
           cursor = head;
       }
   }


   /**
   * Accessor method to determine whether this sequence has a specified
   * current element that can be retrieved with the getCurrent() method.
   *
   * @param none
   * @return
   *   true (there is a current element) or
   *   false (there is no current element at the moment)
   **/
   public boolean isCurrent( )
   {
       if(cursor == null) {
           return false;
       } else {
           return true;
       }
   }


   /**
   * Accessor method to get the value in the current element of this sequence.
   *
   * @param none
   * @precondition
   *   isCurrent() returns true.
   * @return
   *   the value in the current element of this sequence
   * @exception IllegalStateException
   *   Indicates that there is no current element,
   *   so getCurrentValue() may not be called.
   **/
   public int getCurrentValue( )
   {
       if (isCurrent()) {
           return cursor.getData();
       } else {
           // There is no current element.
           throw new IllegalStateException("Indicates that there is no current element, so getCurrentValue() may not be called.");
       }
   }


   /**
   * Mutator method to set the value in the current element of this sequence.
   *
   * @param element
   *   the new value that is to be placed in the current element
   * @precondition
   *   isCurrent() returns true.
   * @exception IllegalStateException
   *   Indicates that there is no current element,
   *   so setCurrentValue() may not be called.
   **/
   public void setCurrentValue(int element)
   {
       if (isCurrent()) {
           cursor.setData(element);
       } else {
           // There is no current element.
           throw new IllegalStateException("Indicates that there is no current element, so setCurrentValue() may not be called.");
       }
   }


   /**
   * Remove the current element from this sequence.
   *
   * @param none
   * @precondition
   *   isCurrent() returns true.
   * @postcondition
   *   The current element has been removed from this sequence, and the
   *   following element (if there is one) is now the new current element.
   *   If there was no following element, then there is now no current
   *   element.
   * @exception IllegalStateException
   *   Indicates that there is no current element,
   *   so removeCurrent() may not be called.
   **/
   public void removeCurrent( )
   {
       if (isCurrent()) {
           IntNode next_node = cursor.getLink();
           IntNode temp_cursor = head;
           while(temp_cursor.getLink() != null) {
               if(temp_cursor.getLink() == cursor) {
                   temp_cursor.setLink(next_node);
                   cursor = next_node;
                   manyItems--; // Remove one node from the count.
                   break;
               }
               temp_cursor = temp_cursor.getLink();
           }
       } else {
           // There is no current element.
           throw new IllegalStateException("Indicates that there is no current element, so removeCurrent() may not be called.");
       }

   }


   /**
   * Remove the element at the beginning of this sequence.
   *
   * @param none
   * @precondition
   *   The sequence is not empty.
   * @postcondition
   *   The first element of the sequence is deleted from the sequence.
   *   If this was the current element, then the current element status
   *   is invalidated.
   * @exception IllegalStateException
   *   Indicates that the sequence is empty,
   *   so removeFirst() may not be called.
   **/
   public void removeFirst( )
   {
       // Check if the sequence is empty.
       if (manyItems == 0) {
           throw new IllegalStateException("Indicates that the sequence is empty, so removeFirst() may not be called.");
       }

       // Check if target node (head) is equal to the cursor so it can be
       // invalidated.
       if (head == cursor) {
           cursor = null;
       }

       head = head.getLink();
       manyItems--; // Remove one node from the count
   }


   /**
   * Remove the element at the end of this sequence.
   *
   * @param none
   * @precondition
   *   The sequence is not empty.
   * @postcondition
   *   The last element of the sequence is deleted from the sequence.
   *   If this was the current element, then the current element status
   *   is invalidated.
   * @exception IllegalStateException
   *   Indicates that the sequence is empty,
   *   so removeLast() may not be called.
   **/
   public void removeLast( )
   {
       // Check if the sequence is empty.
       if (manyItems == 0) {
           throw new IllegalStateException("Indicates that the sequence is empty, so removeLast() may not be called.");
       }

       // One node in the list.
       if (head == tail) {
           head = null;
       } else {
           // Two nodes in the list.
           IntNode temp_cursor = head;
           int index;
           for (index = 0; (index < (manyItems-2)); index++) {
               temp_cursor = temp_cursor.getLink();
           }
           temp_cursor.setLink(null);
           tail = temp_cursor;
       }
       manyItems--; // Remove one node from the count.
   }


   /**
   * Move forward, so that the current element is now the next element
   * in this sequence.
   *
   * @param none
   * @precondition
   *   isCurrent() returns true.
   * @postcondition
   *   If the current element was already the end element of this
   *   sequence (with nothing after it), then there is no longer
   *   any current element. Otherwise, the new element is the
   *   element immediately after the  original current element.
   * @exception IllegalStateException
   *   Indicates that there is no current element,
   *   so advance() may not be called.
   **/
   public void advance( )
   {
       if (isCurrent()) {
           // There is a current element that the cursor references.
           cursor = cursor.getLink();
       } else {
           // There is no current element.
           throw new IllegalStateException("Indicates that there is no current element, so advance() may not be called.");
       }
   }


   /**
   * Set the current element to be the i'th element of this sequence
   * (starting with the 0'th element at the head).
   *
   * @param i
   *   the index of the element to make the current element
   * @precondition
   *   The parameter i is greater than or equal to 0
   *   and i is less than size (i >= 0 && i < size).
   * @postcondition
   *   The current element is the i'th element of the sequence
   *   (where the head element is the 0'th element)
   * @exception IndexOutOfBoundsException
   *   Indicates that i is less than 0 or greater than
   *   size-1 (i < 0 || i >= size).
   **/
   public void setCurrent(int i)
   {
       if (i >= 0 && i < manyItems) {
           // Set a temporary cursor to the head of the list.
           IntNode temp_cursor = head;
           int index;
           for (index = 0; (index < i); index++) {
               temp_cursor = temp_cursor.getLink();
           }
           cursor = temp_cursor;
       } else {
           throw new IndexOutOfBoundsException("Indicates that i is less than 0 or greater than size-1 (i < 0 || i >= size).");
       }
   }


   /**
   * Set the state of this sequence so that it does not have a current element.
   *
   * @param none
   * @postcondition
   *   After calling this method, calling isCurrent() returns false.
   **/
   public void invalidateCurrent( )
   {
       cursor = null;
   }


   /**
   * Method to determine if a particular element
   * is in this sequence.
   *
   * @param target
   *   the element that needs to be found in this sequence
   * @return
   *   true if the target element is in this sequence, false otherwise
   **/
   public boolean contains(int target)
   {
       int index;
       // Set a temporary cursor to the head of the list (so that the current
       // cursor location is left unchanged).
       IntNode temp_cursor = head;
       // Loop through all of the list nodes in search of the data target.
       for (index = 0; (index < manyItems); index++) {
           if (temp_cursor.getData() == target) {
               return true;
           } else {
               // The data target is not where the temporary cursor currently is,
               // change to the next node in the list.
               temp_cursor = temp_cursor.getLink();
               continue;
           }
       }
       return false; // The data target was not found in the entire list.
   }


   /**
   * Returns the index of the first occurrence of the specified element in
   * this sequence, or -1 if this sequence does not contain the element.
   *
   * @param target
   *   the element that needs to be found in this sequence
   * @return
   *   the index of the first occurrence of target in this sequence, or -1
   *   if this sequence does not contain target
   **/
   public int indexOf(int target)
   {
       int index;
       // Set a temporary cursor to the head of the list (so that the current
       // cursor location is left unchanged).
       IntNode temp_cursor = head;
       // Loop through all of the list nodes in search of the data target.
       for (index = 0; (index < manyItems); index++) {
           if (temp_cursor.getData() == target) {
               return index;
           } else {
               // The data target is not where the temporary cursor currently is,
               // change to the next node in the list.
               temp_cursor = temp_cursor.getLink();
               continue;
           }
       }
       return -1;
   }


   /**
   * Determine the number of elements in this sequence.
   *
   * @param none
   * @return
   *   the number of elements in this sequence
   **/
   public int size( )
   {
       return manyItems;
   }



   /**
   * Create a new sequence that contains all the elements from
   * this sequence followed by another sequence. The returned
   * sequence should not be backed by this sequence or the other
   * sequence (so changes to the returned sequence are not reflected
   * in this sequence or the other sequence).
   *
   * @param s2
   *   the second sequence
   * @precondition
   *   s2 is not null.
   * @return
   *   a new sequence that has the elements of this followed by the
   *   elements of s2 (with no current element)
   **/
   public IntLinkedSeq catenation(IntLinkedSeq s2)
   {
       IntLinkedSeq full_list = new IntLinkedSeq(this);
       IntNode addend_cursor = s2.head;
       while(addend_cursor != null) {
           IntNode copy_node = new IntNode(addend_cursor);
           full_list.tail.setLink(copy_node);
           full_list.tail = full_list.tail.getLink();
           addend_cursor = addend_cursor.getLink();
           full_list.manyItems++;
       }

      return full_list;
   }


   /**
   * Create a new sequence that contains all the elements from
   * this sequence that are between the indices fromIndex, inclusive,
   * and toIndex, exclusive. (If fromIndex and toIndex are equal,
   * the returned sequence is empty.) The returned sequence should not
   * be backed by this sequence (so changes to the returned sequence
   * are not reflected in this sequence).
   * The new sequence should not have a current element.
   *
   * @param fromIndex
   *    low endpoint (inclusive) of the sub sequence
   * @param toIndex
   *   high endpoint (exclusive) of the sub sequence
   * @precondition
   *   fromIndex is less than or equal to toIndex (fromIndex <= toIndex),
   *   fromIndex is greater than or equal to zero (fromIndex >= 0),
   *   toIndex is less than or equal to size (toIndex <= size)
   * @return
   *   a new sequence that contains all the elements from this
   *   sequence that are between the indices fromIndex, inclusive,
   *   and toIndex, exclusive.
   * @exception IllegalArgumentException
   *   if the endpoint indices are out of order (fromIndex > toIndex)
   * @exception IndexOutOfBoundsException
   *   endpoint index value out of range (fromIndex < 0 || toIndex > size)
   **/
   public IntLinkedSeq subSeq(int fromIndex, int toIndex)
   {
       if (fromIndex > toIndex) {
           throw new IllegalArgumentException("The endpoint indices are out of order.");
       }

       if (fromIndex < 0 || toIndex > manyItems) {
           throw new IndexOutOfBoundsException("Endpoint index value out of range.");
       }

       IntLinkedSeq sub_list = new IntLinkedSeq();
       IntNode temp_cursor = head;
       int index;
       for (index = 0; (index < manyItems); index++) {
           if (index >= fromIndex && index < toIndex) {
               sub_list.addAfter(temp_cursor.getData());
           }
           temp_cursor = temp_cursor.getLink();
       }
       sub_list.cursor = null;

       return sub_list;
   }


   /**
   * Create a new sequence that contains all the elements from
   * this sequence in the reverse order. The returned sequence
   * should not be backed by this sequence (so changes to the
   * returned sequence are not reflected in this sequence).
   * The new sequence should not have a current element.
   *
   * @param none
   * @return
   *   a new sequence that has the elements of this
   *   in their reverse order (with no current element)
   **/
   public IntLinkedSeq reverse( )
   {
       IntLinkedSeq reverse_list = new IntLinkedSeq();
       IntNode temp_cursor = head;
       while (temp_cursor.getLink() != null) {
           reverse_list.addFirst(temp_cursor.getData());
           temp_cursor = temp_cursor.getLink();
       }
       reverse_list.addFirst(temp_cursor.getData());
       reverse_list.manyItems = manyItems;

       return reverse_list;
   }


   /**
   * Returns an array containing all of the elements in this sequence.
   *
   * @param none
   * @return
   *   an array containing all the elements in this sequence
   **/
   public int[] toArray( )
   {
       IntNode temp_cursor = head;
       int[] data = new int[manyItems];
       int index;
       // Loop through all of the list nodes in search of the data target.
       for (index = 0; (index < manyItems); index++) {
           data[index] = temp_cursor.getData();
           temp_cursor = temp_cursor.getLink();
       }
       return data;
   }



   /**
   * Returns a String containing a representation of all the elements
   * in this sequence. Notice that a special symbol is used to denote
   * the current element.
   *
   * @param none
   * @return
   *   a String containing all the elements in this sequence
   **/
   public String toString( )
   {
      String result = "[";
      IntNode ptr = head;
      while (ptr != null)
      {
         result += ptr.getData();
         if (ptr == cursor)
         {
            result += "*"; // use a special symbol at the cursor
         }
         ptr = ptr.getLink();
         if (ptr != null)
         {
            result += ", ";
         }
      }
      result += "]";
      return result;
   }

}//IntLinkedSeq