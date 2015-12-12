class Pair2<T extends Comparable<T>> implements Comparable<T>
{
    private T first; // first item in the Pair
    private T second; // second item in the Pair

    public Pair2()
    {
        this.first = null;
        this.second = null;
    }

    public Pair2(T first, T second)
    {
        this.first = first;
        this.second = second;
    }

    public T getFirst()
    {
        return this.first;
    }
    public T getSecond()
    {
        return this.second;
    }

    public Pair2<T> setFirst(T first)
    {
        this.first = first;
        return this;
    }

    public Pair2<T> setSecond(T second)
    {
        this.second = second;
        return this;
    }

    public int compareTo(T obj)
    {
        if (this.first.compareTo(obj) < 0 ||
            this.second.compareTo(obj) < 0) {
            return -1;
        }
        else if (this.first.compareTo(obj) > 0 ||
                 this.second.compareTo(obj) > 0) {
            return 1;
        }

        return 0;
    }
}