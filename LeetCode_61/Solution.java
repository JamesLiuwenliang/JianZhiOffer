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

        // 对数组进行排序
        // 这里的时间复杂度是O(n*logn)，也可以通过一个大小是14的哈希表
        Arrays.sort(nums);

        // 统计0的个数
        int zeroCount = 0;

        int i =0 ;
        while(nums[i] == 0){
            zeroCount++;
            i++;
        }
        

        // 统计间隔大小，判断能否用0填补
        if(nums[nums.length-1] - nums[i] <= zeroCount + nums.length-1-i){
            
            // 判断牌里是否含有对子，有的话就不是顺子
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
