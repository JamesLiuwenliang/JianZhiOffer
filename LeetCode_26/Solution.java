
public class Solution {
    public static class TreeNode26 {
        int val;
        TreeNode26 left;
        TreeNode26 right;
        TreeNode26(int x) { val = x; }
     }

    public static void main(String[] args) {
        TreeNode26 treeNode = new TreeNode26(3);
        TreeNode26 treeNode1 = new TreeNode26(4);
        TreeNode26 treeNode2 = new TreeNode26(5);
        TreeNode26 treeNode3 = new TreeNode26(1);
        TreeNode26 treeNode4 = new TreeNode26(2);

        treeNode.left = treeNode1;
        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;
        treeNode.right = treeNode2;

        TreeNode26 tree02Node = new TreeNode26(4);
        TreeNode26 tree02Node01 = new TreeNode26(1);
        tree02Node.left = tree02Node01;

        System.out.println(isSubStructure(treeNode,tree02Node) );


        System.out.println("Hello");

    }

    /*
     * 可以分成两步：
     *   1. 第一步，在树A中找到和树B的根节点的值一样的节点R;
     *   2. 第二步，判断树A中以R为根节点的子树是不是包含和树B一样的结构
     * */
    public static boolean isSubStructure(TreeNode26 A, TreeNode26 B) {

        if(B == null){
            return false;
        }

        return hasSubTree(A,B);
    }

    private static boolean hasSubTree(TreeNode26 A,TreeNode26 B){

        boolean result = false;

        if(A != null && B != null){

            if(A.val == B.val) {
                result = doesTree1HasTree2(A, B);
            }

            if(result == false){
                result = hasSubTree(A.left,B);
            }
            if(result == false){
                result = hasSubTree(A.right, B);
            }
        }



        return result;
    }

    private static boolean doesTree1HasTree2(TreeNode26 A ,TreeNode26 B){

        if(B == null){
           return true;
        }

        if(A != null && A.val == B.val){

            return doesTree1HasTree2(A.left,B.left) && doesTree1HasTree2(A.right,B.right);

        }
        return false;


    }

}
