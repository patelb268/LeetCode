/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        int lengthA  = 0;
        int lengthB = 0;
        
        //calculate Length A
        ListNode head = headA;
        while(head.next != null){
            head = head.next;
            lengthA++;
        }
        
        //calculate Length B
        head = headB;
        while(head.next != null){
            head = head.next;
            lengthB++;
        }
        
        //calculate difference
        int skip = Math.abs(lengthA - lengthB);
        
        //set the nodes
        ListNode fast = headA;
        ListNode slow = headB;
        
        if(lengthA < lengthB){
            fast = headB;
            slow = headA;
        }
        
        while(skip > 0){
            fast = fast.next;
            skip--;
        }
        
        while(fast != null && slow != null){
            if(fast == slow) return fast;
            fast = fast.next;
            slow = slow.next;
        }
        
        return null;
        
    }
}

// Time : O(m + n) 2-pass solution
// space : O(1)
