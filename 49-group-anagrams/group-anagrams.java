class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();

        for(String str:strs){
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedstr = new String(charArray);

            if(!map.containsKey(sortedstr)){
                map.put(sortedstr,new ArrayList<>());
            }
            map.get(sortedstr).add(str);
        }

        return new ArrayList<>(map.values());
    }
}