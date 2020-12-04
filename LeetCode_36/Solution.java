public class Solution {

    public static Node36 head;
    public static Node36 pLastNode;


    static class Node36 {
        public int val;
        public Node36 left;
        public Node36 right;

        public Node36() {}

        public Node36(int _val) {
            val = _val;
        }

        public Node36(int _val, Node36 _left, Node36 _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };

    public static void main(String[] args) {

        Node36 root = new Node36(4);
        Node36 node01 = new Node36(2);
        Node36 node02 = new Node36(5);
        Node36 node03 = new Node36(1);
        Node36 node04 = new Node36(3);

        root.left = node01; root.right = node02; node01.left = node03; node01.right = node04;

//        midShow(root);

        treeToDoublyList(root);

        System.out.println("Hello World");


    }

    private static void midShow(Node36 root){

        if(root.left!=null){
            midShow(root.left);
        }

        System.out.print(root.val+" ");

        if(root.right != null){
            midShow(root.right);
        }

        return;
    }





    public static Node36 treeToDoublyList(Node36 root) {

        if(root == null){
            return null;
        }


        // 双向链表尾结点
        treeToDoublyListMain(root);

        pLastNode.right = head;
        head.left = pLastNode;

        Node36 tmp = head.right;
        while(tmp != head){
            System.out.println(tmp.val);
            tmp = tmp.right;
        }

        return head;
    }


    public static void treeToDoublyListMain(Node36 current){

        if(current == null){
            return;
        }
        treeToDoublyListMain(current.left);
        /*
         *  中序遍历
         */
        if(pLastNode == null){
            head = current;
        }else if(pLastNode != null){
            pLastNode.right = current;
        }

        current.left = pLastNode;
        pLastNode = current;

        treeToDoublyListMain(current.right);

    }



}
