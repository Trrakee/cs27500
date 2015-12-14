import java.util.Stack;

public class Problem13A
{
    public static void main(String[ ] args)
    {
        // FIRST PART - FALSE POSITIVE
        String expression1 = "(";
        System.out.println(Expression.isBalanced(expression1));
        System.out.println("true Expected");
        System.out.println("**********************");
        String expression2 = "( (";
        System.out.println(Expression.isBalanced(expression2));
        System.out.println("true Expected");
        System.out.println("**********************");
        String expression3 = "( ) )";
        System.out.println(Expression.isBalanced(expression3));
        System.out.println("false Expected");
        System.out.println("**********************");
        String expression4 = "( ( )";
        System.out.println(Expression.isBalanced(expression4));
        System.out.println("true Expected");
        System.out.println("**********************");
        String expression5 = "( ) ( (";
        System.out.println(Expression.isBalanced(expression5));
        System.out.println("true Expected");
        System.out.println("**********************");
        System.out.println("");

        // THIRD PART - LOOKING FOR FALSE NEGATIVES
        String expression6 = "( )";
        System.out.println(Expression.isBalanced(expression6));
        System.out.println("true Expected");
        System.out.println("**********************");
        String expression7 = "( ( ) )";
        System.out.println(Expression.isBalanced(expression7));
        System.out.println("true Expected");
        System.out.println("**********************");
        String expression8 = "( ( ) ( ) )";
        System.out.println(Expression.isBalanced(expression8));
        System.out.println("true Expected");
        System.out.println("**********************");
    }//main()
}//Problem13A