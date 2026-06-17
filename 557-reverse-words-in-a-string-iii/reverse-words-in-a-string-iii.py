class Solution:
    def reverseWords(self, s: str) -> str:
        s_arr = s.split(" ")
        new_word = ""
        for word in s_arr:
            new_word += word[::-1] + " "
            
        return new_word.rstrip()