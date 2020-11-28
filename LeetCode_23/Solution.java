
public class Solution {

    public static class ListNode23 {
        int val;
        ListNode23 next;
        ListNode23(int x) { val = x; }
    }

    public static void main(String[] args) {
        ListNode23 head = new ListNode23(1);
        ListNode23 listNode23_01 = new ListNode23(2);
        head.next = listNode23_01;

        ListNode23 listNode23_02 = new ListNode23(3);
        listNode23_01.next = listNode23_02;

        ListNode23 listNode23_03 = new ListNode23(4);
        listNode23_02.next = listNode23_03;

        ListNode23 listNode23_04 = new ListNode23(5);
        listNode23_03.next = listNode23_04;

        ListNode23 listNode23_05 = new ListNode23(6);
        listNode23_04.next = listNode23_05;

        listNode23_05.next = listNode23_02;

        ListNode23 tmp = meetingNode(head);
        System.out.println(tmp.val);


        System.out.println("Hello");


    }

    public static ListNode23 meetingNode(ListNode23 head) {

        int rollLength = getRollLength(head);

        ListNode23 l1 = head;
        ListNode23 l2 = head;

        for (int i = 0; i < rollLength; i++) {
            l1 = l1.next;
        }

        int maxLength = 5000;
        while(maxLength-- != 0 ){
            if(l1 == l2){
                return l1;
            }

            l1 = l1.next;
            l2 = l2.next;
        }



        return head;
    }

    // 获得环的长度
    public static int getRollLength(ListNode23 head){

        ListNode23 l1 = head;
        ListNode23 l2 = head.next;
        ListNode23 meetNode = null;

        int maxLength = 5000;
        int resultLength = 1;

        while(maxLength-- != 0){

            // 计算环的大小
            if(l1 == l2){
                l2 = l2.next;
                while(l2 != l1){
                    resultLength++;
                    l2 = l2.next;
                }
                return resultLength;

            }

            l1 = l1.next;
            l2 = l2.next.next;

        }

        return 0;

    }


}
