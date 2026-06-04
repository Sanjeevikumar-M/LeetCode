class Solution {
    public int totalWaviness(int num1, int num2) {
        int totalWaviness = 0;
        
        for (int i = num1; i <= num2; i++) {
            // Numbers with fewer than 3 digits have a waviness of 0
            if (i < 100) {
                continue;
            }
            
            String s = Integer.toString(i);
            int len = s.length();
            int[] digits = new int[len];
            
            // Use a temporary copy to extract digits without destroying the loop counter 'i'
            int temp = i;
            int j = 0;
            while (temp > 0) {
                digits[j] = temp % 10;
                j++;
                temp /= 10;
            }
            
            // Scan the middle digits (ignoring the first and last extracted digits)
            for (int k = 1; k < len - 1; k++) {
                // Peak condition: strictly greater than both immediate neighbors
                boolean isPeak = digits[k] > digits[k - 1] && digits[k] > digits[k + 1];
                
                // Valley condition: strictly less than both immediate neighbors
                boolean isValley = digits[k] < digits[k - 1] && digits[k] < digits[k + 1];
                
                if (isPeak || isValley) {
                    totalWaviness++;
                }
            }
        }
        
        return totalWaviness;
    }
}