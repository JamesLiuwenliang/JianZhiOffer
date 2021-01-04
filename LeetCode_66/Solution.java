
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

        int[] nums = {1,2,3,4,5};
        System.out.println(Arrays.toString(constructArr(nums)));

    }

    public static int[] constructArr(int[] a) {

        if(a == null){
            return null;
        }else if(a.length == 0){
            return new int[0];
        }

        // B[i] = A[0]*A[1]...*A[i-1]  *  A[i+1]*A[i+2]...*A[n]
        int[] result = new int[a.length];
        int total = 1;

        // A[0]*A[1]...*A[i-1]
        for (int i = 0, product = 1 ; i < a.length; product *= a[i],  i++) {
            result[i] = product;
        }

        System.out.println(Arrays.toString(result));

        // A[i+1]*A[i+2]...*A[n]
        for (int i = a.length-1 , product = 1  ; i >= 0 ; product *= a[i], i--) {
            result[i] *= product;
        }


        return result;
    }

}
