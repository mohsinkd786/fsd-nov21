public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        int i;
        i = 12;
        Integer in = new Integer(12);

        String str = ""; // literal
        String str1 = new String("");

        int[] nums = new int[2];
        nums[0] = 1;
        nums[1] = 2;

        int[] nums1 = {1,28,9};

        int u = nums1[2];

        // loops
        // for loop
        for (int j = 0; j < nums1.length; j++) {
            System.out.println(nums1[i]);
        }

        // while loop
        i = nums.length;
        while(i>0){
            System.out.println(nums[i]);
            i--;
        }

        // for each
        for (int k: nums) {
            System.out.println(k);
        }
    }
}

//class Abc{
//
//}

/**
 * compilation : javac Main.java
 * class file generation : Main.class , Abc.class
 * runtime execution : java Main or java Abc 1 12
 *
 * integer - byte /short / int / long
 * char - char
 * decimal - float / double
 * boolean - boolean
 *
 * */
