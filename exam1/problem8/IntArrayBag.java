import java.lang.IllegalArgumentException;

public class IntArrayBag
{
    // Use two partially-filled "parallel arrays".
    private int[ ] data;       // the data items
    private int[ ] dataCounts; // how many times each item is in the bag
    private int manyDataItems; // number of elements in partially-filled array
    private int manyItems;     // total number of items in the bag

    public IntArrayBag()
    {
        final int INITIAL_CAPACITY = 10;
        data       = new int[INITIAL_CAPACITY];
        dataCounts = new int[INITIAL_CAPACITY];
        manyDataItems = 0;
        manyItems = 0;
    }

    public IntArrayBag(int initialCapacity)
    {
        if (initialCapacity < 0) throw new IllegalArgumentException("Capacity<0.");
        data       = new int[initialCapacity];
        dataCounts = new int[initialCapacity];
        manyDataItems = 0;
        manyItems = 0;
    }

    /** Add a new element to this bag. If the new element would take this bag
     *  beyond its current capacity, then the capacity is increased.
     */
    public void add(int element)
    {
        // Check if the data item is already in the 'data' array.
        boolean found = false;
        int index = 0;
        for (int dataItem: data) {
            if (dataItem == element) {
                found = true;
                break;
            }
            index++;
        }

        if (found) {
            // ** Element is already in the 'data' array.

            // Add element to the array.
            dataCounts[index]++;
            manyItems++;
        } else {
            // ** Element is not already in the 'data' array.

            // Check if the data and dataCounts array needs to be expanded.
            // Both the 'data' and 'dataCounts' arrays will be expanded by
            // multiples of 10.
            if (manyDataItems == data.length) {
                int[ ] biggerDataArray = new int[data.length + 10];
                int[ ] biggerDataCountsArray = new int[data.length + 10];
                System.arraycopy(data, 0, biggerDataArray, 0, manyDataItems);
                System.arraycopy(dataCounts, 0, biggerDataCountsArray, 0, manyDataItems);
                data = biggerDataArray;
                dataCounts = biggerDataCountsArray;
            }

            data[manyDataItems] = element;
            dataCounts[manyDataItems] = 1;
            manyItems++;
            manyDataItems++;
        }
    }//add()

    /** Remove one copy of a specified element from this bag.
     *  If target was found in the bag, then one copy of target
     *  has been removed and the method returns true. Otherwise
     *  the bag remains unchanged and the method returns false.
     */
    public boolean remove(int target)
    {
        // Check if the data item is in the 'data' array.
        boolean found = false;
        int index = 0;
        for (int dataItem: data) {
            if (dataItem == target) {
                found = true;
                break;
            }
            index++;
        }

        if (found && !(dataCounts[index] == 0)) {
            // ** Element is in the 'data' array.
            dataCounts[index]--;
            manyItems--;
            if (dataCounts[index] == 0) {
                // If the data count for an element, decrement the associated
                // element in the dataCounts array.
                manyDataItems--;
                data[index] = data[manyDataItems];
                dataCounts[index] = dataCounts[manyDataItems];
                data[manyDataItems] = 0;
                dataCounts[manyDataItems] = 0;
            }
            return true;
        } else {
            // ** Element is not in the 'data' array so do nothing.
            return false;
        }
    }//remove()

    public int getManyDataItems()
    {
        return manyDataItems;
    }

    public int getManyItems()
    {
        return manyItems;
    }

    public int getDataArraySize()
    {
        return data.length;
    }

    public int getDataCountsArraySize()
    {
        return dataCounts.length;
    }

    public String dataToString( )
    {
        String result = "[";
        for (int dataItem: data) {
            result += Integer.toString(dataItem);
            result += ", ";
        }
        result += "]";
        return result;
    }

    public String dataCountsToString( )
    {
        String result = "[";
        for (int dataCountsItem: dataCounts) {
            result += Integer.toString(dataCountsItem);
            result += ", ";
        }
        result += "]";
        return result;
    }
}//IntArrayBag