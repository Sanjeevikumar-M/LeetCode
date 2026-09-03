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
        int[][] res = new int[m][n];

        int top = 0;
        int bottom = m-1;
        int left = 0;
        int right = n-1;

        ListNode temp = head;

        while(top<=bottom && left<=right){
            for(int row=left;row<=right;row++){
                if(temp!=null){
                    res[top][row] = temp.val;
                    temp = temp.next;
                }else{
                    res[top][row] = -1;
                }
            }
            top++;

            for(int col=top;col<=bottom;col++){
                if(temp!=null){
                    res[col][right] = temp.val;
                    temp = temp.next;
                }else{
                    res[col][right] = -1;
                }
            }
            right--;

            if(top<=bottom){
                for(int row=right;row>=left;row--){
                    if(temp!=null){
                        res[bottom][row] = temp.val;
                        temp = temp.next;
                    }else{
                        res[bottom][row] = -1;
                    }
                }
            }
            bottom--;

            if(left<=right){
                for(int col=bottom;col>=top;col--){
                    if(temp!=null){
                        res[col][left] = temp.val;
                        temp = temp.next;
                    }else{
                        res[col][left] = -1;
                    }
                }
            }
            left++;
        }

        return res;
    }
}