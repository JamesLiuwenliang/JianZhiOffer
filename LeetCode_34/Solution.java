import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {



    public static class TreeNode34 {
        int val;
        TreeNode34 left;
        TreeNode34 right;
        TreeNode34(int x) { val = x; }
    }

    public static void main(String[] args) {
        TreeNode34 treeRoot =  new TreeNode34(5);
        TreeNode34 treeNode1 = new TreeNode34(4);
        TreeNode34 treeNode2 = new TreeNode34(8);
        TreeNode34 treeNode3 = new TreeNode34(11);
        TreeNode34 treeNode4 = new TreeNode34(13);
        TreeNode34 treeNode5 = new TreeNode34(4);
        TreeNode34 treeNode6 = new TreeNode34(7);
        TreeNode34 treeNode7 = new TreeNode34(2);
        TreeNode34 treeNode8 = new TreeNode34(5);
        TreeNode34 treeNode9 = new TreeNode34(1);

        treeRoot.left  = treeNode1;
        treeRoot.right = treeNode2;
        treeNode1.left = treeNode3;
        treeNode2.left= treeNode4;
        treeNode2.right= treeNode5;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;
        treeNode5.left = treeNode8;
        treeNode5.right = treeNode9;

//        TreeNode34 treeRoot =  new TreeNode34(10);
//        TreeNode34 treeNode1 = new TreeNode34(5);
//        TreeNode34 treeNode2 = new TreeNode34(12);
//        TreeNode34 treeNode3 = new TreeNode34(4);
//        TreeNode34 treeNode4 = new TreeNode34(7);
//
//
//        treeRoot.left  = treeNode1;
//        treeRoot.right = treeNode2;
//        treeNode1.left = treeNode3;
//        treeNode1.right= treeNode4;


        midShow(treeRoot);
        System.out.println();
        System.out.println("----------------------------");

        List<List<Integer>> list = pathSum(treeRoot,22);

        System.out.println("***************************");
        for (List<Integer> integers : list) {
            for (Integer integer : integers) {
                System.out.print(integer+" ");
            }
            System.out.println();
        }


        System.out.println("Hello World");
    }

    public static List<List<Integer>> pathSum(TreeNode34 root, int sum) {

        List<List<Integer>> listResult = new ArrayList<>();

        if(root == null || sum <0){
            return listResult;
        }


        Stack<TreeNode34> stack = new Stack<>();


        pathSumMain(root,sum,stack,listResult);

        return listResult;

    }

    private static void pathSumMain(TreeNode34 root, int sum,Stack<TreeNode34> stack, List<List<Integer>> listResult ) {



        if(root.left == null && root.right == null){
            stack.push(root);

//            System.out.println("----------------");
//            for (TreeNode34 treeNode34 : stack) {
//                System.out.println(treeNode34.val+" ");
//            }
//            System.out.println("----------------");

            int count =  0;
            for (TreeNode34 treeNode34 : stack) {
                count += treeNode34.val;
            }
            if(count == sum){
                List<Integer> listInner = new ArrayList<>();
                for (TreeNode34 treeNode34 : stack) {
                    listInner.add(treeNode34.val);
                }
                listResult.add(listInner);

            }
            stack.pop();

            return ;
        }

        stack.push(root);


        if(root.left != null){
            pathSumMain(root.left,sum,stack,listResult);
        }

        if(root.right != null){
            pathSumMain(root.right , sum ,stack,listResult);
        }
        stack.pop();
        return;

    }

    private static void midShow(TreeNode34 root){

        if(root.left!=null){
            midShow(root.left);
        }

        System.out.print(root.val+" ");

        if(root.right != null){
            midShow(root.right);
        }

        return;
    }

}
