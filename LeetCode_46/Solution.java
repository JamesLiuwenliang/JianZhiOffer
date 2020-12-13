

/**
 *  本质上都是DP的思想,正序与反序结果相同
 */

import java.util.Arrays;
import java.util.HashSet;

public class Solution {

    public static HashSet<String> hashSet ;

    public static void main(String[] args) {
        int number = 12258;
        int result = translateNum_Book(number);
        System.out.println(result);
    }

    // 字符串解析实现
    public static int translateNum_DP(int num) {

        if(num <=  0){
            return 0;
        }

        StringBuffer stringBuffer = new StringBuffer(num+"");

        // dp[i] 表示前 i 个数有几种表示方法，前 0 个数只有 1 种表示方法
        int a = 1,b =1;

        for (int i = 2; i <= stringBuffer.length(); i++) {
            String string = stringBuffer.substring(i-2,i);

            // 这里就是状态转移方程
            // dp[i] = dp[i-1]+dp[i-2] ... [10,25]
            // dp[i] = dp[i-1]         ... [0,10) (25,99]
            int c = string.compareTo("10") >= 0 && string.compareTo("25") <=0 ? a+b : a;
            b = a;
            a = c;

        }

        return a;
    }

    public static int translateNum_Book(int num){
        if(num <=  0){
            return 0;
        }

        StringBuffer stringBuffer = new StringBuffer(num+"");

        return translateNum_BookHelper(stringBuffer);

    }
    public static int translateNum_BookHelper(StringBuffer stringBuffer){
        int[] dp = new int[stringBuffer.length()];

        for (int i = stringBuffer.length()-1; i >= 0 ; i--) {


            if(i < stringBuffer.length()-1){
                dp[i] = dp[i+1];
            }else {
                dp[i] = 1;
            }

            if(i < stringBuffer.length()-1){
                int digit = (stringBuffer.charAt(i) - '0') * 10 + (stringBuffer.charAt(i+1) - '0');
                if(digit >= 10 && digit <=25){
                    if(i<stringBuffer.length()-2){
                        dp[i] += dp[i+2];
                    }else{
                        dp[i] += 1;
                    }
                }

            }


        }

        return dp[0];


    }

}
