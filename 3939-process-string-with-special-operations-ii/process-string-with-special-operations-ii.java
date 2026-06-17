import java.util.*;

class Solution {
    public char processStr(String s, long k) {
        int n = s.length();
        long[] lengths = new long[n + 1];
        lengths[0] = 0; // Initial length of an empty string

        // Forward Pass: Compute lengths after each operation
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '*') {
                lengths[i + 1] = Math.max(0, lengths[i] - 1);
            } else if (ch == '#') {
                // Safeguard against potential overflow if length grows too large
                if (lengths[i] > 1e15) {
                    lengths[i + 1] = lengths[i];
                } else {
                    lengths[i + 1] = lengths[i] * 2;
                }
            } else if (ch == '%') {
                lengths[i + 1] = lengths[i];
            } else { // Lowercase English letter
                lengths[i + 1] = lengths[i] + 1;
            }
        }

        // If k is out of bounds of the final string length
        if (k >= lengths[n]) {
            return '.';
        }

        // Backward Pass: Work backwards to trace the index k
        for (int i = n - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            
            if (ch == '*') {
                // A backspace character doesn't affect index k if k is within the valid prefix
                continue;
            } else if (ch == '#') {
                // If k falls into the duplicated second half, map it back to the first half
                if (k >= lengths[i]) {
                    k %= lengths[i];
                }
            } else if (ch == '%') {
                // Reverse flips the index: new_index = length - 1 - current_index
                k = lengths[i] - 1 - k;
            } else {
                // If k points to the character just appended, we've found it!
                if (k == lengths[i]) {
                    return ch;
                }
            }
        }

        return '.';
    }
}