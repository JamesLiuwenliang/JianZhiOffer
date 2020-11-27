

public class Solution {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        ListNode tmp = getKthFromEnd(head,2);

        while(tmp != null){

            System.out.println(tmp.val);
            tmp = tmp.next;
        }
        System.out.println("Hello");


    }

    public static ListNode getKthFromEnd(ListNode head, int k) {

        if(head == null){
            return null;
        }

        ListNode listnode = head;
        int length = 0;
        while(listnode.next != null){
            listnode = listnode.next;
            length++;
        }
        length++;
        if(length < k){
            return null;
        }

        ListNode tmp = listnode;
        listnode.next = head;

        for (int i = 0; i < length-k+1; i++) {
            listnode = listnode.next;
        }

        tmp.next = null;
        return listnode;


    }


}
