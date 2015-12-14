public class Problem18
{
    public static void main(String[ ] args)
    {
        Stack<Integer> stack = new Stack<Integer>();

        stack.push(0);
        stack.push(1);
        stack.push(2);

        System.out.println(stack.pop());
        System.out.println(stack.pop());

        stack.push(3);
        stack.push(4);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }//main()
}//Problem18