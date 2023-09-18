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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        fast = reverse(slow.next);
        System.out.print(fast.val);
        slow.next = null;
        slow = head;
         ListNode temp = null;
        while (fast != null){
            temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp; 
        }
        
    }
    
    public ListNode reverse(ListNode head){
        if(head == null || head.next == null) return head;
        
        ListNode reversed = reverse(head.next);
        
        head.next.next = head;
        
        head.next = null;
        
        return reversed;
    }
}

/**
  * Time Complexity : O(N)
  * Space Coplecity : O(1) => reverse iterative O(N) => reverse recursive;
  */
