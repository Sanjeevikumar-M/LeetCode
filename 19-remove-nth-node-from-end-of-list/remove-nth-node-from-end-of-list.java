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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> temp = new ArrayList<>();
        ListNode curr = head;
        while(curr!=null){
            temp.add(curr);
            curr = curr.next;
        }
        int rem = temp.size()-n;
        if(rem==0){
            return head.next;
        }
        temp.get(rem-1).next = temp.get(rem).next;
        return head;
    }
}