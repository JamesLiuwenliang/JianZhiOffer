import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Solution {

//    public static ArrayList<TreeNode54> arrayList ;

    public static HashMap<Integer,TreeNode54> hashMap;
    public static int index;


    public static class TreeNode54 {
        int val;
        TreeNode54 left;
        TreeNode54 right;
        TreeNode54(int x) { val = x; }
    }

    public static void main(String[] args) {
        TreeNode54 root = new TreeNode54(5);

        TreeNode54 node01 = new TreeNode54(3);
        TreeNode54 node02 = new TreeNode54(6);
        TreeNode54 node03 = new TreeNode54(2);
        TreeNode54 node04 = new TreeNode54(4);
        TreeNode54 node05 = new TreeNode54(1);

        root.left = node01; node01.left = node03;node01.right = node04; node03.left = node05;
        root.right = node02;

        System.out.println(kthLargest(root,3));



    }

    private static void midShow(TreeNode54 treeNode54){

        if(treeNode54 == null){
            return;
        }

        midShow(treeNode54.right);
        System.out.print(treeNode54.val+" ");


        midShow(treeNode54.left);




    }

    public static int kthLargest(TreeNode54 root, int k) {

        if(root == null || k < 0){
            return -1;
        }

        hashMap = new HashMap<>();
        index = 1;
        kthLargest_helper(root);

        return hashMap.get(k).val;

    }

    private static void kthLargest_helper(TreeNode54 treeNode54){

        if(treeNode54 == null){
            return;
        }

        kthLargest_helper(treeNode54.right);

        hashMap.put(index++,treeNode54);

        kthLargest_helper(treeNode54.left);


    }

}
