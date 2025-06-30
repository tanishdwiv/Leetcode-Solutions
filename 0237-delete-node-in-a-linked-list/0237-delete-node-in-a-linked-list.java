/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        
        node.val=node.next.val;//next node ki value copy kro
        node.next=node.next.next;//next node ko skip krdo 
    }
}