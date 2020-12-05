package WebTest.Offer.chap04;


import java.util.ArrayList;

public class Solution {

    // Your Codec object will be instantiated and called as such:
    // Codec codec = new Codec();
    // codec.deserialize(codec.serialize(root));

    public static StringBuffer stringBuffer = new StringBuffer();
    public static int index = 0;
    public static TreeNode37 decodeRoot = new TreeNode37();


    static public class TreeNode37 {
         int val;
         TreeNode37 left;
         TreeNode37 right;
         TreeNode37(int x) { val = x; }
         TreeNode37() {}
     }

    public static void main(String[] args) {
//        TreeNode37 root   = new TreeNode37(1);
//        TreeNode37 node01 = new TreeNode37(2);
//        TreeNode37 node02 = new TreeNode37(3);
//        TreeNode37 node03 = new TreeNode37(4);
//        TreeNode37 node04 = new TreeNode37(5);
//
//        root.left = node01; root.right = node02; node02.left = node03; node02.right = node04;


        TreeNode37 root   = new TreeNode37();

        TreeNode37 deserializeRoot = deserialize(serialize(root));


        midShow(deserializeRoot);
        System.out.println("Hello World");

    }

    private static void midShow(TreeNode37 root){

        if(root.left!=null){
            midShow(root.left);
        }

        System.out.print(root.val+" ");

        if(root.right != null){
            midShow(root.right);
        }

        return;
    }

    public static String serialize(TreeNode37 root) {

        if(root == null){
            return null;
        }


        serializeMain(root);

        String substring = stringBuffer.substring(0,stringBuffer.length()-1);


         return substring;
    }

    public static void serializeMain(TreeNode37 root){

        if(root == null){
            stringBuffer.append("$,");
            return ;
        }

        stringBuffer.append(root.val+",");
        serializeMain(root.left);
        serializeMain(root.right);
    }

    public static TreeNode37 deserialize(String data) {

        if(data == null){
            return null;
        }
        if(data.length() == 0){
            return null;
        }


        String[] strings = data.split(",");
        if(strings[0].equals("$")){
            return null;
        }


        index = 0;
        decodeRoot = deserializeMain(decodeRoot,strings);



        midShow(decodeRoot);

        return decodeRoot;
    }

    public static TreeNode37 deserializeMain(TreeNode37 treeNode37,String[] strings){
        int value;
        if(!strings[index].equals("$")){

            value = Integer.decode(strings[index]);

            treeNode37 = new TreeNode37(value);

            treeNode37.val = value;


            ++index;
            TreeNode37 left = deserializeMain(treeNode37.left,strings);

            ++index;
            TreeNode37 right = deserializeMain(treeNode37.right,strings);

            treeNode37.left = left;
            treeNode37.right = right;
        }

        return treeNode37;


    }


}
