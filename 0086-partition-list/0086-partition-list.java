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
    public ListNode partition(ListNode head, int x) {

        ListNode dummy1=new ListNode(-1);
        ListNode t1=dummy1;

        ListNode dummy2=new ListNode(-1);
        ListNode t2=dummy2;
        ListNode curr=head;

        while(curr!=null){
            if(curr.val<x){
                t1.next=curr;
                curr=curr.next;
                t1=t1.next;
                t1.next=null;
            }
            else{
                t2.next=curr;
                curr=curr.next;
                t2=t2.next;
                t2.next=null;

            }
        }
        t1.next=dummy2.next;
        return dummy1.next;
    }
}