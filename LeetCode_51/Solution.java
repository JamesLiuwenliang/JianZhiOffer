// 归并排序算法： O(n * logn)
public class Solution {

    public static void main(String[] args) {

        int[] array = {7,5,6,4};
//        System.out.println(reversePairs_violence(array));
        System.out.println(reversePairs(array));

    }

    public static  int reversePairs_violence(int[] nums) {

        if(nums.length == 0){
            return 0;
        }

        int count = 0 ;
        for (int i = 0; i < nums.length - 1; i++) {

            int tmp = nums[i];
            for (int j = i+1; j < nums.length; j++) {
                if(tmp > nums[j]){
                    count++;
                }
            }
        }

        return count;
    }

    public static int reversePairs(int[] nums){

        if(nums.length == 0 || nums == null){
            return 0;
        }

        int[] copy = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            copy[i] = nums[i];
        }

        // 归并算法的精髓
        return reversePairs_helper(nums,copy,0,nums.length-1);

    }

    private static int reversePairs_helper(int[] nums,int[] copy ,int start,int end){

        if(start == end){
            copy[start] = nums[start];
            return 0;
        }

        int length = (end-start)/2;

        int left = reversePairs_helper(copy,nums,start,start+length);
        int right = reversePairs_helper( copy,nums, start+length+1, end);

        // leftEnd初始化前半段最后一个数字的下标
        int leftEnd = start+length;

        // rigntEnd初始化为后半段最后一个数字的下标
        int rightEnd = end;

        int indexCopy = end;
        int count = 0;

        while((leftEnd >= start) && ( rightEnd >= start+length+1)){
            if(nums[leftEnd] > nums[rightEnd]){
                // 左侧的数据大于右侧的数据 --> 产生逆序对
                copy[indexCopy--] = nums[leftEnd--];
                // 产生的逆序对的数量
                // 因为此时的左右两侧序列都是排好序的，而且nums[leftEnd]， nums[rightEnd]是两侧的最大值，
                // 所以当发现leftEnd>rightEnd的时候，总的逆序数量就是右侧剩余的数量

                // 左侧:5,7(leftP) 右侧:4,6(rightP),8 合并数组:xxxx8
                // 此时 leftP > rightP  --> 产生的逆序对是7对 4,6共同产生的
                count += rightEnd-start-length;
            }else{
                copy[indexCopy--] = nums[rightEnd--];
            }
        }

        // 左侧或者右侧的数据有一组全部弄完了，将另一组全部放入copy数组内
        for ( ; leftEnd >= start ; ) {
            copy[indexCopy--] = nums[leftEnd--];
        }

        for ( ; rightEnd >= start+length+1 ; ) {
            copy[indexCopy--] = nums[rightEnd--];
        }

        // left right 是之前的左右两侧的产生的逆序对数量
        // count是这次左右合并产生的逆序对的数量
        return left + right + count;

    }


}
