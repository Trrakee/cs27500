import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class Problem5B
{
    public static void main(String[ ] args)
    {
        List<Integer> list1 = Arrays.asList(10, 20, 30, 40, 50);
        List<Integer> list2 = Arrays.asList(1, 2, 3);
        List<Integer> list3 = new ArrayList<Integer>();
        for (Iterator<Integer> it1 = list1.iterator(); it1.hasNext();) {
            int n = it1.next(); // CORRECTION: Move this here.
            for (Iterator<Integer> it2 = list2.iterator(); it2.hasNext(); ) {
                int m = it2.next();
                list3.add(n + m);
            }
        }
        for (int i: list3)
            System.out.print(i + " ");
        System.out.println();
    }//main()
}//Problem5B