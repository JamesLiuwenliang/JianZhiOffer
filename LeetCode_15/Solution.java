import java.util.*;

public class Solution {

    public static void main(String[] args) {


        System.out.println(hammingWeight(120));
    }

    // you need to treat n as an unsigned value
    public static int hammingWeight(int n) {

        int cnt = 0;

        // Java 提供的方法
//        cnt = Integer.bitCount(n);

        while(n != 0){
            if((n&1) == 1){
                cnt ++;
            }
            
            // Java右移补0的符号是 >>>
            // 如果用>> 面对负数的时候会重复补1
            n = n >>> 1;
        }


        return cnt ;
    }

}
