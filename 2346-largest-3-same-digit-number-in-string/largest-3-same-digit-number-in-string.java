class Solution {
    public String largestGoodInteger(String num) {
        String[] goodint = {"999","888","777","666","555","444","333","222","111","000"};
        for(String g:goodint){
            if(num.contains(g)){
                return g;
            }
        }
        return "";
    }
}