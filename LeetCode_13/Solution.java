import java.util.*;

public class Solution {
    
    public static void main(String[] args) {

        System.out.println(movingCount(16,8,4));
        
    }

    public static  int movingCount(int m, int n, int k) {

        if(k<0 || m <=0 || n <=0){
            return 0;
        }

        int res = 0 ;

        boolean[][] possible = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                possible[i][j] = false;
            }
        }

        res = coreCount(m, n ,0,0, possible,k );


        return res;
    }

    private static int coreCount(int rows ,int cols,int row ,int col ,boolean[][] possible , int k){
        int count =0;

        if(isOk(rows,cols,row,col,k ,possible)){
            possible[row][col] = true;

            count = 1+ coreCount(rows,cols,row+1,col,possible,k)+
                    coreCount(rows,cols,row,col+1,possible,k)+
                    coreCount(rows,cols,row,col-1,possible,k)+
                    coreCount(rows,cols,row-1,col,possible,k);
        }

        return count;



    }

    private static boolean isOk(int rows,int cols ,int row ,int col ,int k ,boolean[][] possible){

        if(isDigital(col,row,k)  && row<rows && row >=0 && col < cols && col>=0 && !possible[row][col]){
            return true;
        }else{
            return false;
        }


    }
    
    private static boolean isDigital (int col ,int row,int k){

        if( k >=  col/100 + col/10%10 + col%10 + row/100 + row/10%10 + row%10  ){
            return true;
        }else{
            return false;
        }

    }
    

}