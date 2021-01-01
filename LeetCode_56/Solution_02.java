

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Solution_02 {

    public static void main(String[] args) {

        int[] nums = {3,4,3,3};
        int res = singleNumber(nums);
        System.out.println("res: "+res);
        
        

    }

    public static int singleNumber(int[] nums) {
        
        if(nums == null || nums.length == 0){
            return -1;
        }
        
        if(nums.length == 1) {
            return nums[0];
        }

        int[] numBinary = new int[32];


        for (int i = 0; i < nums.length; i++) {
            char[] chars = Integer.toBinaryString(nums[i]).toCharArray();

            System.out.println(Arrays.toString(chars));

            int index = 0;
            for (int j = chars.length-1; j >=0 ; j--) {

                numBinary[index++] += chars[j] - '0';

            }
        }

        System.out.println(Arrays.toString(numBinary));

        int index2 = 0;
        int result = 0;
        for (int i = 0; i < numBinary.length ; i++) {

            if(numBinary[i] == 0 || numBinary[i] % 3== 0){
                index2++;
                continue;
            }else {

                result += Math.pow(2,index2);
                index2++;
            }

        }


        return result;
        

    }


}
