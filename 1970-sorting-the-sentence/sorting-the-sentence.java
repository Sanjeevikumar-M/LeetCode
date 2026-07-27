class Solution {
    public String sortSentence(String s) {
        String[] str = s.split(" ");
        String[] res = new String[str.length];
        for(String st:str){
            int i = (int) (st.charAt(st.length()-1)-'0');
            res[i-1] = st.substring(0,st.length()-1);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<res.length;i++){
            if(i==res.length-1){
                sb.append(res[i]);
            }else{
                sb.append(res[i]+" ");
            }
            
        }
        return sb.toString();
    }
}