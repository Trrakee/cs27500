import java.util.Stack;

public class Problem7
{
    public static void main(String[ ] args)
    {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(5);
        System.out.println("stack.push(5);");
        System.out.println(stack.toString());
        stack.push(3);
        System.out.println("stack.push(3);");
        System.out.println(stack.toString());
        stack.pop();
        stack.push(2);
        System.out.println("stack.push(2);");
        System.out.println(stack.toString());
        stack.push(8);
        System.out.println("stack.push(8);");
        System.out.println(stack.toString());
        stack.pop();
        stack.pop();
        stack.push(9);
        System.out.println("stack.push(9);");
        System.out.println(stack.toString());
        stack.push(1);
        System.out.println("stack.push(1);");
        System.out.println(stack.toString());
        stack.pop();
        stack.push(7);
        System.out.println("stack.push(7);");
        System.out.println(stack.toString());
        stack.push(6);
        //
        // Maximum number of elements on the stack occur here.
        //
        System.out.println("stack.push(6);");
        System.out.println(stack.toString());
        stack.pop();
        stack.pop();
        stack.push(4);
        System.out.println("stack.push(4);");
        System.out.println(stack.toString());
        stack.pop();
        stack.pop();
        System.out.println("END");
        System.out.println(stack.toString());
    }//main()
}//Problem7