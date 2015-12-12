import java.util.Stack;
import java.util.StringTokenizer;

public class Expression
{
    public static boolean isBalanced(String input)
    {
        Stack<String> character_stack = new Stack<String>();
        StringTokenizer st = new StringTokenizer(input);
        while (st.hasMoreTokens())
        {
            String token = st.nextToken();
            if (token.equals("("))
            {
                character_stack.push(token);
            }
            else if (!character_stack.isEmpty())
            {
                character_stack.pop();
            }
            else
            {
                return false;
            }
        }

        return true;
    }
}