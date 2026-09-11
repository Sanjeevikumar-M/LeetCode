class Solution {
    public String decodeMessage(String key, String message) {
        Map<Character, Character> m = new HashMap<>();
        m.put(' ', ' ');
        char to = 'a';
        for(char from : key.toCharArray())
            if(!m.containsKey(from))
                m.put(from, to++);
        System.out.println(m);
        char[] result = new char[message.length()];
        for (int j = 0; j < message.length(); j++) {
            result[j] = m.get(message.charAt(j));
        }
        return new String(result);
    }
}