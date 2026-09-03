class Solution {
    public String convert(String s, int numRows) {

        if (numRows == 1) {
            return s;
        }

        int n = s.length();
        char[] result = new char[n];
        int index = 0;

        int cycle = 2 * numRows - 2;

        // First row
        for (int i = 0; i < n; i += cycle) {
            result[index++] = s.charAt(i);
        }

        // Middle rows
        for (int row = 1; row < numRows - 1; row++) {

            for (int i = row; i < n; i += cycle) {

                result[index++] = s.charAt(i);

                int next = i + cycle - 2 * row;

                if (next < n) {
                    result[index++] = s.charAt(next);
                }
            }
        }

        // Last row
        for (int i = numRows - 1; i < n; i += cycle) {
            result[index++] = s.charAt(i);
        }

        return new String(result);
    }
}