

import java.util.LinkedList;

public class Solution {

    public static class ListNode52 {
        int val;
        ListNode52 next;

        ListNode52(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {

        ListNode52 headA = new ListNode52(0);
        ListNode52 headB = new ListNode52(3);

        ListNode52 node52_01 = new ListNode52(9);
        ListNode52 node52_02 = new ListNode52(1);
        ListNode52 node52_03 = new ListNode52(2);
        ListNode52 node52_04 = new ListNode52(4);

        headA.next = node52_01; node52_01.next = node52_02;node52_02.next = node52_03;node52_03.next = node52_04;
        headB.next = node52_03;

        ListNode52 result = getIntersectionNode(headA,headB);

        System.out.println(result.val);

    }


    public static ListNode52 getIntersectionNode(ListNode52 headA, ListNode52 headB) {

        if(headA == null || headB == null) {
            return null;
        }
        ListNode52 pA = headA;
        ListNode52 pB = headB;

        while (pA != pB) {

            pA = (pA == null) ? headB : pA.next;
            pB = (pB == null) ? headA : pB.next;

        }

        return pA;

    }

}
