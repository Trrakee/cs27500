/**
 * Course: CS 27500
 * Name: Adam Joseph Cook
 * Email: cook5@purduecal.edu
 * Assignment: 2
 */
import java.lang.Integer;
import java.lang.System;

/******************************************************************************
 * An IntArraySet is a collection of int numbers.
 * A number may appear only one time in a set.
 *
 * @note (1) The capacity of one of these sets can change after it's created, but
 * the maximum capacity is limited by the amount of free memory on the
 * machine. The constructor, addItem, clone,
 * and union will result in an OutOfMemoryError
 * when free memory is exhausted.
 * <p></p>
 * (2) A set's capacity cannot exceed the maximum integer 2,147,483,647
 * (Integer.MAX_VALUE). Any attempt to create a larger capacity
 * results in a failure due to an arithmetic overflow.
 * <p></p>
 * (3) Because of the slow linear algorithms of this
 * class, large sets will have poor performance.
 *
 * @author Adam Joseph Cook
 *  <A HREF="mailto:cook5@purduecal.edu"> (cook5@purduecal.edu) </A>
 ******************************************************************************/
public class IntArraySet implements Cloneable {
    // Invariant of the IntArraySet class:
    //   1. The number of elements in the set is in the instance variable
    //      manyItems, which is no more than data.length.
    //   2. For an empty set, we do not care what is stored in any of data;
    //      for a non-empty set, the elements in the set are stored in data[0]
    //      through data[manyItems-1], and we don't care what's in the
    //      rest of data.
    private int[] data;   // Storage array for data which may exceed the number
    // of elements in the set.
    private int manyItems; // Keeps track of the number of items in the set.

    /**
     * Initialize an empty set with an initial capacity of 10.  Note that the
     * addItem method works efficiently (without needing more
     * memory) until this capacity is reached.
     *
     * @throws OutOfMemoryError
     *  Indicates insufficient memory for: new int[10].
     * @postcondition This set is empty and has an initial capacity of 10.
     **/
    public IntArraySet() {
        final int INITIAL_CAPACITY = 10;
        manyItems = 0; // No items currently stored in the set.
        data = new int[INITIAL_CAPACITY];
    }


    /**
     * Initialize an empty set with a specified initial capacity. Note that the
     * addItem method works efficiently (without needing more
     * memory) until this capacity is reached.
     *
     * @param initialCapacity the initial capacity of this set
     * @throws IllegalArgumentException
     *  Indicates that initialCapacity is negative.
     * @throws OutOfMemoryError
     *  Indicates insufficient memory for: new int[initialCapacity].
     * @precondition initialCapacity is non-negative.
     * @postcondition This set is empty and has the given initial capacity.
     **/
    public IntArraySet(int initialCapacity) {
        if (initialCapacity < 0)
            throw new IllegalArgumentException
                    ("The initialCapacity is negative: " + initialCapacity);
        data = new int[initialCapacity];
        manyItems = 0; // No items currently stored in the set.
    }


    /**
     * Add a new element to this set. If the given element is already
     * in the set, do nothing. If the new element would take this
     * set beyond its current capacity, then the capacity is increased
     * before adding the new element.
     *
     * @param element the new element that is being inserted
     * @throws OutOfMemoryError
     *  Indicates insufficient memory for increasing the set's capacity.
     * @postcondition A copy of the element has been added to this set, if it is not already in the set.
     * @note An attempt to increase the capacity beyond
     * Integer.MAX_VALUE will cause the set to fail with an
     * arithmetic overflow.
     **/
    public void add(int element) {
        // Verify that the element does not already exist in the set. If it does,
        // then do nothing transparently.
        if (!contains(element)) {
            // Increase the capacity of the data structure.
            if (manyItems == data.length) {
                // Ensure twice as much space as we need.
                ensureCapacity((manyItems + 1) * 2);
            }

            data[manyItems] = element;
            manyItems++;
        }
    }


    /**
     * Add new elements to this set. If any of the given elements is already
     * in the set, that element is ignored. If the new elements would take this
     * set beyond its current capacity, then the capacity is increased
     * in order to add the new elements.
     *
     * @param elements (a variable-arity argument)
     *                 one or more new elements that are being inserted
     * @throws OutOfMemoryError
     *  Indicates insufficient memory for increasing the set's capacity.
     * @postcondition A copy of each new element has been added to this set.
     * @note An attempt to increase the capacity beyond
     * Integer.MAX_VALUE will cause the set to fail with an
     * arithmetic overflow.
     **/
    public void addMany(int... elements) {
        for(int element : elements) {
            // Verify that the element does not already exist in the set.
            // If it does, then do nothing transparently.
            if (!contains(element)) {
                // Increase the capacity of the data structure.
                if (manyItems == data.length) {
                    // Ensure twice as much space as we need.
                    ensureCapacity((manyItems + 1) * 2);
                }

                data[manyItems] = element;
                manyItems++;
            }
        }
    }


