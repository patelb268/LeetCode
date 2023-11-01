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
    public boolean isPalindrome(ListNode head) {
        if(head.next == null) return true;
        ListNode slow = head;
        ListNode fast = head;
        
        while( fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        //reverse
        ListNode node = slow.next;
        slow.next = null;
        fast = reverse(node);
        slow = head;
        
        //check for Palindrome
        
        while(fast != null){
            if(fast.val != slow.val) return false;
            fast = fast.next;
            slow = slow.next;
        }
        
        return true;
        
        
        
    }
    
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        
        while(head.next != null){
            head = head.next;
            curr.next = prev;
            prev = curr;
            curr = head;
        }
        
        curr.next = prev;
        
        return curr;
        
    }
}

//Time : O(n)
//Space : O(1)
