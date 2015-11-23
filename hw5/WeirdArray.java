/**
 * Course: CS 27500
 * Name: Adam Joseph Cook
 * Email: cook5@purduecal.edu
 * Assignment: 5
 */

/******************************************************************************
 * A WeirdArray is a container acts like a normal (fixed size) array but has a
 * very specific iterator.
 *
 * @author Adam Joseph Cook
 *  <A HREF="mailto:cook5@purduecal.edu"> (cook5@purduecal.edu) </A>
 ******************************************************************************/

import java.util.Iterator;

/**
 * Generic version of a WeirdIterator class which implements the 'java.lang.Iterable'
 * interface.
 * @param <T> the type of the array items
 */
public class WeirdArray<T> implements Iterable<T>
{
    private Object[] theArray; // the storage array

    /**
     * Initialize an "empty" WeirdArray.
     *
     * @param n the maximum index of the storage array
     * @postcondition The array of the provided size is default initialized.
     */
    public WeirdArray(int n)
    {
        theArray = new Object[n];
    }

    /**
     * Retrieve the iterator for this object.
     *
     * @return
     *      the iterator to walk through the storage array
     */
    @SuppressWarnings("unchecked")
    public Iterator<T> iterator()
    {
        return new WeirdIterator(this);
    }

    /**
     * Set an item in the array.
     *
     * @param index zero-based index at which to store the element
     * @param e element to be stored
     * @postcondition The data at the provided index is updated.
     */
    public void setElement(int index, T e)
    {
        theArray[index] = e;
    }

    /**
     * Retrieve an item from the array.
     *
     * @param index location of the item in the array
     * @return
     *      the item in the array at the specified index
     */
    @SuppressWarnings("unchecked")
    public T getElement(int index)
    {
        return (T) theArray[index];
    }


    /**
     * Retrieve the length of the storage array.
     *
     * @return
     *      the length of the storage array
     */
    public int getLength()
    {
        return theArray.length;
    }
}
