public class Problem17
{
    public static void main(String[ ] args)
    {
        Queue<Integer> queue = new Queue<Integer>();

        queue.add(0);
        queue.add(1);
        queue.add(2);

        System.out.println(queue.remove());
        System.out.println(queue.remove());

        queue.add(3);
        queue.add(4);

        System.out.println(queue.remove());
        System.out.println(queue.remove());
    }//main()
}//Problem17