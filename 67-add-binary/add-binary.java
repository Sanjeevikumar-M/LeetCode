class Solution {
    public String addBinary(String a, String b) {
        
        int n = Math.max(a.length(), b.length());
        char[] result = new char[n + 1];
        
        int i = a.length() - 1;
        int j = b.length() - 1;
        int k = n;
        int carry = 0;

        while (k >= 0) {
            int sum = carry;
            
            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(j--) - '0';
            
            result[k--] = (char)((sum % 2) + '0');
            carry = sum / 2;
        }

        // If first char is '0', skip it
        return result[0] == '0' ? new String(result, 1, n) : new String(result);
    }
}
