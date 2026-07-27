class Solution {
    public String sortSentence(String s) {
        String[] str = s.split(" ");
        String[] res = new String[str.length];
        int i=0;
        for(String st:str){
            i = (int) (st.charAt(st.length()-1)-'0');
            res[i-1] = st.substring(0,st.length()-1);
        }
        // StringBuilder sb = new StringBuilder();
        // for(i=0;i<res.length-1;i++)
        //     sb.append(res[i]+" ");
        // sb.append(res[i]);
        return String.join(" ",res);
    }
}