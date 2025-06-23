/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null){
            return head;
        }
        if(k==0)
        return head;

        //here i am finding length of our list
        ListNode current=head;
        int len=0;
        while(current!=null){
            len++;
            current=current.next;
        }
        k=k%len;
        if(k==0)
        return head;

        ListNode slow=head;
        ListNode fast=head;

        //i have to move fast k steps
        while(k>0){
            fast=fast.next;
            k--;
        }
    //now moving both at same pace
    while(fast.next!=null){
        fast=fast.next;
        slow=slow.next;
    }
    //my slow is now at the node after which rotation will occur
    ListNode newhead=slow.next;
    //breaking the list after slow
    slow.next=null;
    fast.next=head;//my last will now point to my old head and join the list

        return newhead;
    }
}