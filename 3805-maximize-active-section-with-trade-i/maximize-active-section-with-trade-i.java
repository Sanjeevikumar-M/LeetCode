class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int totalOnes = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                totalOnes++;
            }
        }

        String t = "1"+s+"1";
        List<Integer> arr = new ArrayList<>();
        int n = t.length();
        int i=0;
        while(i<n){
            if(t.charAt(i)=='1'){
                while(i<n && t.charAt(i)=='1'){
                    i++;
                }
            }else{
                int start = i;
                while(i<n && t.charAt(i)=='0'){
                    i++;
                }
                arr.add(i-start);
            }
        }

        int max = 0;
        for(int k=0;k<arr.size()-1;k++){
            int gain = arr.get(k)+arr.get(k+1);
            max = Math.max(max,gain);
        }
        return max+totalOnes;
    }
}