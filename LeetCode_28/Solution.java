
public class Solution {


    public static class TreeNode28 {
        int val;
        TreeNode28 left;
        TreeNode28 right;
        TreeNode28(int x) { val = x; }
    }

    public static void main(String[] args) {

        // 3 2 4 1 4 2 3
//        TreeNode28 treeRoot = new  TreeNode28(1);
//        TreeNode28 treeNode1 = new TreeNode28(2);
//        TreeNode28 treeNode2 = new TreeNode28(2);
//        TreeNode28 treeNode3 = new TreeNode28(3);
//        TreeNode28 treeNode4 = new TreeNode28(3);
//        TreeNode28 treeNode5 = new TreeNode28(4);
//        TreeNode28 treeNode6 = new TreeNode28(4);
//
//        treeRoot.left  = treeNode1;
//        treeRoot.right = treeNode2;
//        treeNode1.left = treeNode3;
//        treeNode1.right= treeNode5;
//        treeNode2.right= treeNode4;
//        treeNode2.left = treeNode6;

        // 2 3 1 2 3
        TreeNode28 treeRoot = new  TreeNode28(1);
        TreeNode28 treeNode1 = new TreeNode28(2);
        TreeNode28 treeNode2 = new TreeNode28(2);
        TreeNode28 treeNode3 = new TreeNode28(3);
        TreeNode28 treeNode4 = new TreeNode28(3);

        treeRoot.left  = treeNode1;
        treeRoot.right = treeNode2;
        treeNode1.right= treeNode3;
        treeNode2.right= treeNode4;

        midShow(treeRoot);

        System.out.println(isSymmetric(treeRoot));
        System.out.println("Hello World;");


    }

    private static void midShow(TreeNode28 root){

        if(root.left!=null){
            midShow(root.left);
        }

        System.out.print(root.val+" ");

        if(root.right != null){
            midShow(root.right);
        }

        return;
    }

    public static boolean isSymmetric(TreeNode28 root) {

        if(root == null){
            return false;
        }

        return isSymmetricMain(root.left , root.right);
    }

    private static boolean isSymmetricMain (TreeNode28 rootLeft, TreeNode28 rootRight){

        if( rootLeft == null && rootRight == null){
            return true;
        }

        if((rootLeft == null && rootRight != null) || (rootLeft != null && rootRight == null)){
            return false;
        }





        if(rootLeft.val != rootRight.val){
            return false;
        }


        return isSymmetricMain(rootLeft.right, rootRight.left) && isSymmetricMain(rootLeft.left, rootRight.right) ;


    }

}
