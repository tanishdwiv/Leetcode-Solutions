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
    public ListNode mergeKLists(ListNode[] lists) {
        
        if(lists==null||lists.length==0)
        return null;

        PriorityQueue<Integer> minheap=new PriorityQueue<>();
        for(ListNode i:lists){
            while(i!=null){
                minheap.add(i.val);
                i=i.next;
            }
        }
        ListNode result=new ListNode(0);
        ListNode dummy=result;
        while(!minheap.isEmpty()){
            dummy.next=new ListNode(minheap.poll());
            dummy=dummy.next;
        }
        return result.next;
    }
}