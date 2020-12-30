
import java.util.ArrayList;

public class Solution_01 {

    public static ArrayList<Integer> arrayList;
    public static int depth;

    public static class TreeNode55 {
        int val;
        TreeNode55 left;
        TreeNode55 right;
        TreeNode55(int x) { val = x; }
    }

    public static void main(String[] args) {

        TreeNode55 root = new TreeNode55(3);

        TreeNode55 node01 = new TreeNode55(9);
        TreeNode55 node02 = new TreeNode55(20);
        TreeNode55 node03 = new TreeNode55(15);
        TreeNode55 node04 = new TreeNode55(7);

        root.left = node01;root.right = node02; node02.left = node03; node02.right = node04;

//        midShow(root);

//        System.out.println(maxDepth(root));

        System.out.println(maxDepth_Book(root));

    }

    private static void midShow(TreeNode55 treeNode55){

        if(treeNode55 == null){
            return;
        }
        midShow(treeNode55.left);
        System.out.print(treeNode55.val+" ");


        midShow(treeNode55.right);

    }

    public static int maxDepth(TreeNode55 root) {

        if(root == null){
            return 0;
        }

        arrayList = new ArrayList<>();
        depth = 0;
        maxDepth_helper(root);

        int max = 0;
        for (Integer integer : arrayList) {
            max = integer > max ?  integer : max;
        }



        return max;
    }

    private static void maxDepth_helper(TreeNode55 node){

        if(node == null){
            arrayList.add(depth);
            return ;
        }
        depth++;
        maxDepth_helper(node.left);

        maxDepth_helper(node.right);

        depth--;



    }


    public static int maxDepth_Book(TreeNode55 root){
        if(root == null){
            return 0;
        }

        int nLeft = maxDepth_Book(root.left);
        int nRight = maxDepth_Book(root.right);

        return Math.max(nLeft,nRight) + 1;
    }




}
