import java.util.Stack;

public class Problem16
{
    public static void main(String[ ] args)
    {
        String expression = "( ( ( 2 * 3 ) * ( 9 + ( ( 3 - 1 ) + 4 ) ) ) * ( 5 - 1 ) )";

        int result = EvaluateInfixTwoStacks.evaluateInfix( expression );
        System.out.println( expression + " ==> " + result );
    }//main()
}//Problem16