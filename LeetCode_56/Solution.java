import java.util.Arrays;

/**
 *  应用异或特性的例子
 */
public class Solution {


    public static void main(String[] args) {

        int[] nums = {1,2,10,4,1,4,3,3};

//        int[] nums = {2,4,3,6,3,2,5,5};
//        int[] nums = {4,1,4,6};
        int[] res = singleNumbers(nums);
        System.out.println(Arrays.toString(res));
    }

    public static int[] singleNumbers(int[] nums) {


        if(nums == null || nums.length<2) {
            return null;
        }

        int[] result = new int[2];

        int resultXOR = 0;
        for (int i = 0; i < nums.length; i++) {
            // 以nums为例,结果是0x0010,意味着nums里面的数字二进制的倒数第二位是1的单独分1组，是0的单独分一组
            resultXOR ^= nums[i];
        }

        int indexOf1 = findFirstBitsIs1(resultXOR);

        for (int i = 0; i < nums.length; i++) {

            String str = Integer.toBinaryString(nums[i]);

            if( str.length() > indexOf1 && str.charAt(str.length()-indexOf1-1) == '1'){

                // 倒数第indexOf1位是1
                result[0] ^= nums[i];
            }else{

                // 倒数第indexOf1位是0
                result[1] ^= nums[i];
            }


        }


        return result;

    }

    // 从后往前数,即倒数
    private static int findFirstBitsIs1(int resultXOR){


        String str = Integer.toBinaryString(resultXOR);

        for (int i = str.length()-1; i >= 0; i--) {
            if(str.charAt(i) == '1'){

                return str.length()-i -1;
            }
        }

        return 0;

    }


}
