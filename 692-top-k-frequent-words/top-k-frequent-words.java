import java.util.*;

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freq = new HashMap<>();
        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }

        List<String> candidates = new ArrayList<>(freq.keySet());

        candidates.sort((w1, w2) -> {
            int count1 = freq.get(w1);
            int count2 = freq.get(w2);
            if (count1 != count2) {
                return Integer.compare(count2, count1);
            }
            return w1.compareTo(w2);
        });
        return candidates.subList(0, k);
    }
}