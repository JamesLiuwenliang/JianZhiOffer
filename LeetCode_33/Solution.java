import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

        int[] backShowA = {};


        System.out.println(verifyPostorder(backShowA));

        System.out.println("Hello World");

    }

    public static boolean verifyPostorder(int[] postorder){

        if(postorder == null || postorder.length == 0){
            return true;
        }
        return verifyPostorderMain(postorder);
    }

    public static boolean verifyPostorderMain(int[] postorder) {

        if(postorder == null || postorder.length <= 0){
            return false;
        }

        boolean left=true ,right=true;
        int indexLeftTree = 0;

        int root = postorder[postorder.length-1];
        int i = 0;
        for (; i < postorder.length-1; i++) {
            if(postorder[i] > root){
                indexLeftTree = i; // [0,indexLeftTree]都是左子树，右也是闭
                break;
            }
        }

        indexLeftTree = i;


        for (i = indexLeftTree; i < postorder.length; i++) {

            if(postorder[i] < root){
                return false;
            }
        }

        if(indexLeftTree > 0){
            left = verifyPostorderMain(Arrays.copyOfRange(postorder,0,indexLeftTree));
        }

        if(indexLeftTree < postorder.length-1){
            right = verifyPostorderMain(Arrays.copyOfRange(postorder,indexLeftTree,postorder.length-1));
        }

        return left && right;

    }


}
