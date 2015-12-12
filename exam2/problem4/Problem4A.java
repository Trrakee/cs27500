import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Problem4A
{
    public static void main(String[ ] args)
    {
        List<Integer> list = Arrays.asList(1, 2, 3);
        for (Iterator<Integer> it = list.iterator(); it.hasNext();) {
            System.out.print(it.next());
        }
    }//main()
}//Problem4A