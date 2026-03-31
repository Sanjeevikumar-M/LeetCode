class Solution {
    public String generateString(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int len = n + m - 1;

        char[] word = new char[len];
        boolean[] locked = new boolean[len];

        // Step 1: Initialize
        for (int i = 0; i < len; i++) {
            word[i] = '?';
        }

        // Step 2: Apply 'T'
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'T') {
                for (int j = 0; j < m; j++) {
                    if (word[i + j] == '?' || word[i + j] == str2.charAt(j)) {
                        word[i + j] = str2.charAt(j);
                        locked[i + j] = true; // mark as fixed
                    } else {
                        return "";
                    }
                }
            }
        }

        // Step 3: Fill remaining with 'a'
        for (int i = 0; i < len; i++) {
            if (word[i] == '?') {
                word[i] = 'a';
            }
        }

        // Step 4: Fix 'F'
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'F') {
                boolean match = true;

                for (int j = 0; j < m; j++) {
                    if (word[i + j] != str2.charAt(j)) {
                        match = false;
                        break;
                    }
                }

                if (match) {
                    boolean fixed = false;

                    // Try to modify only non-locked positions
                    for (int j = m - 1; j >= 0; j--) {
                        int idx = i + j;

                        if (!locked[idx]) {
                            // change to smallest different char
                            for (char c = 'a'; c <= 'z'; c++) {
                                if (c != str2.charAt(j)) {
                                    word[idx] = c;
                                    fixed = true;
                                    break;
                                }
                            }
                        }

                        if (fixed) break;
                    }

                    // If no safe modification → impossible
                    if (!fixed) return "";
                }
            }
        }

        return new String(word);
    }
}