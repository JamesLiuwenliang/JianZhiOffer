
public class Solution{

    public static void main(String[] args) {

        int[] nums = {1,2,3,4};
        int[] new_nums = exchange(nums);

    }

    public static int[] exchange(int[] nums) {

        if(nums == null){
            return null;
        }

        int[] new_nums = new int[nums.length];
        int index = nums.length-1;
        int index0 = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] % 2== 0){
                new_nums[index--] = nums[i];
            }else{
                new_nums[index0++] = nums[i];
            }
        }

        for (int i = 0; i < new_nums.length; i++) {
            System.out.print(new_nums[i]+" ");
        }


        return nums;

    }


}
