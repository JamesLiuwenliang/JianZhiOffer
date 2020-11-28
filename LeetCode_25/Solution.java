

public class Solution {

    public static class ListNode25 {
        int val;
        ListNode25 next;
        ListNode25(int x) { val = x; }
    }

    public static void main(String[] args) {
        ListNode25 head01 = new ListNode25(1);
        head01.next = new ListNode25(2);
        head01.next.next = new ListNode25(4);

        ListNode25 head02 = new ListNode25(1);
        head02.next = new ListNode25(3);
        head02.next.next = new ListNode25(4);

        ListNode25 tmp = mergeTwoLists(head01,head02);

        while(tmp != null){

            System.out.println(tmp.val);
            tmp = tmp.next;

        }
        System.out.println("Hello");


    }

    public static ListNode25 mergeTwoLists(ListNode25 l1, ListNode25 l2) {

        if(l1 == null){
            return l2;
        }else if(l2 == null){
            return l1;
        }

        ListNode25 pMergeHead = null;

        if(l1.val < l2.val){
            pMergeHead = l1;
            pMergeHead.next = mergeTwoLists(l1.next, l2);
        }else{
            pMergeHead = l2;
            pMergeHead.next = mergeTwoLists(l1,l2.next);
        }

        return pMergeHead;

    }


}
