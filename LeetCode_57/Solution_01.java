
import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution_01 {


    public static void main(String[] args) {

        int[] nums = {10,26,30,31,47,60};

        int[] res = twoSum(nums,40);

        System.out.println(Arrays.toString(res));

    }

    public static int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return null;
        }

        int nLeft = 0,nRight = nums.length-1;

        int[] res = new int[2];

        while(nLeft < nRight){

            while((target - nums[nLeft] ) <= nums[nRight]){
                if(target-nums[nLeft] == nums[nRight]){
                    res[0] = nums[nLeft];
                    res[1] = nums[nRight];
                    return res;
                }
                --nRight;
            }

            nLeft++;
            nRight = nums.length-1;

        }
        
        return res;

    }

}
