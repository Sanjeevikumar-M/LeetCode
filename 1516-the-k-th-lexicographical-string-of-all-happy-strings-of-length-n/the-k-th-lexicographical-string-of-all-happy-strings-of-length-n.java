import java.util.*;

class Solution {
    List<String> result = new ArrayList<>();

    public String getHappyString(int n, int k) {
        backtrack(n, "");
        if (k > result.size()) {
            return "";
        }
        return result.get(k - 1);
    }

    private void backtrack(int n, String current) {
        if (current.length() == n) {
            result.add(current);
            return;
        }

        char[] chars = {'a', 'b', 'c'};

        for (char c : chars) {
            if (current.length() > 0 && current.charAt(current.length() - 1) == c) {
                continue;
            }
            backtrack(n, current + c);
        }
    }
}