    /**
     * Add to this set any element of another set that is not already in this set.
     * The result is this set unioned with the other set.
     *
     * @param set2 a set whose elements will be unioned with this set
     * @throws NullPointerException
     *  Indicates that set2 is null.
     * @throws OutOfMemoryError
     *  Indicates insufficient memory to increase the size of this set.
     * @precondition The parameter, set2, is not null.
     * @postcondition The elements from set2 have been unioned with this set.
     * @note An attempt to increase the capacity beyond
     * Integer.MAX_VALUE will cause an arithmetic overflow
     * that will cause the set to fail. Such large collections should use
     * a different set implementation.
     **/
    public void addAll(IntArraySet set2) {
        int index;
        // Loop through the provided IntArraySet (set2) and attempt to add
        // elements to the data structure.
        int set2OriginalSize = set2.manyItems;
        for (index = 0; (index < set2OriginalSize); index++) {
            add(set2.data[index]);
        }
    }


    /**
     * Remove from this set any element of another set that is in this set.
     * The result is the other set's elements subtracted from this set.
     *
     * @param set2 a set whose elements will be subtracted from this set
     * @throws NullPointerException
     *  Indicates that set2 is null.
     * @precondition The parameter, set2, is not null.
     * @postcondition The elements from set2 have been subtracted with this set.
     **/
    public void subtractAll(IntArraySet set2) {
        int index;
        // Loop through the provided IntArraySet (set2) and remove an element
        // from the data structure if found.
        int set2OriginalSize = set2.manyItems;
        for (index = 0; (index < set2OriginalSize); index++) {
            remove(set2.data[index]);
        }
    }


    /**
     * Remove from this set any of its elements that are not contained in another set.
     * The result is this set intersected with the other set
     *
     * @param set2 a set whose elements will be intersected with this set
     * @throws NullPointerException
     *  Indicates that set2 is null.
     * @precondition The parameter, set2, is not null.
     * @postcondition This set contains the intersection of itself with set2.
     **/
    public void keepCommonElements(IntArraySet set2) {
        int index;
        // Loop through the data structure and remove any elements that are not
        // found in the provided IntArraySet (set2).
        int thisSetOriginalSize = manyItems;
        for (index = 0; (index < thisSetOriginalSize); index++) {
            if (!set2.contains(data[index])) {
                remove(data[index]);
            }
        }
    }


    /**
     * Generate a copy of this set.
     *
     * @return The return value is a copy of this set. Subsequent changes to the
     * copy will not affect the original, nor vice versa.
     * @throws OutOfMemoryError
     *  Indicates insufficient memory for creating the clone.
     **/
    public IntArraySet clone() {
        // Clone an IntArraySet object.
        IntArraySet answer;

        try {
            answer = (IntArraySet) super.clone();
        } catch (CloneNotSupportedException e) {  // This exception should not occur. But if it does, it would probably
            // indicate a programming error that made super.clone unavailable.
            // The most common error would be forgetting the "Implements Cloneable"
            // clause at the start of this class.
            throw new RuntimeException
                    ("This class does not implement Cloneable");
        }

        answer.data = data.clone();

        return answer;
    }


    /**
     * Method to determine if a particular element
     * is in this set.
     *
     * @param target the element that needs to be found in this set
     * @return true if the target element is in this set, false otherwise
     **/
    public boolean contains(int target) {
        int index;

        // Loop through all of the items currently stored in the array
        // (manyItems).
        for (index = 0; (index < manyItems) && (target != data[index]); index++)
            // No work is needed in the body of this for-loop.
            ;

        if (index == manyItems) {
            // The target was not found. Therefore, the data structure does not
            // currently contain the target element.
            return false;
        } else {
            // The target was found.
            return true;
        }
    }


    /**
     * Change the current capacity of this set.
     *
     * @param minimumCapacity the new capacity for this set
     * @throws OutOfMemoryError
     *  Indicates insufficient memory for: new int[minimumCapacity].
     * @postcondition This set's capacity has been changed to at least minimumCapacity.
     * If the capacity was already at or greater than minimumCapacity,
     * then the capacity is left unchanged.
     **/
    public void ensureCapacity(int minimumCapacity) {
        int[] biggerArray;

        if (data.length < minimumCapacity) {
            biggerArray = new int[minimumCapacity];
            System.arraycopy(data, 0, biggerArray, 0, manyItems);
            data = biggerArray;
        }
    }


