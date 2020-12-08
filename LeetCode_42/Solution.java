import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int result = maxSubArray_Book01(nums);
        System.out.println(result);


    }

    public static int maxSubArray_Book01(int[] nums) {

        if(nums.length == 1){
            return nums[0];
        }

        int curSum = 0;

        // 用来记录子串的最大值
        int greatestSum = Integer.MIN_VALUE ;

        for (int i = 0; i < nums.length; i++) {
            if(curSum <= 0 ){
                 curSum = nums[i];
            }else {
                curSum += nums[i];
            }

            if(curSum > greatestSum){
                greatestSum = curSum;
            }

        }

        return greatestSum;

    }

    public static int maxSubArray_Book02(int[] nums){

        if(nums.length == 1){
            return nums[0];
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1]+nums[i] , nums[i]);
            max = Math.max(max,dp[i]);
        }

        return max;
    }

}
