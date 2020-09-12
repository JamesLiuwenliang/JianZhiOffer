import java.util.*;

public class Solution {


    public static void main(String[] args) {


        char[][] board = {{'a','b','t','g'} , {'c', 'f','c','s'} ,{'j','d','e','h'}};
        String word = "bfce";

//        char[][] board = {{'a'}};
//        String word = "a";

        boolean bool = exist(board,word);
        System.out.println(bool);

    }

    public static boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];

        int pathLength = 0 ;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if(hasPath(board,row,col,pathLength,word,visited)){
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean hasPath(char[][] board ,int row ,int col ,int pathLength , String word ,boolean[][] visited){

        if(pathLength == word.length()){
            return true;
        }

        int rows = board.length;
        int cols = board[0].length;

        boolean hasPath = false;

        if(row >= 0 && row<rows && col>= 0 && col < cols && board[row][col] == word.charAt(pathLength) && !visited[row][col]){

            pathLength++;

            visited[row][col] = true;
            hasPath = hasPath(board,row,col-1,pathLength,word,visited) ||
                    hasPath(board,row-1,col,pathLength,word,visited) ||
                    hasPath(board,row+1,col,pathLength,word,visited) ||
                    hasPath(board,row, col+1,pathLength,word,visited);

            if(!hasPath){
                --pathLength;
                visited[row][col] = false;
            }


        }


        return hasPath;
    }





}