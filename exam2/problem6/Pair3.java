class Pair3<T extends Comparable<T>> implements Comparable<Pair3<T>>
{
    private T first; // first item in the Pair
    private T second; // second item in the Pair

    public Pair3()
    {
        this.first = null;
        this.second = null;
    }

    public Pair3(T first, T second)
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

    public Pair3<T> setFirst(T first)
    {
        this.first = first;
        return this;
    }

    public Pair3<T> setSecond(T second)
    {
        this.second = second;
        return this;
    }

    public int compareTo(Pair3<T> obj)
    {
        if (this.first.compareTo(obj.first) < 0 ||
                this.second.compareTo(obj.second) < 0) {
            return -1;
        }
        else if (this.first.compareTo(obj.first) > 0 ||
                this.second.compareTo(obj.second) > 0) {
            return 1;
        }

        return 0;
    }
}