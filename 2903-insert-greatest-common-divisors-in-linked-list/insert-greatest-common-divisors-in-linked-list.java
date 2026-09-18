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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode temp = head;
        while(temp != null && temp.next!= null){
            int gcdval = gcd(temp.val,temp.next.val);
            ListNode gcdnode = new ListNode(gcdval);

            gcdnode.next = temp.next;
            temp.next = gcdnode;

            temp = gcdnode.next;
        }
        return head;
    }

    private static int gcd(int a,int b){
        return b==0 ? a : gcd(b,a%b);
    }
}