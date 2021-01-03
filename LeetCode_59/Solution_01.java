/**
 *  滑动窗口: 窗口大小-k 暴力的复杂度是O(n*k)
 *  队列方法解解决: 
 */
public class Solution_01 {

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        maxSlidingWindow01(nums,3);

    }

    public static int[] maxSlidingWindow01(int[] nums, int k) {

        if(nums == null || nums.length < k){
            return null;
        }

        if(nums.length == 0){
            return new int[0];
        }


        int[] result = new int[nums.length-k+1];
        int maxIndex = 0;

        for (int i = 0; i < result.length; i++) {
            int maxNum = nums[i];
            for (int j = i+1; j < k+i; j++) {
                maxNum = Math.max(nums[j],maxNum);
            }
            result[i] = maxNum;
        }

        return result;

    }
}
