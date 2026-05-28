class Solution {

    static class TrieNode {
        TrieNode[] child = new TrieNode[26];

        // Best index for this node
        int idx = -1;
    }

    TrieNode root = new TrieNode();
    String[] words;

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        words = wordsContainer;

        // Build Trie using reversed words
        for (int i = 0; i < wordsContainer.length; i++) {
            insert(wordsContainer[i], i);
        }

        int[] ans = new int[wordsQuery.length];

        for (int i = 0; i < wordsQuery.length; i++) {
            ans[i] = query(wordsQuery[i]);
        }

        return ans;
    }

    private void insert(String word, int index) {
        TrieNode node = root;

        // Update root best index
        if (node.idx == -1 || better(index, node.idx)) {
            node.idx = index;
        }

        for (int i = word.length() - 1; i >= 0; i--) {
            int c = word.charAt(i) - 'a';

            if (node.child[c] == null) {
                node.child[c] = new TrieNode();
            }

            node = node.child[c];

            // Store best index at each node
            if (node.idx == -1 || better(index, node.idx)) {
                node.idx = index;
            }
        }
    }

    private int query(String word) {
        TrieNode node = root;

        for (int i = word.length() - 1; i >= 0; i--) {
            int c = word.charAt(i) - 'a';

            if (node.child[c] == null) {
                break;
            }

            node = node.child[c];
        }

        return node.idx;
    }

    // Return true if a is better than b
    private boolean better(int a, int b) {
        if (words[a].length() != words[b].length()) {
            return words[a].length() < words[b].length();
        }

        return a < b;
    }
}