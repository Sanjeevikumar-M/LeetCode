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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 1. Create a dummy node to easily handle the head of the merged list
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        
        // 2. Traverse both lists until one runs out
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next; // Move list1 pointer
            } else {
                current.next = list2;
                list2 = list2.next; // Move list2 pointer
            }
            current = current.next; // Move the merged list tracker forward
        }
        
        // 3. If there are remaining nodes in either list, append them
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }
        
        // 4. Return the actual head of the merged list
        return dummy.next;
    }
}