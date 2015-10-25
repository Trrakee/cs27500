import java.lang.IndexOutOfBoundsException;

class SequenceImpl implements Sequence
{
    private int[] data;
    private int manyItems;

    public SequenceImpl()
    {
        final int initialCapacity = 10;
        data = new int[initialCapacity];
        manyItems = 0;
    }

    public int size()
    {
        return manyItems;
    }

    public void addFirst(int e)
    {
        checkCapacity();

        if (manyItems == 0) {
            // List is currently empty. Add to first element.
            data[0] = e;
        } else {
            // List is currently partially filled.
            int[] data_copy = new int[data.length];
            System.arraycopy(data, 0, data_copy, 1, data.length-1);
            data = data_copy;
            data[0] = e;
        }
        manyItems++;
    }

    public void addLast(int e)
    {
        checkCapacity();

        data[manyItems] = e;
        manyItems++;
    }

    public void add(int i, int e)
    {
        if (i > manyItems - 1 && manyItems != 0) {
            throw new IndexOutOfBoundsException("The index, i, provided is not valid.");
        }

        checkCapacity();

        if (i == 0) {
            // Add to front of the array.
            addFirst(e);
        } else {
            // Add somewhere in the middle.
            int[] new_data = new int[data.length];
            System.arraycopy(data, 0, new_data, 0, i);
            System.arraycopy(data, i, new_data, i+1, manyItems-i);
            data = new_data;
            data[i] = e;
            manyItems++;
        }
    }

    public int get(int i)
    {
        if (i > manyItems - 1 && manyItems != 0) {
            throw new IndexOutOfBoundsException("The index, i, provided is not valid.");
        }

        return data[i];
    }

    public int remove(int i)
    {
        if (i > manyItems - 1 && manyItems != 0) {
            throw new IndexOutOfBoundsException("The index, i, provided is not valid.");
        }
        // TODO: Implement this.
        return 0;
    }

    public void checkCapacity()
    {
        // The current array is full, enlarge the data array.
        if (manyItems == data.length) {
            int[] bigger_data = new int[data.length + 10];
            System.arraycopy(data, 0, bigger_data, 0, data.length);
            data = bigger_data;
        }
    }

    public String toString()
    {
        String result = "[ ";
        for (int index = 0; index < manyItems; index++) {
            result += data[index];
            result += " ";
        }
        result += "]";
        return result;
    }
}