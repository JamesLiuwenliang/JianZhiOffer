
import java.util.Arrays;
import java.util.HashMap;

public class Solution {


    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 2, 2, 2, 5, 4, 2};

        int tmp = majorityElement_BookPartition(nums);

        System.out.println(tmp);
    }

    public static int majorityElement(int[] nums) {

        if(nums.length <= 0){
            return -1;
        }

        int cnt = 0;
        HashMap<Integer,Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(hashMap.containsKey(num)){
                hashMap.put(num,hashMap.get(num)+1);
            }else{
                hashMap.put(num,1);
            }

        }

        int max = 0;
        int maxNum = 0 ;
        for (Integer integer : hashMap.keySet()) {
            if(hashMap.get(integer) > max){
                max = hashMap.get(integer);
                maxNum = integer;
            }
        }

        return maxNum;
    }

    public static int majorityElement_BookPartition(int[] nums) {

        int number = nums[0];
        if(nums == null || nums.length<=0){
            return -1;
        }

        // 排序后是最中间的值
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));


        number = nums[nums.length/2];
        if(!moreThanHalf(nums,number)){
            return -1;
        }

        return number;

    }

    public static boolean moreThanHalf(int[] nums,int number){
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if(number == nums[i]){
                count++;
            }
        }

        return count >= nums.length/2 ? true : false;

    }

    // 很巧妙的方法
    public static int majorityElement_Book02(int[] nums){
        int number = nums[0];
        if(nums == null || nums.length<=0){
            return -1;
        }

        int cnt  = 1;

        // 这种方法建立在这个数组中最多的那个数是占到总数的1/2还要多的情况上
        // 所以定义一个信号量统计
        for (int i = 1; i < nums.length; i++) {
            if(cnt == 0){
                number = nums[i];
                cnt = 1;
            }else if(number == nums[i]){
                cnt++;
            }else{
                cnt--;
            }
        }

        return number;

    }



}
