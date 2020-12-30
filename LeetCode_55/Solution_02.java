
import java.util.ArrayList;

public class Solution_02 {

    public static boolean isAllBalace ;

    public static class TreeNode55_02 {
        int val;
        TreeNode55_02 left;
        TreeNode55_02 right;
        TreeNode55_02(int x) { val = x; }
    }

    public static void main(String[] args) {
        TreeNode55_02 root = new TreeNode55_02(3);

        TreeNode55_02 node01 = new TreeNode55_02(9);
        TreeNode55_02 node02 = new TreeNode55_02(20);
        TreeNode55_02 node03 = new TreeNode55_02(15);
        TreeNode55_02 node04 = new TreeNode55_02(7);


        System.out.println(isBalanced(root));

        System.out.println(isBalanced_Book(root));


    }
    public static  boolean isBalanced(TreeNode55_02 root) {
        if(root == null){
            return true;
        }

        int nLeft = getDepth(root.left);
        int nRight = getDepth(root.right);
        int diff = Math.abs(nLeft-nRight);

        if(diff > 1){
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);

    }

    public static int getDepth(TreeNode55_02 root){
        if(root == null){
            return 0;
        }

        int nLeft = getDepth(root.left);
        int nRight = getDepth(root.right);

        return Math.max(nLeft,nRight) + 1;
    }

    public static  boolean isBalanced_Book(TreeNode55_02 root){
        if(root == null){
            return true;
        }

        isAllBalace = true;


        return (Math.abs(isBalanced_BookHelper(root.left) - isBalanced_BookHelper(root.right) ) <=1 )&& isAllBalace == true;

    }

    private static int isBalanced_BookHelper(TreeNode55_02 root){
        if(root == null){
            return 0;
        }

        int nLeft = isBalanced_BookHelper(root.left);

        int nRight = isBalanced_BookHelper(root.right);


        if(Math.abs(nLeft-nRight) > 1){
            isAllBalace = false;
        }

        return Math.max(nLeft,nRight) + 1;


    }



}
