import java.util.HashMap;
import java.util.LinkedList;

public class Solution {

    public static class ListNode23 {
        int val;
        ListNode23 next;
        ListNode23(int x) { val = x; }
    }


    public static void main(String[] args) {
        ListNode23 head = new ListNode23(1);
//        head.next = new ListNode23(2);
//        head.next.next = new ListNode23(3);
//        head.next.next.next = new ListNode23(4);
//        head.next.next.next.next = new ListNode23(5);
//        head.next.next.next.next.next = new ListNode23(6);

        ListNode23 tmp = reverseList(head);

        while(tmp != null){

            System.out.println(tmp.val);
            tmp = tmp.next;

        }
        System.out.println("Hello");


    }

    public static ListNode23 reverseList(ListNode23 head) {

        if(head == null){
            return null;
        }

        if(head.next == null){
            return head;
        }

        HashMap<Integer,ListNode23> hashMap = new HashMap<>();

        ListNode23 listNode23 = head;

        int length = 0;

        while(listNode23.next != null){
            hashMap.put(length,listNode23);
            length++;
            listNode23 = listNode23.next;

        }

        hashMap.put(length,listNode23);


        ListNode23 listnode_NewHead = new ListNode23(hashMap.get(length).val);

        ListNode23 listnodePoint = new ListNode23(hashMap.get(length-1).val);

        listnode_NewHead.next = listnodePoint;

        for (int i = length-2; i >= 0; i--) {

            ListNode23 tmp = new ListNode23(hashMap.get(i).val);

            listnodePoint.next = tmp;
            listnodePoint = tmp;

        }
        
        return listnode_NewHead;

    }

}
