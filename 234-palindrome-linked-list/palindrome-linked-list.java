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
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode previous = null;
        ListNode current = slow;
        while(current!=null){
            ListNode temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }

        ListNode firstnode = head;
        ListNode secondnode  = previous;
        while(secondnode!=null){
            if(secondnode.val!=firstnode.val){
                return false;
            }
            secondnode = secondnode.next;
            firstnode = firstnode.next;
        }
        return true;
    }
}