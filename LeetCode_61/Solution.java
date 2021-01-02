import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {

        int[] nums = {11,0,9,0,0};
        System.out.println(isStraight(nums));

    }

    public static boolean isStraight(int[] nums) {

        if(nums == null || nums.length != 5){
            return false;
        }

        Arrays.sort(nums);

        int zeroCount = 0;

        int i =0 ;
        while(nums[i] == 0){
            zeroCount++;
            i++;
        }

        System.out.println(nums[nums.length-1] - nums[i]);
        System.out.println(zeroCount + nums.length-1-i);

        if(nums[nums.length-1] - nums[i] <= zeroCount + nums.length-1-i){
            for (int j = i; j < 4; j++) {
                if(nums[j] == nums[j+1]){

                    return false;
                }
            }
            return true;
        }else{
            return false;
        }



    }
}
