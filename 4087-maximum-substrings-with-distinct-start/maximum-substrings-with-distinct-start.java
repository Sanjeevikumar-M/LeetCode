class Solution {
    public int maxDistinct(String s) {
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int val = ch - 'a';
            if (arr[val] == 0)
                arr[val] = 1;
        }
        int cnt = 0;
        for (int ele : arr) {
            if (ele == 1)
                cnt++;
        }
        return cnt;
    }
}