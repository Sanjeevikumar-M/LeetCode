class Solution {
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> res = new HashSet<>();
        int n = digits.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (i != j && j != k && k != i) {
                        if (digits[i] != 0) {
                            if (digits[k] % 2 == 0) {
                                res.add(digits[i] * 100 + digits[j] * 10 + digits[k]);
                            }
                        }
                    }
                }
            }
        }
        int[] ans = new int[res.size()];
        int idx = 0;
        for (int num : res) {
            ans[idx++] = num;
        }
        Arrays.sort(ans);
        return ans;
    }
}