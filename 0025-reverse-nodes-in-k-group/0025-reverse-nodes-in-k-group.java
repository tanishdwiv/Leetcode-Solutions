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
    //for reversing the list
   static ListNode reverselist(ListNode Node){
        ListNode prev=null;
        ListNode curr=Node;
        ListNode next=null;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;

        }
        return prev;
    }
    //finding my kth node
  static  ListNode kthnode(ListNode node,int k){
   k--;
    while(node!=null && k>0){
        
        k--;
        node=node.next;
    }
    return node;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp=head;
        ListNode prevgroup=null;//to attach last node of the previous group to its current
        while(temp!=null){
           ListNode kth=kthnode(temp,k);
            //if my kth is null or all groups are not there
            if(kth==null){
                //if there is a previous group and group is not making
                if(prevgroup!=null){
                    prevgroup.next=temp;
                }
                break;
            }
            ListNode next=kth.next;//this next node will store my node after kth
            kth.next=null;//for reversing
           ListNode reverse= reverselist(temp);
            if(temp==head){
                head=reverse;
            }
            else{
                prevgroup.next=reverse;
            }
            prevgroup=temp;//ab mera previous update hokje dusri list ke end mai aa jayega
            temp=next;
        }
        return head;
    }
}