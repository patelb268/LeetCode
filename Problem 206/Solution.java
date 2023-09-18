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
    public ListNode reverseList(ListNode head) {
        if(head == null) return head;
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head.next;
        
        while(fast != null){
            slow.next = prev;
            prev = slow;
            slow = fast;
            fast = fast.next;
        }
        
        slow.next = prev;
        return slow;
    }
}

/*
  * Time Complexity : O(N)
  * Space Complexity : O(1)
  */



// Recursive Solution

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
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode reversed = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return reversed;
        
    }
    
   
}


/*
  * Time Complexity : O(N)
  * Space Complexity : O(N)
  */

