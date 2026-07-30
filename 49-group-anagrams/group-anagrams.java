class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();

        for(String str: strs){
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedKey = new String(charArray);

            map.computeIfAbsent(sortedKey,k-> new ArrayList()).add(str);
        }

        return new ArrayList<>(map.values());
    }

}