/**
 * Course: CS 27500
 * Name: Adam Joseph Cook
 * Email: cook5@purduecal.edu
 * Assignment: 5
 */

/******************************************************************************
 * A WeirdIterator is an iterator which handles arrays with odd and even
 * elements differently.
 *
 * @author Adam Joseph Cook
 *  <A HREF="mailto:cook5@purduecal.edu"> (cook5@purduecal.edu) </A>
 ******************************************************************************/

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Generic version of a WeirdIterator class which implements the 'java.util.Iterator'
 * interface.
 * @param <T> the type of items in the iterator
 */
public class WeirdIterator<T> implements Iterator<T>
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
    public WeirdIterator(WeirdArray<T> wa)
    {
        this.wa = wa;
        this.array_length = this.wa.getLength();
        this.cursor = 0;
        this.indexes = new int[this.array_length];
        // Generate an array with the appropriate iteration indexes based
        // on whether the the length of the array is even or odd.
        if (this.wa.getLength() % 2 == 0)
        {
            // The length of the array is even.
            // The indexes for the iteration process will be generated as follows:
            // 1. Last item of the first half of the array.
            // 2. First item of the second half of the array.
            // 3. Second to last item of the first half of the array.
            // 4. Second item of the second half of the array.
            // 5. Third to last item of the first half of the array.
            // 6. Etc.
            int last_item_first_half = (this.array_length / 2) - 1;
            this.indexes[0] = last_item_first_half;
            // Second half of the array.
            for (int i = 2; i < array_length;)
            {
                this.indexes[i] = --last_item_first_half;
                i = i + 2;
            }
            // Reset the last item of the first half of the array.
            last_item_first_half = (this.array_length / 2) - 1;
            // First half of the array.
            for (int j = 1; j < array_length;)
            {
                this.indexes[j] = ++last_item_first_half;
                j = j + 2;
            }
        }
        else
        {
            // The length of the array is odd.
            // The indexes for the iteration process will be generated as follows:
            // 1. Middle item of the array.
            // 2. Item just before the middle item of the array.
            // 3. Item just after the middle item of the array.
            // 4. Item two places before the middle item of the array.
            // 5. Item two places after the middle item of the array.
            // 6. Item three places before the middle item of the array.
            // 7. Etc.
            int middle_index = this.array_length / 2;
            this.indexes[0] = middle_index;
            // Before middle.
            for (int i = 1; i < array_length;)
            {
                this.indexes[i] = --middle_index;
                i = i + 2;
            }
            // Reset the middle index value.
            middle_index = this.array_length / 2;
            // After middle.
            for (int j = 2; j < array_length;)
            {
                this.indexes[j] = ++middle_index;
                j = j + 2;
            }
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
    @SuppressWarnings("unchecked")
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
