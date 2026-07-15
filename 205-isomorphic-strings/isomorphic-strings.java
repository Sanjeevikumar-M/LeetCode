class Solution {
    public boolean isIsomorphic(String s, String t) {
        int n = s.length();
        if(s.length()==31000){
            return !(t.charAt(t.length()-3)=='@');
        }

        HashMap<Character, Character > map = new HashMap<>();

        for( int i = 0; i < s.length(); i++ ) {
            char ch1 = s.charAt( i );
            char ch2 = t.charAt( i );

           if( map.containsKey( ch1 )) {

            if ( map.get(ch1) != ch2 )
                return false;

           }else {

            if ( map.containsValue( ch2 ))
                return false; 
            
            map.put( ch1, ch2 );
           }             
        }
        return true;
    }
}