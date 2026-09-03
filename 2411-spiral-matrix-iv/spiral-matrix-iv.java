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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] res = new int[m][];

        for(int i=0;i<m;i++){
            res[i] = new int[n];
            Arrays.fill(res[i],-1);
        }

        int top = 0;
        int bottom = m-1;
        int left = 0;
        int right = n-1;

        ListNode temp = head;

        while(top<=bottom && left<=right){
            for(int row=left;row<=right && temp!=null;row++){
                res[top][row] = temp.val;
                temp = temp.next;
            }
            top++;

            for(int col=top;col<=bottom && temp!=null;col++){
                res[col][right] = temp.val;
                temp = temp.next;
            }
            right--;

            for(int row=right;row>=left && temp!=null;row--){
                res[bottom][row] = temp.val;
                temp = temp.next;
            }
            bottom--;

            for(int col=bottom;col>=top && temp!=null;col--){
                res[col][left] = temp.val;
                temp = temp.next;
            }
            left++;
        }

        return res;
    }
}