/**
 * 利用二分搜索的思路实现，但是不健壮，源自Q3的第二种问题
 */
public class Solution02 {
    public static void main(String[] args) {
        // 这种方式就解决不了问题
        int[] nums = new int[]{0, 1, 2, 0, 4, 5, 6, 7, 8, 9};
        int mid = findRepeatNumber(nums);

        System.out.println(mid);
    }

    public static int findRepeatNumber(int[] nums) {

        int start =0;
        int end = nums.length-1;

        while(end>=start){
            int mid=((end -start)>>1) + start;
            int count = countRange(nums ,start,mid);
            if(end == start){
                if(count > 1){
                    return start;
                }else{
                    break;
                }

            }

            if (count > (mid - start +1 )) {
                end = mid;
            }else {
                start = mid+1;
            }
        }

        return -1;

    }

    private static int countRange( int[] nums, int start, int end){
        int cnt =0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>=start && nums[i] <= end){
                ++cnt;
            }
        }
        return  cnt;
    }

}