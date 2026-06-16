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
    public ListNode oddEvenList(ListNode head) {
        //odd indices
        ListNode dummy1=new ListNode(-1);
        ListNode t1=dummy1;

        //even indices
        ListNode dummy2=new ListNode(-1);
        ListNode t2=dummy2;
       ListNode curr=head;
 // 3. Position variable and iterating over the linkedlist 
        // to figure which element / node is at odd position and even position 
       int pos=1;
       while(curr!=null){
        if(pos%2!=0){
        /// Odd position then attach it to dummyNode1 
        t1.next=curr;
        curr=curr.next;
        t1=t1.next;
        t1.next=null;
        }
        else{
             // Even position then attach it to dummyNode2
            t2.next=curr;
            curr=curr.next;
            t2=t2.next;
            t2.next=null;
        }
        pos++;
       }
        //merge linked list
        t1.next=dummy2.next;
        return dummy1.next;
    }
}