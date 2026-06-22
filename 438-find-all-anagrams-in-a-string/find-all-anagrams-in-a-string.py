class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        # i = 0
        # j = len(p)-1
        # l = []

        # while j<len(s):
        #     arr = [0]*26
        #     k = 0
        #     m = i
        #     while k<len(p):
        #         arr[ord(p[k])-ord('a')]+=1
        #         arr[ord(s[m])-ord('a')]-=1
        #         k+=1
        #         m+=1
            
        #     for n in arr:
        #         if n!=0:
        #             i+=1
        #             j+=1
        #             break
        #     else:
        #         l.append(i)
        #         i+=1
        #         j+=1
        # return l

        if len(p) > len(s):
            return []
        
        p_count = [0]*26
        s_count = [0]*26
        
        for i in range(len(p)):
            p_count[ord(p[i])-ord('a')]+=1
            s_count[ord(s[i])-ord('a')]+=1
            
        l = []
        if s_count == p_count:
            l.append(0)
            
        left = 0
        for right in range(len(p), len(s)):
            s_count[ord(s[right]) - ord('a')] += 1
            s_count[ord(s[left]) - ord('a')] -= 1
            
            left += 1
            
            if s_count == p_count:
                l.append(left)
                
        return l