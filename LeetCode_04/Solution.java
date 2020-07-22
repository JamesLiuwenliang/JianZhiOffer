import java.util.*;

public class Solution {
    public static void main(String[] args) {
//        int[][] nums = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int[][] nums = null;
        Boolean bool = findNumberIn2DArray(nums,5);


        System.out.println(bool);
    }



    public static boolean findNumberIn2DArray(int[][] matrix, int target) {

        boolean found = false;


        if(matrix!= null && matrix.length >0 && matrix[0].length >0) {
            final int ROW = matrix.length;
            final int COLUMN = matrix[0].length;
            int row = 0;
            int column = COLUMN - 1;

            while (row < ROW && column >= 0) {
                if (matrix[row][column] == target) {
                    found = true;
                    break;
                } else if (matrix[row][column] > target) {
                    --column;
                } else {
                    ++row;
                }
            }

        }


        return found;

    }

    public static boolean findNumberIn2DArray02(int[][] matrix, int target) {


        HashMap<Integer,Integer> hashMap = new HashMap<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == target){
                    return  true;
                }
            }
        }

        return false;




    }

}