import sun.reflect.generics.tree.Tree;

import java.util.*;
/**
 * 想明白后发现很容易
 */

public class Solution {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static void main(String[] args) {
        int[] preorder = {1,2};
        int[] inorder = {2,1};
        TreeNode treeNode = buildTree(preorder,inorder);

        PreOrder(treeNode);
        System.out.println();
        System.out.println("=====");
        InOrder(treeNode);
    }

    public static TreeNode buildTree(int []preorder,int[] inoreder) {

        if (preorder == null || inoreder == null || preorder.length != inoreder.length) {
            return null;
        }
        int len = preorder.length-1;

        return buildTree(preorder,inoreder,0, len,0,len);
    }

    private static TreeNode buildTree(int []preorder ,int []inorder ,int startPreorder ,int endPreorder, int startInorder ,int endInorder){


        if(startInorder > endInorder){
            return null;
        }
        if(startInorder == endInorder ){
            System.out.println("inorder:"+inorder[startInorder]);

            return new TreeNode(inorder[startInorder]);
        }

        int index =0;
        for (int i = startInorder; i <= endInorder; i++) {
            if(preorder[startPreorder] == inorder[i]){
                index = i;
                break;
            }
        }

        TreeNode root = new TreeNode(preorder[startPreorder]);

        TreeNode left = buildTree(preorder,inorder,startPreorder+1,startPreorder+index-startInorder , startInorder,index-1);
        TreeNode right = buildTree(preorder,inorder ,startPreorder+index+1-startInorder ,endPreorder,index+1,endInorder);

        root.left =left;
        root.right = right;
        return root;
    }


    public static void PreOrder(TreeNode treeNode){
        if(treeNode == null){
            System.out.print(" "+null);
            return;
        }

        System.out.print(" "+treeNode.val);
        PreOrder(treeNode.left);
        PreOrder(treeNode.right);
    }

    public static void InOrder(TreeNode treeNode){

        if(treeNode == null){
            System.out.print(" "+null);
            return;
        }

        InOrder(treeNode.left);
        System.out.print(" "+treeNode.val);
        InOrder(treeNode.right);
    }




}