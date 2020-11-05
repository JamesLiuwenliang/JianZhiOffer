class Solution {
    public ListNode deleteNode(ListNode head, int val) {

        if(head==null){
            return head;
        }
    
        ListNode listnode = head;
        ListNode prenode = head;

        if(listnode.val!=val){
            listnode = listnode.next;
        }else{
            listnode = listnode.next;
            prenode.next = null;
            return listnode;
        }

        while(listnode != null){
            if(listnode.val==val){
                prenode.next = listnode.next;
                listnode.next = null;
                break;
            }
            listnode = listnode.next;
            prenode = prenode.next;
        }

        return head;


    }


}