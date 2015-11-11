/**
 * Course: CS 27500
 * Name: Adam Joseph Cook
 * Email: cook5@purduecal.edu
 * Assignment: 4
 */

/******************************************************************************
 * A Pair is a container that can be used to pass around two objects or values
 * of type T1 and of type T2.
 *
 * @author Adam Joseph Cook
 *  <A HREF="mailto:cook5@purduecal.edu"> (cook5@purduecal.edu) </A>
 ******************************************************************************/

/**
 * Generic version of a Pair class.
 * @param <T1> the type of the first item
 * @param <T2> the type of the second item
 */
public class Pair<T1, T2>
{
    private T1 first; // first item in the Pair
    private T2 second; // second item in the Pair

    /**
     * Initialize an "empty" Pair.
     *
     * @postcondition The items in this Pair are both set to null.
     **/
    public Pair()
    {
        this.first = null;
        this.second = null;
    }

    /**
     * Initialize a Pair with provided objects of type T1 and type T2.
     *
     * @param first
     *   first item in the pair (of type T1)
     * @param second
     *   second item in the pair (of type T2)
     * @postcondition The items in this Pair are set to the objects provided.
     **/
    public Pair(T1 first, T2 second)
    {
        this.first = first;
        this.second = second;
    }

    /**
     * Initialize a Pair from another provided Pair object.
     *
     * @param pair The Pair object used to initialize this Pair.
     * @postcondition The items in this Pair point to (if the incoming Pair field is an object) or are set to (if
     * the incoming Pair field is a primitive value) the instance fields of the provided Pair object.
     **/
    public Pair(Pair<T1, T2> pair)
    {
        this.first = pair.first;
        this.second = pair.second;
    }

    /**
     * Retrieve the first Pair item.
     *
     * @return
     *   the first item in the Pair
     **/
    public T1 getFirst()
    {
        return this.first;
    }

    /**
     * Set the first Pair item.
     *
     * @param first first item in the pair (of type T1)
     * @postcondition The first Pair item is the same as provided object and the second Pair item remains unchanged.
     * @return
     *   a reference to the current Pair object
     **/
    public Pair<T1, T2> setFirst(T1 first)
    {
        this.first = first;
        return this;
    }

    /**
     * Retrieve the second Pair item.
     *
     * @return
     *   the second item in the Pair
     **/
    public T2 getSecond()
    {
        return this.second;
    }

    /**
     * Set the second Pair item.
     * @param second second item in the pair (of type T2)
     * @postcondition The second Pair item is the same as provided object and the first Pair item remains unchanged.
     * @return
     *   a reference to the current Pair object
     **/
    public Pair<T1, T2> setSecond(T2 second)
    {
        this.second = second;
        return this;
    }

    /**
     * Transpose the objects in the Pair.
     *
     * @return
     *   a reference to a new Pair object of type T2 (first item) and T1 (second item) where the objects are the
     *   same as the objects in this Pair, but in opposite order.
     **/
    public Pair<T2, T1> transpose()
    {
        Pair<T2, T1> new_pair = new Pair<T2, T1>(this.second, this.first);
        return new_pair;
    }

    /**
     * Replace the first item with a provided object.
     * @param <T> the type of the first item
     * @param first first item in the new pair (of type T)
     * @return
     *   a reference to a new Pair object of type T (first item) and T2 (second item) where the first item is set to
     *   the provided object (of type T) and the second item is the same as in this pair.
     **/
    public <T> Pair<T, T2> replaceFirst(T first)
    {
        Pair<T, T2> new_pair = new Pair<T, T2>(first, this.second);
        return new_pair;
    }

    /**
     * Replace the second item with a provided object.
     * @param <T> the type of the second item
     * @param second second item in the new pair (of type T)
     * @return
     *   a reference to a new Pair object of type T1 (first item) and T (second item) where the second item is set to
     *   the provided object (of type T) and the first item is the same as in this pair.
     **/
    public <T> Pair<T1, T> replaceSecond(T second)
    {
        Pair<T1, T> new_pair = new Pair<T1, T>(this.first, second);
        return new_pair;
    }

    /**
     * Memberwise comparison.
     * @param o Pair object in which to compare
     * @return
     *   true will be returned if the Pair objects have the exact same contents. false will be returned otherwise.
     **/
    public boolean equals(Object o)
    {
        if (o == null || !(o instanceof Pair))
        {
            return false;
        }

        // Cast the incoming Object reference value to a Pair reference and, if necessary, recursively check all
        // provided Pairs until the primitive values can be checked for equality.
        Pair other_pair = (Pair) o;
        return ((this.first == other_pair.first ||
                (this.first != null && other_pair.first != null && this.first.equals(other_pair.first))) &&
                (this.second == other_pair.second ||
                (this.second != null && other_pair.second != null && this.second.equals(other_pair.second))));
    }

    /**
     * String representation of the Pair contents.
     *
     * @return
     *   a String will be returned presenting the Pair contents between two square brackets ("[]") seperated by a
     *   single comma (",") without white spaces.
     **/
    public String toString()
    {
        return "[" + this.first + "," + this.second + "]";
    }
}