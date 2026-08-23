class Solution {
    public String makeGood(String s) {
        char[] buf = s.toCharArray();
        int top = 0;
        for (int i = 0; i < buf.length; i++) {
            char c = buf[i];
            if (top > 0 && (buf[top - 1] ^ c) == 32) {
                top--;
            } else {
                buf[top++] = c;
            }
        }
        return new String(buf, 0, top);
    }
}