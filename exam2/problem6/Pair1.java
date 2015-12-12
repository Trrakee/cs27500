class Pair1<T extends Comparable<T>>
{
    private T first; // first item in the Pair
    private T second; // second item in the Pair

    public Pair1()
    {
        this.first = null;
        this.second = null;
    }

    public Pair1(T first, T second)
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

    public Pair1<T> setFirst(T first)
    {
        this.first = first;
        return this;
    }

    public Pair1<T> setSecond(T second)
    {
        this.second = second;
        return this;
    }
}