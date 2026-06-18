import re

class Solution:
    def mostCommonWord(self, paragraph: str, banned: List[str]) -> str:
        # 1. Clean punctuation using regex and convert to lowercase
        cleaned_para = re.sub(r'[^a-zA-Z0-9 ]', ' ', paragraph).lower()
        
        # 2. Split into individual words
        words = cleaned_para.split()
        
        # 3. Convert banned list to a set for rapid O(1) lookups
        bset = set(banned)
        freq = {}
        
        # 4. Count frequencies of words that are NOT banned
        for word in words:
            if word not in bset:
                freq[word] = freq.get(word, 0) + 1
                
        # 5. Track down the word with the highest frequency
        ma = 0
        w = ""
        for x, i in freq.items():
            if ma < i:
                ma = i
                w = x
                
        return w