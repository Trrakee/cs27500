import java.util.Stack;

public class Problem13B
{
    public static void main(String[ ] args)
    {
        // FIRST PART - LOOKING FOR FALSE POSITIVE
        String expression1 = "(";
        System.out.println(ExpressionFixed.isBalanced(expression1));
        System.out.println("false Expected");
        System.out.println("**********************");
        String expression2 = "( (";
        System.out.println(ExpressionFixed.isBalanced(expression2));
        System.out.println("false Expected");
        System.out.println("**********************");
        String expression3 = "( ( )";
        System.out.println(ExpressionFixed.isBalanced(expression3));
        System.out.println("false Expected");
        System.out.println("**********************");
        System.out.println("");

        // THIRD PART - LOOKING FOR FALSE NEGATIVES
        String expression4 = "( )";
        System.out.println(ExpressionFixed.isBalanced(expression4));
        System.out.println("true Expected");
        System.out.println("**********************");
        String expression5 = "( ( ) )";
        System.out.println(ExpressionFixed.isBalanced(expression5));
        System.out.println("true Expected");
        System.out.println("**********************");
        String expression6 = "( ( ) ( ) )";
        System.out.println(ExpressionFixed.isBalanced(expression6));
        System.out.println("true Expected");
        System.out.println("**********************");
    }//main()
}//Problem13B