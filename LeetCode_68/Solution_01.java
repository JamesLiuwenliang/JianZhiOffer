
import DataStruct.ThreadedBinaryTree.TreeNode;

public class Solution_01 {

    private static TreeNode68_01 rootForPQ = null;

    public static class TreeNode68_01 {
        int val;
        TreeNode68_01 left;
        TreeNode68_01 right;
        TreeNode68_01(int x) { val = x; }
    }

    public static void main(String[] args) {

        // 二叉搜索树
        TreeNode68_01 root = new TreeNode68_01(6);
        TreeNode68_01 node0 = new TreeNode68_01(0);
        TreeNode68_01 node2 = new TreeNode68_01(2);
        TreeNode68_01 node3 = new TreeNode68_01(3);
        TreeNode68_01 node4 = new TreeNode68_01(4);
        TreeNode68_01 node5 = new TreeNode68_01(5);
        TreeNode68_01 node7 = new TreeNode68_01(7);
        TreeNode68_01 node8 = new TreeNode68_01(8);
        TreeNode68_01 node9 = new TreeNode68_01(9);

        root.left = node2; root.right = node8;node2.left = node0; node2.right = node4;
        node4.left = node3; node4.right = node5; node8.left = node7; node8.right = node9;


        midShow(root);
        System.out.println();

        lowestCommonAncestor(root,node2,node8);
        System.out.println(rootForPQ.val);



    }

    public static TreeNode68_01 lowestCommonAncestor(TreeNode68_01 root, TreeNode68_01 p, TreeNode68_01 q) {

        if( root == null || p == null || q == null ){
            return null;
        }

        if(p == q) {
            return p;
        }

        TreeNode68_01 nodeMin,nodeMax;
        if(p.val > q.val){
            nodeMin = q;
            nodeMax = p;
        }else{
            nodeMin = p;
            nodeMax = q;
        }


        lowestCommonAncestor_helper(root ,nodeMin,nodeMax);



        return rootForPQ;
    }

    private static void lowestCommonAncestor_helper(TreeNode68_01 root,TreeNode68_01 nodeMin ,TreeNode68_01 nodeMax ){


        if(root == null){
            return;
        }


        if(root.val <= nodeMax.val && root.val >= nodeMin.val){
            rootForPQ = root;

        }else if(root.val < nodeMin.val ){

            lowestCommonAncestor_helper(root.right,nodeMin,nodeMax);

        }else if(root.val > nodeMax.val){
            lowestCommonAncestor_helper(root.left,nodeMin,nodeMax);

        }


    }

    private static void midShow(TreeNode68_01 root){

        if(root == null){
            return;
        }

        midShow(root.left);

        System.out.print(root.val+" ");

        midShow(root.right);

    }

}
