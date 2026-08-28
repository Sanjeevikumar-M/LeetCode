class Solution {
    public int primePalindrome(int n) {
        if(n<8){
            if(n<=2) return 2;
            if(n<=3) return 3;
            if(n<=5) return 5;
            if(n<=7) return 7;
        }
        if(n<=11) return 11;
        int i = 1;
        while(true){
            int palindrome = makePalindrome(i);
            if(palindrome >= n && isPrime(palindrome)){
                return palindrome;
            }
            i++;
        }
    }

    private static boolean isPrime(int num){
        if(num==1) return false;
        for(int i = 2; i*i<=num ; i++){
            if(num%i == 0) return false;
        }
        return true;
    }

    private static int makePalindrome(int num){
        String s = Integer.toString(num);
        String sb = s + new StringBuilder(s.substring(0,s.length()-1)).reverse().toString();
        return Integer.parseInt(sb);
    }
}