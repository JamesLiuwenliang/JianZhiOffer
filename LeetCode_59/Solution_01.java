import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_01 {

    public static void main(String[] args) {

        int[] nums02 = {2,3,4,2,6,2,5,1};
        int[] nums03 = {4,-2};

//        maxSlidingWindow_violence(nums,3);
        int[] res = maxSlidingWindow_Book(nums03,2);

        System.out.println(Arrays.toString(res));

    }



    public static int[] maxSlidingWindow_Book(int[] nums, int k) {

        if(nums == null || nums.length < k){
            return null;
        }

        if(nums.length == 0){
            return new int[0];
        }

        if(k == 1){
            return nums;
        }

        // 存下标，别存数值
        Deque<Integer> deque = new LinkedList<>();
        int[] result = new int[nums.length-k+1];
        int resIndex = 0;


        for (int i = 0; i < k; i++) {
            while(!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]){
                deque.pollLast();
            }

            deque.addLast(i);
        }

//        for (Integer integer : deque) {
//            System.out.print(nums[integer]+" ");
//        }
//
//        System.out.println();

        for (int i = k; i < nums.length; i++) {

            result[resIndex++] = nums[deque.peek()];

            while(!deque.isEmpty() && (nums[i] >= nums[deque.getLast()])){
                deque.pollLast();
            }
            if(!deque.isEmpty() && deque.peek() <= (i-k)){
                deque.pollFirst();
            }

            deque.addLast(i);

        }
        result[resIndex] = nums[deque.peekFirst()];


        return result;


    }

    public static int[] maxSlidingWindow_violence(int[] nums, int k) {

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
