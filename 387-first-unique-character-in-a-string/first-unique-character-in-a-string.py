class Solution:
    def firstUniqChar(self, s: str) -> int:
        char_counts = {}
        
        # Step 1: Build the frequency map
        for char in s:
            char_counts[char] = char_counts.get(char, 0) + 1
            
        # Step 2: Loop through the original string to maintain order
        for index, char in enumerate(s):
            if char_counts[char] == 1:
                return index  # Return the index of the first unique character
                
        # Step 3: If no unique character is found, return -1
        return -1