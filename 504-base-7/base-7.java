class Solution {
    public String convertToBase7(int num) {
        return Integer.toString(num,7);
        // if(num==0) return "0";

        // boolean n = num<0;
        // StringBuilder sb = new StringBuilder();
        // num = Math.abs(num);
        // while(num!=0){
        //     sb.append(num%7);
        //     num/=7;
        // }
        // if(n){
        //     sb.append('-');
        // }
        // return sb.reverse().toString();
    }
}