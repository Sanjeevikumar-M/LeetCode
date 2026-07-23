class Solution:
    def totalFruit(self, fruits: List[int]) -> int:
        freq = {}
        left = 0
        m = 0
        for right in range(len(fruits)):
            freq[fruits[right]] = freq.get(fruits[right],0)+1
            while len(freq)>2:
                freq[fruits[left]] -= 1
                if freq[fruits[left]] == 0:
                    del freq[fruits[left]]
                left+=1
            m = max(m,right-left+1)
        return m
