
public class Solution {

    public static void main(String[] args) {

        int[][] grid = { {1,3,1},{1,5,1},{4,2,1}};

        int value = maxValue_optimization(grid);
        System.out.println(value);
    }

    public static int maxValue(int[][] grid) {

        if(grid == null){
            return -1;
        }

        int rows = grid.length;
        int cols = grid[0].length;

        int[][] dp = new int[rows][cols];

        dp[0][0] = grid[0][0];

        int left = 0,up = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                left = 0;
                up = 0;

                if(i>0){
                    up = dp[i-1][j];
                }

                if(j>0){
                    left = dp[i][j-1];
                }

                dp[i][j] = Math.max(up,left) + grid[i][j];
            }
        }

        return dp[rows-1][cols-1];
    }

    public static int maxValue_optimization(int[][] grid) {

        if(grid == null){
            return -1;
        }

        int rows = grid.length;
        int cols = grid[0].length;

        int[] dp = new int[cols];

        dp[0] = grid[0][0];

        int left = 0,up = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                left = 0;
                up = 0;

                if(i>0){
                    up = dp[j];
                }

                if(j>0){
                    left = dp[j-1];
                }

                dp[j] = Math.max(up,left) + grid[i][j];
            }
        }

        return dp[cols-1];
    }


}
