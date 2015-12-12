/**
 * CAN ONLY USE push() AND pop() FOR THE STACK OPERATIONS
 * AND add() AND remove() FOR THE QUEUE OPERATIONS.
 *
 * END WITH STACK s WITH THE CONTENTS (3 1 2) WITH 3 AS
 * THE TOP-OF-THE-STACK.
 */

import java.util.ArrayDeque;
import java.util.Stack;

public class Problem8B
{
    public static void main(String[ ] args)
    {
        Stack<Integer> stack = new Stack<Integer>();
        ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
        stack.push(3);
        stack.push(2);
        stack.push(1);

        queue.add(stack.pop());     // A
        queue.add(stack.pop());     // B
        queue.add(stack.pop());     // C
        queue.add(queue.remove());  // D
        stack.push(queue.remove()); // E
        queue.add(queue.remove());  // F
        stack.push(queue.remove()); // G
        stack.push(queue.remove()); // H

        // CHECK!
        // SHOULD PRINT:
        // 3
        // 1
        // 2
        System.out.println(stack.toString());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }//main()
}//Problem8B