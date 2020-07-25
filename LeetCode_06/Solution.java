/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public static int[] reversePrint(ListNode head) {
        LinkedList<Integer> linkedList = new LinkedList<>();

        ListNode tmp = head;

        while(tmp != null){
            linkedList.add(tmp.val);
            tmp = tmp.next;
        }

        int total = linkedList.size();
        int[] res =  new int[total];
        int index =0;
        for (int i = total-1 ; i >= 0 ; i--) {
            res[index] = linkedList.get(i);
            index++;
        }

        return res;

    }


    public static int[] reversePrint02(ListNode head) {

        Stack<Integer> stack = new Stack<>();

        ListNode listNode = head;


        while(listNode != null){
            stack.push(listNode.val);

            listNode = listNode.next;
        }

        int[] res = new int[stack.size()];
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            res[i]  =stack.pop();
        }
        System.out.println();

        return res;

    }
}