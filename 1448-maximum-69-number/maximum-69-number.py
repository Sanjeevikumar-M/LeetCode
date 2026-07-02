class Solution:
    def maximum69Number (self, num: int) -> int:
        s = str(num)
        if s[0]=='6':
            return int('9'+s[1:])

        pre = 0
        for i in range(len(s)):
            if s[i]=='6':
                return int(s[:pre+1]+'9'+s[i+1:])
            pre = i
        return num