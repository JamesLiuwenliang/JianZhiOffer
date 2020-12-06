
import javax.xml.soap.Node;
import java.util.HashMap;

public class Solution {

    static class Node35 {
        int val;
        Node35 next;
        Node35 random;

        public Node35(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static void main(String[] args) {

        Node35 node01 = new Node35(7);
        Node35 node02 = new Node35(13);
        Node35 node03 = new Node35(11);
        Node35 node04 = new Node35(10);
        Node35 node05 = new Node35(1);

        node01.next = node02;  node02.next = node03;  node03.next = node04;  node04.next = node05;
        node02.random = node01;node03.random = node05;node04.random = node03;node05.random = node01;

//        copyRandomList(node01);
//        copyRandomList_BookHashTable(node01);
        Node35 pointer = copyRandomList_BookNoHash(node01);


//        System.out.println("------------");
//        while(pointer != null){
//            if(pointer.random!=null){
//                System.out.println(pointer.random.val);
//            }else{
//                System.out.println();
//            }
//            pointer = pointer.next;
//        }
//
//        System.out.println("------------");

    }

    public static Node35 copyRandomList_BookNoHash(Node35 head){
        if(head == null){
            return null;
        }

        Node35 resultHead = new Node35(head.val);

        if(head.next == null){
            if(head.random == head){
                resultHead.random = resultHead;
            }
            return resultHead;
        }




        return resultHead ;

    }

    // 哈希表实现
    public static Node35 copyRandomList_BookHashTable(Node35 head){

        if(head == null){
            return null;
        }

        Node35 resultHead = new Node35(head.val);

        HashMap<Node35 ,Node35> hashMap = new HashMap<>();

        if(head.next == null){
            if(head.random == head){
                resultHead.random = resultHead;
            }
            return resultHead;
        }

        hashMap.put(head,resultHead);
        Node35 nodeOriginPoint = head;
        Node35 resultNodePoint = resultHead;

        while(nodeOriginPoint.next != null){

            resultNodePoint.next = new Node35(nodeOriginPoint.next.val);
            nodeOriginPoint = nodeOriginPoint.next;
            resultNodePoint = resultNodePoint.next;
            hashMap.put(nodeOriginPoint,resultNodePoint);
        }

        nodeOriginPoint = head;
        resultNodePoint = resultHead;

        while(nodeOriginPoint !=null){

            Node35 tmp = hashMap.get(nodeOriginPoint.random);
            if(tmp != null){
                resultNodePoint.random = tmp;
            }

            nodeOriginPoint = nodeOriginPoint.next;
            resultNodePoint = resultNodePoint.next;

        }

        return resultHead;

    }


    public static Node35 copyRandomList(Node35 head) {

        if(head == null){
            return null;
        }

        Node35 resultHeadNode = new Node35(head.val);

        if(head.next == null){
            int index = indexFind(head,head.random);
            if(index==-1){
                return resultHeadNode;
            }else if(index == 0) {
                resultHeadNode.random = resultHeadNode;
            }

            return resultHeadNode;
        }

        Node35 nodeOriginP = head;
        Node35 resultNodeP = resultHeadNode;
        HashMap<Node35,Integer> hashMap = new HashMap<>();
        hashMap.put(resultHeadNode,indexFind(head,nodeOriginP.random));

        while(nodeOriginP.next != null){

            resultNodeP.next = new Node35(nodeOriginP.next.val);
            resultNodeP = resultNodeP.next;
            nodeOriginP = nodeOriginP.next;

            hashMap.put(resultNodeP,indexFind(head,nodeOriginP.random));
        }

        resultNodeP = resultHeadNode;
        nodeOriginP = head;

        Node35 nodeOuterPointer = resultNodeP;
        while(nodeOuterPointer != null){

            int index = hashMap.get(nodeOuterPointer);
            if(index==-1){
                nodeOuterPointer = nodeOuterPointer.next;
                continue;
            }

            Node35 nodeTmpPointer = resultHeadNode;

            for (int i = 0; i < index; i++) {
                nodeTmpPointer = nodeTmpPointer.next;
            }

            nodeOuterPointer.random = nodeTmpPointer;
            nodeOuterPointer = nodeOuterPointer.next;

        }



        return resultHeadNode;


    }

    private static int indexFind(Node35 head,Node35 nodeFind){

        if(nodeFind == null){
            return -1;
        }

        int index = 0;
        Node35 tmp = head;
        while(tmp != null){
            if(tmp == nodeFind){
                break;
            }
            tmp = tmp.next;
            ++index;
        }
        return index;

    }

}
