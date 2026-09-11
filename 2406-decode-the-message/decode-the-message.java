class Solution {
    public String decodeMessage(String key, String message) {
        char[] map = new char[26];
        int index = 0;

        for (char c : key.toCharArray()) {
            if (c != ' ' && map[c - 'a'] == 0) {
                map[c - 'a'] = (char) ('a' + index);
                index++;
            }
        }

        StringBuilder ans = new StringBuilder();

        for (char c : message.toCharArray()) {
            if (c == ' ') {
                ans.append(' ');
            } else {
                ans.append(map[c - 'a']);
            }
        }

        return ans.toString();
    }
}