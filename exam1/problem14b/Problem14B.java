class Problem14B
{
    public static void main(String[ ] args)
    {
//        int[] A = [1, 1]; // n=2
//        int[] A = [1, 2, 2]; // n=3
//        int[] A = [1, 2, 3, 3]; // n=4
//        int[] A = [1, 2, 3, 4, 4]; // n=5
        IntArray int_array = new IntArray(5);
        int[] A = int_array.getArray();
        System.out.println("int_array.toString()");
        System.out.println(int_array.toString());

        System.out.println("");

        int repeated_value = IntArray.findRepeatedNumber(A);
        System.out.println("repeated_value");
        System.out.println(repeated_value);

        System.out.println("");
    }//main()
}//Problem14B