    /**
     * Accessor method to get the current capacity of this set.
     * The add method works efficiently (without needing
     * more memory) until this capacity is reached.
     *
     * @return the current capacity of this set
     **/
    public int getCapacity() {
        return data.length;
    }


    /**
     * Remove a specified element from this set.
     *
     * @param target the element to be removed from the set
     * @return true if set was modified, false otherwise.
     * @postcondition If target was found in the set, then the
     * target has been removed and the method returns true.
     * Otherwise the set remains unchanged and the method returns false.
     **/
    public boolean remove(int target) {
        int index;

        // First, set index to the location of target in the data array,
        // which could be as small as 0 or as large as manyItems-1; If target
        // is not in the array, then index will be set equal to manyItems;
        for (index = 0; (index < manyItems) && (target != data[index]); index++)
            // No work is needed in the body of this for-loop.
            ;

        if (index == manyItems) {
            // The target was not found, so nothing is removed. The set remains
            // unchanged.
            return false;
        } else {
            // The target was found at data[index].
            // So reduce manyItems by 1 and copy the last element onto data[index].
            manyItems--;
            data[index] = data[manyItems];
            return true;
        }
    }


    /**
     * Determine the number of elements in this set.
     *
     * @return the number of elements in this set
     **/
    public int size() {
        return manyItems;
    }


    /**
     * Reduce the current capacity of this set to its actual size (i.e., the
     * number of elements it contains).
     *
     * @throws OutOfMemoryError
     *  Indicates insufficient memory for altering the capacity.
     * @postcondition This set's capacity has been changed to its current size.
     **/
    public void trimToSize() {
        int[ ] trimmedArray;

        if (data.length != manyItems) {
            trimmedArray = new int[manyItems];
            System.arraycopy(data, 0, trimmedArray, 0, manyItems);
            data = trimmedArray;
        }
    }


    /**
     * Create a new set that contains all the elements from this set and one other set.
     *
     * @param set2 the second set in the union
     * @return the union of this set and set2
     * @throws NullPointerException
     *  Indicates that the argument is null.
     * @throws OutOfMemoryError
     *  Indicates insufficient memory for the new set.
     * @precondition set2 is not null, and
     * getCapacity( ) + set2.getCapacity( ) &lt;= Integer.MAX_VALUE.
     * @note An attempt to create a set with a capacity beyond
     * Integer.MAX_VALUE will cause an arithmetic overflow
     * that will cause the set to fail. Such large collections should use
     * a different set implementation.
     **/
    public IntArraySet union(IntArraySet set2) {
        // If set2 is null, then a NullPointerException is thrown.
        // In the case that the total number of items is beyond
        // Integer.MAX_VALUE, there will be an arithmetic overflow and
        // the set will fail.

        IntArraySet answer = new IntArraySet();
        answer.addAll(this);
        answer.addAll(set2);

        return answer;
    }


    /**
     * Create a new set that contains all the elements that are in both this set and one other set.
     *
     * @param set2 the second set in the intersection
     * @return the intersection of this set and set2
     * @throws NullPointerException
     *  Indicates that the argument is null.
     * @throws OutOfMemoryError
     *  Indicates insufficient memory for the new set.
     * @precondition set2 is not null
     * @postcondition the returned set is smaller than either this set or set2
     **/
    public IntArraySet intersection(IntArraySet set2) {
        // If set2 is null, then a NullPointerException is thrown.

        IntArraySet answer = new IntArraySet();
        answer.addAll(this);
        answer.keepCommonElements(set2);

        return answer;
    }


    /**
     * Create a new set that contains all the elements from this set except those from the other set.
     *
     * @param set2 the second set in the subtraction
     * @return the subtraction of set2 from this set
     * @throws NullPointerException
     *  Indicates that the argument is null.
     * @throws OutOfMemoryError
     *  Indicates insufficient memory for the new set.
     * @precondition set2 is not null
     * @postcondition the returned set is smaller than this set
     **/
    public IntArraySet minus(IntArraySet set2) {
        // If set2 is null, then a NullPointerException is thrown.

        IntArraySet answer = new IntArraySet();
        answer.addAll(this);
        answer.subtractAll(set2);

        return answer;
    }


    public String toString() {
        String result = "{";
        for (int i = 0; i < manyItems; i++) {
            if (i > 0) {
                result += " ";
            }
            result += data[i];
            if (i < manyItems - 1) {
                result += ",";
            }
        }
        result += "}";
        return result;
    }

}//IntArraySet