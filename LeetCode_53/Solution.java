


public class Solution {

    public static void main(String[] args) {

        int[] nums = {2,2};

        System.out.println(search(nums,2));

    }

    public static int search(int[] nums, int target) {

        if(nums.length == 0|| nums == null){
            return 0;
        }

        if(nums[nums.length-1] < target){
            return 0;
        }

        int right = nums.length-1 ;
        int left = 0;
        int mid = (right -left)/2;
        int cnt = 0;

        while(left < right) {

            if(nums[mid] == target){
                break;
            }else if(nums[mid] < target){
                left = mid +1;
            }else if(nums[mid] > target){
                right = mid-1 ;
            }

            mid = left + (right-left)/2;
        }

        int tmp = mid;
        while( mid >= 0 && (nums[mid--] == target)){
            cnt++;
        }
        mid = tmp+1;
        while( mid < nums.length && nums[mid++] == target){
            cnt++;
        }
        
        return cnt;
        
    }

    // 这个二分写的比我的强
    public static int search_LeetCode(int[] nums, int target) {
        int left =0,right = nums.length-1;
        int count = 0;
        while(left<right){
            int mid = (left+right)/2;
            if(nums[mid]>=target)
                right=mid;
            if(nums[mid]<target)
                left = mid+1;
        }
        while(left<nums.length&&nums[left++]==target)
            count++;
        return count;
    }

}

