import java.lang.IllegalArgumentException;

public class IntArray
{
    private int[] A;

    public IntArray(int n)
    {
        if (n < 2) {
            throw new IllegalArgumentException("The provided argument must be greater than or equal to 2.");
        }

        A = new int[n];

        int start = 1;
        A[0] = 1; // Array always starts at 1.
        for (int index = 1; index < n-1; index++) {
            A[index] = A[index-1] + 1;
            start++;
        }
        A[start] = n - 1;
    }

    public int[] getArray() {
        return A;
    }

    public String toString() {
        String result = "[ ";
        for (int index = 0; index < A.length; index++) {
            result += A[index];
            result += " ";
        }
        result += "]";
        return result;
    }

    /** For part (a) */
    /** Using two loops. */
    public static int findRepeatedNumber(int[] A)
    {
        int repeated_value = 0;
        for (int outer_index = 0; outer_index < A.length; outer_index++) {
            for (int inner_index = outer_index + 1; inner_index < A.length; inner_index++) {
                if (A[outer_index] == A[inner_index]) {
                    repeated_value = A[outer_index];
                    // Repeated value found, no need to keep looping the outer
                    // loop since it is assumed that there is only one repeated
                    // value in the array.
                    outer_index = A.length;
                    // Break out of the inner loop.
                    break;
                }
            }
        }
        return repeated_value;
    }
}