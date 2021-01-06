
import java.util.Arrays;


public class Solution {

    private static int[] probalities;

    public static void main(String[] args) {

        System.out.println(Arrays.toString(dicesProbability(11)));
        System.out.println("------------------------------------------------");
//        System.out.println(Arrays.toString(dicesProbability_Recursion(11 )));
//        System.out.println("------------------------------------------------");
        System.out.println(Arrays.toString(dicesProbability_LeetCode(11)));

    }


    // DP
    public static double[] dicesProbability(int n) {

        if(n < 0){
            return null;
        }

        if(n == 0){
            return new double[]{1.0f};
        }

        int[][] dp = new int[n+1][6*n+1];
        double[] result = new double[6*n-n+1];
        double total = Math.pow(6,n);

        for (int i = 1; i <= 6 ; i++) {
            dp[1][i] = 1;
        }

        // 状态转移方程 dp[i][j] = \sum_{cur=1}^{6} dp[i-1][j-cur]
        // i 表示阶段，j 表示投掷完 i 枚骰子后的点数和，cur 表示第 i 枚骰子会出现的六个点数。

        for (int i = 2; i <= n ; i++) {

            for (int j = i; j <= 6*n; j++) {

                for (int cur = 1; cur <= 6 ; cur++) {

                    // 当前剩余需要的点数和小于当前第i枚骰子的面的大小，则可以返回
                    // 递归实现也是需要这个判断的
                    if (j - cur <= 0) {
                        break;
                    }
                    dp[i][j] += dp[i-1][j-cur];
                }
            }
        }

        // print
        for (int i = 0; i <= dp.length-1 ; i++) {
            for (int j = 0; j <= dp[0].length-1  ; j++) {
                System.out.print(dp[i][j]+"   ");
            }
            System.out.println();
        }

        for (int i = n; i < 6*n+1; i++) {
            result[i-n] = (dp[n][i] * 1.0)  /total;
        }




        return result;

    }

    public static double[] dicesProbability_LeetCode(int n) {

        if (n < 0) {
            return null;
        }

        if (n == 0) {
            return new double[]{1.0f};
        }

        int[] dp = new int[70];
        double[] result = new double[6 * n - n + 1];
        double total = Math.pow(6, n);

        for (int i = 1; i <= 6; i++) {
            dp[i] = 1;
        }

        // 每个阶段只与前一个阶段有关，所以只需要保存上一个阶段的就可以
        for (int i = 2; i <= n ; i++) {

            for (int j = 6*i; j >= i ; j--) {
                dp[j] = 0;

                for (int cur = 1; cur <= 6 ; cur++) {

                    if (j - cur < i-1) {
                        break;
                    }

                    // 当利用一位数组的时候，第n项等于前面那轮的第n-1，n-2，n-3，n-4，n-5，n-6项的和
                    dp[j] += dp[j-cur];
                }
            }
        }

        for (int i = n; i < 6*n+1; i++) {
            result[i-n] = (dp[i] * 1.0)  /total;
        }

        return result;

    }

    public static double[] dicesProbability_Recursion(int n) {
        if(n < 0){
            return null;
        }

        if(n == 0){
            return new double[]{1.0f};
        }

        double[] result = new double[5*n+1];

        double total = Math.pow(6,n);

        int index = 0;

        for (int i = n; i <= 6*n ; i++) {
            // 表示投掷 n 枚骰子，点数 k 出现的次数
            result[index++] = getCount(n, i) * 1.0 / total;
        }

        return result;
    }

    private static int getCount(int n,int k){

        if(n == 1 && k > 6){
            return 0;
        }

        if(n == 1 ){
            return 1;
        }

        int total = 0;

        for (int i = 1; i <= 6 ; i++ ) {
            if(k - i <= 0){
                break;
            }
            total += getCount(n-1,k-i);
        }

        return total;

    }
}
