import java.util.StringTokenizer;
import java.util.Stack;

public class EvaluateInfixTwoStacks
{

   public static int evaluateInfix(String infix)
   {
      Stack<String> operators = new Stack<String>();
      Stack<Integer> operands  = new Stack<Integer>();
      StringTokenizer st = new StringTokenizer(infix);

      while (st.hasMoreTokens())
      {
         String token = st.nextToken();
         if ( token.equals("(") )
         {
            /* do nothing */
         }
         else if ( token.equals("+")
                || token.equals("-")
                || token.equals("^")
                || token.equals("*")
                || token.equals("/")
                || token.equals("%") )
         {
            operators.push( token );
         }
         else if ( token.equals(")") )
         {
            String op = operators.pop();
            int y = operands.pop();
            int x = operands.pop();
            if ( op.equals("+") )
            {
               operands.push( x + y );
            }
            else if ( op.equals("-") )
            {
               operands.push( x - y );
            }
            else if ( op.equals("*") )
            {
               operands.push( x * y );
            }
            else if ( op.equals("/") )
            {
               operands.push( x / y );
            }
            else if ( op.equals("%") )
            {
               operands.push( x % y );
            }
            else if ( op.equals("^") )
            {
               operands.push( (int)Math.pow(x,y) );
            }
         }
         else // must be a number
         {
            operands.push( Integer.decode( token ) );
         }

         // DEBUG
         if (token.equals("4")) {
            System.out.println(token);
            System.out.println(operators.toString());
            System.out.println(operands.toString());
            System.out.println("**********************");
            System.out.println("");
         }
      }
      return operands.pop();
   }//evaluateInfix()
}