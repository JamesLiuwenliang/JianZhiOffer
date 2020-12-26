/**
 * 状态定义： 设动态规划列表 dp ，dp[i]代表第 i+1 个丑数。
 * 转移方程：
 *      当索引 a, b, c满足以下条件时， dp[i]为三种情况的最小值；
 *      每轮计算 dp[i] 后，需要更新索引a, b, c的值，使其始终满足方程条件。
 *      实现方法：分别独立判断 dp[i] 和 dp[a]×2 , dp[b]×3 , dp[c]×5 的大小关系，若相等则将对应索引 a,b,c 加 1 。
 *
 *          dp[a]*2 > dp[i-1] ≥ dp[a-1]*2
 *          dp[b]*3 > dp[i-1] ≥ dp[b-1]*3
 *          dp[c]*5 > dp[i-1] ≥ dp[c-1]*5
 *
 *      dp[i] = min{dp[a]*2 , dp[b]*3 , dp[c]*5}
 *
 *  初始状态：
 *      dp[0] = 1,即第一个丑数 1
 *  返回值 ：
 *      dp[n-1],即返回第 n 个丑数
 */

public class Solution {

    public static void main(String[] args) {

        int res = nthUglyNumber(10);

        System.out.println(res);

    }

    public static int nthUglyNumber(int n) {

        if(n <= 0 || n > 1690){
            return -1;
        }

        int[] dp = new int[n];
        dp[0] = 1;


        int index2 = 0,index3 = 0,index5 = 0;

        for (int i = 1; i < n; i++) {

            int n2 = dp[index2]*2 , n3 = dp[index3]*3, n5 = dp[index5]*5;

            // 状态转移方程
            dp[i] = Math.min(dp[index2]*2 , Math.min(dp[index3] * 3,dp[index5] *5));

            // 判断条件，满足即对应索引加1
            if(dp[i] == n2) index2++;
            if(dp[i] == n3) index3++;
            if(dp[i] == n5) index5++;

        }

        return dp[n-1];

    }


}
