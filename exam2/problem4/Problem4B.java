import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class Problem4B
{
    public static void main(String[ ] args)
    {
        List<Rectangle> list = Arrays.asList(
                new Rectangle(1.0, 2.0),
                new Rectangle(2.0, 3.0),
                new Rectangle(3.0, 4.0),
                new Rectangle(4.0, 5.0)
        );
        System.out.println(list.toString()); // Check line.
        Stack<Rectangle> stack = new Stack<Rectangle>();
        for(Iterator<Rectangle> it = list.iterator(); it.hasNext();)
            stack.push(it.next());

        System.out.println(stack.toString()); // Check line.
    }//main()
}//Problem4B