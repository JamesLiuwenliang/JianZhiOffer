import java.util.HashMap;

public class Solution {

    public static void main(String[] args) {
        System.out.println("Hello World");
    }

    public int findRepeatNumber(int[] nums) {

        // 哈希表的时间复杂度是O(n)，但是哈希表同时牺牲了O(n)的空间复杂度
        HashMap hashmap = new HashMap();
        for(int i=0;i<nums.length;i++){
            if(hashmap.containsKey(nums[i])){
                return nums[i];
            }else{
                hashmap.put(nums,1);
            }
        }
        return 0;

    }


    public int findRepeatNumber_Offer(int[] nums) {

        for(int i= 0;i<nums.length;i++){
            while(nums[i] != i){
                if(nums[i] == nums[nums[i]]){
                    return nums[i];
                }

                int tmp = nums[i];
                nums[i] = nums[tmp];
                nums[tmp] = tmp;
            }

        }

        return -1;

    }
}