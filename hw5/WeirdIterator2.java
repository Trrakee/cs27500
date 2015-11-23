/**
 * Course: CS 27500
 * Name: Adam Joseph Cook
 * Email: cook5@purduecal.edu
 * Assignment: 5
 */

/******************************************************************************
 * A WeirdIterator is an iterator which handles arrays by walking towards
 * the ends to the middle.
 *
 * @author Adam Joseph Cook
 *  <A HREF="mailto:cook5@purduecal.edu"> (cook5@purduecal.edu) </A>
 ******************************************************************************/

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Generic version of a WeirdIterator2 class which implements the 'java.util.Iterator'
 * interface.
 * @param <T> the type of items in the iterator
 */
public class WeirdIterator2<T> implements Iterator<T>
{
    private int array_length; // length of the storage array
    private int cursor; // tracking cursor for the iterator
    private int[] indexes; // array which holds the indexes in the order that the iterator will walk through
    private WeirdArray<T> wa; // WeirdArray instance

    /**
     * Initializes the iterator by generating an array holding the indexes of which the
     * iterator will use to walk through the elements of the WeirdArray.
     *
     * @param wa the WeirdArray object
     */
    public WeirdIterator2(WeirdArray<T> wa)
    {
        this.wa = wa;
        this.array_length = this.wa.getLength();
        this.cursor = 0;
        this.indexes = new int[this.array_length];
        // Generate an array with the appropriate iteration indexes based on the following:
        // 1. First item in the array.
        // 2. Last item in the array.
        // 3. Second item in the array.
        // 4. Second to last item in the array.
        // 5. Third item in the array.
        // 6. Etc.
        // Odd indexes.
        int first_index = 0;
        int last_index = this.array_length - 1;
        for (int i = 0; i < this.array_length;)
        {
            this.indexes[i] = first_index++;
            i = i + 2;
        }
        for (int j = 1; j < this.array_length;)
        {
            this.indexes[j] = last_index--;
            j = j + 2;
        }
    }

    /**
     * Returns True if the iteration has more elements.
     *
     * @return
     *      true if the iteration has more elements
     */
    public boolean hasNext()
    {
        return (cursor <= this.array_length - 1);
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return
     *      the next element in the iteration
     * @throws NoSuchElementException
     *      indicates that the iteration has no more elements
     */
    public T next()
    {
        if ( hasNext() )
        {
            return (T)this.wa.getElement(this.indexes[this.cursor++]);
        }
        else
            throw new NoSuchElementException();
    }

    /**
     * Removes from the underlying collection the last element returned by this iterator (optional operation).
     * This method can be called only once per call to next().
     *
     * @throws UnsupportedOperationException
     *      indicates if the remove operation is not supported by this iterator
     */
    public void remove()
    {
      throw new UnsupportedOperationException();
    }
}