class Solution {
    public int minFlips(String s) {
        int n = s.length();
        s = s + s;

        int diff1 = 0; 
        int diff2 = 0;
        int ans = Integer.MAX_VALUE;
        int left = 0;

        for(int right=0;right<2*n;right++){
            char e1 = (right%2==0) ? '0':'1';
            char e2 = (right%2==0) ? '1':'0';

            if(s.charAt(right)!=e1) diff1++;
            if(s.charAt(right)!=e2) diff2++;

            if(right-left+1>n){
                char le1 = (left%2==0) ? '0':'1';
                char le2 = (left%2==0) ? '1':'0';

                if(s.charAt(left)!=le1) diff1--;
                if(s.charAt(left)!=le2) diff2--;

                left++;
            }

            if(right - left + 1 == n){
                ans = Math.min(ans, Math.min(diff1,diff2));
            }
        }

        return ans;
    }
}