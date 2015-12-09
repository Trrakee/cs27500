/**
 * Course: CS 27500
 * Name: Adam Joseph Cook
 * Email: cook5@purduecal.edu
 * Assignment: 6
 */

/******************************************************************************
 * Utility class and methods for converting and evaluating mathematical
 * expressions in infix and postfix form.
 *
 * @author Adam Joseph Cook
 *  <A HREF="mailto:cook5@purduecal.edu"> (cook5@purduecal.edu) </A>
 ******************************************************************************/

import java.util.StringTokenizer;
import java.util.Stack;

/**
 * Expression class which provides static utility methods for working with
 * infix and postfix mathematical expressions.
 */
public class Expression
{
    /**
     * Converts an infix form String to its postfix form.
     *
     * @param infix the String in infix form
     * @return
     *      the String in postfix form
     */
    public static String Infix2Postfix(String infix)
    {
        infix = infix + " )";
        Stack<String> operators = new Stack<String>();
        StringTokenizer st = new StringTokenizer(infix);
        String postfix = "";
        operators.push( "(" );
            while (st.hasMoreTokens())
            {
                String token = st.nextToken();
                // Token is a left parenthesis.
                if (token.equals("("))
                {
                    operators.push(token);
                }
                // Token is a supported operator.
                // Operator precendence (highest to lowest):
                //   ^ (power) --- 1
                //   * / %     --- 2
                //   + -       --- 3
                else if (token.equals("+") ||
                         token.equals("-") ||
                         token.equals("^") ||
                         token.equals("*") ||
                         token.equals("/") ||
                         token.equals("%")) {
                    // Loop down through the stack.
                    // Check if the operators on the stack
                    // have equal or greater precendence
                    // than the current operator (token).
                    while(!operators.isEmpty())
                    {
                        // Current token is ^.
                        if (token.equals("^")) {
                            if (operators.peek().equals("^")) {
                                // Operator has equal precendence.
                                postfix += operators.pop();
                                postfix += " ";
                            } else {
                                // Operator has lower precendence.
                                operators.push(token);
                                break;
                            }
                        }
                        // Current token is * / %.
                        else if (token.equals("*") ||
                            token.equals("/") ||
                            token.equals("%")) {
                            if (operators.peek().equals("*") ||
                                operators.peek().equals("/") ||
                                operators.peek().equals("%") ||
                                operators.peek().equals("^")) {
                                // Operator has equal or higher precendence.
                                postfix += operators.pop();
                                postfix += " ";
                            } else {
                                // Operator has lower precendence.
                                operators.push(token);
                                break;
                            }
                        }
                        // Current token is + or -.
                        else if (token.equals("+") ||
                                 token.equals("-")) {
                            if (operators.peek().equals("*") ||
                                operators.peek().equals("/") ||
                                operators.peek().equals("%") ||
                                operators.peek().equals("+") ||
                                operators.peek().equals("-") ||
                                operators.peek().equals("^") ) {
                                // Operator has equal or higher precendence.
                                postfix += operators.pop();
                                postfix += " ";
                            } else {
                                // Operator has lower precendence.
                                operators.push(token);
                                break;
                            }
                        }
                    }
                }
                // Token is a right parenthesis.
                else if (token.equals(")"))
                {
                    // Loop down through the stack.
                    while(!operators.isEmpty())
                    {
                        if (operators.peek().equals("(")) {
                            // Pop (and discard) the left parenthesis
                            // off of the stack if present
                            operators.pop();
                            break;
                        } else {
                            postfix += operators.pop();
                            postfix += " ";
                        }
                    }
                }
                // Current token is an integer.
                else
                {
                    postfix += token;
                    postfix += " ";
                }
            }
        return postfix;
    }//Infix2Postfix()

    /**
     * Mathematically evaluates a postfix form String.
     *
     * @param postfix the String in postfix form
     * @return
     *      the result of the expression
     */
    public static int EvaluatePostfix(String postfix)
    {
        Stack<Integer> operands = new Stack<Integer>();
        StringTokenizer st = new StringTokenizer(postfix);
            while (st.hasMoreTokens())
            {
                String token = st.nextToken();
                int first_operand;
                int second_operand;
                // Token is a supported operator.
                //
                // Addition operation.
                if (token.equals("+")) {
                    operands.push(operands.pop() + operands.pop());
                }
                // Subtraction operation.
                else if (token.equals("-")) {
                    first_operand = operands.pop();
                    second_operand = operands.pop();
                    operands.push(second_operand - first_operand);
                }
                // Exponentiation operation.
                else if (token.equals("^")) {
                    first_operand = operands.pop();
                    second_operand = operands.pop();
                    operands.push((int)Math.pow((double)second_operand, (double)first_operand));
                }
                // Multiplication operation.
                else if (token.equals("*")) {
                    operands.push(operands.pop() * operands.pop());
                }
                // Division operation.
                else if (token.equals("/")) {
                    first_operand = operands.pop();
                    second_operand = operands.pop();
                    operands.push(second_operand / first_operand);
                }
                // Remainder operation.
                else if (token.equals("%")) {
                    first_operand = operands.pop();
                    second_operand = operands.pop();
                    operands.push(second_operand % first_operand);
                }
                // Token is a operand.
                else {
                    operands.push(Integer.parseInt(token));
                }
            }

        return operands.pop();
    }//EvaluatePostfix()
}//Expression
