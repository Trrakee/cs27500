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

    /** For part (b) */
    /** Using another array. */
    public static int findRepeatedNumber(int[] A)
    {
        int repeated_value = 0;
        int[] copy_A = new int[A.length];
        System.arraycopy(A, 0, copy_A, 0, A.length);
        for (int index = 0; index < A.length; index++) {
            if (A[index] == copy_A[index+1]) {
                repeated_value = A[index];
                break;
            }
        }
        return repeated_value;
    }
}