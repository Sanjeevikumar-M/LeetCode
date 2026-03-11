class Solution {
    public int bitwiseComplement(int n) {
        String s = Integer.toBinaryString(n);
        StringBuilder str = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='1'){
                str.append('0');
            }else{
                str.append('1');
            }
        }
        int num = Integer.parseInt(str.toString(),2);
        return num;
        
    }
}